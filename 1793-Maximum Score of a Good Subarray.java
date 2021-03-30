class Solution {
    public int maximumScore(int[] nums, int k) {
        //use two pointers
        //both start from index k

        int ans = nums[k];
        int i = k-1;
        int j = k+1;
        int min = ans;
        int min1 = ans;
        int min2 = ans;

        
        while(i >= 0 || j< nums.length) {
            //v1, v2 need to reset each loop
            int v1 = 0;
            int v2 = 0;
            if (i >= 0) {
                min1 = Math.min(nums[i], min);
                v1 = min1*(j-i);
            }
            if (j < nums.length) {
                min2 = Math.min(nums[j], min);
                v2 = min2*(j-i);
            }
            if (v1 > v2) {
                --i;
                ans = Math.max(ans, v1);
                min = Math.min(min1, min);
            } else {
                ++j;
                ans = Math.max(ans, v2);
                min = Math.min(min2, min);
            }
        }
        return ans;
 
    }
}