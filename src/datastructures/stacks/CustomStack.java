package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomStack() {
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t) {
        try {
            list.addFirst((T) t);
            return true;
        } catch (Exception e) {
            throw new IllegalStateException("Unable to push element to stack", e);
        }
    }

    @Override
    public boolean offer(Object t) {
        try {
            list.addFirst((T) t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public T remove() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.removeFirst();
    }

    @Override
    public T poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst(); 
    }

    @Override
    public T element() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getFirst(); 
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
