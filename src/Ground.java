import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Ground {
    Color grassColor=new Color(0.5f, 1f, 0f,1f);
    Color DirtColor;
    Color ranGrassColor(){
        float ran= Main.random.nextFloat(0.5f,1f);
        return new Color(0.5f*ran,0.9f*ran,0,0.5f);
    }
    int ranGrassRGB(int x,int y, int[] RP){//RP = Random Primes

        float n1=1;
        int nAmo=5;
        for( int i =0;i<nAmo;i++){
            n1 *= Main.GenScaller(x,(i+1)*10,RP[i],RP[i+1])/20.0 + 0.95f;
        }
        for( int i =nAmo;i<nAmo*2;i++){
            n1 *= Main.GenScaller(y,(i+1-nAmo)*10,RP[i],RP[i+1])/20.0 + 0.95f;
        }
        for( int i =nAmo*2;i<nAmo*3;i++){
            n1 *= Main.GenScaller(x+y,(i-2*nAmo+1)*10,RP[i],RP[i+1])/20.0 + 0.95f;
        }

        int green= (int) (255 *n1);
        int red=green/2;
        int blue=0;
        int rgb= 255;
        n1=1;
        n1*=Math.abs(Math.floor(Math.sin(x/70.0)*20)/800)+0.98f;
        n1*=Math.abs(Math.floor(Math.sin(x/400.0)*10)/400)+0.97f;
        if(n1*250 < 250-y){
            rgb=0;
        }
        rgb = (rgb<<8)+red;
        rgb = (rgb << 8) + green;
        rgb = (rgb << 8) + blue;
        return  rgb;
    }
    void DrawGrass(){
        BufferedImage image=new BufferedImage(1500,250,BufferedImage.TYPE_INT_ARGB);
        for(int x=0;x<1500;x++){
            for(int y =0;y<250;y++){
                image.setRGB(x,y,ranGrassRGB(x,y,Main.Primes));
            }
        }
        Main.Frame.drawImg(image,0,500);
    }

}
