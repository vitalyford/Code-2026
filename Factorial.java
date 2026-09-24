public class Factorial {
    public static int f(int n) {
        return (n <= 1) ? 1 : n * f(n - 1);
        // if (n <= 1) {
        //     return 1;
        // }
        // int prod = n * f(n - 1);
        // return prod;
    }

    public static void main(String[] args) {
        System.out.println(f(1000));
    }
}