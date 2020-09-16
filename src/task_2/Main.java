package task_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Какой компьютер хотите собрать?");
        System.out.println("1 - игровой");
        System.out.println("2 - офисный");
        System.out.println("(введите 1 или 2)");

        ComputerFacade facade = null;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case 1:
                    facade = new ComputerForGamesFacade();
                    break;
                case 2:
                    facade = new ComputerForOfficeFacade();
                    break;
                default:
                    System.out.println("Ошибка: введён неверный номер.");
                    break;
            }
        } else {
            System.out.println("Ошибка: введён не номер.");
        }

        if (facade != null) {
            Computer computer = facade.getComputer();
            System.out.println(computer);
        }
    }
}
