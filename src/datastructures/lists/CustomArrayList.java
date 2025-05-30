package datastructures.lists;

import datastructures.interfaces.List;

import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public int size() { 
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0) {
            return true;

        } else {
            return false;
        }
    }

    @Override
    public boolean add(Object t) {
        ensureCapacity();
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return Arrays.stream(elements).limit(size).anyMatch(e -> (e != null) && (e.equals(o)));
    }

    @Override
    public boolean remove(Object o) {
        int index = -1;
        for(int i = 0; i < size; ++i) {
            if(elements[i] != null && elements[i].equals(o)) {
                index = i;
                break;
            }
        }
        if(index == -1) {return false;}

        for(int i = index; i < size - 1; ++i) {
            elements[i] = elements[i+1];
        }
        elements[--size] = null;
        return true;

    }
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        T old = (T) elements[index];
        elements[index] = element;
        return old;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

}