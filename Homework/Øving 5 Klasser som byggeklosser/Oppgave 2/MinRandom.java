import java.util.Random;

public class MinRandom {
    static java.util.Random randoObj;
    static int randoInt;
    static double randoDoub;
    public static void main(String[] args){
        randoObj = new java.util.Random();
        
        System.out.println(nesteHeltall(1,5));
        
        System.out.println(nesteDesimaltall(2,7.777));
       

    }

    public static int nesteHeltall(int nedre, int ovre){

        randoInt = randoObj.nextInt((ovre-nedre)+1) + nedre;
        return randoInt;
        
    }

    public static double nesteDesimaltall(double nedre, double ovre){
        randoDoub = nedre + (ovre-nedre)*randoObj.nextDouble();
        return randoDoub;
    }
}
