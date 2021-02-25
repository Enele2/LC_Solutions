class WordDictionary {
    //dict is divided by the length of words into Sets
    Map<Integer, Set<String>> dict;
    /** Initialize your data structure here. */
    public WordDictionary() {
        dict = new HashMap<>();
    }
    
    public void addWord(String word) {
        int m = word.length();
        if(!dict.containsKey(m)) {
            dict.put(m, new HashSet<>());
        }
        dict.get(m).add(word);
    }
    
    public boolean search(String word) {
        int m = word.length();
        if(dict.containsKey(m)) {
            for(String w : dict.get(m)){
                int i = 0;
                while((i < m) && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')){
                    i++;
                }
                if (i == m) return true;
            }
        }
        return false;
    }
}