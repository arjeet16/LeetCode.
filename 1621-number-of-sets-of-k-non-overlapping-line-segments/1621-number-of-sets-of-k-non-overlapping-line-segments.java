class Solution {
    static final int MOD = 1000000007;
    static final int LIMIT = 1999;
    static long[] fact = new long[LIMIT];
    static long[] inv = new long[LIMIT];

    static {
        fact[0] = 1;

        for (int i = 1; i < LIMIT; i++)
            fact[i] = fact[i - 1] * i % MOD;

        inv[LIMIT - 1] = pow(fact[LIMIT - 1], MOD - 2);

        for (int i = LIMIT - 1; i > 0; i--)
            inv[i - 1] = inv[i] * i % MOD;
    }

    private static long pow(long x, int n) {
        long ans = 1;

        for (; n > 0; n /= 2) {
            if (n % 2 > 0)
                ans = ans * x % MOD;

            x = x * x % MOD;
        }

        return ans;
    }

    private long comb(int n, int m) {
        return fact[n] * inv[m] % MOD * inv[n - m] % MOD;
    }

    public int numberOfSets(int n, int k) {
        return (int) comb(n + k - 1, k * 2);
    }
}