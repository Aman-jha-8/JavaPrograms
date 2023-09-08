package JavaPgms.Sorting;

class catalanSolution {
    // Modulo constant
    private static final int MOD = (int)1e9 + 7;

    public static int findCatalan(int n) {
        // Create an array to store results of subproblems
        int catalan[] = new int[n + 1];

        // Base cases
        catalan[0] = 1;
        catalan[1] = 1;

        // Fill in the values using the recursive formula
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] = (catalan[i] + (int)(((long)catalan[j] * catalan[i-j-1]) % MOD)) % MOD;
            }
        }

        return catalan[n];
    }

    public static void main(String[] args) {
        System.out.println(findCatalan(5));  // should print 42
        System.out.println(findCatalan(4));  // should print 14
    }
}
