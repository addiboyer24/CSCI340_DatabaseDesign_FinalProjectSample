package App.Domain;

public class Employee {
    private String ssn;

    private String name;

    private String dateOfBirth;


    public String getName(){ return this.name; }

    public void setName(String name){
        this.name = name;
    }

    public String getSsn(){ return this.ssn; }

    public void setSsn(String ssn){
        this.ssn = ssn;
    }

    public String getDateOfBirth(){ return this.dateOfBirth; }

    public void setDateOfBirth(String dateOfBirth){ this.dateOfBirth = dateOfBirth; }

}
