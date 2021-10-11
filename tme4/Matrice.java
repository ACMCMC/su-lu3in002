package tme4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Matrice<T> implements Iterable<T> {
    private final T[][] mat;

    @SuppressWarnings("unchecked")
    public Matrice(int nblignes, int nbcolonnes) {
        mat = (T[][]) new Object[nblignes][nbcolonnes];
    }

    public int nbLignes() {
        return mat.length;
    }

    public int nbColonnes() {
        return mat[0].length;
    }

    public T get(int i, int j) {
        return mat[i][j];
    }

    public void put(T e, int i, int j) {
        mat[i][j] = e;
    }

    private class MatriceIterator implements Iterator<T> {
        private int index;

        MatriceIterator() {

        }

        public boolean hasNext() {
            return (index < nbColonnes()*nbLignes());
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("The element doesn't exist");
            }
            return (get(index / nbColonnes(), index % nbColonnes()));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MatriceIterator();
    }
}