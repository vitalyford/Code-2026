import java.util.HashMap;

public class Recursion {
    public static String reverse(String input) {
        // 1. on -> no
        // substring: [first, last)
        if (input.length() <= 1) {
            return input;
        }

        String last = input.substring(input.length() - 1);
        return last + reverse(
            input.substring(0, input.length() - 1)
        );
    }

    /**
     * 
     * @param src my source peg (from)
     * @param dst my destination peg (to)
     * @param spare my temp peg (using)
     * @param numOfRings determines the number of rings I would like to move
     */
    public static void hanoi(String src, String dst, String spare, int numOfRings) {
        if (numOfRings == 0) return;
        hanoi(src, spare, dst, numOfRings - 1);
        System.out.println("Move from " + src + " to " + dst);
        hanoi(spare, dst, src, numOfRings - 1);
    }


    // 1,1,2,3,5,8,13,21
    // Memoization
    public static long fib(long n, HashMap<Long, Long> store) {
        if (n <= 2) return 1; // n = 10
        
        if (store.containsKey(n)) return store.get(n);

        long firstResult  = fib(n - 1, store); // n - 1 = 9
        long secondResult = fib(n - 2, store); // n - 2 = 8
        
        // for n = 9, I know the answer as firstResult
        store.put(n - 1, firstResult);
        // for n = 8, I know the answer as firstResult
        store.put(n - 2, secondResult);

        return firstResult + secondResult;
    }

    public static void main(String[] args) {
        System.out.println(fib(100, new HashMap<>()));

        // System.out.println(
        //     reverse("A Santa lived as a devil at NASA")
        // );

        // hanoi("A", "B", "C", 3);
    }
}
