package task_2;

import task_2.cpu.CPU;
import task_2.cpu.CPUFactory;
import task_2.diskdrive.DiskDrive;
import task_2.diskdrive.DiskDriveFactory;
import task_2.ram.RAM;
import task_2.ram.RAMFactory;
import task_2.videocard.VideoCard;
import task_2.videocard.VideoCardFactory;

public class Computer {
    private Component cpu;
    private Component ram;
    private Component videoCard;
    private Component diskDrive;
    private Component monitor;

    public Computer(String cpuManufacturer, String ramType, String videoCardManufacturer, String diskDriveType) {
        this.cpu = new CPUFactory().createComponent(cpuManufacturer);
        this.ram = new RAMFactory().createComponent(ramType);
        this.videoCard = new VideoCardFactory().createComponent(videoCardManufacturer);
        this.diskDrive = new DiskDriveFactory().createComponent(diskDriveType);
        this.monitor = new Monitor();
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
        return (CPU) cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public RAM getRam() {
        return (RAM) ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public VideoCard getVideoCard() {
        return (VideoCard) videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public DiskDrive getDiskDrive() {
        return (DiskDrive) diskDrive;
    }

    public void setDiskDrive(DiskDrive diskDrive) {
        this.diskDrive = diskDrive;
    }

    public Monitor getMonitor() {
        return (Monitor) monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

}
