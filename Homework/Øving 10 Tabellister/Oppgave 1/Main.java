import java.util.Scanner;

public class Main {
    
    static Scanner quest2;
    static ArrangementRegister registery = new ArrangementRegister();
    static boolean infini = true;

    public static void main(String[] args){

        while(infini){
        uInterface();
        } 

    }

    /**
     * This method acts as the user interface. It, therefore, has all the different questions which helps the program navigate its methods.
     */
    public static void uInterface(){
        System.out.println("\nIf you would like to add an event, press 1.\nIf you would like to find all events that are occurring at a given location, press 2.\nIf you would like all events that are occurring at a given date, press 3.\nIf you would like to find all the events that are occurring between a given time interval, press 4.\nIf you would like to see the events ordered in a special way, press 5");
        Scanner quest = new Scanner(System.in);
        int ans = quest.nextInt();

        switch(ans){
            case 1:
                quest2 = new Scanner(System.in);
                System.out.println("\nWhat identification number does the event have?");
                int number = quest2.nextInt();

                quest2 = new Scanner(System.in);
                System.out.println("\nWhat is the event called?");
                String navn = quest2.nextLine();

                quest2 = new Scanner(System.in);
                System.out.println("\nWhere is the event happening?");
                String sted = quest2.nextLine();

                quest2 = new Scanner(System.in);
                System.out.println("\nWho is arranging it?");
                String arranger = quest2.nextLine();

                quest2 = new Scanner(System.in);
                System.out.println("\nWhat type of event is it?");
                String type = quest2.nextLine();

                quest2 = new Scanner(System.in);
                System.out.println("\nWhat date and time is this event occuring? Write this in the form of year month date time, ex. kl 18 the 30th of October 2002 is written as 200210301800");
                double date = quest2.nextDouble();

                registery.registerEvent(new Arrangement(number, navn, sted, arranger, type, date));

                break;

            case 2:
                quest2 = new Scanner(System.in);
                System.out.println("\nWhat location do you want to check?");
                String location = quest2.nextLine();
                registery.getEventFromLoc(location);
                break;

            case 3:
                quest2 = new Scanner(System.in);
                System.out.println("\nWhat date do you want to check?");
                double date2 = quest2.nextDouble();
                registery.getEventFromDate(date2);
                break;

            case 4:
                quest2 = new Scanner(System.in);
                System.out.println("\nBetween which two dates do you want to check? First type the first date and then the second. \nFirst time:");
                double firstTime = quest2.nextDouble();
                System.out.println("Second Time:");
                quest2 = new Scanner(System.in);
                double secondTime = quest2.nextDouble();
                registery.getEventsTimeInterval(firstTime, secondTime);
                break;

            case 5:
                quest2 = new Scanner(System.in);
                System.out.println("\nIf you would like to sort it by date, press 1.\nIf you would like to sort it by location, press 2.\nIf you would like to sort it by type of event, press 3.");
                int ansTwo = quest2.nextInt();
                registery.listMaker(ansTwo);
                break;
        }
    }

}
