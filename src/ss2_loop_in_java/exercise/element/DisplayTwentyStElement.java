package ss2_loop_in_java.exercise.element;

public class DisplayTwentyStElement {
    public static boolean checkPrime(int number) {
        int i;
        for (i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        int i = 2;
        while (count < 20) {
            if (checkPrime(i)) {
                System.out.print(i + "\t");
                count++;
            }
            i++;
        }
    }
}
