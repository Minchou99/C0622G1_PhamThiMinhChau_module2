package assignment.exercise1.model;

public class Student extends Person {
    private double point;
    private String nameClass;

    public Student() {
    }

    public Student(double point, String nameClass) {
        this.point = point;
        this.nameClass = nameClass;
    }

    public Student(String id, String name, String dateOfBirth, String gender, double point, String nameClass) {
        super(id, name, dateOfBirth, gender);
        this.point = point;
        this.nameClass = nameClass;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("%s,%s", point, nameClass);
    }

}
