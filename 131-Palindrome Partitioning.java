class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<>();
        dfs(0, res, cur, s);
        return res;
    }
    
    public void dfs(int start, List<List<String>> res, List<String> cur, String s) {
        if(start >= s.length()) res.add(new ArrayList<String>(cur));
        
        for(int end = start; end < s.length(); end++) {
            if (isPal(s, start, end)) {
                cur.add(s.substring(start, end + 1));
                dfs(end + 1, res, cur, s);
                cur.remove(cur.size() - 1);
            }
        }
        
    }
    
    public boolean isPal(String s, int l, int h) {
        while (l < h) {
            if (s.charAt(l++) != s.charAt(h--)) return false;
        }
        return true;
    }
    
}