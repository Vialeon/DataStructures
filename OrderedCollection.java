
package oc;
public interface OrderedCollection<E>{
    public void append(E toAppend);
    public E peek();
    public E pop();
    public String toString();
    public int length();
    public void remove(int index);
}