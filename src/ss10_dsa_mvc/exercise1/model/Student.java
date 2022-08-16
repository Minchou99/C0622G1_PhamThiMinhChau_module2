package ss10_dsa_mvc.exercise1.model;

public class Student extends Person {
    private String point;
    private String nameClass;

    public Student() {
    }

    public Student(String point, String nameClass) {
        this.point = point;
        this.nameClass = nameClass;
    }

    public Student(int id, String name, String dateOfBirth, String gender, String point, String nameClass) {
        super(id, name, dateOfBirth, gender);
        this.point = point;
        this.nameClass = nameClass;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
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
        return "Student{" + super.toString() +
                "point=" + point +
                ", nameClass='" + nameClass  +
                "} ";
    }

}
