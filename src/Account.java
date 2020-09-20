public class Account {
    private int id;
    private String holder;
    private float amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Account(int id, String holder, float amount) {
        this.id = id;
        this.holder = holder;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Id = " + id +
                "; holder = " + holder +
                "; amount = " + amount;
    }
}

