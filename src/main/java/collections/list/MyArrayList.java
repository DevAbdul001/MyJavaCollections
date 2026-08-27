package collections.list;

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
      throw new IndexOutOfBoundsException("index" + index + "size" + size);
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
	  if(col.size() > elements.length - size) {
		  Object [] newElements = new Object[elements.length + col.size()];

		  for(int i = 0; i < elements.length; i++){
			  newElements[i] = elements[i];
		  }
		  elements = newElements;
	  }

	  for(E element : col) {
		elements[size] = element;
		size++;
	  }
	  return true;
  }

  // ====================================================================================================
  void clear(){
	Object[] elements = new Object[0];
  }

  // ===================================================================================================
  boolean contains (Object object){

	for(int i = 0; i < elements.length; i++){
		if( elements[i] == object){
			return true;	
		}
	}
  }

}
