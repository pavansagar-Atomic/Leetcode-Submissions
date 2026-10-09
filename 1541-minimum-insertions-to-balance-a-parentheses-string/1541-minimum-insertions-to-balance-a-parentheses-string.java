class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int close = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (close % 2 == 1) {
                    ans++;
                    close--;
                }
                close += 2;
            } else {
                close--;
                if (close < 0) {
                    ans++;
                    close = 1;
                }
            }
        }

        return ans + close;
    }
}