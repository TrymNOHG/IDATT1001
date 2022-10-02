public class Arrangement {
    
    private int number;
    private String name;
    private String location;
    private String arranger;
    private String typeOfEvent;
    private double dateTime;

    /**
     * This is the constructor for an arrangment/event. It, therefore, holds all the necessary features or parameters that define an event.
     * @param nummer Number
     * @param navn
     * @param sted
     * @param arranger
     * @param type
     * @param dateTime
     */
    public Arrangement(int nummer, String navn, String sted, String arranger, String type, double dateTime){
        this.number = nummer;
        this.name = navn;
        this.location = sted;
        this.arranger = arranger;
        this.typeOfEvent = type;
        this.dateTime = dateTime;
    }   

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getArranger() {
        return arranger;
    }

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public double getDateTime() {
        return dateTime;
    }

}

/*For hvert arrangement lagrer vi et entydig nummer, navn, sted, 
arrangør, type (konsert, barneteater, foredrag osv) og tidspunkt 
(dato og klokkeslett). Lagre tidspunktene som heltall, eksempel: 
200210301800 (kl 18 den 30.oktober 2002) slik at du ved å sammenligne 
tallene kan finne ut om et arrangement er før eller etter et annet.
*/


