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

  // ==================================================================================================
  int indexOf(Object object) {

    for (int i = 0; i < elements.size; i++) {
      if (Objects.equals(elements[i], object)) {
        return i;
      }
    }
    return -1;
  }

  // ===================================================================================================
  boolean isEmpty() {

    if (elements.size == 0) {
      return true;
    }

    return false;
  }

  // ===================================================================================================
  Iterator<E> iterator() {

    return new Iterator<E>() {

      int cursor = 0;

      @Override
      public boolean hasNext() {
        return cursor < size;
      }

      @Override
      public E next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }

        E element = elements[cursor];
        cursor++;

        return element;
      }
    };
  }

  // =================================================================================================
  int lastIndexOf(Object o) {

    if (size == 0) {
      return -1;
    }

    return elements[size];
  }

  // ===============================================================================================
  ListIterator<E> listIterator() {
    return listIterator(0);
  }

  // ===============================================================================================
  ListIterator<E> listIterator(int index) {

    return new ListIterator<E>() {

      int cursor = index;

      @Override
      public boolean hasNext() {
        return cursor < size;
      }

      @Override
      public boolean hasPrevious() {
        return cursor > 0;
      }

      @Override
      public E next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        E element = elements[cursor];
        cursor++;

        return element;
      }

      @Override
      public int nextIndex() {
        return cursor;
      }

      @Override
      public E previous() {
        if (!hasPrevious()) {
          throw new NoSuchElementException();
        }
        cursor--;
        E element = elements[cursor];
        return element;
      }

      @Override
      public int previousIndex() {
        int prev = cursor - 1;
        return prev;
      }

      // TODO : remove() & Set(E e) methods
    };
  }

  // ===================================================================================================
  E remove(int index) {

    if (size == 0 || index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    E element = elements[index];

    int elementsToShift = size - index - 1;
    System.arraycopy(elements, index + 1, elements, index, elementsToShift);
    elements[size - 1] = null;
    size--;

    return element;
  }

  // ===================================================================================================
  boolean remove(Object o) {
    if (size == 0) {
      return false;
    }

    int index = this.indexOf(o);

    if (index == -1) {
      return false;
    }
    this.remove(index);
    return true;
  }

  // ===================================================================================================
  boolean removeAll(Collection<?> col) {

    int count = 0;

    for (Object o : col) {
      while (this.contains(o)) {
        this.remove(o);
        count++;
      }
    }

    if (count == 0) {
      return false;
    }

    return true;
  }
}
