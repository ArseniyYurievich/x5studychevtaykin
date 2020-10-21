package task_2.diskdrive;

import task_2.Component;
import task_2.ComponentFactory;

import static task_2.diskdrive.DiskDrive.DiskDriveType.*;

public class DiskDriveFactory implements ComponentFactory {

    @Override
    public Component createComponent(String diskDriveType) {
        switch (diskDriveType) {
            case "HDD":
                return new DiskDrive(HDD);
            case "SSD":
                return new DiskDrive(SSD);
            default:
                return new DiskDrive(UNKNOWN);
        }
    }
}
