package app;

import java.util.Scanner;

public class GondolatOlvasoProgram {

    private static Scanner sc = new Scanner(System.in);
    
    static String[] pakli = new String[22];
    
    
    public static void main(String[] args) {
        feltolt();
        for (int i = 0; i < 3; i++) {
            kirak();//1 tömb
            int oszlop = melyik(); //Scanner
            kever(oszlop); //középre
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
        System.out.printf("%-8s%-8s%-8s\n", "1. o.", "2. o.", "3. o.");
        for (int i = 1; i < pakli.length; i++) {
            System.out.printf("%-8s", pakli[i]);
            if(i % 3 == 0){
                System.out.println("");
            }
        }
    }

    /**
     * Scanner 1-3 közötti szám
     */
    private static int melyik() {
        boolean jo;
        int oszlop;
        do {
            System.out.print("melyik oszlop (1-3): ");
            oszlop = sc.nextInt();
            jo = oszlop >= 1 && oszlop <= 3;
            if(!jo){
                System.out.println("Hibás, újra!");
            }
        } while (!jo);
        
        return oszlop;
    }

    /**
     * választott oszlop középre, a sorrendje ne változzon!
     */
    private static void kever(int oszlop) {
        String[] uj = new String[22];
        switch(oszlop){
            case 1:
                for (int i = 1; i <= 7; i++) {
                    uj[i] = pakli[ 20-(i-1)*3];
                    uj[i+7] = pakli[ 19-(i-1)*3];
                    uj[i+14] = pakli[ 21-(i-1)*3];
                }
                break;
            case 2:
                for (int i = 1; i <= 7; i++) {
                    uj[i] = pakli[ 19-(i-1)*3];
                    uj[i+7] = pakli[ 20-(i-1)*3];
                    uj[i+14] = pakli[ 21-(i-1)*3];
                }
                break;
            case 3:
                for (int i = 1; i <= 7; i++) {
                    uj[i] = pakli[ 21-(i-1)*3];
                    uj[i+7] = pakli[ 19-(i-1)*3];
                    uj[i+14] = pakli[ 20-(i-1)*3];
                }
                break;
        }
        pakli = uj;
    }

    /**
     * visszaadjuk a középső lapot, ami 21 elemnél a [11]
     */
    private static void ezVolt() {
        System.out.println("A választott lap: " + pakli[11]);
    }
}
