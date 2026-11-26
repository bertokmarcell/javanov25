package app;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Controller {
    
    private static Nezet nezet = new Nezet();
    private static JFrame keret = new JFrame();
    private static JTextArea text = new JTextArea();
    private static JButton b1=new JButton();
    private static JButton b2=new JButton();
    private static JButton b3=new JButton();
    private static String tarolo="";
    private static int szamlalo =0;
    
    
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
    public static void start(){
        
    feltolt();
        for (int i = 0; i < 3; i++) {
            kirak();
            int oszlop = melyik(); 
            kever(oszlop); 
        }
        nezet.kiiras(ezVolt()); 
    }
    
    public static void gui_start(){
        
        b1.setText("elso sor");
        b2.setText("masodik sor");
        b3.setText("harmadik sor");
        
        keret.setLayout(new GridLayout(1, 1));
        b1.setSize(20,20);
        keret.setSize(500,350);
        text.setSize(150,200);
        keret.setLocationRelativeTo(null);
        feltolt();
        keretirasok(pakli);
        keret.add(text);
        keret.add(b1);
        keret.add(b2);
        keret.add(b3);
        keret.setVisible(true);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kever(1);
                text.setText("");
                keretirasok(pakli);
                szamlalo+=1;
                if(szamlalo%3==0){
                    tarolo=pakli[11].getErtek();
                    text.setText("");
                    feltolt();
                    keretirasok(pakli);
                    text.append("kivalaszott szama= ");
                    text.append("\n"+tarolo);
                    b1.setText("újra");
                    b2.setText("újra");
                    b3.setText("újra");
                }
                if(!(szamlalo%3==0)){
                    b1.setText("els");
                    b2.setText("mas");
                    b3.setText("harm");
                }
                
                
            }
                
        });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kever(2);
                text.setText("");
                keretirasok(pakli);
                szamlalo+=1;
                if(szamlalo%3==0){
                    tarolo=pakli[11].getErtek();
                    text.setText("");
                    feltolt();
                    keretirasok(pakli);
                    text.append("kivalaszott szama= ");
                    text.append("\n"+tarolo);
                    
                    b1.setText("újra");
                    b2.setText("újra");
                    b3.setText("újra");
                }
                if(!(szamlalo%3==0)){
                    b1.setText("els");
                    b2.setText("mas");
                    b3.setText("harm");
                }
                
                
            }
                
        });
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kever(3);
                text.setText("");
                keretirasok(pakli);
                szamlalo+=1;
                if(szamlalo%3==0){
                    tarolo=pakli[11].getErtek();
                    text.setText("");
                    feltolt();
                    keretirasok(pakli);
                    text.append("kivalaszott szama= ");
                    text.append("\n"+tarolo);
                    b1.setText("újra");
                    b2.setText("újra");
                    b3.setText("újra");
                }
                if(!(szamlalo%3==0)){
                    b1.setText("els");
                    b2.setText("mas");
                    b3.setText("harm");
                }
                
     
            }
                
        });
        
        
    }
    
    public static void keretirasok(Model[] kartyak){
        String s = "";
        for (int i = 1; i < kartyak.length; i++) {
            s=s+kartyak[i].getErtek()+"   ";
            if(i % 3 == 0){
                text.append(s+  "\n");
                text.append("\n");
                s="";
            }
        }
    }
}
