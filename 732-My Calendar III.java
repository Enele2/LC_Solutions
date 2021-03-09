/*  Map
  /      \
HashMap  SortedMap
	|		| 
  无序	TreeMap(Key必须实现comparable)，内部按此排序
*/
class MyCalendarThree {
    TreeMap<Integer, Integer> map;
    
    public MyCalendarThree() {
        map = new TreeMap();    
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int active = 0; 
        int ans = 0;
        for(int i : map.values()){
            active += i;
            if (active > ans) ans = active;
        }
        return ans;
    }
}