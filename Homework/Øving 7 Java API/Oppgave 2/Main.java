import java.util.Scanner;

public class Main {

    static TextAnalyzer textInput;
    static boolean infiniLoop = true;
    static int optNum;
    public static void main(String[] args){
        
        uInterface();

    }
    
    public static void uInterface(){

        System.out.println("\nPlease write a text: \n");
        Scanner quest1 = new Scanner(System.in);
        textInput = new TextAnalyzer(quest1.nextLine());

        while(infiniLoop == true){

            System.out.println("\nWhat do you want to do? \nIf you want the word count, press 1.\nIf you want the average word length, press 2.\nIf you want the average words per sentence, press 3.\nIf you want to replace a word in the text, press 4.\nIf you want to see the text again, press 5.\nIf you want to see the text but capitalized, press 6\nIf you want to write another text, press 7.\n");
            Scanner opt = new Scanner(System.in);
            optNum = opt.nextInt();

            if(optNum == 1){
                System.out.println("\nThe word count is: " + textInput.wordCount() + "\n");
                
            }

            else if(optNum == 2){
                System.out.println("\nThe average word length is: " + textInput.avgWordLen() + "\n");
            }

            else if(optNum == 3){
                System.out.println("\nThe average word per sentence is: " + textInput.avgWordPerSent() + "\n");
            }

            else if(optNum == 4){
                System.out.println("\nWhat word do you want to change?\n");
                Scanner word1 = new Scanner(System.in);
                String wordChange = word1.nextLine();
                System.out.println("\nWhat do you want to replace it with?\n");
                Scanner word2 = new Scanner(System.in);
                String wordReplacement = word2.nextLine();
                System.out.println("\nYou have now replaced " + wordChange + " with " + wordReplacement + ".\nThe text is now: \n" + textInput.changeWord(wordChange, wordReplacement));
            }

            else if(optNum == 5){
                System.out.println("\n" + textInput.getText() + "\n");
            }

            else if(optNum == 6){
                System.out.println("\n" + textInput.getAllCapText() + "\n");
            }

            else if(optNum == 7){
                uInterface();
            }
        }
    }

}
