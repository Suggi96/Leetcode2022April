/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    int step = -1;
    List<NestedInteger> li = new ArrayList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        helper(nestedList);
    }
    
    private void helper(List<NestedInteger> nestedList){
        int size = nestedList.size();
        for(int i=0; i < size; i++){
            if(nestedList.get(i).isInteger()){
                li.add(nestedList.get(i));
            }else{
                helper(nestedList.get(i).getList());
            }
        }
        return;
    }
    
    @Override
    public Integer next() {
        step++;
        if(step < li.size())
            return li.get(step).getInteger();
        return null;
    }

    @Override
    public boolean hasNext() {
        if(step+1 < li.size())
            return true;
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */