import java.util.*;

class Solution {
    int pos = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parse(String s) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (pos < s.length() && s.charAt(pos) != '}') {
            char ch = s.charAt(pos);

            if (ch == '{') {
                pos++;
                Set<String> next = parse(s);
                pos++;
                current = combine(current, next);
            } else if (ch == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                pos++;
            } else {
                Set<String> next = new HashSet<>();
                next.add(String.valueOf(ch));
                current = combine(current, next);
                pos++;
            }
        }

        result.addAll(current);
        return result;
    }

    private Set<String> combine(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}