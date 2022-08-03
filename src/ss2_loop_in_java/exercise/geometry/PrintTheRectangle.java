package ss2_loop_in_java.exercise.geometry;

public class PrintTheRectangle {
    public static void main(String[] args) {
        int longs = 5;
        int width = 7;
        int i;
        int j;
        for (i = 0; i < longs; i++) {
            for (j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
