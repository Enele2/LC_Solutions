class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(i < firstList.length && j < secondList.length) {
            //l - the start of the intersection
            //h - the end of the intersection
            int l = Math.max(firstList[i][0], secondList[j][0]);
            int h = Math.min(firstList[i][1], secondList[j][1]);
            
            if (l <= h) res.add(new int[]{l, h});
            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}