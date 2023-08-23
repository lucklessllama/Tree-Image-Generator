import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Draw extends JFrame {
    Image img;
    public Draw(){
        this.setSize(1500,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        img=new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
    }
    public void drawImg(BufferedImage img2,int x ,int y){
        img.getGraphics().drawImage(img2,x,y,null);
    }
    public void fillRect(int x,int y,int height,int width,Color color){
        Graphics2D g2d= (Graphics2D) img.getGraphics();
        g2d.setColor(color);
        g2d.fillRect(x,y,width,height);
    }
    public void Line(int x1,int y1,int x2,int y2){
        Graphics2D g2d= (Graphics2D) img.getGraphics();
        g2d.drawLine(x1,y1,x2,y2);
    }
    public void fileQuad(int[] X,int[] Y , Color color){
        Graphics2D g2d= (Graphics2D) img.getGraphics();
        g2d.setColor(color);
        g2d.fillPolygon(X,Y,4);
    }

    public void clearImg(){
        img=new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);

        img.getGraphics().fillRect(0,0,getWidth(),getHeight());
    }


    public void updateF() {
        repaint();
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d =(Graphics2D) g;
        g2d.drawImage(img, 0, 0,getWidth(),getHeight(),null);
    }
}
