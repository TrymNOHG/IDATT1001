import java.util.Scanner;

public class TextAnalysis {
    
    static int totalChar;
    static int oneLetterCount;
    static int[] antallTegn = new int[30];
    static String text;

    public TextAnalysis(String text){

    }

    public static void main(String[] args){
        
        uInterface();
    }

    public static void uInterface(){
        for(int i = 0; i < 30; i++){
            antallTegn[i] = 0;
        }
        Scanner textInput = new Scanner(System.in);
        System.out.println("Write a text that you wanted analyzed here:");
        text = textInput.nextLine();

        textCounter();
        totalCounter(text);
        percentCounter(text);
        letterCounter('a');
        mostOccuring();
        uInterface();

    }

    public static void textCounter(){
        
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++){
            for(char alphabetCap = 'A'; alphabetCap <= 'Z'; alphabetCap++){
                for(int i = 0; i < 27; i++){
                    for(int j = 0; j < text.length(); j++){
                        if(text.charAt(j) == alphabet || text.charAt(j) == alphabetCap){

                            antallTegn[i]++;
                        }
                    }
                    System.out.println("There are " + antallTegn[i] + alphabet);
                    alphabet++;
                    alphabetCap++;
                }
            }
        }
    }

    public static void letterCounter(char letter){
        int index = 0;
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++){
            for(char alphabetCap = 'A'; alphabetCap <= 'Z'; alphabetCap++){
                if(letter == alphabet || letter == alphabetCap){
                    oneLetterCount = antallTegn[index];
                }
                else{
                    index++;
                }
                alphabet++;
            }
        }  
        System.out.println("There is " + oneLetterCount + " instances of " + letter + ".");
    }

    public static void totalCounter(String text){
        totalChar = 0;
        for(int i = 0; i < 29; i++){

            totalChar += antallTegn[i];

        }
        System.out.println("The total amount of characters is: " + totalChar);
    }

    public static void percentCounter(String text){
        double percent = (double) totalChar/text.length(); 
        System.out.println(percent);
    }

    public static void mostOccuring(){
        int max = 0;
        for(int i = 0; i < 30; i++){
            if(antallTegn[max] < antallTegn[i]){
                max = i;
            }
        }
        
        int indexAlp = 0;

        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++){
            if(max == indexAlp){
                System.out.println(alphabet);
            }
            indexAlp++;
        }

    }
}
