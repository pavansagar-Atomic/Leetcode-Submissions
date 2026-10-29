import java.util.*;

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] depth = new int[n];
        int[][] up = new int[17][n];
        int[] timer = {0};

        dfs(0, 0, adj, tin, tout, depth, up, timer);

        BIT bit = new BIT(n + 1);
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int mask = 1 << (chars[i] - 'a');
            bit.update(tin[i], mask);
            bit.update(tout[i] + 1, mask);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                if (chars[u] != c) {
                    int mask = (1 << (chars[u] - 'a')) | (1 << (c - 'a'));
                    bit.update(tin[u], mask);
                    bit.update(tout[u] + 1, mask);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int l = lca(u, v, depth, up, tin, tout);

                int mask = bit.query(tin[u]) ^ bit.query(tin[v])
                         ^ (1 << (chars[l] - 'a'));

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private void dfs(int u, int p, List<Integer>[] adj,
                     int[] tin, int[] tout, int[] depth,
                     int[][] up, int[] timer) {
        tin[u] = timer[0]++;
        up[0][u] = p;

        for (int i = 1; i < up.length; i++) {
            up[i][u] = up[i - 1][up[i - 1][u]];
        }

        for (int v : adj[u]) {
            if (v == p) continue;
            depth[v] = depth[u] + 1;
            dfs(v, u, adj, tin, tout, depth, up, timer);
        }

        tout[u] = timer[0] - 1;
    }

    private int lca(int u, int v, int[] depth,
                    int[][] up, int[] tin, int[] tout) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int i = 0; i < up.length; i++) {
            if ((diff & (1 << i)) != 0) {
                u = up[i][u];
            }
        }

        if (u == v) return u;

        for (int i = up.length - 1; i >= 0; i--) {
            if (up[i][u] != up[i][v]) {
                u = up[i][u];
                v = up[i][v];
            }
        }

        return up[0][u];
    }

    static class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            for (i++; i <= n; i += i & -i) {
                tree[i] ^= val;
            }
        }

        int query(int i) {
            int res = 0;
            for (i++; i > 0; i -= i & -i) {
                res ^= tree[i];
            }
            return res;
        }
    }
}