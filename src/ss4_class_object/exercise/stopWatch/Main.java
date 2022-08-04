package ss4_class_object.exercise.stopWatch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        System.out.println("Start Time: " + stopWatch.start());
        long[] array = new long[100000];
        int i;
        for (i = 0; i < array.length; i++) {
            array[i] = (int) Math.floor(Math.random() * 100000);
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("End Time: " + stopWatch.stop());
        System.out.println("ElapsedTime: " + stopWatch.getElapsedTime());

    }
}
