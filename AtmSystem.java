package ATM2;
import java.util.Scanner;

public class AtmSystem {
    private Account account;
    private TransactionHistory history;
    private AtmFunction funtion;
    
    public AtmSystem(Account account){
        this.account = account;
        this.history = new TransactionHistory();
        this.funtion = new AtmFunction(account, history);
    }
    
    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    public void start(){
        boolean exit = false;
        while (!exit) {

        System.out.println("Enter your PIN :");
        int currPin = sc.nextInt();
        if (currPin==account.getPin()) {
            attempts = 0;
            menu();
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Available Balance :" + account.balEnq());
                    break;
                
                case 2:
                    System.out.println("Enter amount for withdrawal :");
                    int withdAmt = sc.nextInt();
                    funtion.withdraw(withdAmt);
                    break;

                case 3:
                    System.out.println("Enter amount for Deposit :");
                    int DepAmt = sc.nextInt();
                    funtion.deposit(DepAmt);
                    break;

                case 4:
                    System.out.println("Enter Account no. to transfer: ");
                    int TransferAccountNo = sc.nextInt();
                    Account transferAccount = new Account(TransferAccountNo, 4321, 10000);
                    System.out.println("Enter Amount to transfer: ");
                    int transAmt = sc.nextInt();
                    funtion.transfer(transAmt, transferAccount);
                    break;

                case 5:
                    history.printTransaction();
                    break;

                case 6:
                    newPin();
                    break;

                case 7:
                    exit=true;
                    break;
            
                default:
                    System.out.println("Invalid Option");
                    break;
            } 
        }
        else{
            attempts++;
            if (attempts<3) {
                System.out.println("Incorrect pin! Please enter Correct pin");
            } 
            else {
                System.out.println("Too many incorrect attempts! You exceed today's limit");
                exit = true;
            }
        }
        }
    }

    public void menu(){
        System.out.println("Press 1. Account Balance Enquiry");
        System.out.println("Press 2. Cash Withdrawal");
        System.out.println("Press 3. Cash Deposit");
        System.out.println("Press 4. Cash Transfer");
        System.out.println("Press 5. Transaction History");
        System.out.println("Press 6. Pin change");
        System.out.println("Press 7. Exit");
    }

    public void newPin(){
        System.out.println("Enter your current PIN");
        int pin2 = sc.nextInt();
        if(pin2==account.getPin()){
        
            System.out.print("Enter new PIN: ");
            int newPin = sc.nextInt();
            System.out.print("Again Enter new PIN: ");
            int newPin2 = sc.nextInt();
            
            if(newPin==newPin2){
                funtion.changePin(newPin2);
                System.out.println("PIN Successfully changed");
            }
            else{
                System.out.println("Pin mismatched");
            }
        }
        else{
            System.out.println("Incorrect pin");
        }
        
    }
    
}
