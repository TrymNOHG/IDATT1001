import java.util.GregorianCalendar;

public class ArbTaker {
   
    private double arbtakernr;
    private int hireYear;
    private double monthIncome;
    private double taxRate;
    private Person personalia;
    private GregorianCalendar kalender = new GregorianCalendar();

    //This constructor acts as an employee profile taking into account all the personal information revolving around work.
    public ArbTaker(Person personalia, double arbtakernr, int hireYear, double monthIncome, double taxRate){
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.hireYear = hireYear;
        this.monthIncome = monthIncome;
        this.taxRate = taxRate;
    }

    //Returns a Person object
    public Person getPersonalia() {
        return personalia;
    }
    
    //Sets a Person object within the ArbeidTaker to another Person object
    public void setPersonalia(Person personalia) {
        this.personalia = personalia;
    }

    //Returns arbeidstaker nummer
    public double getArbtakernr() {
        return arbtakernr;
    }
    
    //Sets a arbeidstaker nummer to another number given as the argument of the function.
    public void setArbtakernr(double arbtakernr) {
        this.arbtakernr = arbtakernr;
    }

    //Returns the Person's hireYear.
    public double getHireYear() {
        return hireYear;
    }

    //Sets a Person's hireYear as another hireYear given as the argument of the function.
    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    //Returns monthIncome
    public double getMonthIncome() {
        return monthIncome;
    }

    //Sets monthIncome to another monthIncome given as argument.
    public void setMonthIncome(double monthIncome) {
        this.monthIncome = monthIncome;
    }

    //Returns the Person's tax rate.
    public double getTaxRate() {
        return taxRate;
    }

    //Sets the Person's tax rate based on the argument.
    /**
     * 
     * @param taxRate
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    //Calculates how much a Person is taxed per month.
    /**
     * 
     * @return 
     */
    public double taxedPerMonth(){
        return this.monthIncome*(this.taxRate/100);
    }

    //Calculates how much a Person earns a year when taxes are not taken into consideration.
    public double totalYearlyIncome(){
        return this.monthIncome*12;
    }

    //Calculates how much money a Person earns when taxes are taken into consideration.
    public double yearlyTaxRemoval(){
        return this.totalYearlyIncome() - (this.taxedPerMonth()*10.5);
    }

    //Returns the name of the Person in question.
    public String nameOfPerson(){
        return this.personalia.getLastName() + ", " + this.personalia.getFirstName();
    }

    //Returns the age of the Person.
    public int ageOfPerson(){
        return this.personalia.getBirthYear();
    }

    //Calculates how many years a Person has been working in a company based on the year of hire and the current year.
    public int yearsInCompany(){
        int currentYear = kalender.get(java.util.Calendar.YEAR);
        return currentYear - this.hireYear;
    }

    //Finds out if a person has worked in a company more, less, or equal to the amount of years given as the argument.
    public void hasBeenHired(int years){
        if(this.yearsInCompany() > years){
            System.out.println(this.nameOfPerson() + " has worked for more than " + years+ " years!");
        }
        else if(this.yearsInCompany() < years){
            System.out.println(this.nameOfPerson() + " has not worked for more than " + years+ " years!");
        }
        else{
            System.out.println(this.nameOfPerson() + " has worked for exactly " + years + " years!");
        }
        
    }

}
