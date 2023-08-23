import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Random random=new Random();
    public static TreeSkeletonGen treeSkeletonGen;
    public static  float GenScaller(int xy,int n1, int n2,int n3){
        return (((xy/n1)*n2)%n3)/(float)n3;
    }
    public static int[] Primes={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541};
    public static Draw Frame = new Draw();
    public static Sky sky = new Sky();
    public static Ground ground=new Ground();
    public static void main(String[] args) {
        treeSkeletonGen=new TreeSkeletonGen();

        for (int i = 0; i < Primes.length; i++) {
            int randomIndexToSwap = Main.random.nextInt(Primes.length);
            int temp = Primes[randomIndexToSwap];
            Primes[randomIndexToSwap] = Primes[i];
            Primes[i] = temp;
        }

        TreeSkeletonGen.vert Trunk;


        Trunk = new TreeSkeletonGen.vert(-180,120,10);
        sky.drawSky();
        Frame.updateF();

        ground.DrawGrass();

        Frame.updateF();

        Trunk.draw(750,600,0);


        for(int i=0;i<10;i++)
            Frame.repaint();
    }
}