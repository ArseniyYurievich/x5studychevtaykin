package task_2.videocard;

public class NvidiaVideoCard extends VideoCard {
    public NvidiaVideoCard() {
        super();
        this.manufacturer = Manufacturer.Nvidia;
    }

    @Override
    public void setManufacturer(Manufacturer manufacturer) {
        System.out.println("В объектах класса NvidiaVideoCard запрещено менять значение поля manufacturer");
    }
}
