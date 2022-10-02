import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents a hearing aid with information about its id, type, whether its rented, and if so then who is
 * renting it. The id and the type are made final variables without setters because they will never be changed.
 * Since the rental status, whether it is currently being rented, and the person renting the hearing aid is prone to change,
 * these variables have setters.
 */
public class HearingAid {
    private final int ID;
    private final String TYPE;
    private boolean aidRented;
    private String loanedTo;

    /**
     * This is a constructor. See oppgave 1.
     * @param ID
     * @param TYPE
     * @param aidRented
     * @param loanedTo
     */
    public HearingAid(int ID, String TYPE, boolean aidRented, String loanedTo) {
        if(ID < 1001 || ID > 9999){
            throw new IllegalArgumentException("The ID of this hearing aid is invalid. For the ID to be valid, it needs" +
                    " to be within the range 1001-9999");
        }
        this.ID = ID;
        this.TYPE = TYPE;
        this.aidRented = aidRented;
        this.loanedTo = loanedTo;
    }

    public HearingAid(HearingAid hearingAid){
        this.ID = hearingAid.getID();
        this.TYPE = hearingAid.getTYPE();
        this.aidRented = hearingAid.isAidRented();
        this.loanedTo = hearingAid.getLoanedTo();
    }

    /**
     * This is a getter for the hearing aid ID.
     * @return Hearing aid's ID
     */
    public int getID() {
        return ID;
    }

    /**
     * This is a getter for the type of hearing aid.
     * @return Type of hearing aid
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * This is a getter for aidRented.
     * @return A boolean showing whether a hearing aid is being rented or not.
     */
    public boolean isAidRented() {
        return aidRented;
    }

    /**
     * This is a setter for the status of rental of a hearing aid.
     * @param aidRented A boolean of whether a hearing aid is rented or not.
     */
    public void setAidRented(boolean aidRented) {
        this.aidRented = aidRented;
    }

    /**
     * This is a getter for the name of the person renting/loaning the hearing aid.
     * @return The name of the person loaning the hearing aid.
     */
    public String getLoanedTo() {
        return loanedTo;
    }

    /**
     * This is a setter for the name of the person loaning the hearing aid.
     * @param loanedTo Name of person loaning the hearing aid.
     */
    public void setLoanedTo(String loanedTo) {
        this.loanedTo = loanedTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HearingAid)) return false;

        HearingAid that = (HearingAid) o;

        return Objects.equals(TYPE, that.TYPE);
    }


    /**
     * This is a toString, which prints out the necessary information (description) about a hearing aid. If no one is loaning out
     * the hearing aid, then it omits that from the descriptions
     * @return A string description of the hearing aid object.
     */
    @Override
    public String toString() {
        if(this.aidRented) {
            return ID + " " + TYPE + " loaned out to " + loanedTo;
        }
        else{
            return ID + " " + TYPE + " Available";
        }
    }
}
