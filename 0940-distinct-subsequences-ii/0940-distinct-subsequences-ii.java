class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1000000007;
        long[] last = new long[26];
        long dp = 1;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            long newDp = 2 * dp - last[idx];
            newDp = (newDp % MOD + MOD) % MOD;
            last[idx] = dp;
            dp = newDp;
        }

        return (int)((dp - 1 + MOD) % MOD);
    }
}