package task_2.videocard;

public class AmdVideoCard extends VideoCard {
    public AmdVideoCard() {
        super();
        this.manufacturer = Manufacturer.AMD;
    }

    @Override
    public void setManufacturer(Manufacturer manufacturer) {
        System.out.println("В объектах класса NvidiaVideoCard запрещено менять значение поля manufacturer");
    }
}
