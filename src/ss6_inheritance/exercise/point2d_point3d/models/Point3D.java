package ss6_inheritance.exercise.point2d_point3d.models;

import java.util.Arrays;

public class Point3D extends Point2D {

    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setX(x);
        super.setY(y);
        this.z = z;

    }

    public float[] getXYZ() {
        float[] array1 = {super.getX(), super.getY(), z};
        return array1;
    }

    @Override
    public String toString() {
        return super.toString() + " z= " + getZ() + " array = " + Arrays.toString(getXYZ());
    }
}