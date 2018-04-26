import java.util.Iterator;
import java.util.Collection;

//Conforms to the standard library documentation, minus the sub interfaces
public interface MyDeque<E> {
	
	
    /****************************
     *     CORE FUNCTIONALITY    *
     *****************************/

    //Inserts element passed at the front of the list
    public void addFirst(E e);
	
    //Inserts element passed at the end of the list
    public void addLast(E e);
	
    //Removes the first element in the list and returns it
    public E removeFirst();
	
    //Removes the last element in the list returns it 
    public E removeLast();
		
    //Returns the size of the list
    public int size();
	
    //Returns the first element without removing it
    public E getFirst();
	
    //Returns the last element without removing it
    public E getLast();
	
    /****************************
     *         WRAPPERS          *
     *****************************/
	
    //Add element to the queue represented by this deque
    public boolean add(E e);
	
    //Remove and return element from the queue represented by this deque
    public E remove();
	
    //Returns the first element but does not remove it, returns null if it's empty
    public E peek();
	
    //Returns the first element but does not remove it, returns null if it's empty
    public E peekFirst();
	
    //Returns the last element but does not remove it, returns null if it's empty
    public E peekLast();
	
    //Returns the first item in the queue represented by this deque without removing it
    public E element();
	
    //Inserts element into queue represented by deque if permitted by size. return true
    //on success and false if there's no space.
    public boolean offer(E e);
	
    //Inserts element at front of dequeue if permitted by size. return true on success
    //and false if there's no space
    public boolean offerFirst(E e);
	
    //Inserts element at end of dequeue if permitted by size. return true on success
    //and false if there's no space
    public boolean offerLast(E e);
	
    //Returns and removes first item in queue represented by this deque, and null if the
    //deque is empty
    public E poll();
	
    //Returns and removes first item in this deque, and null if the
    //deque is empty
    public E pollFirst();
	
    //Returns and removes first item in this deque, and null if the
    //deque is empty
    public E pollLast();
	
    //Removes and returns an item from the stack represented by this deque
    public E pop();
	
    //Adds an item onto the stack represented by this deque
    public void push(E e);

    //Return whether the Deque is empty
    public boolean isEmpty();
    
    /****************************
     *    EXTRA FUNCTIONALITY    *
     *****************************/
	
    //Returns true if the object is in the list
    public boolean contains(Object o);

    public boolean containsAll(Collection<?> c);
    
    //Return an iterator of the elements in this deque
    public Iterator<E> iterator();
  
    //Return an iterator of the elements in reverse order in this deque
    public Iterator<E> descendingIterator();
	
    //Remove the first occurence of Object o in string. Return whether there was an element
    //that matched the query
    public boolean remove(Object o);
	
    //Remove the first occurence of Object o in string. Return whether there was an element
    //that matched the query
    public boolean removeFirstOccurrence(Object o);
	
    //Remove the last occurince of Object o in string. Return whether there was an element
    //that matched the query
    public boolean removeLastOccurrence(Object o);

    //Adds all items in collection c to Deque, throw exception if max size reached
    public boolean addAll(Collection<? extends E> c);

    //Remove all items in list
    public void clear();

    //Remove items that are not in both the Deque and collection c
    public boolean retainAll(Collection<?> c);

    //Remove items that are in both the Deque and collection c
    public boolean removeAll(Collection<?> c);

    //Return T[] a with elements from Deque in it. If a is to small make a larger copy of it
    public <T> T[] toArray(T[] a);

    //Return the elements in Deque in an array of Objects
    public Object[] toArray();
    
} //end interface
