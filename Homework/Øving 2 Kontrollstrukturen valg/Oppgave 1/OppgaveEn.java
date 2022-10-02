import java.util.Scanner;

public class OppgaveEn{

    public static void main(String[] args){
        Scanner question = new Scanner(System.in);
        System.out.println("What year do you want to check?");

        int answer = question.nextInt();
        leapYear(answer);
    }

    public static void leapYear(int year){
        if(year % 4 == 0 && (year+100) % 400 != 0){

            System.out.println("This is a leap year!");
        
        }
        else{
         
            System.out.println("This is not a leap year :(");
        
        }
    }

}