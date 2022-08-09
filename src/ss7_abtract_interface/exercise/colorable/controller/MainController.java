package ss7_abtract_interface.exercise.colorable.controller;

import ss7_abtract_interface.exercise.colorable.models.Circle;
import ss7_abtract_interface.exercise.colorable.models.Rectangle;
import ss7_abtract_interface.exercise.colorable.models.Shape;
import ss7_abtract_interface.exercise.colorable.models.Square;

public class MainController {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle("blue",true, 10.0,16.0);
        shapes[1] = new Square(6.0, "yellow", false);
        shapes[2] = new Circle("red",8.0,true);

        for (Shape shape : shapes){
            System.out.println(shape);
            if (shape instanceof Square){
                ((Square) shape).howToColor();
            }
        }
    }
}
