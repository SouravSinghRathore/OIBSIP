package ATM2;

public class ATM {
    public static void main(String[] args) {
        Account account = new Account(1234, 1234, 50000);
        AtmSystem system = new AtmSystem(account);
        system.start();
    }
}
