package leedcode;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
	
	
	Iterator<Integer> cur;
	int last;
	boolean peek=false;
	boolean has=false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    cur=iterator;
	    
	}

	public Integer peek() {
		if(peek==true)
			return last;
		else{
			peek=true;
			if(cur.hasNext()){
				last=cur.next();
				has=true;
				return last;
			}
			else
				return null;
		}
	}


	@Override
	public Integer next() {
		if(peek){
			peek=false;
			return last;
		}
		else
			return cur.next();
	}

	@Override
	public boolean hasNext() {
		if(peek==true)
			return has;
		else
			return cur.hasNext();
	}
}