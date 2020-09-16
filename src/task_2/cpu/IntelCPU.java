package task_2.cpu;

public class IntelCPU extends CPU {
    public IntelCPU() {
        super();
        this.manufacturer = Manufacturer.Intel;
    }

    @Override
    public void setManufacturer(Manufacturer manufacturer) {
        System.out.println("В объектах класса IntelCPU запрещено менять поле manufacturer");
    }
}
