package task_2;

import task_2.cpu.AmdCPU;
import task_2.cpu.CPU;
import task_2.cpu.IntelCPU;
import task_2.diskdrive.DiskDrive;
import task_2.diskdrive.HardDiskDrive;
import task_2.diskdrive.SolidDiskDrive;
import task_2.ram.Ddr2RAM;
import task_2.ram.Ddr3RAM;
import task_2.ram.DdrRAM;
import task_2.ram.RAM;
import task_2.videocard.AmdVideoCard;
import task_2.videocard.NvidiaVideoCard;
import task_2.videocard.VideoCard;

public class Computer {
    private CPU cpu;
    private RAM ram;
    private VideoCard videoCard;
    private DiskDrive diskDrive;
    private Monitor monitor;

    public Computer(CPU.Manufacturer cpuManufacturer, RAM.RamType ramType, VideoCard.Manufacturer videoCardManufacturer,
                    DiskDrive.DiskDriveType diskDriveType) {
        this.cpu = createCpu(cpuManufacturer);
        this.ram = createRam(ramType);
        this.videoCard = createVideoCard(videoCardManufacturer);
        this.diskDrive = createDiskDrive(diskDriveType);
        this.monitor = new Monitor();
    }

    private CPU createCpu(CPU.Manufacturer manufacturer) {
        switch (manufacturer) {
            case Intel:
                return new IntelCPU();
            case AMD:
                return new AmdCPU();
            default:
                return new CPU();
        }
    }

    private RAM createRam(RAM.RamType ramType) {
        switch (ramType) {
            case DDR:
                return new DdrRAM();
            case DDR2:
                return new Ddr2RAM();
            case DDR3:
                return new Ddr3RAM();
            default:
                return new RAM();
        }
    }

    private VideoCard createVideoCard(VideoCard.Manufacturer manufacturer) {
        switch (manufacturer) {
            case Nvidia:
                return new NvidiaVideoCard();
            case AMD:
                return new AmdVideoCard();
            default:
                return new VideoCard();
        }
    }

    private DiskDrive createDiskDrive(DiskDrive.DiskDriveType diskDriveType) {
        switch (diskDriveType) {
            case HDD:
                return new HardDiskDrive();
            case SSD:
                return new SolidDiskDrive();
            default:
                return new DiskDrive();
        }
    }

    @Override
    public String toString() {
        return "Computer{" + '\n' +
                "cpu=" + cpu + '\n' +
                "ram=" + ram + '\n' +
                "videoCard=" + videoCard + '\n' +
                "diskDrive=" + diskDrive + '\n' +
                "monitor=" + monitor + '\n' +
                '}';
    }

    public Computer() {
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public DiskDrive getDiskDrive() {
        return diskDrive;
    }

    public void setDiskDrive(DiskDrive diskDrive) {
        this.diskDrive = diskDrive;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

}
