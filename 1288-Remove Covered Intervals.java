class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
		//need to define new comparator
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override 
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        int count = 0;
        int end = 0;
        int prev_end = 0;
        for(int[] interval : intervals) {
            end = interval[1];
            if(prev_end < end) {
                count++;
                prev_end = end;
            }
        }
        return count;
    }
}