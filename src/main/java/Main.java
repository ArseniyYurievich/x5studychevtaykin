import java.util.Scanner;

public class Main {
    private static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        System.out.println("Введите команду:");
        ManagerDb managerDb = new ManagerDb();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase(EXIT_COMMAND)) {
            managerDb.operate(command);
            command = scanner.nextLine();
        }
    }
}
