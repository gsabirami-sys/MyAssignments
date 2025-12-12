package week1.day2;

public class FibonacciSeriesassignment {

    public static void main(String[] args) {

        int n = 10;
        int f = 0, s = 1, t;

        System.out.println(f);  // 0
        System.out.println(s);  // 1

        for (int i = 3; i <= n; i++) {
            t = f + s;        // next term
            System.out.println(t);
            f = s;            // shift numbers
            s = t;
        }
    }
}