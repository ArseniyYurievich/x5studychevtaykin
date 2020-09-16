package task_2.ram;

public class Ddr3RAM extends RAM {
    public Ddr3RAM() {
        super();
        this.ramType = RamType.DDR3;
    }

    @Override
    public void setRamType(RamType ramType) {
        System.out.println("В объектах класса Ddr3RAM запрещено менять значение поля ramType");
    }
}
