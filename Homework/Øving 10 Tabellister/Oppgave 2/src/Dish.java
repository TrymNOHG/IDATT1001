public class Dish {

    private String typeOfFood;
    private double price;
    private String dishName;
    private String recipe;

    /**
     * This constructor takes in the intrinsic features of a dish, allowing a dish object to be created.
     * @param dishName
     * @param typeOfFood
     * @param price
     * @param recipe
     */
    public Dish(String dishName, String typeOfFood, double price, String recipe) {
        this.dishName = dishName;
        this.typeOfFood = typeOfFood;
        this.price = price;
        this.recipe = recipe;
    }

    public String getDishName() {
        return dishName;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public double getPrice() {
        return price;
    }

    public String getRecipe() {
        return recipe;
    }

    @Override
    public String toString(){
        return "Dish name:  " + dishName + "\nType:  " + typeOfFood + "\nPrice of dish:  " + price + "\nRecipe:  " + recipe;
    }

}
