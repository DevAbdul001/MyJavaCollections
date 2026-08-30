package collections.list;

import java.util.*;

public class MyArrayList<E> implements MyList<E> {

  private Object[] elements;
  private int size;

  public MyArrayList() {
    elements = new Object[0];
    size = 0;
  }

  // ==================================================================================================

  public boolean add(E e) {
    if (size == elements.length) {
      Object[] newElements = new Object[elements.length + 1];

      for (int i = 0; i < elements.length; i++) {
        newElements[i] = elements[i];
      }

      elements = newElements;
    }

    elements[size] = e;
    size++;

    return true;
  }

  // ==================================================================================================

  public void add(int index, E element) {

    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("index" + index + ", " + "size" + size);
    }

    if (size + 1 > elements.length) {
      Object[] newElements = new Object[elements.length + 1];

      for (int i = 0; i < elements.length; i++) {
        newElements[i] = elements[i];
      }
      elements = newElements;
    }
    System.arraycopy(elements, index, elements, index + 1, size - index);
    elements[index] = element;
    size++;
  }

  // ===================================================================================================

  boolean addAll(Collection<? extends E> col) {
    if (col.size() > elements.length - size) {
      Object[] newElements = new Object[elements.length + col.size()];

      for (int i = 0; i < elements.length; i++) {
        newElements[i] = elements[i];
      }
      elements = newElements;
    }

    for (E element : col) {
      elements[size] = element;
      size++;
    }
    return true;
  }

  // ====================================================================================================
  void clear() {
    Object[] newElements = new Object[0];
    elements = newElements;
  }

  // ===================================================================================================
  boolean contains(Object object) {

    for (int i = 0; i < elements.length; i++) {
      if (elements[i] == object) {
        return true;
      }
    }
  }

  // ===================================================================================================
  boolean containsAll(Collection<?> col) {

    for (E element : col) {
      boolean matches = false;

      for (int i = 0; i < elements.size; i++) {
        if (elements[i] == element) {
          matches = true;
        }
      }

      if (matches == false) {
        return false;
      }
    }

    return true;
  }

  // ===================================================================================================
  boolean equals(Object object) {

    // check if its a List
    if (!(object instanceof List)) {
      return false;
    }

    // cast object to a list
    List<?> cast = (List<?>) object;

    // check for size
    if (cast.size() != elements.size) {
      return false;
    }

    // loop to check each element's index and value
    for (int i = 0; i < elements.size; i++) {

      if (!Objects.equals(elements[i], cast.get(i))) {
        return false;
      }
    }

    return true;
  }

  // ===================================================================================================
  E get(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("index: " + index + ", " + "size: " + size);
    }
    return elements[index];
  }

  // ==================================================================================================
  int hashCode() {

    int hash = 0;

    for (int i = 0; i < elements.size; i++) {
      int hashCode = Objects.hashCode(elements[i]);
      int combined = 31 * hash + hashCode;
      hash = combined;
    }

    return hash;
  }
}
