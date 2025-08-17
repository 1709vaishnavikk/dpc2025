public class Day3 {

    public static int findDuplicate(int[] arr) {
        // Phase 1: find intersection inside cycle
        int tortoise = arr[0];
        int hare = arr[0];
        do {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        } while (tortoise != hare);

        // Phase 2: find entrance to the cycle
        tortoise = arr[0];
        while (tortoise != hare) {
            tortoise = arr[tortoise];
            hare = arr[hare];
        }
        return hare; // or tortoise
    }

    // quick test with the provided test cases
    public static void main(String[] args) {
        int[][] tests = {
            {1, 3, 4, 2, 2},       // -> 2
            {3, 1, 3, 4, 2},       // -> 3
            {1, 1},                // -> 1
            {1, 4, 4, 2, 3},       // -> 4
            // a reduced demonstration for very large test omitted for brevity
        };

        for (int[] t : tests) {
            System.out.println("Input: " + java.util.Arrays.toString(t)
                + "  -> Duplicate: " + findDuplicate(t));
        }

}
