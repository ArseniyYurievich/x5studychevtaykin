package task_2.videocard;

import task_2.Component;
import task_2.ComponentFactory;

import static task_2.videocard.VideoCard.Manufacturer.*;

public class VideoCardFactory implements ComponentFactory {
    @Override
    public Component createComponent(String manufacturer) {
        switch (manufacturer) {
            case "AMD":
                return new VideoCard(AMD);
            case "NVIDIA":
                return new VideoCard(NVIDIA);
            default:
                return new VideoCard(UNKNOWN);
        }
    }
}
