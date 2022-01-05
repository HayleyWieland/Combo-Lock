public class ComboTest {
    public static void main(String[] args){
        ComboLock demoLock = new ComboLock(41, -5, 40);
        demoLock.turnClockwise(81);
        demoLock.turnCounterClockwise(161);
        demoLock.turnClockwise(161);
        boolean isSolved = demoLock.open();
        System.out.println(isSolved);
        demoLock.reset();
        boolean isSolvedNow = demoLock.open();
        System.out.println(isSolvedNow);

    }
}
