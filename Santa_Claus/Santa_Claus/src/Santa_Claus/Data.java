/*
Carlos Ivan Arroyo González
Ricardo Jesus Cruz Jimenez
Jesus Eduardo Gonzalez Martinez
 */
package Santa_Claus;
import java.util.concurrent.Semaphore;

public class Data {
    
    private int duendes = 0;
    private int renos = 0;
    
    final private int TOTAL_RENOS=9;
    final private int GRUPO_DUENDE=3;
    
    private Semaphore mutex = new Semaphore(1);
    private Semaphore semSanta = new Semaphore(0);
    private Semaphore semDuendes = new Semaphore(0);
    private Semaphore semRenos = new Semaphore(0);

    public int getTOTAL_RENOS() {
        return TOTAL_RENOS;
    }
    
    public int getRenos() {
        return renos;
    }

    public void setRenos(int renos) {
        this.renos = renos;
    }

    public int getGRUPO_DUENDE() {
        return GRUPO_DUENDE;
    }

    public int getDuendes() {
        return duendes;
    }

    public void setDuendes(int duendes) {
        this.duendes = duendes;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public Semaphore getSemSanta() {
        return semSanta;
    }

    public void setSemSanta(Semaphore semSanta) {
        this.semSanta = semSanta;
    }

    public Semaphore getSemDuendes() {
        return semDuendes;
    }

    public void setSemDuendes(Semaphore semDuendes) {
        this.semDuendes = semDuendes;
    }

    public Semaphore getSemRenos() {
        return semRenos;
    }

    public void setSemRenos(Semaphore semRenos) {
        this.semRenos = semRenos;
    }
    
}
