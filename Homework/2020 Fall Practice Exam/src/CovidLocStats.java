import java.time.LocalDate;

/**
 * This is a class representing the different data/statistics that a country releases. Since the data does not change,
 * all the variables are final.
 */
public class CovidLocStats {
    private final LocalDate REGISTERED_DATE;
    private final String REGISTERED_COUNTRY;
    private final int INFECTED;
    private final int DEATHS;

    /**
     * This is a constructor representing a CovidLocStats object. The object will have the information necessary to
     * represent the stats.
     * @param REGISTERED_DATE The date when the Covid19 statistics were released.
     * @param REGISTERED_COUNTRY The country from which the statistics were released.
     * @param INFECTED The number of people infected by Covid19.
     * @param DEATHS The number of deaths so far due to Covid19.
     */
    public CovidLocStats(LocalDate REGISTERED_DATE, String REGISTERED_COUNTRY, int INFECTED, int DEATHS) {
        this.REGISTERED_DATE = REGISTERED_DATE; //Maybe make regex for this.
        this.REGISTERED_COUNTRY = REGISTERED_COUNTRY;
        if(INFECTED < 0 || DEATHS < 0){
            throw new IllegalArgumentException("Either the number of infected or deaths is incorrect: less than 0.");
        }
        this.INFECTED = INFECTED;
        this.DEATHS = DEATHS;
    }

    /**
     * This is a constructor which allows for deep copies to be made. It does so by taking a CovidLocStats object as the
     * parameter, then creating a new object using the information from the given object.
     * @param covidObj The CovidLocStats object that will be copied.
     */
    public CovidLocStats(CovidLocStats covidObj){
        this(covidObj.getREGISTERED_DATE(), covidObj.getREGISTERED_COUNTRY(), covidObj.getINFECTED(), covidObj.getDEATHS());
    }

    /**
     * This method retrieves the date the Covid location stats were published as a LocalDate object.
     * @return Date the Covid location stats were released, in the form of LocalDate.
     */
    public LocalDate getREGISTERED_DATE() {
        return REGISTERED_DATE;
    }

    /**
     * This method retrieves the country in which the stats were registered in.
     * @return The country the stats are from.
     */
    public String getREGISTERED_COUNTRY() {
        return REGISTERED_COUNTRY;
    }

    /**
     * This method retrieves the number of people infected by Covid.
     * @return An int representing the number of people infected.
     */
    public int getINFECTED() {
        return INFECTED;
    }

    /**
     * This method retrieves the number of deaths due to Covid.
     * @return An int representing the number of deaths due to Covid.
     */
    public int getDEATHS() {
        return DEATHS;
    }

}
