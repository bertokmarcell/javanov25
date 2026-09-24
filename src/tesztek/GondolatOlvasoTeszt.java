package tesztek;

import app.GondolatOlvasoProgram;

public class GondolatOlvasoTeszt {
    
    
    public static void main(String[] args) {
        
        /* invariánsok: feltoltés és keveres után */
        testPakliMerete();
        testPaklibanNincsNull();
        testPaklibanNincsDuplikatum();
        testPaklibanMindenLapSzerepelEgyszer();
        
        testPaklibanNincsNullKeveresUtan();
        testPakliMereteNemValtozikKeveresUtan();
        testLapNemValtozikKeveresUtan();
        testPaklibanNincsDuplikatumKEveresUtan();
        testPaklibanMindenLapSzerepelEgyszerKeveresUtan();
        
        /* keveres használata */
        testEgyKeveresUtanLapJoHelyreKerul();
        testKeveresUtanMindenLapHelyzeteValtozik();//kell???
        testHaromKeveresUtanMegfeleloLapKozepen();
        
        testAzonosKiindulasbolKeveresUtanMindigAzonosAllapot();
    }

    private static void testPakliMerete() {
        System.out.print("Pakli mérete: ");
        int vart = 22;
        int kapott = GondolatOlvasoProgram.getPakli().length;
        assert vart == kapott : "nem megfelelő a pakli mérete!";
        System.out.println("ok");
    }

    private static void testPaklibanNincsNull() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void testPaklibanNincsDuplikatum() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void testPaklibanMindenLapSzerepelEgyszer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void testPaklibanNincsNullKeveresUtan() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private static void testPakliMereteNemValtozikKeveresUtan() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private static void testLapNemValtozikKeveresUtan() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void testEgyKeveresUtanLapJoHelyreKerul() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void testKeveresUtanMindenLapHelyzeteValtozik() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void testHaromKeveresUtanMegfeleloLapKozepen() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void testPaklibanNincsDuplikatumKEveresUtan() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static void testPaklibanMindenLapSzerepelEgyszerKeveresUtan() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private static void testAzonosKiindulasbolKeveresUtanMindigAzonosAllapot() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
