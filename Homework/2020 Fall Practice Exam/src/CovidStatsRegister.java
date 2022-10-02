/*
2a. The java.time package is the package where LocalDate exists. In order to implement the package for LocalDate,
you would write import java.time.LocalDate.

2b. The method that can be used to get an instance of todays date is now(). The signature of this method is:
public static LocalDate now().

If you want to check if a date is before another date, you can use:
public boolean isBefore(ChronoLocalDate other)

2c. The method, public static LocalDate parse(CharSequence text), takes in a text string in the form year - month - day,
YYYY-MM-DD. It, then, returns an instance of LocalDate.

 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CovidStatsRegister implements Iterable<CovidLocStats>{
    private final List<CovidLocStats> covidRegister;

    public CovidStatsRegister() {
        this.covidRegister = new ArrayList<>();
    }

    public boolean registerNewStats(String localDate, String registeredCountry, int infected, int numDeaths){
        if(localDate.isBlank()){
            this.covidRegister.add(new CovidLocStats(LocalDate.now(), registeredCountry.toUpperCase(), infected, numDeaths));
            return true;
        }
        this.covidRegister.add(new CovidLocStats(LocalDate.parse(localDate), registeredCountry, infected, numDeaths));
        return true;
    }

    public CovidLocStats findStatByDate(String date){
        LocalDate dateToSearch = LocalDate.parse(date);
        for(CovidLocStats covidLocStats : covidRegister){
            if(covidLocStats.getREGISTERED_DATE().isEqual(dateToSearch)){
                return new CovidLocStats(covidLocStats);
            }
        }
        return null;
    }

    public List<CovidLocStats> findStatsAfterDate(String date){
        LocalDate dateToSearchAfter = LocalDate.parse(date);
        List<CovidLocStats> statsAfterDateList = new ArrayList<>();
        for(CovidLocStats covidLocStats : covidRegister){
            if(dateToSearchAfter.isBefore(covidLocStats.getREGISTERED_DATE())){
                statsAfterDateList.add(new CovidLocStats(covidLocStats));
            }
        }
        return statsAfterDateList;
    }


    public List<CovidLocStats> wholeRegister(){
        List<CovidLocStats> copiedRegister = new ArrayList<>();
        for(CovidLocStats covidLocStats : covidRegister){
            copiedRegister.add(new CovidLocStats(covidLocStats));
        }
        return copiedRegister;
    }

    public int numRegistered(){
        return this.covidRegister.size();
    }

    public int sumOfDeathsOfCountry(String country){
        int sumDeaths = 0;
        for(CovidLocStats covidLocStats : covidRegister){
            if(country.equals(covidLocStats.getREGISTERED_COUNTRY())){
                sumDeaths += covidLocStats.getDEATHS();
            }
        }
        return sumDeaths;
    }

    public int totalSumOfDeaths(){
        int totNumDeaths = 0;
        for(CovidLocStats covidLocStats : covidRegister){
            totNumDeaths += covidLocStats.getDEATHS();
        }
        return totNumDeaths;
    }

    @Override
    public Iterator<CovidLocStats> iterator() {
        Iterator<CovidLocStats> covidIterator = wholeRegister().iterator();
        return covidIterator;
    }
}

