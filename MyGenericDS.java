
package oc;

public class MyGenericDS<E> implements OrderedCollection<E> {
	public Node<E> end;// the last Node stored
	private int length = 0;

	class Node<E> {
		private int position;
		E element;// setting the object for the current node
		Node<E> next;// initializing the next node

		public Node(E elem) {
			element = elem;
			position = length;
			length+=1;
		}
	}
	public E peek() {
		return end.element;
	}

	@Override
	public E pop() {
		E toReturn = end.element;// creating local variable for end.num
		end = end.next;// changing 'index' to the previous node
		return toReturn;
	}

	public MyGenericDS() {
		end = null;// setting value to null
	}

	public void add(E Add) {
		Node<E> toAdd = new Node<E>(Add);
		toAdd.element = Add;
		toAdd.next = end;// making this known as the last node
		end = toAdd;
	}

	public void append(E toAppend) {
		Node<E> toAdd = new Node<E>(toAppend);
		toAdd.element = toAppend;
		toAdd.next = end;// making this known as the last node
		end = toAdd;
	}

	public String toString() {
		String toReturn = "";
		Node<E> n = end;
		while (n != null) {
			toReturn = n.element.toString() + " " + toReturn;
			n = n.next;
		}
		return toReturn;
	}

	public int length() {
		int num = 0;
		Node<E> n = end;
		while (n != null) {
			num++;
			n = n.next;
		}
		return num;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

		Node<E> toCheck = end;
		try {
			if (index > length || index < 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Please use a valid index");
		}
		try {
			while(toCheck !=null) {
				if (index == length-1 && toCheck.position == length-1) {
					pop();
				} 
				else if (toCheck.position == index + 1) {
					toCheck.next = toCheck.next.next;
				}
				toCheck = toCheck.next;
			}
		}
		catch(Exception e1) {
			System.out.println("something went wrong in the process of removing");
		}
	}


}