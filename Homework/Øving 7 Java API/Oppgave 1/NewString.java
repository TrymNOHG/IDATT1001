final class NewString {

    private String text;
    private String shortenedString = "";
    private String newText;

    public NewString(String text){
        this.text = text;
    }

    public String shortening(){
        String[] arrOfString = this.text.split(" ");
        for(int i = 0; i < arrOfString.length; i++){
            shortenedString += arrOfString[i].substring(0,1);
        }
        return shortenedString;
    }

   public String removalOfChar(char character){

        newText = "";
        
        String[] arrOfString = this.text.split(String.valueOf(character));

        for(int i = 0; i < arrOfString.length; i++){
            newText += arrOfString[i];
        }
        this.text = newText;
        return this.text;

    }
    
}

    //    int storageVal = 1;
    //    int charCounter = 0;
    //     for(int i = 0; i < this.text.length(); i++){
    //         if(this.text.indexOf(character) == i){
    //             charCounter++;
    //             if(charCounter == 2){
    //                 newText += this.text.substring(storageVal, i);
    //                 charCounter = 0;
    //             }
    //             storageVal = i+1;
    //         }
    //     }
    //     return newText;