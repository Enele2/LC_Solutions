class Solution {
    //Solution1: dfs bruteforce
    /*
    public int splitArray(int[] nums, int m) {
        int[] res = new int[]{Integer.MAX_VALUE};
        dfs(nums, m, 0, 0, 0, 0, res);
        return res[0];
    }
    
    public void dfs(int[]nums, int m, int i, int cutcnt, int curSum, int curMax, int[] res) {
        if (i == nums.length && cutcnt == m) {
            res[0] = Math.min(res[0], curMax);
            return;
        }
        if (i == nums.length) {
            return;
        }
        //!!!当i=0刚开始时避免这支
        if (i > 0) {
            dfs(nums, m, i+1, cutcnt, nums[i]+curSum, Math.max(curMax, nums[i]+curSum), res);
        }
            
        if(cutcnt < m) {
            dfs(nums, m, i+1, cutcnt+1, nums[i], Math.max(curMax, nums[i]), res);
        }
    }
    */
    
    //Solution2: DP
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        int[] sub = new int[n+1];
        
        for(int i = 0; i<=n; i++) {
            for (int j =0; j<= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i+1] = sub[i] + nums[i];
        }
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }
}