package tme4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private T[] tab;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyArrayList(int max) {
        tab = (T[]) new Object[max];
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public boolean add(T e) {
        if (size == tab.length) {
            T[] newTab = (T[]) new Object[tab.length * 2];
            for (int i = 0; i < tab.length; i++) {
                newTab[i] = tab[i];
            }
            tab = newTab;
        }
        tab[size++] = e;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return tab[index];
    }

    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int index = 0;

        public MyArrayListIterator() {
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return get(index++);
        }

        public boolean hasNext() {
            return index < size();
        }
    }
}
