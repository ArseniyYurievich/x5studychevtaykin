package task_1;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone(8_495_123_45_67L, "apple");
        Phone phone2 = new Phone(8_495_234_56_78L, "samsung");
        Phone phone3 = new Phone(8_495_345_67_89L, "xiaomi");

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);

        phone1.recieveCall("Мистер первый");
        phone2.recieveCall("Мистер второй");
        phone3.recieveCall("Мистер третий");

        System.out.printf("Номер первого: %s%n", phone1.getNumber());
        System.out.printf("Номер второго: %s%n", phone2.getNumber());
        System.out.printf("Номер третьего: %s%n", phone3.getNumber());

        Phone.recieveCall("Мистер перегруженный", phone1.getNumber());

        Phone.sendMessage(new long[]{phone1.getNumber(), phone2.getNumber(), phone3.getNumber()});
    }
}
