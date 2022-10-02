import java.util.ArrayList;

/**
 * This class acts as a list of all the menus that this restaurant has.
 * It, therefore, contains multiple functions such as adding new dishes, making new menus,
 * finding dishes based on name or type, making a menu without duplicates, and finding menus within a given price range.
 */
public class MenuRegister {

    private ArrayList<Menu> menuList;

    /**
     * Similar to how the Menu Constructor {@link Menu#Menu(String)} )} works, the Menu Register creates an arrayList for every
     * instance of it.
     */
    public MenuRegister() {
        menuList = new ArrayList<>();
    }

    /**
     * This function creates a new dish in the first menu created. This first menu acts a catalogue of all the dishes the restaurant has.
     * @param dishName
     * @param typeOfFood
     * @param price
     * @param recipe
     */
    public void newDish(String dishName, String typeOfFood, double price, String recipe){
        this.menuList.get(0).dishAdd(new Dish(dishName, typeOfFood, price, recipe));
    }

    /**
     * If a dish already exists, then the user can add it to the menu by typing its name.
     * This method checks that the name exists as a dish and thereafter adds it to the last menu created.
     * @param dishName
     */
    public void addItem(String dishName, String nameMenu){
        if(dishName.equals(null)){
            System.out.println("This isn't a valid item.");
        }
        else if(nameMenu == "No Duplicate"){
            System.out.println("This isn't a valid menu to edit.");
        }
        else{
            if(this.findDish(dishName) == null){
                System.out.println("This item does not exist.");
            }
            this.menuList.get(findMenu(nameMenu)).dishAdd(findDish(dishName));
        }
    }

    /**
     * If a dish wants to be added to the menu being worked on and it doesn't exist
     * @param dishName
     * @param typeOfFood
     * @param price
     * @param recipe
     */
    public void addItem(String dishName, String typeOfFood, double price, String recipe, String nameMenu){
        if(nameMenu == "No Duplicate"){
            System.out.println("This isn't a valid menu to edit.");
        }
        else {
            //Make one variable Dish dish = new ....
            this.menuList.get(findMenu(nameMenu)).dishAdd(new Dish(dishName, typeOfFood, price, recipe));
            this.menuList.get(0).dishAdd(new Dish(dishName, typeOfFood, price, recipe));
        }
    }

    /**
     * This method adds another menu object to the menu registry.
     */
    public void newMenu(String menuName){
        this.menuList.add(new Menu(menuName));
    }

    /**
     * This method takes a dish name as input and uses the dishFinder function from the Menu class in order to find
     * the dish object that has the dish name.
     * @param dishName
     * @return
     */
    public Dish findDish(String dishName){
        for (int i = 1; i < menuList.size(); i++) {
            if(menuList.get(i).dishFinder(dishName) != null){
                return menuList.get(i).dishFinder(dishName);
            }
        }
        return null;
    }

    /**
     * The purpose of this method is to make a list of all the dishes that have the typeOfFood variable equal to the
     * input: type. This is done through the {@link Menu#dishTypeFinder(String)}.
     * @param type
     */
    public void listOfDishType(String type){
        ArrayList<Dish> listOfSameType = new ArrayList<>();
        for (int i = 1; i < menuList.size(); i++) {
            if(this.menuList.get(i).dishTypeFinder(type) != null){
                listOfSameType.add(this.menuList.get(i).dishTypeFinder(type));
            }
        }
        System.out.println("\nThe following dishes are all of type " + type + ":");
        if(listOfSameType.size() > 0) {
            for (int i = 0; i < listOfSameType.size(); i++) {
                System.out.println(" -  " + listOfSameType.get(i).getDishName());
            }
        }
        System.out.println("\n");

    }

    /**
     * This method creates a menu with no duplicate dishes in it.
     */
    public void noDuplicateMenu(){

        newMenu("No Duplicate");

        boolean alreadyExists = false;
            for (int i = 0; i < this.menuList.get(0).getDishList().size(); i++) {
                for (int j = 0; j < this.menuList.get(this.menuList.size() - 1).getDishList().size() + 1; j++) {
                    if(this.menuList.get(this.menuList.size() - 1).getDishList().get(j).equals(this.menuList.get(0).getDishList().get(i)) && this.menuList.get(this.menuList.size() - 1).getDishList().get(j) != null) {
                        alreadyExists = true;
                        System.out.println("Problem");
                    }
                }
                if(alreadyExists = false){
                    System.out.println("good");
                    this.menuList.get(this.menuList.size() - 1).dishAdd(this.menuList.get(0).getDishList().get(i));
                }
                alreadyExists = false;
            }
        System.out.println("The following is a menu of all the items in all of the existing menus without any duplicates: ");
        this.menuList.get(this.menuList.size() - 1).printingMenu();
    }

    /**
     * This method take an upper and lower bounds of a price range. It, then, uses the calcMenuPrice() function
     * {@link Menu#calcMenuPrice()} in order to determine the total price of a menu and whether it falls
     * within those boundaries.
     * @param lower
     * @param upper
     */
    public void menuPriceRange(double lower, double upper){
        int counter = 0;
            for (int i = 0; i < this.menuList.size(); i++) {
                if(this.menuList.get(i).getDishList().size() > 0) {
                    if (this.menuList.get(i).calcMenuPrice() >= lower && this.menuList.get(i).calcMenuPrice() <= upper) {
                        this.menuList.get(i).printingMenu();
                        counter++;
                    }
                }
            }
            if (counter == 0) {
                System.out.println("There are no menus within this price range!");
            }
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    /**
     * This method prints uses a print method {@link Menu#printingMenu()} in order show the dishes on a given menu.
     * @param nameMenu
     */
    public void showMenu(String nameMenu){
        if(findMenu(nameMenu) == 0 && nameMenu != "Catalogue"){
            System.out.println("That menu doesn't exist. Remember to have correct capitalization!");
        }
        else{
            this.menuList.get(findMenu(nameMenu)).printingMenu();
        }
    }

    /**
     * This method takes the input nameMenu and searches through the menuList in order to find where a Menu object's
     * name is the same. It, then, returns the index value.
     * @param nameMenu
     * @return
     */
    public int findMenu(String nameMenu){
        for (int i = 0; i < this.menuList.size(); i++) {
            if(nameMenu.equals(this.menuList.get(i).getMenuName())){
                return i;
            }
        }
        return 0;
    }

    /**
     * This method prints out a list of all the different menu names.
     */
    public void showMenuNames(){
        System.out.println("The different Menus created are:");
        for (int i = 0; i < this.menuList.size(); i++) {
            System.out.println("  -  " + menuList.get(i).getMenuName());
        }
    }
}