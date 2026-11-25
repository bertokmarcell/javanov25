
package app;

import java.util.Arrays;

public class Kartyak {
    private Model[] pakli = new Model[22];
    
    public Model[] getPakli(){
        return Arrays.copyOf(pakli, pakli.length);
    }
    
}
