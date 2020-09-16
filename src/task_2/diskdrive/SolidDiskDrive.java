package task_2.diskdrive;

public class SolidDiskDrive extends DiskDrive {
    public SolidDiskDrive() {
        super();
        this.diskDriveType = DiskDriveType.SSD;
    }

    @Override
    public void setDiskDriveType(DiskDriveType diskDriveType) {
        System.out.println("В объектах класса SolidDiskDrive запрещено менять поле DiskDriveType");
    }
}
