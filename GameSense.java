import java.util.Scanner;

public class GameSense {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    public static String[] encounters = {"Walka", "Walka", "Walka", "Odpoczynek", "Odpoczynek"};

    public static String[] enemies = {"Ogr", "Troll", "Goblin", "Kościotrup", "Żywiołak"};

    public static int place = 0, act = 1;
    public static String[] places = {"Góry Wiecznego Zapomnienia", "Nawiedzony Cmentarz", "Zamek Cesarza Zła", "Sala Tronowa"};

    public static int readInt(String prompt, int userChoices) {
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch(Exception e) {
                input = -1;
                System.out.println("Proszę podaj liczbę!");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    public static void clearConsole(){
        for(int i = 0; i < 100; i++);
        System.out.println();

    }
    public static void printSeparator(int n){
        for(int i = 0; i < n; i++)
            System.out.println("-");

    }
    public static void printHeading(String title){
        printSeparator(1);;
        System.out.println(title);
        printSeparator(1);;
    }
    public static void anythingToContinue(){
        System.out.println("\nWciśnij dowolny przycisk aby kontynuować...");
        scanner.next();
    }

    public static void startGame(){
        boolean nameSet = false;
        String name;

        clearConsole();
        printSeparator(1);;
        System.out.println("Najlepsza gra wszechczasów!!!");
        System.out.println("Jano & Domin");
        printSeparator(1);;
        anythingToContinue();

        do{
            clearConsole();
            printHeading("Jak się nazywasz?");
            name = scanner.next();
            clearConsole();
            printHeading("Nazywasz się " + name + ".\nZgadza się?");
            System.out.println("(1) Tak!");
            System.out.println("(2) Nie, chciałbym zmienić moją nazwę.");
            int input = readInt("-> ", 2);
            if(input == 1)
                nameSet = true;
        }while(!nameSet);

        Story.printIntro();

        player = new Player(name);

        Story.printFirstActIntro();

        isRunning = true;

        gameLoop();
    }
    public static void checkAct(){

        if(player.xp >= 10 && act == 1){
            act = 2;
            place = 1;
            Story.printFirstActOutro();
            player.chooseTrait();
            Story.printSecondActIntro();
            enemies[0] = "Najemnik Złego Cesarza";
            enemies[1] = "Goblin";
            enemies[2] = "Stado Wilków";
            enemies[3] = "Pomocnik Złego Cesarza";
            enemies[4] = "Ogr";

            encounters[0] = "Walka";
            encounters[1] = "Walka";
            encounters[2] = "Walka";
            encounters[3] = "Odpoczynek";
            encounters[4] = "Wędrowny Handlarz";

        }else if(player.xp >= 50 && act == 2){
            act = 3;
            place = 2;
            Story.printSecondActOutro();
            player.chooseTrait();
            Story.printThirdActIntro();
            enemies[0] = "Pies Złego Cesarza";
            enemies[1] = "Najemnik Złego Cesarza";
            enemies[2] = "Czarodziej Złego Cesarza";
            enemies[3] = "Pomocnik Złego Cesarza";
            enemies[4] = "Miecznik Złego Cesarza";

            encounters[0] = "Walka";
            encounters[1] = "Walka";
            encounters[2] = "Walka";
            encounters[3] = "Walka";
            encounters[4] = "Wędrowny Handlarz";
            player.hp = player.maxHp;

        }else if(player.xp >= 100 && act == 3){
            act = 4;
            place = 3;
            Story.printThirdActOutro();
            player.chooseTrait();
            Story.printFourthActIntro();
            player.hp = player.maxHp;

            finalBattle();
        }
    }
    public static void randomEncounter(){
        int encounter = (int) (Math.random()* encounters.length);
        if(encounters[encounter].equals("Walka")){
            randomBattle();
        }else if(encounters[encounter].equals("Odpoczynek")){
            takeRest();
        }else {
            shop();
        }
    }


    public static void continueJourney(){

        checkAct();
        if(act != 4)
            randomEncounter();

    }
    public static void characterInfo(){
        clearConsole();
        printHeading("INFORMACJE O BOHATERZE");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(1);;
        System.out.println("XP: " + player.xp + "\tZłoto: " + player.gold);
        printSeparator(1);;
        System.out.println("# Mikstur: " + player.pots);
        printSeparator(1);;


        if(player.numAtkUpgrades > 0) {
            System.out.println("Cecha ofensywna: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(1);;
        }
        if(player.numDefUpgrades > 0) {
            System.out.println("Cecha defensywna: " + player.defUpgrades[player.numDefUpgrades - 1]);

        }
        anythingToContinue();
    }

    public static void shop(){
        clearConsole();
        printHeading("Spotykasz tajemniczego nieznajomego.\nTajemniczy nieznajomy oferuje Ci:");
        int price = (int) (Math.random()* (10 + player.pots*3) + 10 + player.pots);
        System.out.println("- Magiczną Miksturę : " + price + " Złota.");
        printSeparator(20);
        System.out.println("Czy chcesz kupić?\n(1) Tak!\n(2) Nie, dzięki.");
        int input = readInt("-> ", 2);
        if(input == 1){
            clearConsole();
            if(player.gold >= price){
                printHeading("Kupiłeś Magiczną Miksturę za " + price + "Złota.");
                player.pots++;
                player.gold -= price;
            }else {
                printHeading("Nie masz wystarczającej ilości Złota aby kupić ten przedmiot...");
                anythingToContinue();
            }
        }
    }

    public static void takeRest(){
        clearConsole();
        if(player.restsLeft >= 1){
            printHeading("Czy chcesz odpocząć? (Zostało jeszcze " + player.restsLeft + " odpoczynków).");
            System.out.println("(1) Tak.\n(2) Nie, nie teraz.");
            int input = readInt("-> ", 2);
            if(input == 1){
                clearConsole();
                if(player.hp < player.maxHp){
                    int hpRestored = (int) (Math.random() * (player.xp/4 + 1) + 10);
                    player.hp += hpRestored;
                    if(player.hp > player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("Odpocząłeś i odnowiłeś sobie " + hpRestored + " życia.");
                    System.out.println("Masz teraz " + player.hp + "/" + player.maxHp + " życia.");
                    player.restsLeft--;
                } else {
                    System.out.println("Masz pełne życie. Nie potrzebujesz teraz odpoczywać!");
                }
                anythingToContinue();
            }
        }
    }

    public static void randomBattle(){
        clearConsole();
        printHeading("Napotkałeś przeciwnika. Musisz z nim walczyć!");
        anythingToContinue();

        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp));
    }

    public static void battle(Enemy enemy){
        while(true){
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Wybierz akcję: ");
            printSeparator(3);
            System.out.println("(1) Walcz\n(2) Użyj Mikstury\n(3) Uciekaj");
            int input = readInt("-> ", 3);

            if (input == 1){
                //fight
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();

                if(dmgTook < 0) {
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if (dmg < 0)
                    dmg = 0;
                player.hp -= dmgTook;
                enemy.hp -= dmg;

                clearConsole();
                printHeading("WALKA");
                System.out.println("Zadajesz " + dmg + " obrażen przeciwnikowi - " + enemy.name + ".");
                printSeparator(3);
                System.out.println("Przeciwnik - " + enemy.name + " - zadał Ci " + dmgTook + " obrażeń.");
                anythingToContinue();
                if(player.hp <= 0) {
                    playerDied();
                    break;
                }else if(enemy.hp <= 0) {
                    clearConsole();
                    printHeading("Pokonałeś - " + enemy.name + "!");

                    player.xp += enemy.xp;
                    System.out.println("Zdobyłeś " + enemy.xp + " XP!");

                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random()*enemy.xp);
                    if(addRest){
                        player.restsLeft++;
                        System.out.println("Dostałeś szansę na dodatkowy odpoczynek!");
                    }
                    if(goldEarned > 0){
                        player.gold += goldEarned;
                        System.out.println("Zebrałeś " + goldEarned + " złota ze zwłok - " + enemy.name + "!");

                    }
                    anythingToContinue();
                    break;
                }
            }else if(input == 2){
                //potion
                clearConsole();
                if(player.pots > 0 && player.hp < player.maxHp){
                    //use potion
                    printHeading("Czy chcesz się napić mikstury? (Zostało Ci" + player.pots + " mikstur).");
                    System.out.println("(1) Tak\n(2) Nie, może później");
                    input = readInt("-> ", 2);
                    if(input == 1){
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("Wypiłeś magiczną miksturę. Przywróciła Ci " + player.maxHp);
                        anythingToContinue();
                    }
                }else {
                    printHeading("Nie masz żadnych mikstur lub jesteś w pełni zdrowia.");
                    anythingToContinue();
                }
            }else {
                clearConsole();

                if(act != 4){
                    if(Math.random()*10 + 1 <= 3.5){
                        printHeading("Uciekłes przed - " + enemy.name + "!");
                        anythingToContinue();
                        break;
                    }else{
                        printHeading("Nie udało Ci się uciec.");

                        int dmgTook = enemy.attack();
                        System.out.println("Podczas nieudanej ucieczki otrzymałeś " + dmgTook + " obrażeń!");
                        anythingToContinue();

                        if(player.hp <= 0)
                            playerDied();
                    }
                }else{
                    printHeading("NIE MOŻESZ UCIEKAĆ PRZED ZŁYM CESARZEM!!! STAW MU CZOŁA JAK PRAWDZIWY MĘŻCZYZNA");
                    anythingToContinue();
                }
            }
        }

    }

    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Wybierz opcje:");
        printSeparator(1);;
        System.out.println("(1) Kontynuuj przygodę");
        System.out.println("(2) Informacje o bohaterze");
        System.out.println("(3) Wyłącz grę");
    }

    public static void finalBattle(){
        battle(new Enemy("ZŁY CESARZ", 300));
        Story.printEnd(player);
        isRunning = false;

    }

    public static void playerDied(){
        clearConsole();
        printHeading("Zginąłeś...");
        printHeading("Zdobyłeś " + player.xp + " XP podczas podróży. Postaraj się zdobyć więcej następnym razem!");
        System.out.println("Dzięki za grę!");
        isRunning = false;
    }

    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("-> ", 3);
            if(input == 1)
                continueJourney();
            else if(input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }
}


