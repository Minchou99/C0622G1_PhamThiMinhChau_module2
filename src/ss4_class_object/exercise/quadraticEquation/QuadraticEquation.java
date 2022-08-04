package ss4_class_object.exercise.quadraticEquation;

public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return ((this.b * this.b) - (4 * this.c * this.a));
    }

    public double getRoot1() {
        return ((-this.b + Math.pow(getDiscriminant(), 0.5)) / (2 * this.a));
    }

    public double getRoot2() {
        return ((-this.b - Math.pow(getDiscriminant(), 0.5)) / (2 * this.a));
    }

    public double getRoot0() {
        return -this.b / (2 * this.a);
    }
}
