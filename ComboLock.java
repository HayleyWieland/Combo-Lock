public class ComboLock {
    private int num1;
    private int num2;
    private int num3;
    private int dial = 0;
    private int currentNum1;
    private int currentNum2;
    private int currentNum3;
    private int turnNum = 0;

    //constructs a combination lock, takes the combination as the arguments
    public ComboLock(int x, int y, int z) {
           if (x < 0) { //validates the x input, if less than zero, assigns the value 0
                num1 = 0;
            } else if (x > 39) {//if more than 39, assigns the value 39
                num1 = 39;
            } else {//if a valid number, assigns that number
                num1 = x;
            }
           if(y < 0){//same validation process as x
               num2 = 0;
           }else if (y > 39){
               num2 = 39;
           }else{
               num2 = y;
           }
           if(z<0){//same validation process as x
               num3 = 0;
           }else if(z > 39){
               num3 = 39;
           }else{
               num3 = z;
           }
        }





    public void reset() {//resets the dial, clears the numbers input so far, resets the turn number
        dial = 0;
        currentNum1 = 0;
        currentNum2 = 0;
        currentNum3 = 0;
        turnNum = 0;
    }

    //turns the dial clockwise, takes the amount of numbers turned past as the argument.
    public void turnClockwise(int amtMoved) {
        if (turnNum == 0) {//this will save the number as the first number input for the combination
            if (dial == 0) {//ensures the math will work correctly by making sure everything subtracts from 40 instead of 0
                dial = 40;
            }
            if (dial - amtMoved < 0) {/*make sure you don't reverse too far to a number that doesn't exist on the dial. Math below with examples.
                //formula for how to translate the number given to the number the dial goes to
                //45 = 35                             //45 - 40 = 5                //40 - 5 = 35
                //amtMoved = where the dial ends up   //amtMoved - 40 = remainder  //40 - remainder = dial
                //80 = 0                              //80 - 40 = 40               //40 - 40 = 0
                //WITH AMOUNTS OVER 80
                //81 = 39                             // 81/40 = 2                // 81 - (40*2) = 1                      // 40 - 1 = 39
                //amtMoved = where the dial ends up   //amtMoved/40 = divRemain   //amtMoved - (40*divRemain) = subFrom40 // 40 - subFrom40 = dial
                //372 = 28                            // 372/40 = 9               // 372 - (40*9) = 12                    // 40 - 12 = 28
                */
                if (amtMoved < 81) {
                    int remainder = amtMoved - 40;
                    dial = 40 - remainder;
                }
                if (amtMoved > 80) {
                    int divRemain = amtMoved / 40;
                    int subFrom40 = amtMoved - (40 * divRemain);
                    dial = 40 - subFrom40;
                }
            } else { //if the dial moves by an amount that doesn't give it a non-valid number, assign the dial its value - amtMoved
                dial -= amtMoved;
            }
            currentNum1 = dial; //save the number that the dial moved to as the attempt for the first number
        } else if (turnNum == 2) {//ensures that the number saves as the third number input
            int startNum = dial; //make sure that you're starting from where the dial is

            //ensures that a valid number gets assigned to the dial if the dial moves beyond 0
            if (amtMoved > startNum) {
                if (amtMoved - startNum > 40) {//ensures that the dial won't be assigned to a number over 40 if amtMoved is too large a number

                    //removes the excessive full turns of the lock from the equation so as not to end up assigning a negative number to subFrom40
                    while (amtMoved > 40 && amtMoved - 40 > startNum) {
                        amtMoved -= 40;
                    }
                }
                int subFrom40 = amtMoved - startNum; //moves the dial to zero (40) & leaves the remainder of moves to be subtracted from 40
                dial = 40 - subFrom40;//moves the dial the rest of the way to the number selected
            } else {
                dial = startNum - amtMoved; //moves the dial to the number selected
            }
            currentNum3 = dial; //save the number that the dial moved to as the attempt for the third number
        }
        turnNum++;//tracks the number of turns
    }

    public void turnCounterClockwise(int x) {
        dial += x;
        if(dial > 39) { //ensures that the number assigned to the dial placement is valid
            int overRotateAmt = dial /40; /*see how many times the dial was turned around past 0 (40) & store that value
            in the variable overRotateAmt*/
            dial -= 40 * overRotateAmt;  //subtract the excess numbers from the turn to keep the dial within a valid range
            currentNum2 = dial; //assign the dial number to the current input for the second number
        } else {
            currentNum2 = dial; /*assign the current position of the dial to the variable keeping track of this try's
            second number in the combo attempt*/
        }
        turnNum++;
    }

    public boolean open() {
        if (num1 > currentNum1 || num1 < currentNum1) { //tests to see if the attempt for the first number was incorrect, if so, returns false
            return false;
        } else if (num2 > currentNum2 || num2 < currentNum2) {//tests to see if the attempt for the second number was incorrect, if so, returns false
            return false;
        } else if (num3 > currentNum3 || num3 < currentNum3) {//tests to see if the attempt for the third number was incorrect, if so, returns false
            return false;
        } else {//if all numbers attempted were correct, returns true
            return true;
        }
    }

}




