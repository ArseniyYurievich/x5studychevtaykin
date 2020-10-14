package task_2.cpu;

import task_2.Component;

public class CPU extends Component {
    public enum Manufacturer {UNKNOWN, INTEL, AMD}

    protected Manufacturer manufacturer;
    private int clockSpeed;
    private int coreQuantity;
    private int cacheSize;
    private String name;

    public CPU(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "manufacturer=" + manufacturer +
                ", clockSpeed=" + clockSpeed +
                ", coreQuantity=" + coreQuantity +
                ", cacheSize=" + cacheSize +
                ", name='" + name + '\'' +
                '}';
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getCoreQuantity() {
        return coreQuantity;
    }

    public void setCoreQuantity(int coreQuantity) {
        this.coreQuantity = coreQuantity;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
