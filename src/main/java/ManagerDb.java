import java.io.IOException;
import java.sql.*;

public class ManagerDb implements AccountService {
    private final String DATABASE_DRIVER = "org.h2.Driver";
    private final String DATABASE_URL = "jdbc:h2:.\\test;mode=MySQL;";
    private final String DATABASE_INIT = "INIT=RUNSCRIPT FROM 'schema.sql'\\;RUNSCRIPT FROM 'data.sql';";
    private final String USERNAME = "";
    private final String PASSWORD = "";

    private final String SQL_GET_ACCOUNT = "SELECT * FROM ACCOUNTS WHERE ID = ?";
    private final String SQL_SET_AMOUNT = "UPDATE ACCOUNTS SET AMOUNT = ? WHERE ID = ?";

    {
        try {
            Class.forName(DATABASE_DRIVER).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            System.out.println("Ошибка загрузки драйвера БД.\nЗавершение работы");
            System.exit(1);
        }

        try (Connection connection = DriverManager.getConnection(DATABASE_URL + DATABASE_INIT, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT ID FROM ACCOUNTS LIMIT 1")) {
            if (!resultSet.next()) {
                throw new IOException("Ошибка: БД пустая.\nЗавершение работы");
            }
        } catch (SQLException | IOException se) {
            se.printStackTrace();
            System.out.println("Ошибка: не удалось подключиться к БД.\nЗавершение работы.");
            System.exit(1);
        }
    }

    public void operate(String command) {
        String[] operands = command.split("\\s+");
        try {
            switch (operands[0]) {
                case "balance":
                    balance(Integer.parseInt(operands[1]));
                    break;
                case "withdraw":
                    withdraw(Integer.parseInt(operands[1]), Float.parseFloat(operands[2]));
                    break;
                case "deposit":
                    deposit(Integer.parseInt(operands[1]), Float.parseFloat(operands[2]));
                    break;
                case "transfer":
                    transfer(Integer.parseInt(operands[1]), Integer.parseInt(operands[2]), Float.parseFloat(operands[3]));
                    break;
                default:
                    System.out.printf("Ошибка: Команда \"%s\" не опознана.\nВведите одну из следующих команд:\n" +
                            "\"balance\", \"withdraw\", \"deposit\", \"transfer\"\n", operands[0]);
                    break;
            }
        } catch (UnknownAccountException uae) {
            System.out.println("Ошибка: Неизвестный номер счёта");
        } catch (NotEnoughMoneyException neme) {
            System.out.println("Ошибка: Недостаточно средств на счёте");
        } catch (NumberFormatException nfe) {
            System.out.println("Ошибка: Неверно введено число");
        } catch (NegativeAmountException ne) {
            System.out.println("Ошибка: Запрещены операции с отрицательными значениями");
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Ошибка: Недостаточно аргументов");
        }
    }

    @Override
    public void withdraw(int accountId, float amount) throws UnknownAccountException, NotEnoughMoneyException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }
        Account account = getAccount(accountId);
        if (account.getAmount() >= amount) {
            account.setAmount(account.getAmount() - amount);
        } else {
            throw new NotEnoughMoneyException();
        }

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SET_AMOUNT)) {
            preparedStatement.setFloat(1, account.getAmount());
            preparedStatement.setInt(2, account.getId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void balance(int accountId) throws UnknownAccountException {
        System.out.println(getAccount(accountId));
    }

    @Override
    public void deposit(int accountId, float amount) throws UnknownAccountException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }
        Account account = getAccount(accountId);
        account.setAmount(account.getAmount() + amount);

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SET_AMOUNT)) {
            preparedStatement.setFloat(1, account.getAmount());
            preparedStatement.setInt(2, account.getId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void transfer(int fromAccountId, int toAccountId, float amount) throws UnknownAccountException, NotEnoughMoneyException, NegativeAmountException {
        // если аккаунт источник совпадает с аккаунтом целью, то операция бессмысленна
        if (fromAccountId == toAccountId) {
            return;
        }

        if (amount < 0) {
            throw new NegativeAmountException();
        }
        Account fromAccount = getAccount(fromAccountId);
        Account toAccount = getAccount(toAccountId);
        if (fromAccount.getAmount() >= amount) {
            fromAccount.setAmount(fromAccount.getAmount() - amount);
            toAccount.setAmount(toAccount.getAmount() + amount);
        } else {
            throw new NotEnoughMoneyException();
        }

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SET_AMOUNT)) {
            connection.setAutoCommit(false);
            fromAccount.setAmount(fromAccount.getAmount());
            preparedStatement.setFloat(1, fromAccount.getAmount());
            preparedStatement.setInt(2, fromAccount.getId());
            preparedStatement.execute();
            preparedStatement.setFloat(1, toAccount.getAmount());
            preparedStatement.setInt(2, toAccount.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Account getAccount(int accountId) throws UnknownAccountException {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ACCOUNT)) {
            preparedStatement.setInt(1, accountId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Account(resultSet.getInt("ID"),
                            resultSet.getString("HOLDER"),
                            resultSet.getFloat("AMOUNT"));
                } else {
                    throw new UnknownAccountException();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnknownAccountException();
        }
    }
}
