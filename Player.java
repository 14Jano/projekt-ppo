public class Player extends Character {

    public int numAtkUpgrades, numDefUpgrades;

    int gold, restsLeft, pots;

    public String[] atkUpgrades = {"Siła", "Ryk Bitewny", "Szał Wojenny", "Szósty Zmysł"};
    public String[] defUpgrades = {"Lwie Serce", "Kamienna Skóra", "Ostateczna Obrona", "Święta Aura"};

    public Player(String name) {
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        this.gold = 5;
        this.restsLeft = 1;
        this.pots = 0;
        chooseTrait();
    }

    @Override
    public int attack() {
        return (int) (Math.random()*(xp/2 + numAtkUpgrades*10 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(xp/2 + numDefUpgrades*3 + 3) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }

    public void chooseTrait() {
        GameSense.clearConsole();
        GameSense.printHeading("Wybierz cechę:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        int input = GameSense.readInt("-> ", 2);
        GameSense.clearConsole();
        if(input == 1) {
            GameSense.printHeading("Wybierasz " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else {
            GameSense.printHeading("Wybierasz " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameSense.anythingToContinue();
    }
}

