package ss10_dsa_mvc.model;

import ss10_dsa_mvc.model.Person;

public class Student extends Person {
    private double point;
    private String nameClass;

    public Student() {
    }

    public Student(double point, String nameClass) {
        this.point = point;
        this.nameClass = nameClass;
    }

    public Student(int id, String name, String dateOfBirth, String gender, double point, String nameClass) {
        super(id, name, dateOfBirth, gender);
        this.point = point;
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "point=" + point +
                ", nameClass='" + nameClass + '\'' +
                "} " + super.toString();
    }

}
