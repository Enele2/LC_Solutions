class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {        
        //use sliding win
        if (grumpy == null || grumpy.length == 0) {
            return 0;
        }
        int sat = 0;
        if (grumpy.length <= X) {
            for(int c : customers) {
                sat += c;
            }
            return sat;
        }
        int sat0 = 0;
        for(int i = 0; i < grumpy.length; i++) {
            if(grumpy[i] == 0) 
                sat0+=customers[i];
        }
        for(int i = 0; i < X; i++){
            if(grumpy[i] == 1) 
                sat+=customers[i];
        }
        int max = sat + sat0;
        sat = max;
        for(int j=X; j<grumpy.length; j++) {
            if(grumpy[j] == 1)
                sat+=customers[j];
            if(grumpy[j-X] == 1)
                sat-=customers[j-X];
            max = Math.max(max, sat);
        }
        return max;
    }
}