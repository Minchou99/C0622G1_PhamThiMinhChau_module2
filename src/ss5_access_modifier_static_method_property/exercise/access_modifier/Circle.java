package ss5_access_modifier_static_method_property.exercise.access_modifier;

public class Circle {
    double radius = 1;
    String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
