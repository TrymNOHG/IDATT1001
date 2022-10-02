import java.util.Scanner;

public class Main {
    
    static int respTwo;
    static int respThree;
    static double money;

    static Valuta swed = new Valuta(0.98, " SEK");
    static Valuta euro = new Valuta(0.096, " €");
    static Valuta dollar = new Valuta(0.11, " $");

    public static void main(String[] args){
        uInter();
    }

    public static void uInter(){

        Scanner firstOpt = new Scanner(System.in);
        System.out.println("Would you like to exchange from or to NOK?");
        System.out.println("If you would like to exchange from NOK, press 1. \nIf you would like to exchange to NOK, press 2.");

        int respOne = firstOpt.nextInt();

        if(respOne == 1){
            Scanner secOpt = new Scanner(System.in);
            System.out.println("Would you like to exchange to SEK, Euro, or Dollars?");
            System.out.println(" For SEK, press 1. \n For euros, press 2. \n For dollars, press 3. \n If you want to return, press 4.");

            respTwo = secOpt.nextInt();
            
            
            if(respTwo == 4){
                uInter();
            }

            else if (respTwo == 1) {
                Scanner whatAmt = new Scanner(System.in);
                System.out.println("How much would you like to exchange?");
                money = whatAmt.nextDouble();
                System.out.println(money + " in " + swed.valutaName + " is " + swed.fraNok(money) + " in NOK.");
            }
            else if (respTwo == 2) {
                Scanner whatAmt = new Scanner(System.in);
                System.out.println("How much would you like to exchange?");
                money = whatAmt.nextDouble();
                System.out.println(money + " in " + euro.valutaName + " is " + euro.fraNok(money) + " in NOK.");
            }
            else if (respTwo == 3) {
                Scanner whatAmt = new Scanner(System.in);
                System.out.println("How much would you like to exchange?");
                money = whatAmt.nextDouble();
                System.out.println(money + " in " + dollar.valutaName + " is " + dollar.fraNok(money) + " in NOK.");
            }
            
        }
        else if(respOne == 2){
            Scanner thirdOpt = new Scanner(System.in);
            System.out.println("Would you like to exchange from SEK, Euro, or Dollars?");
            System.out.println(" For SEK, press 1. \n For euros, press 2. \n For dollars, press 3. \n If you want to return, press 4.");

            respThree = thirdOpt.nextInt();

            if(respTwo == 4){
                uInter();
            }

            else if (respTwo == 1) {

                Scanner whatAmt = new Scanner(System.in);
                System.out.println("How much would you like to exchange?");
                money = whatAmt.nextDouble();
                System.out.println(money + " in NOK is " + swed.toNok(money) + " in " + swed.valutaName);
          
            }

            else if (respTwo == 2) {
               
                Scanner whatAmt = new Scanner(System.in);
                System.out.println("How much would you like to exchange?");
                money = whatAmt.nextDouble();
              
                System.out.println(money + " in NOK is " + euro.toNok(money) + " in " + euro.valutaName);
            }

            else if (respTwo == 3) {
               
                Scanner whatAmt = new Scanner(System.in);
                System.out.println("How much would you like to exchange?");
                money = whatAmt.nextDouble();
               
                System.out.println(money + " in NOK is " + dollar.toNok(money) + " in " + dollar.valutaName);
            }
        }
        else {
            uInter();
        }

    }

    

}
