# Combo-Lock
A program that creates a combination lock object, sets it, and unlocks it

ComboLock.java contains a constructor that allows the user to set the lock, and four methods that allow the user to turn the lock and then check if it opened. 
- The constructor validates user input
- The turnClockwise method takes the amount the dial is moved as the argument and moves the dial clockwise that many turns
- The turnCounterclockwise method takes the amount the dial is moved as the argument and moves the dial counterclockwise that many turns
- The open method returns true or false depending on if the combination has been selected 
- The reset method begins a new attempt to open the combination lock 

ComboTest.java is the main method that prompts the user to input the combination for their lock, and then enter the number of turns in each direction to unlock it. 

