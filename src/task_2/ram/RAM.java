package task_2.ram;

public class RAM {
    public enum RamType {DDR, DDR2, DDR3}

    protected RamType ramType;
    private String manufacturer;
    private int volume;
    private int frequency;

    @Override
    public String toString() {
        return "RAM{" +
                "ramType=" + ramType +
                ", manufacturer='" + manufacturer + '\'' +
                ", volume=" + volume +
                ", frequency=" + frequency +
                '}';
    }

    public RamType getRamType() {
        return ramType;
    }

    public void setRamType(RamType ramType) {
        this.ramType = ramType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
