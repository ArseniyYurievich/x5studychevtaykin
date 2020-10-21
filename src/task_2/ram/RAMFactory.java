package task_2.ram;

import task_2.Component;
import task_2.ComponentFactory;

import static task_2.ram.RAM.RamType.*;

public class RAMFactory implements ComponentFactory {
    @Override
    public Component createComponent(String ramType) {
        switch (ramType) {
            case "DDR":
                return new RAM(DDR);
            case "DDR2":
                return new RAM(DDR2);
            case "DDR3":
                return new RAM(DDR3);
            default:
                return new RAM(UNKNOWN);
        }
    }
}
