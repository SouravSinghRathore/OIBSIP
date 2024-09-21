import java.util.*;
public class GuessNumb {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Random random = new Random();
       int x = 1;        
       while (x==1) {
           int randNumb = random.nextInt(100);
           System.out.println("Guess the number between 1 to 100");
           int myNumb = sc.nextInt();
           int tries = 1;

            while (randNumb!=myNumb) {
                tries++;
                if (randNumb>myNumb) {
                    System.out.println("your number is too small \n");
                }
                
                else{
                    System.out.println("your number is too big \n");
                }
                myNumb = sc.nextInt();
            }    
            System.out.println("congrats!! you guessed it in  " + tries + "  tries");
            System.out.println(" press 1 for continue \n press 2 for exit");
            x = sc.nextInt();    
       }
       sc.close();
    }
}
