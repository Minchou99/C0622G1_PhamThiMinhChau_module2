package ss7_abtract_interface.exercise.resizeable.controller;

import ss7_abtract_interface.exercise.colorable.models.Circle;
import ss7_abtract_interface.exercise.colorable.models.Rectangle;
import ss7_abtract_interface.exercise.colorable.models.Shape;
import ss7_abtract_interface.exercise.colorable.models.Square;

public class MainController {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5);
        shapes[1] = new Rectangle(3, 5);
        shapes[2] = new Square(3);

        for (Shape shape : shapes) {
            shape.resize(Math.floor((Math.random() * 100)));
        }

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
