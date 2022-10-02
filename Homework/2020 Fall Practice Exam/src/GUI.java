import java.util.Scanner;


public class GUI {

    private static Scanner input = new Scanner(System.in);
    private static final int ADD_COVID_ENTRY_TO_REGISTER = 1;
    private static final int LIST_ALL_COVID_ENTRIES = 2;
    private static final int FIND_COVID_ENTRY_BY_DATE = 3;
    private static final int FIND_COVID_ENTRY_AFTER_DATE = 4;
    private static final int CALCULATE_DEATHS_BY_COUNTRY = 5;
    private static final int CALCULATE_TOTAL_DEATHS = 6;
    private static final int EXIT = 7;
    private CovidStatsRegister covidRegister;

    public GUI() {
        this.covidRegister = new CovidStatsRegister();
    }

    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     * If 0 is returned, the user has entered a wrong value
     */
    private int getMenuChoice() {
        int menuChoice = 0;
        System.out.println("\n***** Covid Statistics Application v0.1 *****\n");
        System.out.println("1. Add a COVID-19 entry");
        System.out.println("2. List all COVID-19 entries");
        System.out.println("3. Find COVID-19 entry by date");
        System.out.println("4. Find all entries after date");
        System.out.println("5. Show the total deaths for a country");

        System.out.println("9. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            menuChoice = sc.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }
    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public void start() {
        boolean finished = false;
        while (!finished) {
            int menuChoice = this.getMenuChoice();
            try {
                switch (menuChoice) {
                    case ADD_COVID_ENTRY_TO_REGISTER:
                        addCovidEntry();
                        break;
                    case LIST_ALL_COVID_ENTRIES:
                        break;
                    case FIND_COVID_ENTRY_BY_DATE:
                        break;
                    case FIND_COVID_ENTRY_AFTER_DATE:
                        break;
                    case CALCULATE_DEATHS_BY_COUNTRY:
                        break;
                    case CALCULATE_TOTAL_DEATHS:
                        break;
                    default:
                        System.out.println("Unrecognized menu selected..");
                        break;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private void addCovidEntry(){
        System.out.println("First, you need to enter the date of the stats.\nThis needs to be " +
                "in the form YYYY-MM-DD. Hit enter, without typing anything, for the current date.");
        String dateEntry = input.nextLine();
        System.out.println("Now, you need to enter the name of the country!");
        String country = input.nextLine();
        System.out.println("How many are/were infected?");
        int numInfected = input.nextInt();
        System.out.println("How many died from Covid?");
        int numDeaths = input.nextInt();

        this.covidRegister.registerNewStats(dateEntry, country, numInfected, numDeaths);

    }

    private void listAllEntries(){
        for(CovidLocStats covidLocStats : covidRegister){
            System.out.println(covidLocStats);
        }
    }

    private void findCovidEntryByDate(){

    }

    private void findCovidEntryAfterDate(){

    }

    private void calculateDeathsByCountry(){

    }

    private void calculateTotalDeaths(){

    }

}
