import java.util.Iterator;

public interface Deque {
	
	
	/****************************
	*     CORE FUNCTIONALITY    *
	*****************************/

	//Inserts element passed at the front of the list
	public void addFirst(String e);
	
	//Inserts element passed at the end of the list
	public void addLast(String e);
	
	//Removes the first element in the list and returns it
	public String removeFirst();
	
	//Removes the last element in the list returns it 
	public String removeLast();
		
	//Returns the size of the list
	public int size();
	
	//Returns the first element without removing it
	public String getFirst();
	
	//Returns the last element without removing it
	public String getLast();
	
	/****************************
	*         WRAPPERS          *
	*****************************/
	
	//Add element to the queue represented by this deque
	public void add(String e);
	
	//Remove and return element from the queue represented by this deque
	public String remove();
	
	//Returns the first element but does not remove it, returns null if it's empty
	public String peek();
	
	//Returns the first element but does not remove it, returns null if it's empty
	public String peekFirst();
	
	//Returns the last element but does not remove it, returns null if it's empty
	public String peekLast();
	
	//Returns the first item in the queue represented by this deque without removing it
	public String element();
	
	//Inserts element into queue represented by deque if permitted by size. return true
	//on success and false if there's no space.
	public boolean offer(String e);
	
	//Inserts element at front of dequeue if permitted by size. return true on success
	//and false if there's no space
	public boolean offerFirst(String e);
	
	//Inserts element at end of dequeue if permitted by size. return true on success
	//and false if there's no space
	public boolean offerLast(String e);
	
	//Returns and removes first item in queue represented by this deque, and null if the
	//deque is empty
	public String poll();
	
	//Returns and removes first item in this deque, and null if the
	//deque is empty
	public String pollFirst();
	
	//Returns and removes first item in this deque, and null if the
	//deque is empty
	public String pollList();
	
	//Removes and returns an item from the stack represented by this deque
	public String pop();
	
	//Adds an item onto the stack represented by this deque
	public void push(String e);

	/****************************
	*    EXTRA FUNCTIONALITY    *
	*****************************/
	/* WORK BAR
	//Returns true if the object is in the list
	public boolean contains(String o);
	
	//Return an iterator of the elements in this deque
	public Iterator<String> iterator();
	
	//Return an iterator of the elements in reverse order in this deque
	public Iterator<String> descendingIterator();
	
	//Remove the first occurence of Object o in string. Return whether there was an element
	//that matched the query
	public boolean remove(String o);
	
	//Remove the first occurence of Object o in string. Return whether there was an element
	//that matched the query
	public boolean removeFirstOccurence(String o);
	
	//Remove the last occurince of Object o in string. Return whether there was an element
	//that matched the query
	public boolean removeLastOccurence(String o);
	WORK BAR*/
} //end interface
