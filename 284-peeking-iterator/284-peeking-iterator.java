// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Integer nextEl = null;
    Iterator<Integer> it = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
        nextEl = it.next(); //built in java next() method
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextEl;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer curVal = nextEl;
        if(it.hasNext()) { //java built in hasNext() method
            this.nextEl = it.next(); //java built in next() method
        }
        else {
            this.nextEl = null;
        }
        return curVal;
	}
	
	@Override
	public boolean hasNext() {
	    return nextEl==null ? false:true;
	}
}