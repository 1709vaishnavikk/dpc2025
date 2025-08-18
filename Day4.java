public class Day4 {
    // merge arr1 (size m) and arr2 (size n) in-place using Gap method
    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int total = m + n;
        int gap = nextGap(total);

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < total) {
                // get values at i and j (virtual combined array indexing)
                int vi = (i < m) ? arr1[i] : arr2[i - m];
                int vj = (j < m) ? arr1[j] : arr2[j - m];

                if (vi > vj) {
                    // swap them in the appropriate arrays
                    if (i < m && j < m) {           // both in arr1
                        int tmp = arr1[i]; arr1[i] = arr1[j]; arr1[j] = tmp;
                    } else if (i < m && j >= m) {   // arr1[i] and arr2[j-m]
                        int tmp = arr1[i]; arr1[i] = arr2[j - m]; arr2[j - m] = tmp;
                    } else {                         // both in arr2
                        int tmp = arr2[i - m]; arr2[i - m] = arr2[j - m]; arr2[j - m] = tmp;
                    }
                }
                i++; j++;
            }
            gap = nextGap(gap);
        }
    }

    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap + 1) / 2; // ceil(gap/2)
    }

    // quick test
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println(java.util.Arrays.toString(arr1)); // [1,2,3,4]
        System.out.println(java.util.Arrays.toString(arr2)); // [5,6,7,8]
    }
}
