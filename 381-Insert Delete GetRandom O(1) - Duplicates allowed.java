class RandomizedCollection {
    List<Integer> array;
    Map<Integer, Set<Integer>> map;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        array = new ArrayList<>();
        map = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) map.put(val, new HashSet<Integer>());
        map.get(val).add(array.size());
        array.add(val);
        return map.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0) return false;
        int removeIdx = map.get(val).iterator().next();
        map.get(val).remove(removeIdx);
        int last = array.get(array.size() - 1);
        array.set(removeIdx, last);
        map.get(last).add(removeIdx);
        map.get(last).remove(array.size() - 1);
        
        array.remove(array.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return array.get(rand.nextInt(array.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */