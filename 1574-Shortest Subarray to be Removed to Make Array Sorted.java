class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        //1 2 3 10  7  7  8  9
        //1 2 3 10 10 10 10 10
        //    l=2     
        //7 7 7  7  7  7  8  9  
        //            h=5   
        //dp不可，本质为two pointers
        int low=0;
        int high=arr.length-1;
        
        while(low<arr.length-1 && arr[low]<=arr[low+1]){
            low+=1;
        }
        if(low==arr.length-1){
            return 0;
        }
        
        
        while(low<=high && arr[high]>=arr[high-1]){
            high-=1;
        }
        if(high==0){
            return arr.length-1;
        }
        
        int result=Math.min(high, arr.length-low-1);
        
        int i=0;
        int j=high;
        
        while(i<=low &&  j<arr.length){
            if(arr[j]>=arr[i]){
                result=Math.min(j-i-1, result);
                i+=1;
            }else {
                j+=1;
            }
        }
        return result;
    }
}