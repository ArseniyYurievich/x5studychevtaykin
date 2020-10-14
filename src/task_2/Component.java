package task_2;

public abstract class Component {
    protected boolean isWorking;

    public void start() {
        isWorking = true;
    }

    public void stop() {
        isWorking = false;
    }

    public String getInfo() {
        return this.toString() +
                " now working: " + isWorking;
    }
}
