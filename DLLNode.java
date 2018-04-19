/*****************************************************
 * class DLLNode v1
 * Implements a node, for use in lists and other container classes.
 * Stores a String as cargo.
 *****************************************************/

public class DLLNode<E>
{
  private E _value;    //data that this node holds
  private DLLNode<E> _nextNode, _prevNode; //pointers to next, prev DLLNodes


  // constructor -- initializes instance vars
  public DLLNode( E value, DLLNode<E> prev, DLLNode<E> next )
  {
    _value = value;
    _nextNode = next;
    _prevNode = prev;
  }


  //--------------v  ACCESSORS  v--------------
  public E getValue() { return _value; }

  public DLLNode<E> getNext() { return _nextNode; }

  public DLLNode<E> getPrev() { return _prevNode; }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public E setValue( E newValue )
  {
    E foo = getValue();
    _value = newValue;
    return foo;
  }

  public DLLNode setNext( DLLNode<E> newNext )
  {
    DLLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }

  public DLLNode setPrev( DLLNode<E> newPrev )
  {
    DLLNode foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString() { return _value.toString(); }


}//end class DLLNode
