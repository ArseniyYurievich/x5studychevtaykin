package task_2;

import task_2.cpu.CPU;
import task_2.diskdrive.DiskDrive;
import task_2.ram.RAM;
import task_2.videocard.VideoCard;

public class ComputerForOfficeFacade implements ComputerFacade {
    @Override
    public Computer getComputer() {
        Computer computer = new Computer(CPU.Manufacturer.AMD, RAM.RamType.DDR, VideoCard.Manufacturer.NVIDIA, DiskDrive.DiskDriveType.HDD);

        computer.getCpu().setCacheSize(100);
        computer.getCpu().setClockSpeed(100);
        computer.getCpu().setCoreQuantity(100);

        computer.getRam().setFrequency(100);
        computer.getRam().setManufacturer("Some Fabric");
        computer.getRam().setVolume(100);

        computer.getDiskDrive().setFormFactor("3.5\"");
        computer.getDiskDrive().setManufacturer("Cheap Discs");
        computer.getDiskDrive().setMemoryVolume(100);

        computer.getVideoCard().setActiveCooling(false);
        computer.getVideoCard().setRamType(RAM.RamType.DDR);
        computer.getVideoCard().setRamVolume(100);

        computer.getMonitor().setDiagonal(100);
        computer.getMonitor().setManufacturer("Not Bad Monitors");
        computer.getMonitor().setType("CRT");

        return computer;
    }
}
