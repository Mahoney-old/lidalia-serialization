package uk.org.lidalia.serialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class SerializedArray extends Serialized implements List<Serialized> {

    private final List<Serialized> data = new ArrayList<Serialized>();

    public void add(int index, Serialized element) {
        data.add(index, element);
    }

    public boolean add(Serialized e) {
        return data.add(e);
    }

    public boolean addAll(Collection<? extends Serialized> c) {
        return data.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Serialized> c) {
        return data.addAll(index, c);
    }

    public void clear() {
        data.clear();
    }

    public boolean contains(Object o) {
        return data.contains(o);
    }

    public boolean containsAll(Collection<?> c) {
        return data.containsAll(c);
    }

    public boolean equals(Object o) {
        return data.equals(o);
    }

    public Serialized get(int index) {
        return data.get(index);
    }

    public int hashCode() {
        return data.hashCode();
    }

    public int indexOf(Object o) {
        return data.indexOf(o);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public Iterator<Serialized> iterator() {
        return data.iterator();
    }

    public int lastIndexOf(Object o) {
        return data.lastIndexOf(o);
    }

    public ListIterator<Serialized> listIterator() {
        return data.listIterator();
    }

    public ListIterator<Serialized> listIterator(int index) {
        return data.listIterator(index);
    }

    public Serialized remove(int index) {
        return data.remove(index);
    }

    public boolean remove(Object o) {
        return data.remove(o);
    }

    public boolean removeAll(Collection<?> c) {
        return data.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return data.retainAll(c);
    }

    public Serialized set(int index, Serialized element) {
        return data.set(index, element);
    }

    public int size() {
        return data.size();
    }

    public List<Serialized> subList(int fromIndex, int toIndex) {
        return data.subList(fromIndex, toIndex);
    }

    public Object[] toArray() {
        return data.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return data.toArray(a);
    }

}
