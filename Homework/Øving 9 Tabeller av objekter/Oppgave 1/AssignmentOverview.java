import java.util.HashMap;

public class AssignmentOverview{
    
    private HashMap<String, Student> assignmentOverview;

    //This constructor creates a hashmap of all the different Student objects created.
    public AssignmentOverview(){

        assignmentOverview = new HashMap<String, Student>();

    }

   public int numStudRegistered(){
        return this.assignmentOverview.size();
        //    Finn antall studenter registrert
        //    Use hashmap to create an arraylist type beat with a given length.

   }

   public int assignSolved(String studName){
        //Finn antall oppgaver som en bestemt student har løst
        return this.assignmentOverview.get(studName).getAntOppg();

   }

   public Student registering(String studentName, int numAssign){
        // Registrer en ny student
        this.assignmentOverview.put(studentName, new Student(studentName, numAssign));
        return this.assignmentOverview.get(studentName);


   }

   public void incrAssign(String studentName, int numIncrease){
        // Øk antall oppgaver for en bestemt student.
        this.assignmentOverview.get(studentName).setAntOppg(numIncrease);

   }
   
   //This function prints out the list of student names and assignments done through using the keyset of the hashmap.
   public void representAssignmentOverview() {
       for(String i : this.assignmentOverview.keySet()){
            System.out.println("\nName: " + i + " \nAssignments Done: " + this.assignmentOverview.get(i).getAntOppg());
       }
   }

   //This returns the hashmap of the constructor.
   public HashMap<String, Student> getAssignmentOverview() {
       return assignmentOverview;
   }

}

//Maybe create a hashmap with Student name as the key and the number of assignment solved as the value.
//Hashmap takes the keys of the students names and has the value of the number of assignments completed.