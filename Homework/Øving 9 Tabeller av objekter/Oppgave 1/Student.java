public class Student{
    private String navn; // entydig(!)
    private int antOppg;
    
    public Student(String name, int numAssign){
        this.navn = name;
        this.antOppg = numAssign;
    }

   public String getNavn() {
        return navn;
   }

   public void setNavn(String navn) {
        this.navn = navn;
   }

   public int getAntOppg() {
        return antOppg;
   }

   public void setAntOppg(int antOppg) {
        this.antOppg = antOppg;
   }

    public void incAntOppg(int increase){
        this.antOppg += increase;
    }

    @Override
    public String toString(){
        return navn + "has completed " + antOppg + "assignments";
    }

}