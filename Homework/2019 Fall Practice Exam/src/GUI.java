import javax.sound.midi.Synthesizer;
import java.util.List;
import java.util.Scanner;
public class GUI {
    private final int ADD_HEARING_AID = 1;
    private final int LIST_ALL_HEARING_AIDS = 2;
    private final int AVAILABLE_AIDS = 3;
    private final int LOAN_HEARING_AID = 4;
    private final int END_LOAN = 5;
    private final int EIRIK = 6;
    private final int EXIT = 7;
    private HearingAidCentral currentCentral;

    public GUI(String hearingAidName) {
        currentCentral = new HearingAidCentral(hearingAidName);
    }

    /**
     * Presents the menu for the user, and awaits input from the user. The menu * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1. * If 0 is returned, the user has entered a wrong value
     */
    private int showMenu() {
        int menuChoice = 0;
        System.out.println("\n***** Hearing Aid Central v0.1 *****\n");
        System.out.println("1. Add hearing aid");
        System.out.println("2. List all hearing aids");
        System.out.println("3. Available hearing aids.");
        System.out.println("4. Loan a hearing aid");
        System.out.println("5. End Loan on a hearing aid");
        System.out.println("6. Quit");
        System.out.println("\nPlease select from the menu.\n");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt())
        {
            menuChoice = sc.nextInt();
        } else
        {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice; }

    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user, * and executing the selected functionality.
     */
    public void start() {
        boolean finished = false;
        Scanner input = new Scanner(System.in);
        while (!finished) {
            try{
            int menuChoice = this.showMenu();
            switch (menuChoice) {
                case ADD_HEARING_AID:
                    System.out.println("What is the ID of the hearing aid?");
                    int iD = input.nextInt();
                    input.nextLine();
                    System.out.println("What is the type of the hearing aid?");
                    String type = input.nextLine();
                    if (currentCentral.registerHearingAid(iD, type)) {
                        System.out.println("This hearing aid has been succesfully registered!");
                    } else {
                        System.out.println("Something went wrong with registration. Make sure you have the correct info.");
                    }
                    break;
                case LIST_ALL_HEARING_AIDS:
                    System.out.println(currentCentral.getCenterName() + "\nCurrently registered hearing aids: ");
                    for (HearingAid hearingAids : currentCentral.hearingAidInformation()) {
                        System.out.println(hearingAids.toString());
                    }
                    break;

                case AVAILABLE_AIDS:
                    System.out.println("What type of hearing aid do you want to check?");
                    String typeOfAid = input.nextLine();
                    System.out.println(currentCentral.getCenterName() + "\nCurrently these " + typeOfAid + " are " +
                            "available:");
                    for (HearingAid availableAids : currentCentral.availableAid(typeOfAid)) {
                        System.out.println(availableAids.toString());
                    }
                    break;

                case LOAN_HEARING_AID:
                    System.out.println("What type of hearing aid do you want to loan?");
                    String hearingAidType = input.nextLine();
                    System.out.println("And what is your first and last name?");
                    String nameOfLoan = input.nextLine();
                    if (currentCentral.loanOutAid(hearingAidType, nameOfLoan)) {
                        System.out.println("Great, you are all set!");
                    } else {
                        System.out.println("Sorry, it seems there aren't any hearing aids of this type available.");
                    }
                    break;

                case END_LOAN:
                    System.out.println("What is your name?");
                    String loanerName = input.nextLine();
                    currentCentral.endLoan(loanerName);
                    System.out.println("Ok, you are officially taken off the loan list.");
                    break;

                case EIRIK:
                    HearingAid eirik = currentCentral.eirik();
                    eirik.setLoanedTo("Eirik");
                    eirik.setAidRented(true);
                    break;

                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    break;

                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}



