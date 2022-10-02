/**
 * This class, Property, represents a property with the intrinsic information included as object variables:
 * municipality name and number, lot number, section number, lot name, area of the property, and the owner of the property's
 * name. Furthermore, since the municipality number and name, the lot number, and the section number cannot be changed
 * once set. These were made to be final and do therefore not have setters.
 */
public class Property {
    private final int MUNICIPALITYNUMBER;
    private final String MUNICIPALITYNAME;
    private final int LOTNUM;
    private final int SECTNUM;
    private String lotName;
    private double area;
    private String ownerName;

    /**
     * This is a constructor for a property. It takes in the necessary parameters. However, if one of the parameters does
     * not fit the specifications of that variable, such as municipality number cannot be less than 101 or more than 5054,
     * then an illegal argument exception is thrown.
     * @param MUNICIPALITYNUMBER
     * @param MUNICIPALITYNAME
     * @param LOTNUM
     * @param SECTNUM
     * @param lotName
     * @param area
     * @param ownerName
     */
    public Property(int MUNICIPALITYNUMBER, String MUNICIPALITYNAME, int LOTNUM, int SECTNUM, String lotName, double area, String ownerName) {
        if(MUNICIPALITYNUMBER < 101 || MUNICIPALITYNUMBER > 5054){
            throw new IllegalArgumentException("The municipality is not legible.");
        }
        if(LOTNUM < 0 || SECTNUM < 0 || area < 0){
            throw new IllegalArgumentException("You sent in a negative number for one of the following variables:" +
                    " lot number, section number, or area.");
        }
        this.MUNICIPALITYNUMBER = MUNICIPALITYNUMBER;
        this.MUNICIPALITYNAME = MUNICIPALITYNAME;
        this.LOTNUM = LOTNUM;
        this.SECTNUM = SECTNUM;
        this.lotName = lotName;
        this.area = area;
        this.ownerName = ownerName;
    }

    /**
     * This is an additional Property constructor. This constructor serves the purpose of making copies of pre-existing
     * Property objects. This allows for the variable data to be copied instead of the reference to the object, in other
     * words deep copies can be made.
     * @param prop Property object
     */
    public Property(Property prop){
        this.MUNICIPALITYNUMBER = prop.getMUNICIPALITYNUMBER();
        this.MUNICIPALITYNAME = prop.getMUNICIPALITYNAME();
        this.LOTNUM = prop.getLOTNUM();
        this.SECTNUM = prop.getSECTNUM();
        this.lotName = prop.getLotName();
        this.area = prop.getArea();
        this.ownerName = prop.getOwnerName();
    }

    /**
     * This is a getter for the municipality number.
     * @return Municipality number
     */
    public int getMUNICIPALITYNUMBER() {
        return MUNICIPALITYNUMBER;
    }

    /**
     * This is a getter for the municipality name.
     * @return Municipality name
     */
    public String getMUNICIPALITYNAME() {
        return MUNICIPALITYNAME;
    }

    /**
     * This is a getter for the lot number of the given property.
     * @return Lot number
     */
    public int getLOTNUM() {
        return LOTNUM;
    }

    /**
     * This is a getter for the section number of a given property.
     * @return Section number
     */
    public int getSECTNUM() {
        return SECTNUM;
    }

    /**
     * This is a getter for the lot name of a property.
     * @return Lot name
     */
    public String getLotName() {
        return lotName;
    }

    /**
     * This method allows for the lot name of a property to be changed.
     * @param lotName The lot name of a property.
     */
    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    /**
     * This is a getter for the area of a property.
     * @return Area of property
     */
    public double getArea() {
        return area;
    }

    /**
     * This method allows for the area of a given property to be changed.
     * @param area Area of a property
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * This is a getter for the name of the owner of a given property.
     * @return Name of the owner.
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * This method allows for the name of the owner to be changed.
     * @param ownerName Name of the owner of a given property
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * This is a method that creates and returns an ID for the property. An ID takes the form:
     * "Municipality number-Lot number/Section number". For example, if the municipality number was 5000, the lot
     * number was 43, and the section number was 11. Then, the ID would be "5000-43/11".
     * @return The String for the ID of a given property.
     */
    public String returnID(){
        return this.MUNICIPALITYNUMBER + "-" + this.LOTNUM + "/" + this.SECTNUM;
    }

    @Override
    public String toString(){
        return "Property name:" + lotName + "     Owner name: " + ownerName;
    }

}
