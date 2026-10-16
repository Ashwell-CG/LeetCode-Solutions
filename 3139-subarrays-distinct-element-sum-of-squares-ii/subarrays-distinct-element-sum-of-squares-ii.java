class Solution {
    long[] sum;
    long[] square;
    long[] lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int l = last[nums[i]] + 1;

            update(1, 0, n - 1, l, i);

            last[nums[i]] = i;
            ans = (ans + square[1]) % 1000000007;
        }

        return (int) ans;
    }

    void apply(int node, int left, int right, long add) {
        long len = right - left + 1L;

        square[node] = (
            square[node] + 2 * add * sum[node] + add * add * len
        ) % 1000000007;

        sum[node] = (sum[node] + add * len) % 1000000007;
        lazy[node] = (lazy[node] + add) % 1000000007;
    }

    void push(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = (left + right) / 2;

        apply(node * 2, left, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, right, lazy[node]);

        lazy[node] = 0;
    }

    void update(int node, int left, int right, int ql, int qr) {
        if (ql > right || qr < left) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(node, left, right, 1);
            return;
        }

        push(node, left, right);

        int mid = (left + right) / 2;

        update(node * 2, left, mid, ql, qr);
        update(node * 2 + 1, mid + 1, right, ql, qr);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1])
                    % 1000000007;

        square[node] = (square[node * 2] + square[node * 2 + 1])
                       % 1000000007;
    }
}