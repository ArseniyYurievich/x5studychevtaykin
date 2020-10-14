package task_2.diskdrive;

import task_2.Component;

public class DiskDrive extends Component {
    public enum DiskDriveType {UNKNOWN, HDD, SSD}

    protected DiskDriveType diskDriveType;
    private String manufacturer;
    private int memoryVolume;
    private String formFactor;

    public DiskDrive(DiskDriveType diskDriveType) {
        this.diskDriveType = diskDriveType;
    }

    @Override
    public String toString() {
        return "DiskDrive{" +
                "diskDriveType=" + diskDriveType +
                ", manufacturer='" + manufacturer + '\'' +
                ", memoryVolume=" + memoryVolume +
                ", formFactor='" + formFactor + '\'' +
                '}';
    }

    public DiskDriveType getDiskDriveType() {
        return diskDriveType;
    }

    public void setDiskDriveType(DiskDriveType diskDriveType) {
        this.diskDriveType = diskDriveType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getMemoryVolume() {
        return memoryVolume;
    }

    public void setMemoryVolume(int memoryVolume) {
        this.memoryVolume = memoryVolume;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }
}
