import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a property register. Therefore, when a register object is created, an ArrayList is automatically
 * generated as an object variable. Since a property register's size isn't predefined and can expand if the areas of
 * properties and such changes, an arrayList was used. ArrayLists do not have a predefined size and therefore allows for
 * more variability.
 */
public class PropertyRegister {
    private List<Property> propertyRegister;

    /**
     * This is a constructor for the PropertyRegister class where the property register arrayList is initialized.
     */
    public PropertyRegister() {
        this.propertyRegister = new ArrayList<>();
    }

    /**
     * This method registers a new property into the property register arrayList. The method takes in the necessary
     * information to create a new Property object. Since when a new property is registered, it doesn't
     * immediately have an owner, that parameter was not added.
     * @param MUNICIPALITYNUMBER
     * @param MUNICIPALITYNAME
     * @param LOTNUM Lot number
     * @param SECTNUM Section number
     * @param lotName Name of the lot
     * @param area Area of the property
     */
    public void registerNewProperty(int MUNICIPALITYNUMBER, String MUNICIPALITYNAME, int LOTNUM, int SECTNUM, String lotName, double area){
        propertyRegister.add(new Property(MUNICIPALITYNUMBER, MUNICIPALITYNAME, LOTNUM, SECTNUM, lotName, area, "Available"));
    }

    /**
     * This method checks whether there is a property with the given owner name and lot name. If so, that property is
     * removed from the register.
     * @param lotNum
     * @param lotName
     * @return A boolean stating whether the Property was removed or not.
     */
    public boolean removeProperty(int lotNum, String lotName){
        for(Property prop: propertyRegister){
            if(prop.getLOTNUM() == lotNum && prop.getLotName().equals(lotName)){
                propertyRegister.remove(prop);
                return true;
            }
        }
        return false;
    }

    /**
     * This method returns the number of Property objects registered.
     * @return Number of Property objects registered.
     */
    public int numProperty(){
        return propertyRegister.size();
    }

    /**
     * This method find a Property in the register given the Property's ID. It therefore uses the returnID property
     * {@link Property#returnID()}.
     * @param municipalityNum
     * @param lotNum
     * @param sectNum
     * @return A copy of the Property with the same ID.
     */
    public Property findPropertyByID(int municipalityNum, int lotNum, int sectNum){
        String propertyID = municipalityNum + "-" + lotNum + "/" + sectNum;
        for(Property prop: propertyRegister){
            if(prop.returnID().equals(propertyID)){
                return new Property(prop);
            }
        }
        return null;
    }

    /**
     * Since properties registered don't automatically have an owner, this allows for the property to get a new owner.
     * @param ownerName
     * @param lotName
     * @return A boolean stating whether the property was successfully "bought" or changed the owner of.
     */
    public boolean newOwner(String ownerName, String lotName){
        for(Property prop: propertyRegister){
            if(prop.getLotName().equals(lotName) && prop.getOwnerName().equals("Available")){
                prop.setOwnerName(ownerName);
                return true;
            }
        }
        return false;
    }

    public boolean changeArea(double newArea, String lotName){
        for(Property prop: propertyRegister){
            if(prop.getLotName().equals(lotName)){
                prop.setArea(newArea);
                return true;
            }
        }
        return false;
    }

    public boolean changeLotName(String oldLotName, String newLotName){
        for(Property prop: propertyRegister){
            if(prop.getLotName().equals(oldLotName)){
                prop.setLotName(newLotName);
                return true;
            }
        }
        return false;
    }

    /**
     * This method find the average area of all the properties registered in the registry. It does this by adding all
     * the areas, then dividing by the number of properties found through the numProperty method {@link #numProperty()}.
     * @return Average area of all the properties in the registry.
     */
    public double averageArea(){
        double sumOfAreas = 0;
        for(Property prop: propertyRegister){
            sumOfAreas += prop.getArea();
        }
        return sumOfAreas / numProperty();
    }

    /**
     * This method finds all the properties from the property register given the lotNumber. It, then, adds them to
     * a list of Properties.
     * @param lotNum
     * @return A list of properties with the same lot number.
     */
    public List<Property> findPropertyByLotNum(int lotNum){
        List<Property> lotNumPropList = new ArrayList<>();
        for(Property prop: propertyRegister){
            if(prop.getLOTNUM() == lotNum){
                lotNumPropList.add(new Property(prop));
            }
        }
        return lotNumPropList;
    }

    /**
     * This is a toString method which takes the information from an arrayList and makes it into a single String.
     * @return A string containing the information of a list of Property elements.
     */
    @Override
    public String toString() {
        String finalOutput = "";
        for(int i = 0; i < propertyRegister.size(); i++){
            finalOutput += (i+1) + ". " + propertyRegister.get(i).toString() + "\n";
        }
        return finalOutput;
    }
}
