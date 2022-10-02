import java.util.Random;

public class Player {
    
int score;
static int diceVal;
static int roll = 1;
static Player a = new Player();
static Player b = new Player();


    public Player(){

        score = 0;

    }

    public static void main(String[] args){
        
        erFerdig();

    }

    public int getScore(){
        return score;
    }

    
    public void kastTerningen(){

        java.util.Random terning = new java.util.Random();
        diceVal = terning.nextInt(6)+ 1;

        if(roll % 2 != 0){
            if(diceVal == 1){
                a.score = 0;
            }
            else{
                a.score += diceVal;
            }
        }
        else{
            if(diceVal == 1){
                b.score = 0;
            }
            else{
                b.score += diceVal;
            }
        }
        
    }

    public static void erFerdig(){

        while(a.getScore() < 100 && b.getScore() < 100){
            if(roll % 2 != 0){
                a.kastTerningen();
                System.out.println("In roll " + roll + ", player A's dice showed: " + diceVal + " and their score is:" + a.getScore());
            }
            else{
                b.kastTerningen();
                    System.out.println("In roll " + roll + ", player B's dice showed: " + diceVal + " and their score is:" + b.getScore());
            }
            roll++;
        }

        if(a.getScore() >= 100){
            System.out.println("Player A won on the " + (roll-1) + "th roll!");
        }
        else{
            System.out.println("Player B won on the " + (roll-1) + "th roll!");
        }

    }

}
