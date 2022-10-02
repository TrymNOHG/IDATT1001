class OppgaveThree {

    public static void main(String[] args){

        secondConverter(56565);

    }

    public static void secondConverter(int seconds){

        int hours = seconds/3600;
        int minutes = (seconds-(hours*3600))/60;
        int newSec = seconds - (minutes*60 + hours*3600);
        System.out.println("In " + seconds + " seconds, there are " + hours + " hours, " + minutes + " minutes, and " + newSec + " seconds!");
    }

}