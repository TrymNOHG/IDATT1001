import java.util.ArrayList;

/**
 * This class acts as a Menu. It, therefore, has different functions for manipulating a list with Dish objects.
 */
public class Menu {

    private ArrayList<Dish> dishList;
    private String menuName;

    /**
     * This constructor represents a menu using a dishList. Each time a new menu is created, an arrayList is attached
     * to that object.
     * @param menuName
     */
    public Menu(String menuName) {
        dishList = new ArrayList<>();
        this.menuName = menuName;

    }

    /**
     * This method adds Dish objects into the Menu's ArrayList.
     * @param dish
     */
    public void dishAdd(Dish dish){
        this.dishList.add(dish);
    }

    /**
     * This method takes a dishes name and see's if it exists within the class instance's arrayList (dishList). This is
     * done through equating the argument and the dishList's objects names {@link Dish#getDishName()}.
     * @param dishName
     * @return
     */
    public Dish dishFinder(String dishName){
        for (int i = 0; i < this.dishList.size(); i++) {
            if(dishName.equals(this.dishList.get(i).getDishName())){
                return dishList.get(i);
            }
        }
        return null;
    }

    /**
     * This method returns all the dishes that have the same type as the argument "type" passed.
     * @param type
     * @return
     */
    public Dish dishTypeFinder(String type){
        for (int i = 0; i < this.dishList.size(); i++) {
            if(dishList.get(i).getTypeOfFood().equals(type)){
                return dishList.get(i);
            }
        }
        return null;
    }

    /**
     * Since dishList is private, this is a getter function that returns the ArrayList.
     * @return
     */
    public ArrayList<Dish> getDishList() {
        return dishList;
    }

    /**
     * This method adds up all the prices of all the dish objects in a given menu object's arraylist.
     * @return
     */
    public double calcMenuPrice(){
        double totalPrice = 0;
        for (int i = 0; i < this.dishList.size(); i++) {
            totalPrice += this.dishList.get(i).getPrice();
        }
        return totalPrice;
    }

    /**
     * This method takes a menu and uses toString {@link Dish#toString()} to print out the menu.
     */
    public void printingMenu(){
        System.out.println("\n");
        for (int i = 0; i < this.dishList.size(); i++) {
            System.out.println(this.dishList.get(i).toString());
        }
    }

    public String getMenuName() {
        return menuName;
    }
}
