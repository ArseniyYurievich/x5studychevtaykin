package task_2.videocard;

import task_2.Component;

public class VideoCardFactory {
    private VideoCardFactory() {
    }

    public static Component getVideoCard(VideoCard.Manufacturer manufacturer) {
        switch (manufacturer) {
            case AMD:
            case NVIDIA:
                return new VideoCard(manufacturer);
            default:
                return new VideoCard(VideoCard.Manufacturer.UNKNOWN);
        }
    }
}
