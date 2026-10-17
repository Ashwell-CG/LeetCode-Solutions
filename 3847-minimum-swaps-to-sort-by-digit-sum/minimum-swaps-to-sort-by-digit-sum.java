class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            int digit = nums[i];
            int t = 0;
            while(digit>0){
                int ld = digit%10;
                t+=ld;
                digit/=10;
            }
            arr[i] = t;
        }

        int[][] temp = new int[n][3];
        for (int i = 0; i < n; i++) {
            temp[i][0] = arr[i];
            temp[i][1] = nums[i];
            temp[i][2] = i;
        }

        Arrays.sort(temp, (x, y) -> {
            if (x[0] != y[0]) {
                return Integer.compare(x[0], y[0]);
            }
            return Integer.compare(x[1], y[1]);
        });

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || temp[i][2] == i) {
            continue;
            }

            int j = i;
            int cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = temp[j][2];
                cycle++;
            }

            count += cycle - 1;
        }
        return count;
    }
}