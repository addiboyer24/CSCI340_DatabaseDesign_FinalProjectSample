package App.Domain;

import java.util.List;

public class Attraction {
    private String name;
    private String description;
    private String buildDate;
    private int cost;
    private String manager;
    private String dateStarted;
    private boolean isAgeRestricted;

    private List<AgeRestriction> ageRestrictions;
    private List<HeightRestriction> heightRestrictions;

    // Getter for ageRestrictions
    public List<AgeRestriction> getAgeRestrictions() {
        return ageRestrictions;
    }

    // Setter for ageRestrictions
    public void setAgeRestrictions(List<AgeRestriction> ageRestrictions) {
        this.ageRestrictions = ageRestrictions;
    }

    // Getter for heightRestrictions
    public List<HeightRestriction> getHeightRestrictions() {
        return heightRestrictions;
    }

    // Setter for heightRestrictions
    public void setHeightRestrictions(List<HeightRestriction> heightRestrictions) {
        this.heightRestrictions = heightRestrictions;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public int getCost() {
        return cost;
    }

    public String getManager() {
        return manager;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public boolean isAgeRestricted() {
        return isAgeRestricted;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public void setAgeRestricted(boolean ageRestricted) {
        isAgeRestricted = ageRestricted;
    }
}
