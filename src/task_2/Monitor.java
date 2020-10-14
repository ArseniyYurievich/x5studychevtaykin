package task_2;

public class Monitor extends Component {
    private String manufacturer;
    private int diagonal;
    private String type;

    @Override
    public String toString() {
        return "Monitor{" +
                "manufacturer='" + manufacturer + '\'' +
                ", diagonal=" + diagonal +
                ", type='" + type + '\'' +
                '}';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
