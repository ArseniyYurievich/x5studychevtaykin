package task_2.ram;

public class Ddr2RAM extends RAM {
    public Ddr2RAM() {
        super();
        this.ramType = RamType.DDR2;
    }

    @Override
    public void setRamType(RamType ramType) {
        System.out.println("В объектах класса Ddr2RAM запрещено менять значение поля ramType");
    }
}
