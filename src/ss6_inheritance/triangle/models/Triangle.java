package ss6_inheritance.triangle.models;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
    }

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        return Math.sqrt(getHalfPerimeter() * (getHalfPerimeter() - side1) * (getHalfPerimeter() - side2) * (getHalfPerimeter() - side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public double getHalfPerimeter() {
        return getPerimeter() / 2;
    }

    @Override
    public String toString() {
        return "Triangle has " +
                " side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", area= " + getArea()+
                ", perimeter=" + getPerimeter()+ super.toString();
    }
}
