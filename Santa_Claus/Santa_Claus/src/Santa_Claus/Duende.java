/*
Carlos Ivan Arroyo González
Ricardo Jesus Cruz Jimenez
Jesus Eduardo Gonzalez Martinez
 */
package Santa_Claus;

import java.util.logging.Logger;
import java.util.logging.Level;


public class Duende implements Runnable{
    private Data data;
    private Window window;
    public Duende(Data data, Window v){
        this.data = data;
        this.window = v;
    }

    @Override
    public void run() {
        while(true){
            try {
                data.getMutex().acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Duende.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(data.getDuendes() == data.getGRUPO_DUENDE()-1){
                data.setDuendes(data.getDuendes()+1);
                
                
                data.getSemSanta().release();
                window.update(window.getGraphics());
                System.out.println("Los tres duendes despiertan a Santa Claus");
                data.getMutex().release();
                try {
                    Thread.sleep((long)(Math.random()*2500+600));
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
                
                try {
                    data.getSemDuendes().acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Duende.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                data.setDuendes(0);
                window.update(window.getGraphics());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Duende.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                data.setDuendes(data.getDuendes()+1);
                System.out.println("duendes "+data.getDuendes());
                window.update(window.getGraphics());
                data.getMutex().release();
                try {
                    Thread.sleep((long)(Math.random()*2500+600));
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
                
            }
        }
    }
    
}