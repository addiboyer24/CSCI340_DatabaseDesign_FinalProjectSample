package database.design.finalproject;

public class Student {
    // Instance Variables.
    private int id;
    private String name;

    // Constructors.
    public Student(){
    }

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
    }

    // Getters and Setters.
    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
