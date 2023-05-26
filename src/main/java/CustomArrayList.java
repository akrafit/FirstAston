import java.util.*;


public class CustomArrayList<E> implements Custom<E> {
    private E[] elements;

    CustomArrayList() {
        elements = (E[]) new Object[0];
    }

    public boolean add(E e) {
        try {
            E[] lastArray = elements;
            elements = (E[]) new Object[lastArray.length + 1];
            System.arraycopy(lastArray, 0, elements, 0, lastArray.length);
            elements[elements.length - 1] = e;
            return true;
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public void delete(int index) {
        try {
            E[] lastArray = elements;
            elements = (E[]) new Object[lastArray.length - 1];
            System.arraycopy(lastArray, 0, elements, 0, index);
            System.arraycopy(lastArray, index + 1, elements, index, lastArray.length - index - 1);
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
    }

    public void update(int index, E e) {
        elements[index] = e;
    }

    @Override
    public void deleteAll() {
        elements = (E[]) new Object[0];
    }

    public E get(int index) {
        return elements[index];
    }


    public int size() {
        return elements.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(elements);
    }

    public void sort(Comparator<? super E> c) {
        if (elements.length != 0) {
            quickSort(elements, 0, elements.length - 1, c);
        }
    }

    public void quickSort(E[] elementsBody, int low, int high, Comparator<? super E> c) {
        int middle = low + (high - low) / 2;
        E border = elementsBody[middle];

        int i = low, j = high;
        while (i <= j) {
            while (c.compare(elementsBody[i], border) < 0) i++;
            while (c.compare(elementsBody[j], border) > 0) j--;
            if (i <= j) {
                E swap = elementsBody[i];
                elementsBody[i] = elementsBody[j];
                elementsBody[j] = swap;
                i++;
                j--;
            }
        }
        if (low < j) quickSort(elementsBody, low, j, c);
        if (high > i) quickSort(elementsBody, i, high, c);
    }
}


