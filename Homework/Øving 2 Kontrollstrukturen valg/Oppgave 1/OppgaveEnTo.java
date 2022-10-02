public class OppgaveEnTo{

    static boolean leapYear;

    public static void main(String[] args){

        System.out.println("It is " + isLeapYear(1904) + " that this year is a leap year!");
    }

    public static boolean isLeapYear(int year){
        if(year % 100 == 0){
            if(year % 400 == 0){
                leapYear = true;
            }
            else { 
                leapYear = false;
            }
        }
        else if(year % 4 == 0){
            leapYear = true;
        }
        
        return leapYear;
    }
}