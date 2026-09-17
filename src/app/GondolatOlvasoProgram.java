package app;

import java.util.Scanner;

public class GondolatOlvasoProgram {

    private static Scanner sc = new Scanner(System.in);
    
    static String[] pakli = new String[22];
    
    
    public static void main(String[] args) {
        feltolt();
        for (int i = 0; i < 3; i++) {
            kirak();//1 tömb
            melyik(); //Scanner
            kever(); //középre
        }
        ezVolt(); //11., azaz középső lap
    }

    private static void feltolt() {
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        int db = 0;
        for (String szin : szinek) {
            for (String ertek : ertekek) {
                String lap = szin + "_" + ertek;
                if(db < 21){
                    pakli[++db] = lap;
                }
            }
        }
    }

    /**
     * tömb elemeit hármasával
     */
    private static void kirak() {
        for (int i = 1; i < pakli.length; i++) {
            System.out.print(pakli[i] + " ");
            if(i % 3 == 0){
                System.out.println("");
            }
        }
    }

    /**
     * Scanner 1-3 közötti szám
     */
    private static void melyik() {
        boolean jo;
        do {
            System.out.print("melyik oszlop (1-3): ");
            int oszlop = sc.nextInt();
            jo = oszlop >= 1 && oszlop <= 3;
            if(!jo){
                System.out.println("Hibás, újra!");
            }
        } while (!jo);
    }

    /**
     * választott oszlop középre, a sorrendje ne változzon!
     */
    private static void kever() {
        //később
        System.out.println("\n---- KEVERÉS... ----\n");
    }

    /**
     * visszaadjuk a középső lapot, ami 21 elemnél a [11]
     */
    private static void ezVolt() {
        System.out.println("A választott lap: " + pakli[11]);
    }
}
