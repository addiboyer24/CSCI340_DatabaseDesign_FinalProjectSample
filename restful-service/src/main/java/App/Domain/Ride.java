package App.Domain;

public class Ride {
    private String attractionName;
    private String riderEmail;
    private String boardingTime;

    // Getter methods
    public String getAttractionName() {
        return attractionName;
    }

    public String getRiderEmail() {
        return riderEmail;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    // Setter methods
    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public void setRiderEmail(String riderEmail) {
        this.riderEmail = riderEmail;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }
}
