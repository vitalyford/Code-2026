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

    public static void main(String[] args) {
        System.out.println(
            reverse("A Santa lived as a devil at NASA")
        );

        hanoi("A", "B", "C", 64);
    }
}
