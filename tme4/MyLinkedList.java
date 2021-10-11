package tme4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private ChainedElement<T> head = null;
    private ChainedElement<T> tail = null;
    private int size = 0;

    public boolean add(T element) {
        if (head == null) {
            head = new ChainedElement<T>(element, null);
            tail = head;
        } else {
            tail.setNext(new ChainedElement<T>(element, null));
            tail = tail.getNext();
        }
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ChainedElement<T> currElement = head;
        for (int i = 0; i < index; i++) {
            currElement = currElement.getNext();
        }
        return currElement.getData();
    }

    public T getLast() {
        return tail.getData();
    }

    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private static class ChainedElement<T> {
        private T elem;
        private ChainedElement<T> next;
        public ChainedElement(T data, ChainedElement<T> next) {
            this.next = next;
            elem = data;
        }

        public T getData() {
            return elem;
        }

        public ChainedElement<T> getNext() {
            return next;
        }

        public void setNext(ChainedElement<T> next) {
            this.next = next;
        }
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private ChainedElement<T> current;

        public MyLinkedListIterator() {
            current = head;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T elem = current.getData();
            current = current.getNext();
            return elem;
        }

        public boolean hasNext() {
            return current.getData() != null;
        }
    }
}
