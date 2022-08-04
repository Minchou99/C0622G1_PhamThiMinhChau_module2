package algorithm;

import java.util.Scanner;

public class Algorithm {
    public static void main(String[] args) {
        int n = 5;
        for (int i = -n; i <= n; i++) {
            int iAbs = Math.abs(i);
            for (int j = -n; j <= n; j++) {
                int jAbs = Math.abs(j);
                System.out.print(iAbs + jAbs == n ? jAbs : " ");
                if (j < n) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }
}

