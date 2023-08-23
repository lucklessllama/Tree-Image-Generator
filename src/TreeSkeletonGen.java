import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Type;

public class TreeSkeletonGen {
    Color treeColor = new Color(40,80,30);
    BufferedImage leafImg;
    int ranLeafRGB(int x,int y, int[] RP){//RP = Random Primes
        float n1=1;
        int nAmo=10;
        for( int i =0;i<nAmo;i++){
            n1 *= Main.GenScaller(x,(i+1)*5,RP[i],RP[i+1])/15.0 + 0.93f;
        }
        for( int i =nAmo;i<nAmo*2;i++){
            n1 *= Main.GenScaller(y,(i+1-nAmo)*5,RP[i],RP[i+1])/15.0 + 0.93f;
        }
        for(int i =nAmo*2;i<nAmo*3;i++){
            n1 *= Main.GenScaller(x+y,(i+1-2*nAmo)*10,RP[i],RP[i+1])/10.0 + 0.92f;
        }


        int red=(int) (255 *n1);
        int green= red/2;
        int blue=0;
        int rgb = red;
        rgb = (rgb << 8) + green;
        rgb = (rgb << 8) + blue;
        return  rgb;
    }
    public TreeSkeletonGen(){
        leafImg=new BufferedImage(1500,750,BufferedImage.TYPE_INT_RGB);
        for(int x=0;x<1500;x++){
            for(int y =0;y<750;y++){
                leafImg.setRGB(x,y,ranLeafRGB(x,y,Main.Primes));
            }
        }

    }
    public static class vert{
        int endDist;
        vert br1;
        vert br2;
        int length;
        int angle;
        vert(int ang, int len,int deapth){
            this.endDist=deapth;
            angle = ang;
            length = len;
            if(deapth>0){
                int a = genAngle();
                if(Main.random.nextInt(0,deapth*5)>0) {
                    br1 = new TreeSkeletonGen.vert(-a, (int) (length / 1.3f), deapth - 1);
                    br2 = new TreeSkeletonGen.vert(a, (int) (length / 1.3f), deapth - 1);
                }
                else {
                    endDist=0;
                }
            }
        }
        int genAngle(){
                return Main.random.nextInt(10,35);
        }
        void draw(float x , float y, int ang){
            int brAngle = ang+angle;

            float newX = x + (float) Math.sin(brAngle/360.0*2*Math.PI)*length;
            float newY = y + (float) Math.cos(brAngle/360.0*2*Math.PI)*length;

            float botLX = x + (float) Math.sin(brAngle/360.0*2*Math.PI+90)*length/10;
            float botLY = y + (float) Math.cos(brAngle/360.0*2*Math.PI+90)*length/10;

            float botRX = x + (float) Math.sin(brAngle/360.0*2*Math.PI-90)*length/10;
            float botRY = y + (float) Math.cos(brAngle/360.0*2*Math.PI-90)*length/10;

            float topLX = newX + (float) Math.sin(brAngle/360.0*2*Math.PI+90)*length/10/1.3f;
            float topLY = newY + (float) Math.cos(brAngle/360.0*2*Math.PI+90)*length/10/1.3f;

            float topRX = newX + (float) Math.sin(brAngle/360.0*2*Math.PI-90)*length/10/1.3f;
            float topRY = newY + (float) Math.cos(brAngle/360.0*2*Math.PI-90)*length/10/1.3f;

            Main.Frame.fileQuad(new int[]{(int)botRX,(int)botLX,(int)topLX,(int)topRX},new int[]{(int)botRY,(int)botLY,(int)topLY,(int)topRY},Main.treeSkeletonGen.treeColor);

            if(br1!=null)
                br1.draw(newX,newY,brAngle);
            if(br2!=null)
                br2.draw(newX,newY,brAngle);
            if(endDist<2){

                BufferedImage im = Main.treeSkeletonGen.leafImg.getSubimage((int)newX-15, (int)newY,30,15);
                Main.Frame.drawImg( im,(int)newX,(int)newY-10);
            }
            else {
                Main.Frame.updateF();
            }
        }
    }
}

