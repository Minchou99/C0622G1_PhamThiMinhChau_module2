package ss6_inheritance.practise.geometry.controller;

import ss6_inheritance.practise.geometry.model.Circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle("indigo", 3.5, false);
        System.out.println(circle);
    }
}
