class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a,b) -> Integer.compare(a[0], b[0]));
        //index of cur
        int s1 = 0;
        int s2 = 0;
        List<Integer> res = new ArrayList<>();
        if(slots1.length == 0 || slots2.length == 0) return res;
        while (s1<slots1.length && s2<slots2.length) {
            int interLeft = Math.max(slots1[s1][0], slots2[s2][0]);
            int interRight = Math.min(slots1[s1][1], slots2[s2][1]);
            if (interRight - interLeft >= duration) {
                res.add(interLeft);
                res.add(interLeft+duration);
                return res;
            }
            if(slots1[s1][1] < slots2[s2][1]){
                s1++;
            } else {
                s2++;
            }
        }
        return res;
    } 
}