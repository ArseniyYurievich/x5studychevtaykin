package task_2.cpu;

public class AmdCPU extends CPU {
    public AmdCPU() {
        super();
        this.manufacturer = Manufacturer.AMD;
    }

    @Override
    public void setManufacturer(Manufacturer manufacturer) {
        System.out.println("В объектах класса AmdCPU запрещено менять поле manufacturer");
    }
}
