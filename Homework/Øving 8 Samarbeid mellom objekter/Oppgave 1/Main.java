import java.util.Scanner;

public class Main {
   
    static ArbTaker user;
    static Person person;
    static boolean infini = true;

    public static void main(String [] args){
        setUp();
        while(infini == true){
            uInterface();
        }
    }

    public static void setUp(){
        System.out.println("\nTo upload an employee profile, fill in the following information: ");

        Scanner infoFirstName = new Scanner(System.in);
        System.out.println("\nWhat is the person's first name?\n");
        String firstName = infoFirstName.nextLine();

        Scanner infoLastName = new Scanner(System.in);
        System.out.println("\nWhat is the person's last name?\n");
        String lastName = infoLastName.nextLine();

        Scanner infoBirthYear = new Scanner(System.in);
        System.out.println("\nWhat is the person's birth year?\n");
        int birthYear = infoBirthYear.nextInt();

        person = new Person(firstName, lastName, birthYear);

        Scanner infoArbTakeNr = new Scanner(System.in);
        System.out.println("\nWhat is the person's arbeidstaker nummer?\n");
        double arbtakernr = infoArbTakeNr.nextDouble();

        Scanner infoHireYear = new Scanner(System.in);
        System.out.println("\nWhen was the person hired?\n");
        int hireYear= infoHireYear.nextInt();

        Scanner infoMonthIncome = new Scanner(System.in);
        System.out.println("\nWhat is the person's monthly income?\n");
        double monthIncome = infoMonthIncome.nextDouble();

        Scanner infoTaxRate = new Scanner(System.in);
        System.out.println("\nWhat is the person's tax rate?\n");
        double taxRate = infoTaxRate.nextDouble();

        user = new ArbTaker(person, arbtakernr, hireYear, monthIncome, taxRate);
    
    }

    public static void uInterface(){
        Scanner quest1 = new Scanner(System.in);
        System.out.println("\nIf you want to see " + user.nameOfPerson() + "'s employee profile, press 1.\nIf you want to reset any information, press 2.\nIf you want to see their tax per month, press 3.\nIf you want to see their total yearly income, press 4\nIf you want to see how much of their yearly income is left after removing tax, press 5.\nIf you want to know how many years they've been in the company, press 6.\nIf you want to check how long they've been hired, press 7.");
        int opts = quest1.nextInt();

        if(opts == 1){
            
            System.out.println("                               Employee Profile");
            System.out.println("\nName of Employee:   " + user.nameOfPerson());
            System.out.println("Year of birth:   " + user.ageOfPerson());
            System.out.println("Arbeidstaker nummer:   " + user.getArbtakernr());
            System.out.println("Year of hire:   " + user.getHireYear());
            System.out.println("Monthly income:   " + user.getMonthIncome());
            System.out.println("Tax rate:   " + user.getTaxRate());
            System.out.println("\nYears in the company:   " + user.yearsInCompany());
            System.out.println("Yearly income (taking into consideration tax):  " + user.yearlyTaxRemoval());

        }

        else if(opts == 2){
            Scanner quest2 = new Scanner(System.in);
            System.out.println("\nFor the following, press the number to the right to reset it.\n1. Everything\n2. First name\n3. Last Name\n4. Birth year\n5. Arbeidstaker nummer\n6. Year that they were hired\n7. Monthly income value\n8. Tax rate");
            int opt2 = quest2.nextInt();

            Scanner quest3 = new Scanner(System.in);

            switch(opt2){

                case 1:
                    setUp();
                    break;

                case 2:
                    System.out.println("What do you want to change the first name to?");
                    
                    String firstNameChange = quest3.nextLine();
                    user.getPersonalia().setFirstName(firstNameChange);
                    break;

                case 3:
                    System.out.println("What do you want to change the last name to?");
                    String lastNameChange = quest3.nextLine();
                    user.getPersonalia().setFirstName(lastNameChange);
                    break;

                case 4:
                    System.out.println("What do you want to change the birth to?");
                    String birthYearChange = quest3.nextLine();
                    user.getPersonalia().setFirstName(birthYearChange);
                    break;
                
                case 5:
                    System.out.println("What do you want to change the arbeidstaker nummer to?");
                    double arbeidstakerChange = quest3.nextDouble();
                    user.setArbtakernr(arbeidstakerChange);
                    break;
                    
                case 6:
                    System.out.println("What do you want to change the year they were hired to?");
                    int yearHiredChange = quest3.nextInt();
                    user.setHireYear(yearHiredChange);
                    break;

                case 7:
                    System.out.println("What do you want to change the monthly income to?");
                    double monthIncomeChange = quest3.nextDouble();
                    user.setMonthIncome(monthIncomeChange);
                    break;

                case 8:
                    System.out.println("What do you want to change the tax rate to?");
                    double taxRateChange = quest3.nextDouble();
                    user.setTaxRate(taxRateChange);
                    break;

            }

        }

        else if(opts == 3){
            System.out.println("\nThe tax per month is: " + user.taxedPerMonth());
        }

        else if(opts == 4){
            System.out.println("\nThe yearly income is: " + user.totalYearlyIncome());
        }

        else if(opts == 5){
            System.out.println("\nThis much is left of the income after tax each year: " + user.yearlyTaxRemoval());
        }

        else if(opts == 6){
            System.out.println("\nThis is how many years they've been in the company: " + user.yearsInCompany());
        }

        else if(opts == 7){
            Scanner quest4 = new Scanner(System.in);
            System.out.println("\nHow many years do you want to check if they've been working for? \nEnter the number of years you think they've worked for:");
            user.hasBeenHired(quest4.nextInt());
            
        }
   
    }

}
