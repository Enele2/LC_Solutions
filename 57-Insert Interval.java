class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int index = 0;
        while(index < intervals.length && newInterval[0] > intervals[index][0])
            res.add(intervals[index++]);
        
        int[] newOne = new int[2];
        if (res.isEmpty() || res.get(res.size() - 1)[1] < newInterval[0])
            res.add(newInterval);
        else {
            newOne = res.remove(res.size() - 1);
            newOne[1] = Math.max(newOne[1], newInterval[1]);
            res.add(newOne);
        }
        
        while(index < intervals.length) {
            newOne = intervals[index++];
            int end = newOne[1];
            if(res.get(res.size()-1)[1] < newOne[0]) res.add(newOne);
            else {
                newOne = res.remove(res.size() - 1);
                newOne[1] = Math.max(newOne[1], end);
                res.add(newOne);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}