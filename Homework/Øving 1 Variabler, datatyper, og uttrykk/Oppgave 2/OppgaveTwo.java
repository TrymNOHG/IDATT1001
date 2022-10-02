class OppgaveTwo{

    public static void main(String[] args){
        timeConverter(213,61,1);

    }

    public static void timeConverter(int hours, int minutes, int seconds){
        int numSeconds = 3600*hours + 60*minutes + seconds;
        System.out.println("The total number of seconds is " + numSeconds + " seconds!");
    }

}