public class OppgaveUno{

    public static void main(String[] arg){
        multTable(9, 15);
    }

    public static void multTable(int firstMult, int secondMult){
        for(int i = firstMult; i < secondMult+1; i++){
            for(int j = 1; j < 11; j++){
                System.out.println(i + " X " + j + " = " + (i*j));
            }
            System.out.println("   ");
        }

    }
}