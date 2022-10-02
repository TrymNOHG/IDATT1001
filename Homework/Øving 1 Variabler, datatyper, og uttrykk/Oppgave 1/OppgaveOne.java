class OppgaveOne{

    public static void main(String[] args){
        converter(78.3f);
    }

    public static void converter(float inch){

        float centimeter = (float) (inch/2.54);

        System.out.println(inch + " in inches is " + centimeter + " cm.");

    }

}