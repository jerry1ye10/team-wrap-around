# team-wrap-around  
## The Game Plan -- to-do List 
0. Preliminary action items(things to do before we get into implementing any actual methods): 
  * Decide on a specific object to use(before implementing generic typing at the end): We have decided on Strings! 
  * Decide between choosing a (doubly-linked) node-based, array-based, or ArrayList-based architecture to implement a deque: we have decided on using a doubly-linked node-based structure. 
  * Create a deque class with (nearly) empty implementations of the interface for deque to check if class will compile
1. Implement the following core methods:  
  * addFirst(Object)  
  * addLast(Object)
  * removeFirst()
  * removeLast()
  * size()
  * getFirst()  
  * getLast()
2. Implement wrappers for other methods by using core functionality:  
  * add(Object)
  * remove()
  * peek()
  * peekFirst() 
  * peekLast()
  * element()
  * offer(Object)
  * offerFirst(Object)
  * offerLast(Object)
  * poll()
  * pollFirst() 
  * pollLast()
  * pop()
  * push(Object) 
3. Implement extra functionality Methods:
  * contains(Object)
  * descendingIterator()
  * iterator()
  * remove(Object)
  * removeFirstOccurence(Object)
  * removeLastOccurence(Object)
4. Implement extra functionality: 
  * Generic Typing
  * Exception Handlding
## Summary of Development Plan
Our development plan is broken down into 5 phases -- the steps shown above. Before any of our actual code is written, we decided that it's very important to have a plan of the structure of our deque and a general idea of how each of our methods were implemented. We all agreed that a doubly linked node would be the best way to implement the deque class. After deciding on this, the next general step should be to familiarize ourselves with every method that the Java api expects us to implement. After doing this, we will create an interface that our deque should implement. After writing this interface we will begin developing our deque without generic typing, using Strings. We will start by implementing the core functionality that is essential to the functioning of the deque as a data strucutre. Afterwards, we will use these core methods and wrap other methods around them. We will then implement the extra functionality methods onto the deque, continuing with a deque of Strings. Lastly, we will implement other extra functionality to polish up our deque class and data structure. 
