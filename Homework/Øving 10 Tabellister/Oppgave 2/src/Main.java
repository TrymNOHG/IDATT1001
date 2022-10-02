import java.util.Scanner;
public class Main {
    static MenuRegister menuRegister;
    static boolean infini = true;
    static Scanner input;
    static String dishName;
    static String typeOfFood;
    static double price;
    static String recipe;
 
    
    public static void main(String[] args) {
        System.out.println("The way this program works is as follows:" + "\n - In order to create a menu, you need to " +
                "choose the create menu option. With this option, any new item added to a menu is automatically put on " +
                "this menu. ");
        menuRegister = new MenuRegister();
        menuRegister.newMenu("Catalogue");
        menuRegister.newMenu("First Menu");
        while(infini){
            uInterface();
        }
    }
    
    public static void uInterface(){
        System.out.println("\nHere are the different functions you may choose from:" + "\nPress 1 to create another dish" +
                " in the registry.\nPress 2 to add a dish to a chosen menu. \nPress 3 to create a new menu " +
                "to work on.\nPress 4 to find a certain dish.\nPress 5 to find all the dishes of the same type (appetizer," +
                " main course, etc.)\nPress 6 to create a menu of all existing dishes with no duplicates.\nPress 7 to find " +
                "all the items within a certain price range. \nPress 8 to check what menus you may choose from." +
                "\nPress 9 if you want to check an existing menu.");
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        switch (cases){
            case 1:
                System.out.println("In order to create a new dish, you will need to provide the necessary information. " +
                        "\nType in the following: Name of the dish, the type of food (appetizer, main course, dessert, e" +
                        "tc.), the price, and the recipe");
                input = new Scanner(System.in);
                String dishName = input.nextLine();
                String typeOfFood = input.nextLine();
                double price = input.nextInt();
                input.nextLine();
                String recipe = input.nextLine();
                menuRegister.newDish(dishName, typeOfFood, price, recipe);
                break;

            case 2:
                menuRegister.showMenuNames();
                input = new Scanner(System.in);
                Scanner input2 = new Scanner(System.in);
                System.out.println("What is the menu you want to work on called?");
                String nameMenu = input.nextLine();
                System.out.println("If you want to add a dish that already exists, press 1. If you want to add a new " +
                        "dish into a menu, press 2.");
                int ans = input2.nextInt();
                if(ans == 1){
                    System.out.println("What is the dish called?");
                    String nameOfDish = input.nextLine();
                    menuRegister.addItem(nameOfDish, nameMenu);
                }
                else{
                    System.out.println("Type in the following: Name of the dish, the type of food (appetizer, " +
                            "main course, dessert, etc.), the price, and the recipe");
                    input = new Scanner(System.in);
                    String nameDish = input.nextLine();
                    String foodType = input.nextLine();
                    double pricing = input.nextInt();
                    input.nextLine();
                    String recipes = input.nextLine();
                    menuRegister.addItem(nameDish, foodType, pricing, recipes, nameMenu);
                }
                break;

            case 3:
                System.out.println("What do you want the menu to be called?");
                input = new Scanner(System.in);
                String nameOfMenu = input.nextLine();
                menuRegister.newMenu(nameOfMenu);
                break;
                
            case 4:
                System.out.println("What dish do you want to find?");
                input = new Scanner(System.in);
                String nameOfDish = input.nextLine();
                if(menuRegister.findDish(nameOfDish) != null){
                    System.out.println(menuRegister.findDish(nameOfDish));
                }
                else{
                    System.out.println("This dish does not exist yet.");
                }
                break;

            case 5:
                System.out.println("What type of dish are you looking for?");
                input = new Scanner(System.in);
                String typeOfDish = input.nextLine();
                menuRegister.listOfDishType(typeOfDish);
                break;

            case 6:
                menuRegister.noDuplicateMenu();
                break;

            case 7:
                System.out.println("In order to find all the menus within a certain price range, you need to provide " +
                        "the interval. \nFirst, type the lower bounds of the interval (inclusive). Then, type the upper " +
                        "bounds (also inclusive)");
                input = new Scanner(System.in);
                int lower = input.nextInt();
                int upper = input.nextInt();
                menuRegister.menuPriceRange(lower, upper);
                break;

            case 8:
                menuRegister.showMenuNames();
                break;

            case 9:
                menuRegister.showMenuNames();
                System.out.println("What menu do you want to check?");
                input = new Scanner(System.in);
                String nameOfMenus = input.nextLine();
                menuRegister.showMenu(nameOfMenus);

                break;

            default:
                System.out.println("\nYou did not choose one of the options.");
                break;

        }
    }

}



//In order to be able to use dishes, even if they aren't technically on a menu, I could reserve the first menu in the arrayList as a catalogue.

//List<Arrangement> list = arrangementer.stream().sorted(Comparator.comparing(Arrangement::getTime).collect(Collectors.toList());