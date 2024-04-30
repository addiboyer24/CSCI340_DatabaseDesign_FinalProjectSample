package App.Domain;

public class AttractionHistory {
    private String attractionName;
    private String historyDate;
    private String description;

    public void setAttractionName(String attractionName){
        this.attractionName = attractionName;
    }

    public void setHistoryDate(String historyDate){
        this.historyDate = historyDate;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getAttractionName(){ return this.attractionName; }
    public String getHistoryDate(){ return this.historyDate; }
    public String getDescription(){ return this.description; }

}
