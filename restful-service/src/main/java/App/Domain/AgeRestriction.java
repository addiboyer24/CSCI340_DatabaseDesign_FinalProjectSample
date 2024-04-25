package App.Domain;

public class AgeRestriction extends Restriction {
    private int minAge;

    // Getter method
    public int getMinAge() {
        return minAge;
    }

    // Setter method
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
