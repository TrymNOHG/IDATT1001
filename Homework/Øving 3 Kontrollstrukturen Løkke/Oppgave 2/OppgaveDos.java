public class OppgaveDos{

static boolean numPrime;

    public static void main(String[] args){
        System.out.println("It is " + isPrime(7) + " that this number is a prime!");
    }

    public static boolean isPrime(int prime){

        if(prime  == 2){
            numPrime = true;
            return numPrime;
        }
        for(int i = 2; i < prime; i++){
            if(prime % i == 0){
                numPrime = false;
                break;
            }
            else{
                numPrime = true;
            }
            
        }
        return numPrime;
    }

}