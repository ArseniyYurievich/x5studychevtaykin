package task_1;

public class Phone {
    private long number;
    private String model;
    private float weight;

    public Phone() {
    }

    public Phone(long number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(long number, String model, float weight) {
        this(number, model);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "task_1.Phone{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void recieveCall(String callerName) {
        System.out.printf("Звонит %s%n", callerName);
    }

    public static void recieveCall(String callerName, long number) {
        System.out.printf("Звонит %s, номер %d%n", callerName, number);
    }

    public long getNumber() {
        return number;
    }

    public static void sendMessage(long[] numbers) {
        for (long number :
                numbers) {
            System.out.println(number);
        }
    }
}
