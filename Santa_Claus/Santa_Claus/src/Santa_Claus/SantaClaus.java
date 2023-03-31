/*
Carlos Ivan Arroyo González
Ricardo Jesus Cruz Jimenez
Jesus Eduardo Gonzalez Martinez
 */
package Santa_Claus;
import java.util.concurrent.Semaphore;


public class SantaClaus {
    
   
    public static void main(String[] args) {
        // TODO code application logic here
        Data data=new Data();
      
     
        
        Window window = new Window(data);
        Santa santa=new Santa(data, window);
       
        Duende duende = new Duende(data, window);
       
        Reno reno = new Reno(data, window);
        
        Thread hiloSanta = new Thread(santa);
        Thread hiloDuende = new Thread(duende);
        Thread hiloReno = new Thread(reno);
       
        hiloSanta.start();
        hiloDuende.start();
        hiloReno.start();
        
    }
    
}
