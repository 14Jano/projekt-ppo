public class Story {

    public static void printIntro() {
        GameSense.clearConsole();
        GameSense.printSeparator(1);
        System.out.println("FABUŁA");
        GameSense.printSeparator(1);
        System.out.println("Jesteś ostatnim człowiekiem, który ocalał po tym, jak armia Złego Cesarza napadla na twoją wioskę.");
        System.out.println("Cała Twoja rodzina, wszyscy przyjaciele i sąsiedzi zostali zamordowani. Stoisz w płonących ruinach tej niegdyś pięknej, tętnącej życiem wioscę");
        System.out.println("Wszystko, czego teraz pragniesz, to zemsta! Zaczynasz planować podróż, aby pokonać Złego Cesarza i wyzwolić ziemię z pod panowania rąk tyrana!");
        GameSense.anythingToContinue();
    }

    public static void printFirstActIntro() {
        GameSense.clearConsole();
        GameSense.printSeparator(1);
        System.out.println("AKT I WPROWADZENIE");
        GameSense.printSeparator(1);
        System.out.println("Rozpoczynając podróż, zaczynasz przemierzać pobliskie lasy, aby dotrzeć do Gór Wiecznego Zapomnienia.");
        System.out.println("Góry Wiecznego Zapomnienia to bardzo niebezpieczne miejsce. Mówi się, że nikt nie wrócił stamtąd żywy.");
        System.out.println("\nPo długim dniu wędrówki po lesie w końcu docierasz do wiecznych Gór Wiecznego Zapomnienia.");
        System.out.println("Nie przejmujesz się tym, co słyszałeś o tym niebezpiecznym miejscu, kierowany żądzą zemsty nie znasz strachu i rozpocznasz swoją podróż, aby pokonać zło");
        GameSense.anythingToContinue();
    }

    public static void printFirstActOutro() {
        GameSense.clearConsole();
        GameSense.printSeparator(1);
        System.out.println("AKT I ZAKOŃCZENIE");
        GameSense.printSeparator(1);
        System.out.println("Zrobiłeś to! Przekroczyłeś Góry Wiecznego Zapomnienia i nadal żyjesz!");
        System.out.println("Kiedy schodzisz z ostatniego wzniesienia, jesteś bardziej niż szczęśliwy, że znów pod stopami czujesz twardy, stabilny grunt.");
        System.out.println("\nCzujesz się wzmocniony przeżytym doświadczeniem, dzięki któremu możesz nauczyć się kolejnej cechy!");
        GameSense.anythingToContinue();
    }

    public static void printSecondActIntro() {
        GameSense.clearConsole();
        GameSense.printSeparator(1);
        System.out.println("AKT II - WPROWADZENIE");
        GameSense.printSeparator(1);
        System.out.println("Rozpoczynasz podróż przez Nawiedzony Cmentarz, o którym słyszałeś przerażające legendy.");
        System.out.println("Zebrałeś trochę złota od potworów, które zabiłeś po drodze.");
        System.out.println("Na szczęście wiesz, że od czasu do czasu pewien stary podróżujący handlarz przemierza tymi szlakami.");
        System.out.println("Wiesz dokładnie, gdzie znajduje się Zamek Złego Cesarza, ale najpierw musisz przekroczyć ten Nawiedzony Cmentarz...");
        GameSense.anythingToContinue();
    }

    public static void printSecondActOutro() {
        GameSense.clearConsole();
        GameSense.printSeparator(1);
        System.out.println("AKT II ZAKOŃCZENIE");
        GameSense.printSeparator(1);
        System.out.println("Udało Ci się przekroczyć Nawiedzony Cmentarz i nadal oddychasz!");
        System.out.println("Tylko kilka godzin wędrówki dzieli Cię od miejsca docelowego; Zamek Złego Cesarza!");
        System.out.println("Wiesz, że prawdopodobnie nie możesz tam odpocząć, więc robisz ostatnią przerwę, aby odzyskać trochę zdrowia..");
        System.out.println("\nPo tym wszystkim, co udało Ci się przeżyć, czujesz, że możesz nauczyć się kolejnej cechy.");
        GameSense.anythingToContinue();
    }

    public static void printThirdActIntro() {
        GameSense.clearConsole();
        GameSense.printSeparator(1);
        System.out.println("AKT III - WPROWADZENIE");
        GameSense.printSeparator(1);
        System.out.println("Widzisz przed sobą ogromny czarny zamek.");
        System.out.println("Stojąc przed bramą wiesz, że nie ma już odwrotu.");
        System.out.println("Przebierasz się za najemnika i wchodzisz do zamku. Nie wiesz, ile czasu ci pozostało, zanim ktoś Cie przejrzy.");
        System.out.println("Wszystko, co możesz teraz zrobić, to walczyć o swoje życie i modlić się, aby wyjść jako zwycięzca...");
        GameSense.anythingToContinue();
    }

    public static void printThirdActOutro() {
        GameSense.clearConsole();
        GameSense.printSeparator(1);
        System.out.println("AKT III - ZAKOŃCZENIE");
        GameSense.printSeparator(1);
        System.out.println("Dotarłeś tak daleko. Pokonałeś wszystkie sługi Złego Cesarza.");
        System.out.println("Stojąc przed drzwiami do jego sali tronowej, wiesz, że nie ma odwrotu.");
        System.out.println("Przywracasz utraconą moc i przywracasz zdrowie.");
        System.out.println("Przed wejściem do sali tronowej masz szansę nauczyć się ostatniej cechy.");
        GameSense.anythingToContinue();
    }

    public static void printFourthActIntro() {
        GameSense.clearConsole();
        GameSense.printSeparator(1);
        System.out.println("AKT IV - WPROWADZENIE");
        GameSense.printSeparator(1);
        System.out.println("Wchodzisz do Sali Tronowej Złego Cesarza.");
        System.out.println("Zły Cesarz patrzy ci prosto w oczy. Czujesz otaczającą Cię aure śmierci.");
        System.out.println("Zły Cesarz wyjmuje święty miecz ciemności - najpotężniejszą broń znaną człowiekowi.");
        System.out.println("Pomimo przytłaczającej aury przeciwnika, zachowujesz spokój, dobrze pamiętasz ile musiałeś znieść aby tu dotrzeć. To Twoja ostatnia i najwazniejsza walka, a Ty jesteś na nią gotów!");
        GameSense.anythingToContinue();
    }

    public static void printEnd (Player player) {
        GameSense.clearConsole();
        GameSense.printSeparator(1);
        if (player.hp > 0) {
            System.out.println("Gratulacje, " + player.name + "! Pokonałeś Złego Cesarza i uratowałeś świat!");
        } else {
            System.out.println("Niestety, " + player.name + "! Przegrałeś ze Złym Cesarzem i świat pogrążył się w chaosie!");
        }
        GameSense.printSeparator(1);
        System.out.println("Ta gra została zaprojektowana przez Dominika Kamińskiego i Jana Łabaj.");
        System.out.println("Mamy nadzieję, że ci się podobało!");
    }
}