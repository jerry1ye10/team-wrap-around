import java.util.NoSuchElementException;
import java.util.Iterator;

public class DLLDeque implements Deque {
    DLLNode<String> _head, _tail;
    int _size;
    int _max;

    public DLLDeque() {
       	_size = 0;
       	_max = -1;
    }

    public DLLDeque(int max) {
       	this();
       	_max = max;
    }
	
    public void add(String e) {
	addLast(e);
    }
	
    public void addFirst(String e) {
	if( (_max >= 0) && (_size >= _max) ) {
	    throw new IllegalStateException();
	}
	else if(size() == 0) {
	    DLLNode<String> newNode = new DLLNode<String>(e, null, null);
	    _head = newNode;
	    _tail = newNode;
	}
	else {
	    DLLNode<String> newNode = new DLLNode<String>(e, null, _head);
	    _head.setPrev(newNode);
	    _head = newNode;
	}
	_size++;
    }
	
    public void addLast(String e) {
	if( (_max >= 0) && (_size >= _max) ) {
	    throw new IllegalStateException();
	}
	else if(size() == 0) {
	    DLLNode<String> newNode = new DLLNode<String>(e, null, null);
	    _head = newNode;
	    _tail = newNode;
	}
	else {
	    DLLNode<String> newNode = new DLLNode<String>(e, _tail, null);
	    _tail.setNext(newNode);
	    _tail = newNode;
	}
	_size++;
    }

    public void push(String e) {
	addFirst(e);
    }
	
    public boolean offer(String e) {
	return offerLast(e);
    }
	
    public boolean offerFirst(String e) {
	if( (_max >= 0) && (_size >= _max) ) {
	    return false;
	}
	addFirst(e);
	return true;
    }
	
    public boolean offerLast(String e) {
	if( (_max >= 0) && (_size >= _max) ) {
	    return false;
	}
	addLast(e);
	return true;
    }
	
    public String remove(){
	return removeFirst();
    }
	
    public String removeFirst(){
	String retVal;
	if(size() == 0) { throw new NoSuchElementException();}
	if(size() == 1) {
	    retVal = _head.getValue();
	    _head = null;
	    _tail = null;
	}
	else {
	    retVal = _head.getValue();
	    _head = _head.getNext();
	    _head.setPrev(null);
	}
	_size--;
	return retVal;
    }
    
    public String removeLast(){
	String retVal;
	if(size() == 0) { throw new NoSuchElementException();}
	if(size() == 1) {
	    retVal = _head.getValue();
	    _head = null;
	    _tail = null;
	}
	else {
	    retVal = _tail.getValue();
	    _tail = _tail.getPrev();
	    _tail.setNext(null);
	}
	_size--;
	return retVal;
    }
	
    public String pop() {
	return removeFirst();
    }
	
    public String poll() {
	return pollFirst();
    }
	
    public String pollFirst() {
	if(_size == 0) { return null; }
	return removeFirst();
    }
	
    public String pollLast() {
	if(_size == 0) { return null; }
	return removeLast();
    }
	
    public int size() {
       	return _size;
    }
	
    public String getFirst() {
	if( _size == 0 ) { throw new NoSuchElementException(); }
       	return _head.getValue();
    }

    public String getLast() {
	if( _size == 0 ) { throw new NoSuchElementException(); }
	return _tail.getValue();
    }
	
    public String peek() {
	return peekFirst();
    }
	
    public String peekFirst() {
	if( _size == 0 ) { return null; }
	return getFirst();
    }
	
    public String peekLast() {
	if( _size == 0 ) { return null; }
	return getLast();
    }
	
    public String element() {
	return getFirst();
    }
    
    public String toString() {
	if( _size == 0 ) {return null;}
	String retStr = "";
	DLLNode tmp = _head;
	for(int i = 0; i < _size; i++) {
	    retStr += tmp.getValue() + ", ";
	    tmp = tmp.getNext();
	}
	retStr = retStr.substring(0, retStr.length()-2);
	return retStr;
    }

    /*****************************************************
     * inner class MyIterator
     * Adheres to specifications given by Iterator interface.
     * Uses dummy node to facilitate iterability over LList.
     *****************************************************/
    private class MyIterator implements Iterator<T> 
    {
	private DLLNode<String> _dummy;   // dummy node to tracking pos
	private boolean _okToRemove; // flag indicates next() was called
    
	//constructor 
	public MyIterator(boolean head) 
	{
	    //place dummy node in front of head
	    if(head)
		_dummy = new DLLNode<String>( null, null, _head );
	    else
		_dummy = new DLLNode<String>( null, null, _tail );
	    _okToRemove = false;
	}

	//-----------------------------------------------------------
	//--------------v  Iterator interface methods  v-------------
	//return true if iteration has more elements.
	public boolean hasNext() 
	{
	    return _dummy.getNext() != null;
	}


	//return next element in this iteration
	public T next() 
	{
	    _dummy = _dummy.getNext();
	    if ( _dummy == null )
		throw new NoSuchElementException();
	    _okToRemove = true;
	    return _dummy.getCargo();
	}


	//return last element returned by this iterator (from last next() call)
	//postcondition: maintains invariant that _dummy always points to a node
	//               (...so that hasNext() will not crash)
	public void remove() 
	{
	    if ( ! _okToRemove )
		throw new IllegalStateException("must call next() beforehand");
	    _okToRemove = false;

	    //If removing only remaining node...
	    //maintain invariant that _dummy always points to a node
	    //   (...so that hasNext() will not crash)
	    if ( _head == _tail ) {
		_head = _tail = null;
	    }
	    //if removing first node...
	    else if ( _head == _dummy ) {
		_head = _head.getNext();
		_head.setPrev( null ); //just to save mem
	    }
	    //if removing last node...
	    else if ( _tail == _dummy ) {
		_tail = _tail.getPrev();
		_tail.setNext( null );
	    }
	    //if removing an interior node...
	    else {
		_dummy.getNext().setPrev( _dummy.getPrev() );
		_dummy.getPrev().setNext( _dummy.getNext() );
		//Q: How could the line below cause trouble?
		//_dummy = _dummy.getPrev();
	    }

	    _size--; //decrement size attribute of outer class LList      
	}//end remove()
	//--------------^  Iterator interface methods  ^-------------
	//-----------------------------------------------------------
    }//*************** end inner class MyIterator *************** private class DLLIterator implements Iterator<String>

    public static void main( String[] args ) {
	DLLDeque test = new DLLDeque();
	System.out.println(test); //null
	test.addFirst("foo");
	System.out.println(test); //foo
	test.addFirst("bar");
	System.out.println(test); //bar, foo
	test.addLast("baf");
	System.out.println(test); //bar, foo, bad
	System.out.println(test.size()); //3 
	System.out.println(test.getFirst()); //bar
	System.out.println(test.getLast()); //baf
	test.removeFirst();
	System.out.println(test); //foo, baf
	test.removeLast();
	System.out.println(test); //foo
    }
}
