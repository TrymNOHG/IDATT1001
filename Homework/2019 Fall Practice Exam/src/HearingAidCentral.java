import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a hearing aid central. Therefore, it always comes along with an arrayList, operating as a
 * register. The class has methods replicating the functions of a hearing aid central. These include registering a
 * new hearing aid, loaning out hearing aids, ending loans, providing the information on the different types of
 * hearing aids, and checking which hearing aids are available for loan.
 */
public class HearingAidCentral {
    private String centerName;
    private List<HearingAid> hearingAidList;

    public HearingAidCentral(String centerName) {
        this.centerName = centerName;
        this.hearingAidList = new ArrayList<>();
    }

    /**
     * This method registers a new hearing aid with all the necessary information. In order to make sure there
     * aren't any duplicate hearing aids with the same ID, the hearing aid is only registered if it has a unique
     * ID. If it doesn't, nothing is registered.
     * @param ID
     * @param TYPE
     * @return A boolean showing whether the hearing aid was registered or not.
     */
    public boolean registerHearingAid(int ID, String TYPE){
        for(HearingAid registered: hearingAidList){
            if(registered.getID() == ID){
                return false;
            }
        }
        this.hearingAidList.add(new HearingAid(ID, TYPE, false, "Available"));
        return true;
    }

    /**
     * This method checks whether a person can be loaned out a hearing aid. If the hearing aid isn't already loaned out,
     * then the hearing aid is registered as being loaned out by the new person wanting to loan it.
     * @param TYPE
     * @param loanedTo
     * @return A boolean stating whether the person was successful in loaning the hearing aid.
     */
    public boolean loanOutAid(String TYPE, String loanedTo){
        for(HearingAid registered: hearingAidList){
            if(registered.getTYPE().equals(TYPE) && registered.isAidRented() == false){
                registered.setLoanedTo(loanedTo);
                registered.setAidRented(true);
                return true;
            }
        }
        return false;
    }

    /**
     * This finds the loans that a given person has taken and ends it by setting the hearing aid to available again.
     * @param loanTo
     */
    public void endLoan(String loanTo){
        for(HearingAid registered: hearingAidList){
            if(registered.getLoanedTo().equals(loanTo)){
                registered.setLoanedTo("Available");
                registered.setAidRented(false);
            }
        }
    }

    /**
     * This method returns a deep copied version of the list of all the hearing aids, with the respective information
     * included.
     * @return A list of all the hearing aid objects registered so far.
     */
    public List<HearingAid> hearingAidInformation(){
        List<HearingAid> allHearingAids = new ArrayList<>();
        for(HearingAid registered: hearingAidList){
            allHearingAids.add(new HearingAid(registered));
        }
        return allHearingAids;
    }

    /**
     * This method creates a list of all the hearing aid objects which are both available and of the type given.
     * @param TYPE Type of hearing aid.
     * @return A list of all the available hearing aids of the given type.
     */
    public List<HearingAid> availableAid(String TYPE){
        List<HearingAid> availableAids = new ArrayList<>();
        for(HearingAid registered: hearingAidList){
            if(registered.getTYPE().equals(TYPE) && registered.isAidRented() == false){
                availableAids.add(new HearingAid(registered));
            }
        }
        return availableAids;
    }

    public HearingAid eirik(){
        return hearingAidList.get(0);
    }

    /**
     * This method is a getter for the name of the hearing aid center.
     * @return Hearing aid center name
     */
    public String getCenterName() {
        return centerName;
    }


}
