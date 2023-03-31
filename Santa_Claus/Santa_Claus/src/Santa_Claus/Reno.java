/*
Carlos Ivan Arroyo González
Ricardo Jesus Cruz Jimenez
Jesus Eduardo Gonzalez Martinez
 */
package Santa_Claus;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Reno implements Runnable{
    private Data data;
    private Window window;
    public Reno(Data data, Window v){
        this.data=data;
        this.window = v;
    }

    @Override
    public void run() {
        while(true){
        try {
            data.getMutex().acquire();
            
        } catch (InterruptedException ex) {
            System.out.println("Reno exception"+ex);
        }
        if(data.getRenos()==data.getTOTAL_RENOS()-1){
            data.setRenos(data.getRenos()+1);
            data.getSemSanta().release();
            
            System.out.println("Llego el ultimo reno y desperto a Santa");
            window.update(window.getGraphics());
            data.getMutex().release();
            try {
                Thread.sleep((long)(Math.random()*1500+200));
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
            
            try {
                data.getSemRenos().acquire();
                data.setRenos(0);
                window.update(window.getGraphics());
                 //Thread.sleep((long) (Math.random()*500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Reno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            data.setRenos(data.getRenos()+1);
            System.out.println("Un reno ha llegado al taller. Ahora hay: "+data.getRenos());
            window.update(window.getGraphics());
            data.getMutex().release();
            try {
                Thread.sleep((long)(Math.random()*1500+200));
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
            
        }
    }
    }
}
