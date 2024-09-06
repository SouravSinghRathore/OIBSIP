package ATM2;

public class Account {
    private int accountNo = 67676767;
    private int pin = 1234; 
    private int balance = 50000;

    public Account(int accountNo, int pin, int balance){
        this.accountNo = accountNo;
        this.pin = pin;
        this.balance = balance;
    }

    public int getId(){
        return accountNo;
    }

    public int getPin(){
        return pin;
    }

    public int balEnq(){
        return balance;
    }

    public void chngPin(int chngPin){
        this.pin = chngPin;
    }

    public boolean withdraw(int amount){
        if (amount<=balance) {
            balance -=amount;
            return true;
        }
        else {
            return false;
        }
    }

    public void deposit(int amount){
        balance += amount;
    }

    public boolean transfer(Account transferAccount, int amount ){
        if (this.withdraw(amount)) {
            transferAccount.deposit(amount);
            return true;
        }
        else{
            return false;
        }
    } 

}
