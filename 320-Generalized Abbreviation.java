class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        char[] array = word.toCharArray();
        helper(res, s, array, 0, 0);
        return res;
    }
    
    public void helper(List<String> res, StringBuilder s, char[] array, int level, int k) {
        int len = s.length();
        if (level == array.length) {
            if (k != 0) s.append(k);
            res.add(s.toString());
        } else {
            //abbreviated  
            helper(res, s, array, level + 1, k + 1);
        
            //char is kept
            if (k != 0) s.append(k);
            s.append(array[level]);
            helper(res, s, array, level + 1, 0);
        }
        s.setLength(len);
    }
}