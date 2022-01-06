import java.util.Scanner;

public class ComboTest {
    static ComboLock createNewLock() {
        //prompts the user for the numbers for the lock combination and then uses them to create a new combination lock
        Scanner keyboard = new Scanner(System.in); //initializes a reader for user input
        System.out.println("Enter the first number for your lock combination: ");
        int firstNum = Integer.parseInt(keyboard.nextLine());
        System.out.println("Enter the second number for your lock combination: ");
        int secondNum = Integer.parseInt(keyboard.nextLine());
        System.out.println("Enter the third number for your lock combination: ");
        int thirdNum = Integer.parseInt(keyboard.nextLine());
        ComboLock demoLock = new ComboLock(firstNum, secondNum, thirdNum);
        return demoLock;
    }

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in); //initializes a reader for user input
        String answer = "y"; //initializes answer, ensures that the while loop will run
        ComboLock demoLock = createNewLock();
        while(answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("n")) {
            switch (answer) {
                case "n": {
                   demoLock = createNewLock();
                }
                case "y": {
                    //prompts the user to turn the dial to unlock the lock
                    System.out.println("Enter the amount of clockwise turns to make: ");
                    int turns = Integer.parseInt(keyboard.nextLine());
                    demoLock.turnClockwise(turns);
                    System.out.println("Enter the amount of counterclockwise turns to make: ");
                    turns = Integer.parseInt(keyboard.nextLine());
                    demoLock.turnCounterClockwise(turns);
                    System.out.println("Enter the amount of clockwise turns to make: ");
                    turns = Integer.parseInt(keyboard.nextLine());
                    demoLock.turnClockwise(turns);
                }

            //tests if the lock has been unlocked
            boolean isSolved = demoLock.open();
            if(isSolved == true) {
                System.out.println("Congrats! You unlocked the lock. Press n to play again.");
                 answer = keyboard.nextLine();
            } else {
                 System.out.println("The lock is still locked. Press y to try again with this combination, or n to try again with a new combination.");
                 answer = keyboard.nextLine();
                 }
            demoLock.reset();

            }
        }
    }
}
