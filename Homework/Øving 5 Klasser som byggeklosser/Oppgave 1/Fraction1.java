import java.util.Scanner;

public class Fraction{

    static float dividend;
    static float dividend1;
    static float divisor;
    static float dividend2;
    static int opt;
    static int subtractOption;
    static int divisionOption;
    static int addOption;
    static int multOption;
    static Fraction frac1;
    static Fraction frac2;
    static int counter = 0;

    public Fraction(float teller, float nevner){
        if(nevner == 0){
            throw new IllegalArgumentException("Can't divide by 0!");
        }
        else{
            dividend = teller;
            divisor = nevner;
        }
    }
    
    public Fraction(float teller){
        dividend = teller;
        divisor = 1;
    }

    public static void main(String[] args){
 
       setUp();

        frac1 = new Fraction(dividend1, divisor);
        frac2 = new Fraction(dividend2);

        uInterface();
    }

    public static void setUp(){

        Scanner firstTeller = new Scanner(System.in);
        System.out.println("What do you want the dividend of your first fraction to be?");
        dividend1 = firstTeller.nextFloat();

        Scanner firstNevner = new Scanner(System.in);
        System.out.println("What do you want the divisor of your first fraction to be?");
        divisor = firstNevner.nextFloat();

        Scanner secondTeller = new Scanner(System.in);
        System.out.println("What do you want the dividend of your second fraction to be?");
        dividend2 = secondTeller.nextFloat();

        System.out.println("\n Your two fractions are currently: " + dividend1 + "/" + divisor + " and " + dividend2 + "/" + 1 + "\n" + "\n");

        

    }

    public static void uInterface(){
        Scanner options = new Scanner(System.in);
        System.out.println("\nIf you would like to insert new fractions, press 1.\nIf you would like to add the two fractions, press 2.\nIf you would like to subtract, press 3.\nIf you would like to multiply the two fractions, press 4.\nIf you would like to divide, press 5.\nIf you want to check the fractions, press any other number.");
        opt = options.nextInt();

        if(opt == 1){
            setUp();
        }

        else if(opt == 2){
            Scanner add = new Scanner(System.in);
            System.out.println("\nIf you would like to add fraction 1 by fraction 2, press 1. \nIf you would like to add fraction 2 by fraction 1, press 2");
            addOption = add.nextInt();
            if(addOption == 1){
                frac1.adder(frac2.dividend);
                System.out.println("\n" +"The fraction 1 looks like this: " + frac1.dividend + "/" + frac1.divisor + "\n");
                System.out.println("Fraction 1 is now: " + frac1.getFraction() + "\n" + "\n");
                uInterface();
            }
            else if(addOption == 2){
                frac2.adder((frac1.dividend/frac1.divisor));
                System.out.println("\n" +"The fraction 2 looks like this: " + frac2.dividend + "/" + frac2.divisor + "\n");
                System.out.println("\n" + "Fraction 2 is now: " + frac2.getFraction() + "\n" + "\n");

                uInterface();
            }
            else{
                uInterface();
            }
        }

        else if(opt == 3){
            Scanner subt = new Scanner(System.in);
            System.out.println("\nIf you would like to subtract fraction 1 by fraction 2, press 1.\nIf you would like to subtract fraction 2 by fraction 1, press 2");
            subtractOption = subt.nextInt();
            if(subtractOption == 1){
                frac1.subtracter(dividend2);
                System.out.println("\n" +"The fraction 1 looks like this: " + frac1.dividend + "/" + frac1.divisor + "\n");
                System.out.println("\n" + "Fraction 1 is now: " + frac1.getFraction() + "\n" + "\n");
                uInterface();
            }
            else if(subtractOption == 2){
                frac2.subtracter(frac1.fraction);
                System.out.println("\n" +"The fraction 2 looks like this: " + frac2.dividend + "/" + frac2.divisor + "\n");
                System.out.println("\n" + "Fraction 2 is now: " + frac2.getFraction() + "\n" + "\n");
                uInterface();
            }
            else{
                uInterface();
            }
        }

        else if(opt == 4){
            Scanner mult = new Scanner(System.in);
            System.out.println("\nIf you would like to multiply fraction 1 by fraction 2, press 1.\nIf you would like to multiply fraction 2 by fraction 1, press 2");
            multOption = mult.nextInt();
            if(multOption == 1){
                frac1.multiplier(dividend2);
                System.out.println("\n" +"The fraction 1 looks like this: " + frac1.dividend + "/" + frac1.divisor + "\n");
                System.out.println("\n" + "Fraction 1 is now: " + frac1.getFraction() + "\n" + "\n");
                uInterface();
            }
            else if(multOption == 2){
                frac2.multiplier(frac1.fraction);
                System.out.println("\n" +"The fraction 2 looks like this: " + frac2.dividend + "/" + frac2.divisor + "\n");
                System.out.println("\n" + "Fraction 2 is now: " + frac2.getFraction() + "\n" + "\n");
                uInterface();
            }
            else{
                uInterface();
            }
        }

        else if(opt == 5){
            Scanner divis = new Scanner(System.in);
            System.out.println("\nIf you would like to divide fraction 1 by fraction 2, press 1. \nIf you would like to divide fraction 2 by fraction 1, press 2");
            divisionOption = divis.nextInt();
            if(divisionOption == 1){
                frac1.divider(dividend2);
                System.out.println("\n" +"The fraction 1 looks like this: " + frac1.dividend + "/" + frac1.divisor + "\n");
                System.out.println("\n" + "Fraction 1 is now: " + frac1.getFraction() + "\n" + "\n");
                uInterface();
            }
            else if(divisionOption == 2){
                frac2.divider(frac1.fraction);
                System.out.println("\n" +"The fraction 2 looks like this: " + frac2.dividend + "/" + frac2.divisor + "\n");
                System.out.println("\n" + "Fraction 2 is now: " + frac2.getFraction() + "\n" + "\n");
                uInterface();
            }
            else{
                uInterface();
            }
        }
        else{
            System.out.println("\n" +"The fraction 1 looks like this: " + frac1.dividend + "/" + frac1.divisor + "\n");
            System.out.println("\n" + "Fraction 1 is: " + frac1.getFraction() +  ". Fraction 2 is: " + frac2.getFraction() + ".\n");
            uInterface();
        }
    }

    public void adder(float fraction2){
        int testVal = (frac1.dividend/frac1.divisor) + frac2.dividend2;
        dividend = testVal;
        while(testVal% 1 != 0){
            counter++;
            dividend = testVal;
            dividend = dividend*counter;
        }
        divisor = counter;
    }

    public void subtracter(float fraction2){
        int testVal = (frac1.dividend/frac1.divisor) - frac2.dividend2;
        dividend = testVal;
        while(dividend % 1 != 0){
            counter++;
            dividend = testVal;
            dividend = dividend*counter;
        }
        divisor = counter;

    }

    public void multiplier(float fraction2){
        int testVal = (frac1.dividend/frac1.divisor) * frac2.dividend2;
        dividend = testVal;
        while(dividend % 1 != 0){
            counter++;
            dividend = testVal;
            dividend = dividend*counter;
        }
        divisor = counter;

    }

    public void divider(float fraction2){
        int testVal = (frac1.dividend/frac1.divisor) + frac2.dividend2;
        dividend = testVal;
        while(dividend % 1 != 0){
            counter++;
            dividend = testVal;
            dividend = dividend*counter;
        }
        divisor = counter;
    }

    public float getFraction(){
        //this.fraction = (((this.fraction * 100)%100000000)/100); Attempt at quick rounding
        return (dividend/divisor);
    }

}