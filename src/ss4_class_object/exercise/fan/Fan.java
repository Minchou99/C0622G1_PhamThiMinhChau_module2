package ss4_class_object.exercise.fan;

public class Fan {
    private final int slow;
    private final int medium;
    private final int fast;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.slow=1;
        this.medium=2;
        this.fast=3;
        this.speed=slow;
        this.on=false;
        this.radius=5;
        this.color="blue";
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fan{" +
                " speed=" + speed +
                ", on=" + on +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
