public interface Deque<E> {
	
	/****************************
	*     CORE FUNCTIONALITY    *
	*****************************/
	
	public void addFirst(E e);
	
	public void addLast(E e);
	
	public E removeFirst();
	
	public E removeLast();
	
	public int size();
	
	public E getFirst();
	
	public E getLast();
	
	/****************************
	*         WRAPPERS          *
	*****************************/
	
	public void add(E e);
	
	public E remove();
	
	public E peek();
	
	public E peekFirst();
	
	public E peekLast();
	
	public E element();
	
	public boolean offer(E e);
	
	public boolean offerFirst(E e);
	
	public boolean offerLast(E e);
	
	public E poll();
	
	public E pollFirst();
	
	public E pollList();
	
	public E pop();
	
	public void push(E e);
	
	/****************************
	*    EXTRA FUNCTIONALITY    *
	*****************************/
	
	public boolean contains(Object o);
	
	public Iterator<E> iterator();
	
	public Iterator<E> descendingIterator();
	
	public boolean remove(Object o);
	
	public boolean removeFirstOccurence(Object o);
	
	public boolean removeLastOccurence(Object o);
} //end interface