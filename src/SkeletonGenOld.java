public class SkeletonGenOld {
    static class vert{
        vert br1;
        vert br2;
        vert br3;
        int length;
        int angle;
        vert(int ang, int len,int deapth){
            angle = ang;
            length = len;
            if(deapth>0){
                if(Main.random.nextInt(0,deapth+1)>0) {
                    br1 = new vert(genAngle(), (int) (length / 1.3f), deapth - 1);
                }
                if(Main.random.nextInt(0,deapth+1)>0) {
                    br2 = new vert(genAngle(), (int) (length / 1.3f), deapth - 1);
                }
                if(Main.random.nextInt(0,deapth+1)>0) {
                    br3 = new vert(genAngle(),(int) (length / 1.3f), deapth - 1);
                }
            }
        }
        int genAngle(){
            if(Main.random.nextBoolean())
                return Main.random.nextInt(20,90);
            return -Main.random.nextInt(20,90);
        }
        void draw(float x , float y, int ang){
            int brAngle = ang+angle;
            float newX = x + (float) Math.sin(brAngle/360.0*2*Math.PI)*length;
            float newY = y + (float) Math.cos(brAngle/360.0*2*Math.PI)*length;
            if(br1!=null)
                br1.draw(newX,newY,brAngle);
            if(br2!=null)
                br2.draw(newX,newY,brAngle);
            if(br3!=null)
                br3.draw(newX,newY,brAngle);
            Main.Frame.Line((int)x,(int)y,(int)newX,(int)newY);
        }
    }
}
