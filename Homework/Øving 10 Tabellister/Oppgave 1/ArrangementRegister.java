import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class has the necessary methods to create and call forth specific lists of events based on factors such as time, location, and date. The class also functions as a registry, making it possible to add more events to the list if needed.
 */
public class ArrangementRegister {
  
    private ArrayList<Arrangement> register;
    static ArrayList<String> eventList; //Not static! Use it at the start of each method instead.


    public ArrangementRegister(){

      register = new ArrayList<Arrangement>();

    }

    /**
     * This method registers new events by adding them to the ArrayList initialized in the constructor.
     * @param newEvent
     */
    public void registerEvent(Arrangement newEvent){ //Registers new events (initializes instances of the arrangement constructor/creates new arrangement object)
        this.register.add(newEvent);
    }

    /**
     * This method creates an ArrayList of all the events occurring in a particular place. Then, it prints out the list of events.
     * @param location
     */
    public void getEventFromLoc(String location){ //Get all the events from a given location.
        
        eventList = new ArrayList<String>();
        
        for(int i = 0; i < this.register.size(); i++){
            if(this.register.get(i).getLocation().equals(location)){
                eventList.add(this.register.get(i).getName());
            }
        }

        System.out.println("\nEvents occuring in " + location + ": ");
        for(int i = 0; i < eventList.size(); i++){
            System.out.println("- " + eventList.get(i));
        }

    }

    /**
     * This method creates a list of all the different events occurring on a specific date. Then, it prints out the list of events.
     * @param date
     */
    public void getEventFromDate(double date){ //Get all the events from a given date.
        
        eventList = new ArrayList<String>();
        for(int i = 0; i < this.register.size(); i++){
            if(this.register.get(i).getDateTime() == date){
                eventList.add(this.register.get(i).getName());
            }
        }

        // if(eventList.get(0) == null){
        //     System.out.println("There are no events at this location.");
        // }
        System.out.println("\nEvents occuring at the date" + date + ": "); //USE FORMATTER TO CREATE DATE
        for(int i = 0; i < eventList.size(); i++){
            System.out.println("- " + eventList.get(i));
        }
    }

    /**
     * This method creates a list of all the events occurring between a given time interval. Then, the method prints out all the events from the list.
     * @param firstTime
     * @param secondTime
     */
    public void getEventsTimeInterval(double firstTime, double secondTime){ //Get all the events within a given time interval.
        eventList = new ArrayList<String>();
        for(int i = 0; i < this.register.size(); i++){
            if(this.register.get(i).getDateTime() >= firstTime && this.register.get(i).getDateTime() <= secondTime){
                eventList.add(this.register.get(i).getName());
            }
        }

        //Needs to be sorted according to what goes first.

        System.out.println("\nEvents occurring between the date" + firstTime + " and " + secondTime + ": "); //USE FORMATTER TO CREATE DATE
        for(int i = 0; i < eventList.size(); i++){
            System.out.println("- " + eventList.get(i));
        }
        
    }
    
    public void listMaker(int cases){ //Makes lists of all events sorted according to location
        switch(cases){
            case 1:
                listSortDate();
                break;

            case 2:
                listSortLoc();
                break;

            case 3:
                listSortType();
                break;
        }
    }  

    /**
     * This method first creates a list of all the dates of all the events. Thereafter, it sorts the events based on their date using the Collection's sort method. Finally, the name of all the events in the newly sorted list is printed out.
     */
    public void listSortDate(){

       ArrayList<Double> dateList = new ArrayList<Double>();

       for(int i = 0; i < this.register.size(); i++){
           dateList.add(this.register.get(i).getDateTime());
       }
       Collections.sort(dateList);
       //Collections.sort(eventList, Comparator.comparing(Arrangement::getLocation).thenComparing()....);

        for(int i = 0; i < this.register.size(); i++) {
            for (int j = 0; j < this.register.size(); j++){
                if (dateList.get(i) == this.register.get(j).getDateTime()) {
                    System.out.println("- " + this.register.get(j).getName() + "(" + dateList.get(i) + ")");
                }
            }
        }
    }

    public void listSortLoc(){
        eventList = new ArrayList<>();

        for(int i = 0; i < this.register.size(); i++){
            eventList.add(this.register.get(i).getLocation());
        }
        Collections.sort(eventList);

        for(int i = 0; i < this.register.size(); i++) {
            for (int j = 0; j < this.register.size(); j++){
                if (eventList.get(i) == this.register.get(j).getLocation()) {
                    System.out.println("- " + this.register.get(j).getName() + "(" + eventList.get(i) + ")");
                }
            }
        }
    }

    public void listSortType(){
        eventList = new ArrayList<>();

        for(int i = 0; i < this.register.size(); i++){
            eventList.add(this.register.get(i).getTypeOfEvent());
        }
        Collections.sort(eventList);

        for(int i = 0; i < this.register.size(); i++) {
            for (int j = 0; j < this.register.size(); j++){
                if (eventList.get(i) == this.register.get(j).getTypeOfEvent()) {
                    System.out.println("- " + this.register.get(j).getName() + "(" + eventList.get(i) + ")");
                }
            }
        }
    }
    
    public ArrayList<Arrangement> getRegister() {
        return register;
    }

}

/*
Å registrere et nytt arrangement
• Å finne alle arrangementer på et gitt sted
• Å finne alle arrangementer på en gitt dato
• Å finne alle arrangementer innenfor et tidsintervall 
  gitt ved to datoer. Listen skal
  være sortert på tid.
• Å lage lister over alle arrangementer, sortert etter
  henholdsvis sted, type og
  tidspunkt.
*/