import java.awt.image.BufferedImage;

public class Sky {
    BufferedImage skyImg;
    BufferedImage skyImg2;
    Sky(){
        skyImg = new BufferedImage(1500,750,BufferedImage.TYPE_INT_RGB);
        skyImg2= new BufferedImage(1500,750,BufferedImage.TYPE_INT_ARGB);
        for(int x=0;x<1500;x++){
            for(int y =0;y<750;y++){
                skyImg.setRGB(x,y,ranSkyRGB(x,y,Main.Primes));
                //skyImg2.setRGB(x,y,ranSkyRGB2(x,y,Main.Primes));
            }
        }
        //skyImg.getGraphics().drawImage(skyImg2,0,0,null);
    }
    int ranSkyRGB2(int x,int y, int[] RP){//RP = Random Primes
        float n1=1;
        int nAmo=3;
        for( int i =0;i<nAmo;i++){
            n1 *= Math.min(Main.GenScaller(y,(i+1)*15,RP[i],RP[i+1])/15.0 + 0.95f,1);
        }
        for( int i =nAmo;i<nAmo*2;i++){
            n1 *= Math.min(Main.GenScaller(x,(i+1-nAmo)*10,RP[i],RP[i+1])/10.0 + 0.97f,1);
        }
        for(int i =nAmo*2;i<nAmo*3;i++){
            n1 *=Math.min(Main.GenScaller(x+y,(i+1-2*nAmo)*5,RP[i],RP[i+1])/15.0 + 0.95f,1);
        }

        int blue = 255;
        int green = 255;
        int red = 255;

        int rgb=0;
        System.out.println(rgb);
        rgb = (rgb << 8) + red;
        rgb = (rgb << 8) + green;
        rgb = (rgb << 8) + blue;
        return  rgb;
    }
    int ranSkyRGB(int x,int y, int[] RP){//RP = Random Primes
        float n1=1;
        int nAmo=5;
        for( int i =0;i<nAmo;i++){
            n1 *= Math.min(Main.GenScaller(y,(i+1)*15,RP[i],RP[i+1])/20.0 + 0.975f,1);
        }
        for( int i =nAmo;i<nAmo*2;i++){
            n1 *= Math.min(Main.GenScaller(x,(i+1-nAmo)*10,RP[i],RP[i+1])/20.0 + 0.975f,1);
        }
        for(int i =nAmo*2;i<nAmo*3;i++){
            n1 *=Math.min( Main.GenScaller(x+y,(i+1-2*nAmo)*5,RP[i],RP[i+1])/15.0 + 0.975f,1);
        }

        int blue = (int) (255 * n1);
        int green = blue/4;
        int red = blue/4;
        int rgb = red;
        rgb = (rgb << 8) + green;
        rgb = (rgb << 8) + blue;
        return  rgb;
    }
    void drawSky(){
        Main.Frame.drawImg(skyImg,0,0);
    }
}
