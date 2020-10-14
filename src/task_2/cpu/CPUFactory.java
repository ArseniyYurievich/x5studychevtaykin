package task_2.cpu;

import task_2.Component;

public class CPUFactory {
    private CPUFactory() {
    }

    public static Component getCPU(CPU.Manufacturer manufacturer) {
        switch (manufacturer) {
            case AMD:
            case INTEL:
                return new CPU(manufacturer);
            default:
                return new CPU(CPU.Manufacturer.UNKNOWN);
        }
    }
}
