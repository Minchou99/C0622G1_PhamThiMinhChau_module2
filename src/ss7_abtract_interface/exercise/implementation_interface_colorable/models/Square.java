package ss7_abtract_interface.exercise.implementation_interface_colorable.models;

public class Square extends Shape implements Colorable {
    private double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public void howToColor() {
        System.out.println("Filled Square");
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}
