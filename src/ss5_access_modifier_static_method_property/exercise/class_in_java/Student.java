package ss5_access_modifier_static_method_property.exercise.class_in_java;

public class Student {
    private String name;
    private String classes;

    public Student() {
        this.name = "John";
        this.classes = "C02";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

     public String display(){
        return this.name + " " + this.classes;
     }
}
