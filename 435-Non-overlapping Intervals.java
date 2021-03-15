class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < intervals.length; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                //Non-overlapping
                if (intervals[i][0] >= intervals[j][1]) {
                    max = Math.max(dp[j], max);
                    break;
                }
            }
            dp[i] = Math.max(max+1, dp[i-1]);
            res = Math.max(res, dp[i]);
        }
        return intervals.length - res;
    }
}