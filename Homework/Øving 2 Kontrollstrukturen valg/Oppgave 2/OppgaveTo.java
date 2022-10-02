public class OppgaveTo{

    static double meatAPrice = 35.90;
    static double meatAWeight = 450;
    static double meatBPrice =39.50;
    static double meatBWeight = 500;

    public static void main(String[] args){
        deterCheapest();
    }

    public static void deterCheapest(){

        double meatARatio = meatAPrice/meatAWeight;
        double meatBRatio = meatBPrice/meatBWeight;
        //This determines the price-weight ratio of the meats

        if(meatARatio < meatBRatio){
            System.out.println("Meat A is cheaper!");
        }
        if(meatBRatio < meatARatio){
            System.out.println("Meat B is cheaper!");
        }
        else{
            System.out.println("They cost the same!");
        }

    }

}