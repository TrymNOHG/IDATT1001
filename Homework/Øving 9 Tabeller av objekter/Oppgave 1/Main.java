import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static boolean infini = true;
    
    static AssignmentOverview studs = new AssignmentOverview();
    static Scanner nameQuest = new Scanner(System.in);
    static Scanner numAssign = new Scanner(System.in);

    public static void main(String[] args){

        setUp();

        while(infini == true){
            uInterface();
        }

    }

    public static void setUp(){

        System.out.println("To get started, first enter the information of a student.");

        System.out.println("\nWhat is the students name?");
        String name = nameQuest.nextLine();

        System.out.println("\nHow many assignments have they done?");
        int numAssignments = numAssign.nextInt();

        studs.getAssignmentOverview().put(name, new Student(name, numAssignments));

        studs.representAssignmentOverview();

    }
    
    public static void uInterface(){

        Scanner opt = new Scanner(System.in);
        System.out.println("\nIf you want to see an overview, press 1.\nIf you want to add a new student. press 2.\nIf you want to find a specific student's assignment number, press 3.\nIf you want to increase a specific student's number of assignments, press 4.\nIf you want to see how many students are registered, press 5.");
        int option = opt.nextInt();

        Scanner quest1 = new Scanner(System.in);
        Scanner quest2 = new Scanner(System.in);



        switch(option) {
            case 1:
                studs.representAssignmentOverview();
                break;

            case 2:
                System.out.println("\nWhat is the students name?");
                String name1 = nameQuest.nextLine();
        
                System.out.println("\nHow many assignments have they done?");
                int numAssignments = numAssign.nextInt();

                studs.registering(name1, numAssignments);

                break;

            case 3:
                System.out.println("\nWhat is the students name?");
                String name2 = nameQuest.nextLine();
                System.out.println("\n" + name2 + " has completed " + studs.assignSolved(name2) + " assignments!");
                
                break;

            case 4:
                System.out.println("\nWhich student do you want to increase the assignment count for?");
                String studName = quest1.nextLine();

                System.out.println("\nWhat do you want it to be increased to?");
                int increase = quest2.nextInt();

                studs.incrAssign(studName, increase);

                break;

            case 5:
                System.out.println("\nThere are " + studs.numStudRegistered() + " student(s) registered.");
                break;
        }
        
    }
    
}

//Print list of students, names and num assignments
//Give option to add a new student, entering the students name and assignments completed
//Give option to increase assignment number
//Give option to find the specific student's assignment number
//Give option to find how many students are registered
