package ss6_inheritance.exercise.point_moveable_point.controller;

import ss6_inheritance.exercise.point_moveable_point.models.MoveablePoint;
import ss6_inheritance.exercise.point_moveable_point.models.Point;

public class MainController {
    public static void main(String[] args) {

        Point point = new Point(1, 2);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint(2, 3, 2.1f, 4.3f);
        moveablePoint.move();
        System.out.println(moveablePoint);

    }
}
