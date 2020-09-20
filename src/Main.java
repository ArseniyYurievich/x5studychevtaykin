import java.util.Scanner;

public class Main {
    private static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        System.out.println("Введите команду:");
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase(EXIT_COMMAND)) {
            manager.operate(command);
            command = scanner.nextLine();
        }
    }
}
