import java.util.Scanner;

public class Main {
    static final int ADD_PROPERTY = 1;
    static final int LIST_PROPERTIES = 2;
    static final int FIND_PROPERTY_BY_LOT_NUMBER = 3;
    static final int CALCULATE_AVERAGE_AREA = 4;
    static final int SET_OWNER = 5;
    static final int SET_LOT_NAME = 6;
    static final int SET_NEW_AREA = 7;
    static final int END = 8;
    static boolean infinity = true;
    static Scanner options;
    static Scanner input;
    static PropertyRegister propReg = new PropertyRegister();
    public static void main(String[] args) {
        System.out.println("*** Welcome to the Property Registry Application ***");
        while(infinity){
            try{
                uInterface();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    public static int startMenu(){
        options = new Scanner(System.in);
        int opt = 0;
        boolean start = false;
        while(!start) {
            System.out.println("The different options you have to choose from with this application are as follows: ");
            System.out.println("1. Add a new property to the registry.\n2. List all the properties in the registry." +
                    "\n3. Find all properties of a given lot number.\n4. Calculate the average area of all the properties " +
                    "in the registry." + "\n5. Set a new owner of a given property.\n6. Set a new lot name." +
                    "\n7. Set a new area for a property.\n8. End the program.");
            if (options.hasNextInt()) {
                opt = options.nextInt();
                if (opt < 0 || opt > 8) {
                    System.out.println("You have entered an invalid option. Try again.");
                }
                else{
                    return opt;
                }
            } else {
                System.out.println("You have entered an invalid option. Try again.");
            }
        }
        return opt;
    }

    public static void uInterface(){
        input = new Scanner(System.in);
        switch (startMenu()){
            case ADD_PROPERTY:
                System.out.println("In order to add a new property, the following information needs to be answered: ");
                System.out.println("What is the lot number?");
                int lotNum = input.nextInt();
                System.out.println("What is the section number?");
                int sectNum = input.nextInt();
                input.nextLine();
                System.out.println("What is the lot name?");
                String lotName = input.nextLine();
                System.out.println("And finally, what is the area of the property?");
                double areaOfProp = input.nextDouble();
                propReg.registerNewProperty(1445, "Gloppen", lotNum, sectNum, lotName, areaOfProp);
                System.out.println("The property was successfully registered!");
                break;

            case LIST_PROPERTIES:
                System.out.println("These are all the properties in the property register currently: \n");
                System.out.println(propReg.toString());
                break;

            case FIND_PROPERTY_BY_LOT_NUMBER:
                System.out.println("What is the lot number you want to check?");
                int lotNumber = input.nextInt();
                System.out.println(propReg.findPropertyByLotNum(lotNumber).toString());
                break;

            case CALCULATE_AVERAGE_AREA:
                System.out.println("This is the average area of all the properties in the register: " + propReg.averageArea());
                break;

            case SET_OWNER:
                System.out.println("What is the name of the lot you want to change ownership to?");
                String nameOfLot = input.nextLine();
                System.out.println("What is the new owner's name?");
                String newOwner = input.nextLine();
                if(propReg.newOwner(newOwner, nameOfLot)){
                    System.out.println("The ownership has been changed successfully");
                }
                else{
                    System.out.println("The ownership change was unsuccessful, meaning someone already owns that property.");
                }
                break;

            case SET_LOT_NAME:
                System.out.println("What is the current name of the lot you want to change?");
                String oldLotName = input.nextLine();
                System.out.println("What do you want to change the lot name to?");
                String newLotName = input.nextLine();
                if(propReg.changeLotName(oldLotName, newLotName)){
                    System.out.println("The lot name has been successfully changed.");
                }
                else{
                    System.out.println("The lot name was not changed successfully. This may be due to a spell error or " +
                            "the lot name is not currently registered.");
                }
                break;

            case SET_NEW_AREA:
                System.out.println("What is the name of the lot you want to change the area of?");
                String nameOfTheLot = input.nextLine();
                System.out.println("What do you want to change the area to?");
                double newArea = input.nextDouble();
                if(propReg.changeArea(newArea, nameOfTheLot)){
                    System.out.println("The area was successfully changed.");
                }
                else{
                    System.out.println("The area was not changed. There may have been an error.");
                }
                break;

            case END:
                System.out.println("Thank you for using this application!");
                break;
        }
    }

}

