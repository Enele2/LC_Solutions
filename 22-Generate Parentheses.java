class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        helper(res, s, 0, 0, n);
        return res;
    }

    public void helper(List<String> res, StringBuilder s, int l, int r, int n) {
        if (l == n && r == n) {
            res.add(s.toString());
        }
        if (l < n) {
            s.append('(');
            helper(res, s, l+1, r, n);
            s.deleteCharAt(s.length() - 1);
        }
        if (r < l) {
            s.append(')');
            helper(res, s, l, r+1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}