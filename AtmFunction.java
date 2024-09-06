package ATM2;

public class AtmFunction {
    private Account account;
    private TransactionHistory history;

    public AtmFunction (Account account, TransactionHistory history){
        this.account = account;
        this.history = history;
    }

    public void deposit(int amount){
        account.deposit(amount);
        history.addTransaction(new Transaction("deposite: ", amount));
        System.out.println("Deposite Successfull");
    }

    public void withdraw(int amount){
        if (account.withdraw(amount)) {
            history.addTransaction(new Transaction("withdraw: ", amount));
            System.out.println("Withdraw Successfull");
        } 
        else {
            System.out.println("Insufficient Balance");   
        }
    }

    public void transfer(int amount, Account transferAccount){
        if (account.transfer(transferAccount, amount)) {
            history.addTransaction(new Transaction("transferded to Account No." + transferAccount.getId(), amount));
            System.out.println("Transfer Successfull");
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    public void changePin(int newPin){
        account.chngPin(newPin);
        System.out.println("Pin changed successfully");
    }
}
