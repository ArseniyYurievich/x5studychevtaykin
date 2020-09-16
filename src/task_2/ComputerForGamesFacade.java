package task_2;

import task_2.cpu.CPU;
import task_2.diskdrive.DiskDrive;
import task_2.ram.RAM;
import task_2.videocard.VideoCard;

public class ComputerForGamesFacade implements ComputerFacade {
    @Override
    public Computer getComputer() {
        Computer computer = new Computer(CPU.Manufacturer.Intel, RAM.RamType.DDR3, VideoCard.Manufacturer.AMD, DiskDrive.DiskDriveType.SSD);

        computer.getCpu().setCacheSize(100500);
        computer.getCpu().setClockSpeed(100500);
        computer.getCpu().setCoreQuantity(100500);

        computer.getRam().setFrequency(100500);
        computer.getRam().setManufacturer("Ultra Fabric");
        computer.getRam().setVolume(100500);

        computer.getDiskDrive().setFormFactor("3.5\"");
        computer.getDiskDrive().setManufacturer("Super Discs");
        computer.getDiskDrive().setMemoryVolume(100500);

        computer.getVideoCard().setActiveCooling(true);
        computer.getVideoCard().setRamType(RAM.RamType.DDR3);
        computer.getVideoCard().setRamVolume(100500);

        computer.getMonitor().setDiagonal(100500);
        computer.getMonitor().setManufacturer("Quantum Monitors");
        computer.getMonitor().setType("OLED");

        return computer;
    }
}
