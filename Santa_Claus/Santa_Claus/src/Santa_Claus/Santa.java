/*
Carlos Ivan Arroyo González
Ricardo Jesus Cruz Jimenez
Jesus Eduardo Gonzalez Martinez
 */
package Santa_Claus;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import java.awt.Image;


public class Santa implements Runnable{
    private Data data;
    private Window window;
    public Santa(Data data, Window v){
        this.data = data;
        this.window = v;
    }
    
    @Override
    public void run() {
       while(true){
           try {
               data.getSemSanta().acquire();
               data.getMutex().acquire();
           } catch (InterruptedException ex) {
               System.out.println("Santa Claus exception"+ex);
           }
           if(data.getRenos()==data.getTOTAL_RENOS()){
               data.getSemRenos().release();
               System.out.println("Santa Claus ha salido a dar los regalos");
               try {
                       window.imageSanta = new ImageIcon(getClass().getResource("/imagenes/"+ window.urlSanta[1])).getImage();
                       window.update(window.getGraphics());
                       Thread.sleep(1000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
               data.getMutex().release();
               window.imageSanta = new ImageIcon(getClass().getResource("/imagenes/"+ window.urlSanta[0])).getImage();
               window.update(window.getGraphics());
               try {
                       Thread.sleep(100);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
           }else{
               if(data.getDuendes() == data.getGRUPO_DUENDE()){
                   data.getSemDuendes().release();
                   System.out.println("Santa Claus ayuda a los duendes");
                   try {
                       window.imageSanta = new ImageIcon(getClass().getResource("/imagenes/"+ window.urlSanta[2])).getImage();
                       window.update(window.getGraphics());
                       Thread.sleep(1000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                   data.getMutex().release();
                   window.imageSanta = new ImageIcon(getClass().getResource("/imagenes/"+ window.urlSanta[0])).getImage();
                    window.update(window.getGraphics());
                    try {
                
                       Thread.sleep(100);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
       }
    }
    
}
