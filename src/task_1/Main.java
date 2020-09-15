package task_1;

public class Main {
    public static void main(String[] args) {
        Phone[] phones = new Phone[]{
                new Phone(8_495_123_45_67L, "apple")
                , new Phone(8_495_234_56_78L, "samsung")
                , new Phone(8_495_345_67_89L, "xiaomi")
        };

        for (Phone phone :
                phones) {
            System.out.println(phone);
        }

        for (Phone phone :
                phones) {
            phone.recieveCall("Мистер " + phone.getModel());
        }

        for (Phone phone :
                phones) {
            System.out.printf("Номер %s: %s%n", phone.getModel(), phone.getNumber());
        }

        phones[0].recieveCall("Мистер перегруженный", phones[0].getNumber());

        phones[0].sendMessage(new long[]{phones[0].getNumber(), phones[1].getNumber(), phones[2].getNumber()});
    }
}
