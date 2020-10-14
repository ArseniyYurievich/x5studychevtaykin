package task_2.ram;

import task_2.Component;

public class RAMFactory {
    private RAMFactory() {
    }

    public static Component getRAM(RAM.RamType ramType) {
        switch (ramType) {
            case DDR:
            case DDR2:
            case DDR3:
                return new RAM(ramType);
            default:
                return new RAM(RAM.RamType.UNKNOWN);
        }
    }
}
