/*
Carlos Ivan Arroyo González
Ricardo Jesus Cruz Jimenez
Jesus Eduardo Gonzalez Martinez
 */
package Santa_Claus;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.Graphics;


public class Window extends JFrame {
    
    private Data data;
    private Graphics gBuffer;
    String urlSanta[]={"santaDormido.png","santaCostal.png",  "santaRegalo.png"};
    String urlDuende[]={"duende1.png", "duende2.png", "duende3.png"};
    Image image, imageSanta, imageFondo;
    
    public void inicializar(){ 
        
        setTitle("Problema de Santa Claus y su Taller");
        setSize(800, 500);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setLayout(null);
        
        String url = "/imagenes/fondo.jpg";
        imageSanta = new ImageIcon(getClass().getResource("/imagenes/"+ urlSanta[0])).getImage();
        imageFondo = new ImageIcon(getClass().getResource(url)).getImage();
       
        setVisible(true);
        }
    
     public Window(Data data){
        this.data = data;
        inicializar();
    }
     
    public void paint(Graphics g){
        super.paint(g);
        update(g);
    }
    
    public void update(Graphics g){ 
     
       BufferedImage buffer = new BufferedImage(800, 500, BufferedImage.TYPE_INT_ARGB);
       gBuffer=buffer.getGraphics();
       
       //gBuffer.fillRect(0, 0, 800, 500);
       gBuffer.drawImage(imageFondo, 0, 0, 800, 500, this);
       dibujarSanta();
       dibujarDuende();
       dibujarReno();
       g.drawImage(buffer, 0, 0, this);
    }
    
        public void dibujarSanta(){
        int x=400;
        int y=300;
        gBuffer.drawImage(imageSanta, x, y, this);
    }
    
    public void dibujarDuende(){
        int x = 100;
        int y = 350;
        
        for(int i = 0; i < data.getDuendes(); i++){
            image = new ImageIcon(getClass().getResource("/imagenes/"+ urlDuende[i])).getImage();
            gBuffer.drawImage(image, x, y, this);
            x+= 100;
        }
    }
    
    public void dibujarReno(){
        int x = 50;
        int y = 30;
        for(int i = 0; i < data.getRenos(); i++){
            image = new ImageIcon(getClass().getResource("/imagenes/reno.png")).getImage();
            gBuffer.drawImage(image, x, y,68,68, this);
            x+= 70;
        }
    }
  
}
