package ss5_access_modifier_static_method_property.exercise.access_modifier;

public class Circle {
   private double radius = 1;
   private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double i) {
        this.radius=i;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
