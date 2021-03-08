//chronological ordering
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] startIntervals = new int[intervals.length];
        int[] endIntervals = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            startIntervals[i] = intervals[i][0];
            endIntervals[i] = intervals[i][1];
        }
        Arrays.sort(startIntervals);
        Arrays.sort(endIntervals);
        int start = 0;
        int end = 0;
        int rooms = 0;
        while(start < intervals.length) {
            if(startIntervals[start] >= endIntervals[end]) {
                rooms--;
                end++;
            }
            rooms++;
            start++;
        }
        return rooms;
    }
}