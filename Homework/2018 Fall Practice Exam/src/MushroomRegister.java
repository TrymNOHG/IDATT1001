import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MushroomRegister {
    private Mushroom[] mushroomRegister;

    public MushroomRegister() {
        this.mushroomRegister = new Mushroom[10];
    }

    /**
     * This method registers a new mushroom in the rigid array, mushroomRegister. The mushroom register can only have
     * a length in the multiple of 10. If the register is full, then the register is made anew with a length plus 10
     * indices. This method also checks whether the mushroom trying to be registered already exists or not. If it
     * doesn't already exist and the register needs to be expanded, then a list called tempRegister makes deep copies of
     * all the Mushroom objects in the list and adds them to the expanded array.
     * @param name Name of the mushroom species
     * @param description Description of the mushroom
     * @param poisonous Whether the mushroom is poisonous or not
     * @return A boolean stating whether the mushroom was added or not. It is only not added if it already exists.
     */
    public boolean registerNewMushroom(String name, String description, boolean poisonous){
        List<Mushroom> tempRegister = new ArrayList<>();
        for(int i = 0; i < this.mushroomRegister.length; i++){
            if(mushroomRegister[i] == null){
                mushroomRegister[i] = new Mushroom(name, description, poisonous);
                return true;
            }
            else if(this.mushroomRegister[i].equals(new Mushroom(name, description, poisonous))){
                return false;
            }
            else{
                tempRegister.add(new Mushroom(this.mushroomRegister[i]));
            }
        }

        this.mushroomRegister = new Mushroom[this.mushroomRegister.length + 10];
        for(int i = 0; i < tempRegister.size() + 1; i++){
            if(i < tempRegister.size()){
                this.mushroomRegister[i] = tempRegister.get(i);
            }
            else{
                this.mushroomRegister[i] = new Mushroom(name, description, poisonous);
                return true;
            }
        }
        return false;
    }

    public Mushroom[] edibleMushrooms(){
        Mushroom[] infoRegister = new Mushroom[this.mushroomRegister.length];
        for(int i = 0; i < this.mushroomRegister.length; i++) {
            if (this.mushroomRegister[i] != null) {
                if (!this.mushroomRegister[i].isPOISONOUS()) {
                    infoRegister[i] = new Mushroom(this.mushroomRegister[i]);
                }
            }
        }
        return infoRegister;
    }

    /**
     * This method checks for all the mushrooms which fit the description sent in as input.
     * @param description The description of the mushroom.
     * @return A string with all the info on all the mushroom that fit the description.
     */
    public String findMushroomByDesc(String description){
        String mushInfo = "All the mushrooms fitting the description: ";
        int counter = 1;
        for(int i = 0; i < this.mushroomRegister.length; i++){
            if(this.mushroomRegister[i] != null) {
                if (this.mushroomRegister[i].descriptionCheck(description)) {
                    mushInfo += "\n" + counter + ". " + this.mushroomRegister[i].toString();
                    counter++;
                }
            }
        }
        return mushInfo;
    }

    /**
     * This method returns the whole register. However, when returning the register, only the object information is sent,
     * not the references to the objects. This is done by making deep copies, making new objects with new references.
     * @return An array of Mushroom Objects.
     */
    public Mushroom[] allMushrooms(){
        Mushroom[] infoRegister = new Mushroom[this.mushroomRegister.length];
        for(int i = 0; i < this.mushroomRegister.length; i++){
            if(this.mushroomRegister[i] != null) {
                infoRegister[i] = new Mushroom(this.mushroomRegister[i]);
            }
        }
        return infoRegister;
    }



    /**
     * This method is a toString, which takes all the Mushroom objects registered in the registry and prints out their
     * information. This is done via a for loop and the toString property in the Mushroom class {@link Mushroom#toString()}
     * @return A string with all the information from all the Mushrooms in the registry.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("All the mushrooms currently register (Name, description, poisonous or not): ");
        for(int i = 0; i < this.mushroomRegister.length; i++){
            if(this.mushroomRegister[i] != null) {
                sb.append("\n" + (i+1) + ". " + this.mushroomRegister[i].toString());            }
        }
        return sb.toString();
    }
}
