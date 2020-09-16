package task_2.videocard;

import task_2.ram.RAM;

public class VideoCard {
    public enum Manufacturer {unknown, Nvidia, AMD}

    protected Manufacturer manufacturer;
    private RAM.RamType ramType;
    private int ramVolume;
    private boolean isActiveCooling;

    @Override
    public String toString() {
        return "VideoCard{" +
                "manufacturer=" + manufacturer +
                ", ramType=" + ramType +
                ", ramVolume=" + ramVolume +
                ", isActiveCooling=" + isActiveCooling +
                '}';
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public RAM.RamType getRamType() {
        return ramType;
    }

    public void setRamType(RAM.RamType ramType) {
        this.ramType = ramType;
    }

    public int getRamVolume() {
        return ramVolume;
    }

    public void setRamVolume(int ramVolume) {
        this.ramVolume = ramVolume;
    }

    public boolean isActiveCooling() {
        return isActiveCooling;
    }

    public void setActiveCooling(boolean activeCooling) {
        isActiveCooling = activeCooling;
    }
}
