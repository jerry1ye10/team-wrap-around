# team-wrap-around  
## The Game Plan -- to-do List 
0. Preliminary action items(things to do before we get into implementing any actual methods): Completed
  * Decide on a specific object to use(before implementing generic typing at the end): We have decided on Strings! 
  * Decide between choosing a (doubly-linked) node-based, array-based, or ArrayList-based architecture to implement a deque: we have decided on using a doubly-linked node-based structure. 
  * Create a deque class with (nearly) empty implementations of the interface for deque to check if class will compile
1. Implement the following core methods:Completed
  * addFirst(Object)  
  * addLast(Object)
  * removeFirst()
  * removeLast()
  * size()
  * getFirst()  
  * getLast()
2. Implement wrappers for other methods by using core functionality:Completed 
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
3. Implement extra functionality Methods:Completed
  * contains(Object)
  * descendingIterator()
  * iterator()
  * remove(Object)
  * removeFirstOccurence(Object)
  * removeLastOccurence(Object)
4. Implement extra functionality: Completed
  * Generic Typing
  * Exception Handlding
  * Collection methods
## Summary of Development Plan
Our development plan is broken down into 5 phases -- the steps shown above. Before any of our actual code is written, we decided that it's very important to have a plan of the structure of our deque and a general idea of how each of our methods were implemented. We all agreed that a doubly linked node would be the best way to implement the deque class. After deciding on this, the next general step should be to familiarize ourselves with every method that the Java api expects us to implement. After doing this, we will create an interface that our deque should implement. After writing this interface we will begin developing our deque without generic typing, using Strings. We will start by implementing the core functionality that is essential to the functioning of the deque as a data strucutre. Afterwards, we will use these core methods and wrap other methods around them. We will then implement the extra functionality methods onto the deque, continuing with a deque of Strings. Lastly, we will implement other extra functionality to polish up our deque class and data structure. 
## Method Selections
 We were able to implement all of the methods present in the java API because most of them were simply wrappers of other ones. Despite implementing every method, we developed our class creating a minimum viable product first. Our minimum viable product implemented the core methods first because they were the most important for the use of a deque, and could be wrapped to implement future methods. 
## Rationale for architecture of the Deque
 We decided to encapsulate doubly linked nodes to implement the deque because we thought it was the best data structure for it. If we were to use an arraylist or an array, it would come at the cost of either a linear runtime remove method or a linear runtime add method for one end depending on how our array/arraylist was encapsulated. With doubly linked nodes, the run time of addFirst(), addLast(), removeFirst(), and removeLast() would all be constant. There is a way to acheive constant run time methods with an arraylist/array like we did when we implemented a queue with an arraylist, however, the method comes at the cost of a memory leakage or with the hastle of having to recopy the array/arraylist. 

