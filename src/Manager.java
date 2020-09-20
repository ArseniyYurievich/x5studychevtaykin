import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Manager implements AccountService {
    private static final File fileStorage = new File(".\\accounts.txt");
    private final Map<Integer, Account> accounts = new HashMap<>();
    private final String lineDelimiter = ";";

    // при отсутсвии файла - создаём, заполняем его и заполняем локальное хранилище объектов
    {
        boolean newFileCreated = false;
        try {
            newFileCreated = fileStorage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Не удалось создать новый файл хранилища аккаунтов.\nЗавершение работы.");
            System.exit(1);
        }

        if (newFileCreated) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileStorage))) {
                String simpleAccounts = "1;Адам Адамович Самородков;100500\r\n" +
                        "2;Ева Адамовна Самородкова;100500\r\n" +
                        "3;Яков Адамович Шниперсон;1000\r\n" +
                        "4;Сара Ибрагимовна Затрибатько;1000\r\n" +
                        "5;Иван Петрович Сидоров;1000\r\n" +
                        "6;Петра Сидоровна Иванова;1000\r\n" +
                        "7;Сидор Иванович Петров;1000\r\n" +
                        "8;Зинаида Поликарповна Брамс;1000\r\n" +
                        "9;Евлампий Вассисуарьевич Толь;1000\r\n" +
                        "10;Ольга Олеговна Конь;1000";
                bufferedWriter.write(simpleAccounts);
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Не удалось заполнить хранище аккаунтов.\nЗавершение работы.");
                System.exit(1);
            }
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileStorage))) {
            String[] accountElements;
            String line = bufferedReader.readLine();
            while (line != null) {
                accountElements = line.split(lineDelimiter);

                int id = Integer.parseInt(accountElements[0]);
                String holder = accountElements[1];
                float amount = Float.parseFloat(accountElements[2]);

                accounts.put(id, new Account(id, holder, amount));

                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл не найден.\nЗавершение работы.");
            System.exit(1);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Ошибка при разборе файла.\nЗавершение работы.");
            System.exit(1);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            System.out.println("Ошибка в содержимом файла.\nЗавершение работы.");
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
        } finally {
            // сохраняем изменения в файл
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileStorage))) {
                accounts.forEach((k, v) -> {
                    try {
                        bufferedWriter.write(k + lineDelimiter + v.getHolder() + lineDelimiter + v.getAmount() + "\r\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void withdraw(int accountId, float amount) throws UnknownAccountException, NotEnoughMoneyException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }
        Account account = getAccount(accountId);
        if (amount > account.getAmount() || amount < 0) {
            throw new NotEnoughMoneyException();
        } else {
            account.setAmount(account.getAmount() - amount);
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
    }

    @Override
    public void transfer(int fromAccountId, int toAccountId, float amount) throws UnknownAccountException, NotEnoughMoneyException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }
        Account fromAccount = getAccount(fromAccountId);
        Account toAccount = getAccount(toAccountId);
        if (fromAccount.getAmount() < amount) {
            throw new NotEnoughMoneyException();
        } else {
            fromAccount.setAmount(fromAccount.getAmount() - amount);
            toAccount.setAmount(toAccount.getAmount() + amount);
        }
    }

    // проверяем наличие аккаунта
    private Account getAccount(int accountId) throws UnknownAccountException {
        Account account = accounts.get(accountId);
        if (account != null) {
            return account;
        } else {
            throw new UnknownAccountException();
        }
    }

}
