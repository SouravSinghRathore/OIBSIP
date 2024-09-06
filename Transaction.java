package ATM2;

public class Transaction {
    private int amount;
    private String type;

    public Transaction(String type, int amount){
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString(){
        return type + ": " + amount;
    }
}
