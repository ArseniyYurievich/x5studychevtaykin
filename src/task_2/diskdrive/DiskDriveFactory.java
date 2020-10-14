package task_2.diskdrive;

import task_2.Component;

public class DiskDriveFactory {
    private DiskDriveFactory() {
    }

    public static Component getDiskDrive(DiskDrive.DiskDriveType diskDriveType) {
        switch (diskDriveType) {
            case HDD:
            case SSD:
                return new DiskDrive(diskDriveType);
            default:
                return new DiskDrive(DiskDrive.DiskDriveType.UNKNOWN);
        }
    }
}
