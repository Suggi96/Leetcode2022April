class MyHashMap {
    boolean[] arrKey;
    int[] arrValue;
    public MyHashMap() {
        arrKey = new boolean[1000001];
        arrValue = new int[1000001];
    }
    
    public void put(int key, int value) {
        arrKey[key] = true;
        arrValue[key] = value;
    } 
    
    public int get(int key) {
        if(arrKey[key]==false)
            return -1;
        return arrValue[key];
    }
    
    public void remove(int key) {
        arrKey[key] = false;
        arrValue[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */