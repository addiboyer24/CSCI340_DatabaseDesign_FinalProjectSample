package App.Domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Rider {
    private String email;
    private String name;
    private String dateOfBirth;
    private int age;

    private boolean isBirthday;
    private int height;
    private int tickets;

    // Getter methods
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge(){
        return this.age;
    }

    public boolean getIsBirthday(){
        return this.isBirthday;
    }

    public int getHeight() {
        return height;
    }

    public int getTickets() {
        return tickets;
    }

    // Setter methods
    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setIsBirthday(boolean isBirthday){ this.isBirthday = isBirthday; }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public void ride(Attraction attraction) throws Exception {
        this.validateRide(attraction); // Semantic constraints i.e. business rules.

        // If it's not your birthday you have to pay.
        if (!isBirthday){
            this.tickets -= attraction.getCost();
        }
    }
    private void validateRide(Attraction attraction) throws Exception {
        // Check if it's their birthday, or they have sufficient tickets for the attraction.
        if (!isBirthday){
            if (this.tickets < attraction.getCost()) throw new Exception("Sorry, you don't have a sufficient number of tickets to ride this attraction.");
        }

        // Check age restrictions.
        for (AgeRestriction restriction : attraction.getAgeRestrictions()){
            if (this.age < restriction.getMinAge()) throw new Exception("Sorry, you're not old enough to ride this attraction.");
        }
        // Check height restrictions.
        for (HeightRestriction restriction : attraction.getHeightRestrictions()){
            if (this.height < restriction.getMinHeight()) throw new Exception("Sorry, you're not tall enough to ride this attraction.");
        }
    }
}
