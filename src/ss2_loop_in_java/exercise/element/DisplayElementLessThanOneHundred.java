package ss2_loop_in_java.exercise.element;

public class DisplayElementLessThanOneHundred {
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
        int i = 2;
        while (i < 100) {
            if (checkPrime(i)) {
                System.out.print(i + "\t");
            }
            i++;
        }
    }
}
