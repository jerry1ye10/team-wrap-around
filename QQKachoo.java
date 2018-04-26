import java.util.NoSuchElementException;	
import java.util.Iterator;
import java.util.Collection;
import java.util.Deque;
import java.util.Arrays;
	
	
/*******************************************
 * public class QQKachoo
 * Adheres to java's Deque interface
 * Formally adhered to personal MyDeque Standard
 * Is a Queue that can be accessed from both ends
 * Due to specifications can also serve as a Stack,
 * regular Queue, Collection, and Iterable.
 * Differs from a List in that elements cannot be
 * accessed by index.
 *******************************************/
public class QQKachoo<E> implements Deque<E> {	
    DLLNode<E> _head, _tail; //head and tail pointers	
    int _size; //size of Deque	
    int _max; //largest size possible of deque, -1 if infinite	

    /***********************
     *     CONSTRUCTORS    *
     ***********************
     *------V-Start-V------*/
    
    //init vars	
    public QQKachoo() {	
	_size = 0;	
	_max = -1; //infinite max size	
    }	
	
    //init vars and max (user pref)	
    public QQKachoo(int max) {	
	this();	
	_max = max;	
    }	

    /*------^-END-^------*/

    /**********************
     *  ADDITION METHODS  *
     **********************
     *------V-Start-V-----*/
    
    //Identical to add last except for boolean return val	
    public boolean add(E e) {	
	addLast(e);	
	return true;	
    }	
		
    //Adds an element to the front of the deque, throws exception if over the limit (Assuming there is one)	
    public void addFirst(E e) {	
	if( (_max >= 0) && (_size >= _max) ) { //If over limit specified by max
	    throw new IllegalStateException("Max size reached");	
	}	
	else if(size() == 0) { //special case for first element in deque	
	    DLLNode<E> newNode = new DLLNode<E>(e, null, null);	
	    _head = newNode;   
	    _tail = newNode;	
	}	
	else {	
	    DLLNode<E> newNode = new DLLNode<E>(e, null, _head);	
	    _head.setPrev(newNode);	
	    _head = newNode;	
	}	
	_size++;	
    }	
		
    //Same as add first but adds to the end	
    public void addLast(E e) {	
	if( (_max >= 0) && (_size >= _max) ) {	//If over limit specified by max
	    throw new IllegalStateException("Max size reached");	
	}	
	else if(size() == 0) {	//special case for first element in deque
	    DLLNode<E> newNode = new DLLNode<E>(e, null, null);	
	    _head = newNode;	
	    _tail = newNode;	
	}	
	else {	
	    DLLNode<E> newNode = new DLLNode<E>(e, _tail, null);	
	    _tail.setNext(newNode);	
	    _tail = newNode;	
	}	
	_size++;	
    }	
    	
    //Identical to addFirst	
    public void push(E e) {	
	addFirst(e);	
    }	
    	
    //Identical to offerLast	
    public boolean offer(E e) {	
	return offerLast(e);	
    }	
		
    //returns false if over limit, otherwise identical to addFirst	
    //This should be used if a capped deque is init'd	
    public boolean offerFirst(E e) {	
	if( (_max >= 0) && (_size >= _max) ) {	
	    return false;	
	}	
	addFirst(e);	
	return true;	
    }	
		
    //Same as offer first but adds to end	
    public boolean offerLast(E e) {	
	if( (_max >= 0) && (_size >= _max) ) {	
	    return false;	
	}	
	addLast(e);	
	return true;	
    }

    //Add all items in collection 
    public boolean addAll(Collection<? extends E> c) {
	if( (_max >= 0) && (size() + c.size() >= _max) ) {//If over limit specified by max
	    throw new IllegalStateException("Max size reached");	
	}
	boolean ret = false;
	for( E cEl : c ) {
	    this.add(cEl); 
	    ret = true;
	}
	return ret;
    }

    /*------^-END-^------*/

    /**********************
     *  REMOVAL METHODS   *
     **********************
     *------V-Start-V-----*/

    
    //Remove all items in list
    public void clear() {
	_head = null;
	_tail = null;
	_size = 0;
    }
    
    //Identical to removeFirst	
    public E remove(){	
	return removeFirst();	
    }	
    	
