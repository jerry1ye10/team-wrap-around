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