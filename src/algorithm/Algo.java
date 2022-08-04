package algorithm;

public class Algo {
    public static void main(String[] args) {
        for (int i = 0; i <6 ; i++) {
            for (int j = 6; j >i ; j--) {
                if(j-i>0){
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }System.out.println();
        }
    }
}