    //Removes head of deque, throws no such element if the size is 0	
    public E removeFirst(){	
	E retVal;	
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
    	
    //Removes tail of deque throws no such element if the size is 0	
    public E removeLast(){	
	E retVal;	
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
	
    //Same as remove first occurence	
    public boolean remove(Object o) {	
	return removeFirstOccurrence(o);	
    }	
    	
    //Removes first occurrence of Object o in the deque, returns true if there is something to remove, otherwise false	
    public boolean removeFirstOccurrence(Object o) {	
	Iterator<E> iter = iterator();	
	while(iter.hasNext()) {	
	    E e = iter.next();	
	    if(e.equals(o)) {	
		iter.remove();
		_size--;
		return true;	
	    }	
	}	
	return false;	
    }	
	
    //Same as removeFirstOccurrence, but traverses through backwards	
    public boolean removeLastOccurrence(Object o) {	
	Iterator<E> iter = descendingIterator();	
	while(iter.hasNext()) {	
	    E e = iter.next();	
	    if(e.equals(o)) {	
		iter.remove();
		_size--;
		return true;	
	    }	
	}	
	return false;	
    }	
    	
    //Identical to removeFirst	
    public E pop() {	
	return removeFirst();	
    }	
		
    //Identical to pollFirst	
    public E poll() {	
	return pollFirst();	
    }	
		
    //Same as removeFirst, but returns null instead if deque is empty	
    public E pollFirst() {	
	if(_size == 0) { return null; }	
	return removeFirst();	
    }	
    	
    //Same as removeLast, but returns null instead if deque is empty	
    public E pollLast() {	
	if(_size == 0) { return null; }	
	return removeLast();	
    }	

    //keeps all items in the intersection of Collection c and QQKachoo, removes everything else.  Returns true if changes are made
    public boolean retainAll(Collection<?> c) {
	boolean ret = false;
	Iterator<E> iter = this.iterator(); //iterator so we can remove as we go
 	while(iter.hasNext()) { 
	    E e = iter.next();
	    if(!c.contains(e)) { //If the current item isn't in both
		iter.remove();
		ret = true;
		_size--;
	    }
	}
	return ret;
    }

    //Removes items in the intersection of Collection c and QQKachoo, returns true if changes were made
    public boolean removeAll(Collection<?> c) {
	boolean ret = false;
	Iterator<E> iter = this.iterator(); //iterator so we can remove as we go
 	while(iter.hasNext()) { 
	    E e = iter.next();
	    if(c.contains(e)) { //If the current item is in both
		iter.remove();
		ret = true;
		_size--;
	    }
	}
	return ret;
    }

    
    /*------^-END-^------*/

    /**********************
     *   STATE METHODS    *
     **********************
     *------V-Start-V-----*/

    
    //return size of the deque	
    public int size() {	
	return _size;	
    }	

    //return if the list isEmpty
    public boolean isEmpty() {
	return _size == 0;
    }

    	
    //return true if Object o is in the the deque	
    public boolean contains(Object o) {	
	Iterator<E> i = this.iterator();	
	while (i.hasNext()) {	
	    E e = i.next();	
	    if( e.equals(o) ) {	
		return true;	
	    }	
	}	
	return false;	
    }

    //return true if all the elements in collection c are contained within QQKachoo
    public boolean containsAll(Collection<?> c) {
	for(Object cEl : c) {
	    if(!contains(c))
		return false;
	}
	return true;
    }
    
    /*------^-END-^------*/

    /**********************
     *      ACCESSORS     *
     **********************
     *------V-Start-V-----*/

    
    //return front of deque, if the deque is empty return null	
    public E getFirst() {	
	if( _size == 0 ) { throw new NoSuchElementException(); }	
	return _head.getValue();	
    }	
	
    //return last of deque, if the deque is empty return null	
    public E getLast() {	
	if( _size == 0 ) { throw new NoSuchElementException(); }	
	return _tail.getValue();	
    }	
    	
    //Same is peekFirst peek	
    public E peek() {	
	return peekFirst();	
    }	
    	
    //Same as getFirst except it returns null with an empty deque	
    public E peekFirst() {	
	if( _size == 0 ) { return null; }	
	return getFirst();	
    }	
		
    //Same as getLast except it returns null with an empty deque	
    public E peekLast() {	
	if( _size == 0 ) { return null; }	
	return getLast();	
    }	
		
    //Identical to getFirst	
    public E element() {	
	return getFirst();	
    }	

    /*------^-END-^------*/

    /**********************
     *  ITERATOR METHODS  *
     **********************
     *------V-Start-V-----*/

    
    //Return an iterator that iterates forward thru the deque	
    public Iterator<E> iterator() {	
	return new QQKachooIterator(true); //return iterator starting at head	
    }	
	
    //Return an iterator that iterates backwards thru the deque	
    public Iterator<E> descendingIterator() {	
	return new QQKachooIterator(false); //return iterator starting at tail
    }	

    /*------^-END-^------*/

    /**********************
     * CONVERSION METHODS *
     **********************
     *------V-Start-V-----*/

    //simple toString to display Deque in a clear format for testing
    public String toString() {	
	if( _size == 0 ) {return null;}	
	String retStr = "HEAD>";	
	DLLNode tmp = _head;	
	for(int i = 0; i < _size; i++) {	
	    retStr += tmp.getValue() + "<->";	
	    tmp = tmp.getNext();	
	}	
	retStr = retStr.substring(0, retStr.length()-3);	
	return retStr + "<-TAIL";	
    }	

    
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if( a.length < size() ) {
	    a = Arrays.copyOf(a, size()); //set a to an expanded copy of itself, making a new list of type T
	                                  //would cause a class cast error
	}
	int cnt = 0;
	for( E e : this ) {
	    a[cnt] = (T) e; //copy deque elements into a (causes unchecked warning)
	    cnt++;
	}
	for(int i = cnt; i < a.length; i++) {
	    a[cnt] = null; //fill up remaining list with null as recommended by docs
	}
	return a; //return modified a
    }
    
    public Object[] toArray() {
	Object[] ret = new Object[size()]; //
	int cnt = 0;
	for( Object o : this ) {
	    ret[cnt] = o; //copy objects in this Deque to the new Array
	    cnt++;
	}
	return ret;
    }

    /*------^-END-^------*/

    
    /*****************************************************	
     * LIBRARY IMPLEMENTATION ALL CREDIT TO TOPHER BROWN-MYKOLYK	
     * inner class MyIterator	
     * Adheres to specifications given by Iterator interface.	
     * Uses dummy node to facilitate iterability over QQKachoo.	
     *****************************************************/	
    private class QQKachooIterator implements Iterator<E> 	
    {	
	private DLLNode<E> _dummy;   // dummy node to tracking pos	
	private boolean _okToRemove; // flag indicates next() was called	
	private boolean head; //Whether the iterator starts from the head or the tail	
		
	//constructor 	
	public QQKachooIterator(boolean head) 	
	{	
	    this.head = head;	
	    //place dummy node in front of head	
	    if(head)	
		_dummy = new DLLNode<E>( null, null , _head);	
	    else	
		_dummy = new DLLNode<E>( null, _tail, null );	
	    _okToRemove = false;	
	}	
	
	//-----------------------------------------------------------	
	//--------------v  Iterator interface methods  v-------------	
	//return true if iteration has more elements.	
	public boolean hasNext() 	
	{	
	    if(head)	
		return _dummy.getNext() != null;	
	    else	
		return _dummy.getPrev() != null;	
	}	
	
	
	//return next element in this iteration	
	public E next() 	
	{	
	    if(head)	
		_dummy = _dummy.getNext();	
	    else	
		_dummy = _dummy.getPrev();	
	    if ( _dummy == null )	
		throw new NoSuchElementException();	
	    _okToRemove = true;	
	    return _dummy.getValue();	
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
	    }	
	
	    _size--; //decrement size attribute of outer class LList      	
	}//end remove()	
    }//End class QQKachooIterator

    
    public static void main( String[] args ) {	
	QQKachoo<String> test = new QQKachoo<>();	
	test.addFirst("foo");
	test.addFirst("bar");
	test.addFirst("baf");
	System.out.println(test.size());
	String[] arr = test.toArray(new String[0]);
	for(int i = 0; i < arr.length; i++) {
	    System.out.println(arr[i]);
	}

	test.clear();
	
	//Adding test	
	System.out.println(test); //null	
	test.addFirst("foo");	
	System.out.println(test); //foo	
	test.addFirst("bar");	
	System.out.println(test); //bar, foo	
	test.addLast("baf");	
	System.out.println(test); //bar, foo, baf	
		
	//Iterator testing	
	Iterator<String> iter = test.iterator();	
	System.out.println(iter.next()); //bar	
	System.out.println(iter.next()); //foo	
	//iter.remove();	
	//System.out.println(test);	
	System.out.println(iter.next()); //baf	
	
	//Descending iterator testing	
	iter = test.descendingIterator();	
	System.out.println(iter.next()); //baf	
	System.out.println(iter.next()); //foo	
	//iter.remove();	
	//System.out.println(test);	
	System.out.println(iter.next()); //bar	
	
	//Contains test	
	System.out.println(test.contains("baf"));//true	
	System.out.println(test.contains("baaar"));//false	
	
	//Remove test	
	System.out.println(test.remove("baf"));//true	
	System.out.println(test.remove("baaar"));//false	
	System.out.println(test);	
	test.addLast("baf");	
	System.out.println(test);	
		
	//Size test	
	System.out.println(test.size()); //3 	
	
	//Accessor test 	
	System.out.println(test.getFirst()); //bar	
	System.out.println(test.getLast()); //baf	
	
	//Remove	
	test.removeFirst();	
	System.out.println(test); //foo, baf	
	test.removeLast();	
	System.out.println(test); //foo	
    }//End main()
}//End class
