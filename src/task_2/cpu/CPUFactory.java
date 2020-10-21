package task_2.cpu;

import task_2.Component;
import task_2.ComponentFactory;

import static task_2.cpu.CPU.Manufacturer.*;

public class CPUFactory implements ComponentFactory {
    @Override
    public Component createComponent(String manufacturer) {
        switch (manufacturer) {
            case "AMD":
                return new CPU(AMD);
            case "INTEL":
                return new CPU(INTEL);
            default:
                return new CPU(UNKNOWN);
        }
    }
}
