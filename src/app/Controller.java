package app;
import java.util.Arrays;
import java.util.Scanner;
public class Controller {
    
    private static Scanner sc = new Scanner(System.in);
    private static Nezet nezet = new Nezet();
    
    static Model[] pakli = new Model[22];
    
    public static void feltolt() {
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        int db = 0;
        for (String szin : szinek) {
            for (String ertek : ertekek) {
                String lap = szin + "_" + ertek;
                if(db < 21){
                    pakli[++db] = new Model(lap);
                }
            }
        }
    }
    private static void kirak() {
        nezet.kiiras("-----------------------");
        nezet.kiirasf("%-8s%-8s%-8s\n", "1.sor", "2.sor", "3.sor");
        for (int i = 1; i < pakli.length; i++) {
            nezet.kiirasf("%-8s", pakli[i].getErtek());
            if(i % 3 == 0){
                nezet.kiiras("");
            }
        }
        
    }
    private static int melyik() {
        boolean jo;
        int oszlop;
        do {
            nezet.kiirasegysorba("melyik oszlop (1-3): ");
            oszlop = sc.nextInt();
            jo = oszlop >= 1 && oszlop <= 3;
            if(!jo){
                nezet.kiiras("Hibás, újra!");
            }
        } while (!jo);
        return oszlop;
    }
    public static void kever(int oszlop) {
        Model[] uj = new Model[22];
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
    public static String ezVolt() {    
        return pakli[11].getErtek();
    }
    public void start(){
    feltolt();
        for (int i = 0; i < 3; i++) {
            kirak();
            int oszlop = melyik(); 
            kever(oszlop); 
        }
        nezet.kiiras(ezVolt()); 
    }
}
