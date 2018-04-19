public class DLLDeque implements Deque {
	DLLNode<String> _head, _tail;
	int _size;
	int _max;

    public void addFirst(String e){
	if(size() == 0) {
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


    public void addLast(String e){
	if(size() == 0) {
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

    public String removeFirst(){
	String retVal;
	if(size() == 0) { return null;}
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
	if(size() == 0) { return null;}
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
	
    public DLLDeque() {
       	_size = 0;
       	_max = -1;
    }

    public DLLDeque(int max) {
       	this();
       	_max = max;
    }
	
    public int size() {
       	return _size;
    }
	
    public String getFirst() {
       	return _head.getValue();
    }

    public String getLast() {
	return _tail.getValue();
    }
}
