package ss6_inheritance.exercise.point2d_point3d.controller;

import ss6_inheritance.exercise.point2d_point3d.models.Point2D;

public class MainController2D {
    public static void main(String[] args) {
        Point2D point2D=new Point2D();
        System.out.println(point2D);

        Point2D point2D1=new Point2D(2,1);
        System.out.println(point2D1);
    }
}
