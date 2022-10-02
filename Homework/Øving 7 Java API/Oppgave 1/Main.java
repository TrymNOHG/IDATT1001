import java.util.Scanner;

public class Main {

    static NewString textInput;
    static int numAnswer;
    static boolean infiniLoop = true;
    public static void main(String[] args){

        uInterface();

    }

    public static void uInterface(){

        System.out.println("\nPlease write a text: \n");
        Scanner quest1 = new Scanner(System.in);
        textInput = new NewString(quest1.nextLine());

        while(infiniLoop == true){
            System.out.println("\nHow would you like the text to be analyzed? \nIf you want it to be shortened, press 1. \nIf you want it to remove a character, press 2. \nIf you want a new text, press 3.\n");
            Scanner quest2 = new Scanner(System.in);
            numAnswer = quest2.nextInt();
            
            if(numAnswer == 1){

                System.out.println("\n" + textInput.shortening());

            }

            else if(numAnswer == 2){        

                System.out.println("\nWhat character would you like to remove?\n");
                Scanner quest3 = new Scanner(System.in);
                String removeCharString = quest3.nextLine();
                char removeChar = removeCharString.charAt(0);
     
                System.out.println("\n" + textInput.removalOfChar(removeChar));
                

            }

            else if(numAnswer == 3){
                break;
            }

        }

        uInterface();
    }

}
