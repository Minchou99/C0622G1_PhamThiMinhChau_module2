package ss6_inheritance.exercise.point2d_point3d.controller;

import ss6_inheritance.exercise.point2d_point3d.models.Point3D;

public class MainController3D {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);

        Point3D point3D1 = new Point3D(2, 3, 1);
        System.out.println(point3D1);
    }
}
