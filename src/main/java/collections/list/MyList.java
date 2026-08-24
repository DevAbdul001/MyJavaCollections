package collections.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public interface MyList<E> {

  // Appends the specified elemnt at the end of the list
  boolean add(E e);

  // Inserts the specified element at the specified position in the list
  void add(int index, E elemnt);

  // Appends all of the elements in the specified collection to the end of the list
  boolean addAll(Collection<? extends E> c);

  // Inserts all the elemnts in the specified collection at the specified position
  boolean addAll(int index, Collection<? extends E> c);

  // Removes all elements from the list
  void clear();

  // Returns true if the list contains the specified element
  boolean contains(Object o);

  // Returns true if list contans all of the elements of the specified collection
  boolean containsAll(Collection<?> c);

  // Compares the specified object with the list for equality
  boolean equals(Object o);

  // Returns the element at the specified position in the list
  E get(int index);

  // Returns the hash code value for this list
  int hashCode();

  // Returns the position of the first occurance of the specified element, or -1 if the list doesnt
  // contain the element
  int indexOf(Object o);

  // Returns true if the list contains no elemnts
  boolean isEmpty();

  // Returns an iterator over the elements in this list for a proper sequence
  Iterator<E> iterator();

  // Returns the last index of the occurance of the specified elemnt in the list, otherwise returns
  // -1
  int lastIndexOf(Object o);

  // Returns a list iterator over the elements in the list
  ListIterator<E> listIterator();

  // Returns a list iterator over the elements in the list starting at a specific index
  ListIterator<E> listIterator(int index);

  // Removes the element at the specified position in this list
  E remove(int index);

  // Removes the first occurance of the specified element from the list if its present
  boolean remove(Object o);

  // Removes from the list all of its elements that are contained in the specified collection
  boolean removeAll(Collection<?> c);

  // Replaces each element of this list with the result of applying the operator to the element

}
