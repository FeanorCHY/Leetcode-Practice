import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    int next=0;;
    Iterator<Integer> iterator;
    boolean has;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator=iterator;
	    has=iterator.hasNext();
	    if(has)
	        next=iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int tem=next;
	    has=iterator.hasNext();
	    if(has)
	        next=iterator.next();
	    return tem;
	}

	@Override
	public boolean hasNext() {
	    return has;
	}

}
