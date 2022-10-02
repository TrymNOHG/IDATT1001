public class TextAnalyzer {
    
    private int wordCount;
    private String text;
    private float avgWordLength;
    private int letterCounter = 0;
    private float avgWordPerSentence;
    private String storageText;

    public TextAnalyzer(String text){
        this.text = text;
    }

    public int wordCount(){

        String[] arrOfString = this.text.split(" ");
        wordCount = arrOfString.length;
        return wordCount;

    }

    public float avgWordLen(){

        String[] arrOfString = this.text.split(" ");
        for(int i = 0; i < arrOfString.length; i++){
            letterCounter += arrOfString[i].length();
        }
        avgWordLength = (float) letterCounter/this.wordCount();
        
        return avgWordLength;

    }

    public float avgWordPerSent(){

        String[] arrOfString = this.text.split("[.!:?]");
        avgWordPerSentence = (float) this.wordCount/arrOfString.length;
        return avgWordPerSentence;

    }

    public String changeWord(String word, String replacementWord){

        while(this.text.indexOf(word) != -1){
            int index = this.text.indexOf(word);
            this.text = this.text.substring(0, index) + replacementWord + this.text.substring(index + word.length());
        }
        return this.text;
    }

    public String getText(){
        
        return this.text;
    }

    public String getAllCapText(){

        return this.text.toUpperCase();


    }

}
