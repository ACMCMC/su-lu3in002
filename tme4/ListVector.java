package tme4;

import java.util.Collections;
import java.util.Iterator;

public class ListVector<T> {
    private final int tailleMax;
    private MyLinkedList<MyArrayList<T>> list;
    private int taille = 0;

    public ListVector(int t) {
        this.tailleMax = t;
    }

    public int size() {
        return taille;
    }

    public boolean add(T e) {
        if (list.getLast().size() == tailleMax) {
            list.add(new MyArrayList<T>(tailleMax));
        }
        list.getLast().add(e);
        return true;
    }

    public T get(int index) {
        int indexElementListeChainee = index / tailleMax;
        int indexElementVecteur = index % tailleMax;

        MyArrayList<T> eLinkedList = list.get(indexElementListeChainee);
        return eLinkedList.get(indexElementVecteur);
    }

    public Iterator<T> iterator() {
        return new ListVectorIterator();
    }

    private class ListVectorIterator implements Iterator<T> {
        private Iterator<MyArrayList<T>> listIT;
        private Iterator<T> vectIT;
        
        public ListVectorIterator() {
            listIT = list.iterator();
            vectIT = Collections.emptyIterator();
        }

        public boolean hasNext() {
            return (vectIT.hasNext() || listIT.hasNext());
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (!vectIT.hasNext()) {
                vectIT = listIT.next().iterator();
            }
            return vectIT.next();
        }
    }
}
