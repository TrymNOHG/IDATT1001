import java.util.Objects;

/**
 * This class represents a mushroom species. It, therefore, is immutable because the information registered on the different
 * types of mushrooms does not change. This class can check whether two mushrooms are identical through the use of an
 * equals method. Furthermore, it can check if a mushroom's description contains a certain phrase or other description.
 */
public class Mushroom {
    private final String NAME;
    private final String DESCRIPTION;
    private final boolean POISONOUS;

    /**
     * This is the constructor for the mushroom class, allowing a new mushroom object to be made through the input of
     * the variables.
     * @param NAME Name of the mushroom species.
     * @param DESCRIPTION Description of the type of mushroom.
     * @param POISONOUS A boolean, stating whether the mushroom is poisonous or not.
     */
    public Mushroom(String NAME, String DESCRIPTION, boolean POISONOUS) {
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.POISONOUS = POISONOUS;
    }

    /**
     * This is a second constructor. It allows for Mushroom objects to be cloned/deep copied. This is done by sending
     * in a pre-existing Mushroom object and creating a new one by using the information from the input.
     * @param mushroom A pre-existing mushroom object.
     */
    public Mushroom(Mushroom mushroom){
        this.NAME = mushroom.getNAME();
        this.DESCRIPTION = mushroom.getDESCRIPTION();
        this.POISONOUS = mushroom.isPOISONOUS();
    }

    /**
     * This is a method which checks if a mushroom object contains a certain phrase/description within its own
     * description.
     * @param description The description of the mushroom.
     * @return A boolean stating whether the phrase exists in the mushrooms description.
     */
    public boolean descriptionCheck(String description){
        return this.DESCRIPTION.contains(description);
    }

    /**
     * This is an equals, seeing if two Mushroom objects are identical. Two mushrooms are identical if they have
     * the same name.
     * @param o The o object is another mushroom object.
     * @return A boolean stating whether they are identical or not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mushroom)) return false;

        Mushroom mushroom = (Mushroom) o;

        return Objects.equals(NAME, mushroom.NAME);
    }

    /**
     * This is a getter for the name of the mushroom.
     * @return Name of the mushroom.
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * This is a getter for the description of the mushroom.
     * @return The description of the mushroom.
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    /**
     * This is a getter for the boolean poisonous.
     * @return The boolean poisonous.
     */
    public boolean isPOISONOUS() {
        return POISONOUS;
    }

    @Override
    public String toString() {
        return this.NAME + ": " + this.DESCRIPTION + " " + this.POISONOUS;
    }
}
