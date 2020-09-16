package task_2.ram;

public class DdrRAM extends RAM {
    public DdrRAM() {
        super();
        this.ramType = RamType.DDR;
    }

    @Override
    public void setRamType(RamType ramType) {
        System.out.println("В объектах класса DdrRAM запрещено менять значение поля ramType");
    }
}
