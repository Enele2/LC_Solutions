class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return helper(nums1, nums2) + helper(nums2, nums1);
    }
    public int helper(int[] nums1, int[] nums2) {
        int res = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put((long)nums1[i]*nums1[i], map.getOrDefault((long)nums1[i]*nums1[i], 0)+1);
        }
        for(int j = 0; j < nums2.length; j++) {
            for(int k = j+1; k < nums2.length; k++) {
                //cause TLE
                //if ((long)Math.pow(nums1[i],2) == (long)nums2[j]*nums2[k]) res++;
                if(map.get((long)nums2[j]*nums2[k]) != null) 
                    res+=map.get((long)nums2[j]*nums2[k]);
            }
        }
        return res;
    }
}