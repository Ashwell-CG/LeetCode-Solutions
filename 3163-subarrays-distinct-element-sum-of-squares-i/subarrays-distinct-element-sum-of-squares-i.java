class Solution {
    public int sumCounts(List<Integer> nums) {
        int ts = 0;
        int N = nums.size();
        for(int i=0;i<N;i++){
            Set<Integer> ds = new HashSet<>();
            for(int j=i;j<N;j++){
                ds.add(nums.get(j));
                int c = ds.size();
                ts += c*c;
            }
        }
        return ts;
    }
}