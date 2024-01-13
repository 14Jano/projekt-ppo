public class Main {
    /**
     * @param args
     */
    public static void main(Sting[] args){
        GameSense.printHeading("Testowanie metod!");
        GameSense.anythingToContinue();
        GameSense.clear.Console();
        int input = GameSense.readInt("Wprowadź 1,2 lub 3: ", 3);
        System.out.println("Wybrałeś numer + " input);
    }
}
