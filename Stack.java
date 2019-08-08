import java.util.*;
public class Stack<E> {
	private Vector<E> v;
	public Stack(){
		v = new Vector<E>(0);
	}
	public Stack(int size){
		v = new Vector<E>(size);
	}


	public void push(E a){

		v.add(a);
	}
	public E pop(){
		if(!v.isEmpty()){
			return v.remove(v.size()-1);
		}
		else{
			return null;
		}
	}
	public E peek(){
		if(!v.isEmpty()){
			return v.lastElement();
		}
		else{
			return null;
		}
	}
	public int size(){
		return v.size();
	}
	public boolean isEmpty(){
		return v.isEmpty();
	}
	public void print(){
		for(int i = 0;i<v.size();i++){
			System.out.print(v.get(i)+ " ");
		}
		System.out.println();
	}
	public int lastIndexOf(E element){
		return v.lastIndexOf(element);
	}
	public boolean contains(E element) {
		return v.contains(element);
	}

}