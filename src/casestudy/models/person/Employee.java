package casestudy.models.person;

public class Employee extends Person {
    private String position;
    private String part;
    private double salary;

    public Employee() {
    }

    public Employee(String id, String name, String dateOfBirth, String gender, double phoneNumber, String email, String position, String part, double salary) {
        super(id, name, dateOfBirth, gender, phoneNumber, email);
        this.position = position;
        this.part = part;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                ", part='" + part + '\'' +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
