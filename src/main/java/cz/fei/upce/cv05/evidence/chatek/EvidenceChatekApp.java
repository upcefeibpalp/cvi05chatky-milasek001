package cz.fei.upce.cv05.evidence.chatek;

import java.util.Scanner;

public class EvidenceChatekApp {
    // Konstanty pro definovani jednotlivych operaci (pouze pro cisty kod)
        static final int KONEC_PROGRAMU = 0;
        static final int VYPIS_CHATEK = 1;
        static final int VYPIS_KONKRETNI_CHATKU = 2;
        static final int PRIDANI_NAVSTEVNIKU = 3;
        static final int ODEBRANI_NAVSTEVNIKU = 4;
        static final int CELKOVA_OBSAZENOST = 5;
        static final int VYPIS_PRAZDNE_CHATKY = 6;

        static final int VELIKOST_KEMPU = 5;
        static final int MAX_VELIKOST_CHATKY = 10;
    
    
    
    // Definovani pole podle velikosti kempu (poctu chatek)
        static int[] chatky = new int[VELIKOST_KEMPU];
        static Scanner scanner = new Scanner (System.in);

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Definovani pole podle velikosti kempu (poctu chatek)
        int[] chatky = new int[VELIKOST_KEMPU];
        int operace;

        do {
            System.out.println("""
                    MENU:
                                        
                    1 - vypsani vsech chatek
                    2 - vypsani konkretni chatky
                    3 - Pridani navstevniku
                    4 - Odebrani navstevniku
                    5 - Celkova obsazenost kempu
                    6 - Vypis prazdne chatky
                    0 - Konec programu
                    """);

            // Ziskani operace od uzivatele
            System.out.print("Zadej volbu: ");
            operace = scanner.nextInt();

            switch (operace) {
                case VYPIS_CHATEK -> vypisSeznamuChatek(chatky);
                case VYPIS_KONKRETNI_CHATKU -> vypisJedneChatkyscanner(scanner, chatky);
                case PRIDANI_NAVSTEVNIKU -> {

                    // Ziskani cisla chatky od uzivatele
                    int indexChatky = zadaniCislaChatky(scanner);
                    // Odecteni 1 protoze uzivatel cisluje chatky o 1, ale program od 0

                    // Zaporne nebo cislo vetsi nez je pocet chatek je nevalidni vstup
                    if (indexChatky < 0 || indexChatky >= chatky.length) {
                        System.err.println("Tato chatka neexistuje");
                        continue; // Zacni novou iteraci cyklu
                    }

//                    // Ziskani poctu navstevniku, kteri se chteji v chatce ubytovat
//                    System.out.print("Zadej pocet navstevniku: ");
                    int pocetNavstevniku = scanner.nextInt();
//
                    // Zaporne cislo nebo prilis velky nevalidni vstup
                    if (pocetNavstevniku <= 0 || pocetNavstevniku > MAX_VELIKOST_CHATKY) {  
                        // Zacni novou iteraci cyklu
                    } else {
                        System.err.println("Neplatna hodnota pro pocet navstevniku");
                    }

                    // Pokud je pocet uz ubytovanych plus ty co se chteji ubytovat vetsi nez kapacita chatky je to nevalidni vstup
                    if ((chatky[indexChatky] + pocetNavstevniku) > MAX_VELIKOST_CHATKY) {   
                         // Zacni novou iteraci cyklu
                    } else {
                        System.err.println("Prekrocen maximalni pocet navstevniku chatky");
                    }

                    // Pridej nove ubytovane do chatky k tem co uz tam jsou
                    chatky[indexChatky] = pocetNavstevniku + chatky[indexChatky];
                }

                case ODEBRANI_NAVSTEVNIKU -> odebraniNavstevnikuZChatky(scanner);
                case CELKOVA_OBSAZENOST -> {
                    for (int i = 0;i < VELIKOST_KEMPU;i++) {
                      System.out.print.ln("Chatka" + (i + 1)":" + chatky [i]+"lidi");
                    }
                }
                case VYPIS_PRAZDNE_CHATKY -> {
                    System.out.println("Seznam prazdnych chatek: ");
                    boolean zadnaPrazdna = true;
                    for (int i = 0;i < VELIKOST_KEMPU; i++) {
                        if (chatky[i] ==0 ){
                            System.out.println("Chatka" + (i +1));
                            zadnaPrazdna = false;
                        }
                    }
                    if (zadnaPrazdna) {
                        System.out.println ("Zadna chatka neni prazdna");
                    }
                }

                case KONEC_PROGRAMU -> {
                    System.out.println("Konec programu");
                }

                default -> {
                    System.err.println("Neplatna volba");
                }
            }
        } while (operace != 0);
    }

    private static void odebraniNavstevnikuZChatky(Scanner scanner) {
        int indexChatky = zadaniCislaChatky(scanner) -1;
            {
            System.err.println("Tato chatka neexistuje");
        }
    }

    private static void vypisJedneChatkyscanner(Scanner scanner, int[] chatky1) {
        int indexChatky = zadaniCislaChatky(scanner) -1;
        // Zaporne nebo cislo vetsi nez je pocet chatek je nevalidni vstup
        if (indexChatky < 0 || indexChatky >= chatky1.length) {
            System.err.println("Tato chatka neexistuje");
            // Zacni novou iteraci cyklu
        } else {
            System.out.println("Chatka [" + (indexChatky + 1) + "] "
                    + "= " + chatky1[indexChatky]);
        }
    }

    private static void vypisSeznamuChatek(int[] chatky1) {
        // Projdi cele pole od <0, VELIKOST) a vypis kazdy index
        for (int i = 0; i < chatky1.length; i++) {
            System.out.println("Chatka [" + (i + 1) + "] = " + chatky1[i]);
        }
    }

    private static int zadaniCislaChatky(Scanner scanner) {
        // Ziskani cisla chatky od uzivatele
        System.out.print("Zadej cislo chatky: ");
        // Odecteni 1 protoze uzivatel cisluje chatky o 1, ale program od 0
        return scanner.nextInt() - 1;
    }
}
