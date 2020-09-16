package task_2.diskdrive;

public class HardDiskDrive extends DiskDrive {
    public HardDiskDrive() {
        super();
        this.diskDriveType = DiskDriveType.HDD;
    }

    @Override
    public void setDiskDriveType(DiskDriveType diskDriveType) {
        System.out.println("В объектах класса HardDiskDrive запрещено менять поле DiskDriveType");
    }
}
