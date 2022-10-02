import java.util.Random;

public class RandomGenerator {
    
    static int randomNum;
    static int[] arr;
    static int[] roundedArr = new int[10];
    static java.util.Random rando;
    static int[] antall = new int[10];
    static String zeros = "";
    static String ones = "";
    static String twos = "";
    static String threes = "";
    static String fours = "";
    static String fives = "";
    static String sixes = "";
    static String sevens = "";
    static String eights = "";
    static String nines = "";
    static String[] stars = new String[10];
  
    public static void main(String[] args){

        randSeqGen(1000);
        counter(1000);
        extraWork();

    }

    public static void counter(int iterations){
        for(int i = 0; i < 10; i++){
            System.out.println("In " + iterations + " iterations, there were " + antall[i] + "   " + i + "'s!");
        }
    }

    public static void randSeqGen(int iterations){
        arr = new int[iterations];
        for(int i = 0; i < iterations; i++){
         rando = new java.util.Random();
         randomNum = rando.nextInt(10);
            arr[i] = randomNum;
            antall[randomNum]++;
        }
    }

    public static int rounder(int arrayNum){
        for(int i = 0; i < 10; i++){
            roundedArr[i] = (int) java.lang.Math.ceil((double)antall[i]/10)*10;
        }
        return roundedArr[arrayNum];
    }

    public static void extraWork(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < rounder(i)/10; j++){
                if(i == 0){
                    zeros = zeros + "*";
                }
                else if(i == 1){
                    ones = ones + "*";
                }
                else if(i == 2){
                    twos = twos + "*";
                }
                else if(i == 3){
                    threes = threes + "*";
                }
                else if(i == 4){
                    fours = fours + "*";
                }
                else if(i == 5){
                    fives = fives + "*";
                }
                else if(i == 6){
                    sixes = sixes + "*";
                }
                else if(i == 7){
                    sevens = sevens+ "*";
                }
                else if(i == 8){
                    eights = eights + "*";
                }
                else{
                    nines = nines + "*";
                }
                
            }

            String[] stars = {zeros, ones, twos, threes, fours, fives, sixes, sevens, eights, nines};

            System.out.println("\n" + i + "  " + antall[i] + " " + stars[i]); 
       }

    }
}
