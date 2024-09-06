package ATM2;

import java.util.*;

public class TransactionHistory {
    private ArrayList<Transaction> transaction;
    
    public TransactionHistory(){
        transaction = new ArrayList<>();
    }

    public void addTransaction(Transaction transactions){
        transaction.add(transactions);
    }

    public void printTransaction(){
        if (transaction.isEmpty()) {
            System.out.println("No Transaction Found");    
        } 
        else {
            for(Transaction transactions : transaction){
                System.out.println(transactions);
            }
        }
    }
}
