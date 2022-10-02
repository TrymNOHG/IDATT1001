public class Person {
   
    private String firstName;
    private String lastName;
    private int birthYear;

    //Person constructor takes the personal information informations, first and last name and birth year.
    public Person(String firstName, String lastName, int birthYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    //Returns a Person Object's firstName
    public String getFirstName() {
        return firstName;
    }

    //Sets a Person Object's firstName into a given new String
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Returns a Person Object's lastName
    public String getLastName() {
        return lastName;
    }

    //Takes a new lastName string as an argument and sets a Person Object's firstName to that.
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Returns a Person object's birthYear
    public int getBirthYear() {
        return birthYear;
    }

    //Takes another birthYear as an argument and sets a Person object's birthYear to that.
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

}
