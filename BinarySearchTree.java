
public class BinarySearchTree<K extends Comparable,V> {
	private Node<K,V> root;
	public BinarySearchTree() {
		root = null;
	}
	public BinarySearchTree(V val, K kluch) {
		root = new Node(val, kluch); 
	}
	
	public V remove(K kluch){
		Node<K,V> toRemove = nodeLookup(kluch);
		
		if(toRemove == null) {
			System.out.println("this node does not exist");
			return null;
		}
		else if(toRemove == root) {
			Node<K,V> toReplace;
			if(toRemove.getLeft() != null) {
				toReplace = toRemove.getLeft();
				while(toReplace.getRight()!=null) {
					toReplace = toReplace.getRight();
				}
				if(toReplace.getLeft()!=null) {
					toReplace.getLeft().setParent(toReplace.getParent());
					toReplace.getParent().setRight(toReplace.getLeft());
				}
			}
		}
		else {
			Node<K,V> parent = toRemove.getParent();
			char lr;
			// finds if toRemove is right or left child node of parent
			if(parent.getRight() == toRemove) {
				lr = 'r';
			}
			else {
				lr = 'l';
			}
			
			// if leaf
			if(toRemove.getRight() == null && toRemove.getLeft()==null) {
				// deindexing toRemove
				if(lr =='r') {
					parent.setRight(null);
				}
				else {
					parent.setLeft(null);
				}
			}
			
			// if toRemove has one subtree
			else if(toRemove.getRight() == null || toRemove.getLeft()==null) {
				// if the child has right subtree connect it to parent thus deindexing toRemove
				if(toRemove.getRight()!=null) {
					if(lr =='r') {parent.setRight(toRemove.getRight());	}
					else {parent.setLeft(toRemove.getRight());}
				}
				// if the child has a left subtree connect it to parent thus deindexing toRemove
				else {
					if(lr == 'r') {	parent.setRight(toRemove.getLeft());}
					else {parent.setLeft(toRemove.getLeft());}
				}
			}
			
			/* if two children for toRemove
			 * if toRemove is right child:
			 * find smallest possible key in right toRemove.child subtrees and replace (should lead to leaf)
			 * if toRemove is left child:
			 * find largest possible key in left toRemove.child subtrees and replace(should also lead to leaf)
			 */
			else {
				Node<K,V> replacementNode;
				// if right child
				if(lr == 'r') {
					replacementNode = toRemove.getRight();
					while(replacementNode.getLeft()!=null) {
						replacementNode = replacementNode.getLeft();
					}
					// set parent of the replacement node to null
					replacementNode.getParent().setLeft(null);
					// set the parent of the replacement node to the parent node of toRemove
					replacementNode.setParent(toRemove.getParent());
					// set left and right nodes of new node to those of toRemove
					replacementNode.setLeft(toRemove.getLeft());
					replacementNode.setRight(toRemove.getRight());
					// set the parent's right child to new replacement node
					replacementNode.getParent().setRight(replacementNode);
					// set children of replacements node parent as replacement Node thus completely deindexing toRemove Node
					replacementNode.getRight().setParent(replacementNode);
					replacementNode.getLeft().setParent(replacementNode);
				}
				// if left child
				else {
					replacementNode = toRemove.getLeft();
					while(replacementNode.getRight()!=null) {
						replacementNode = replacementNode.getRight();
					}
					// set parent of the replacement node to null
					replacementNode.getParent().setRight(null);
					// set the parent of the replacement node to the parent node of toRemove
					replacementNode.setParent(toRemove.getParent());
					// set left and right nodes of new node to those of toRemove
					replacementNode.setLeft(toRemove.getLeft());
					replacementNode.setRight(toRemove.getRight());
					// set the parent's left child to new replacement node
					replacementNode.getParent().setLeft(replacementNode);
					// set children of replacements node parent as replacement Node thus completely deindexing toRemove Node
					replacementNode.getRight().setParent(replacementNode);
					replacementNode.getLeft().setParent(replacementNode);
				}
				
			}
		}
		return toRemove.getValue();
	}
	public void add(K kluch, V val) {
		Node<K,V> addition = new Node<K,V>(val, kluch);
		if(root == null) {
			root = addition;
		}
		else {
			Node<K,V> holder = root;
			while(true) {
				if((holder.getKey()).compareTo(kluch)==0) {
					holder.setValue(val);
					break;
				}
				else if(holder.getKey().compareTo(kluch)<0) {
					//Sets Right Node and Parent
					if(holder.getRight()==null) {
						holder.setRight(addition);
						holder.getRight().setParent(holder);
						break;
					}
					// traverses to right
					else {
						holder= holder.getRight();
					}
				}
				else {
					//Sets Left Node and Parent
					if(holder.getLeft()==null) {
						holder.setLeft(addition);
						holder.getLeft().setParent(holder);
						break;
					}
					//traverses to left
					else {
						holder= holder.getLeft();
					}
				}
			}
			
		}
	}
	public V lookup(K key) {
		Node<K,V> holdptr = root;
		if(root ==null) {
			return null;
		}
		while(holdptr!=null) {
			if(holdptr.getKey()!=null && holdptr.getKey().compareTo(key)!=0) {
				if(holdptr.getKey().compareTo(key)<0) {
				holdptr = holdptr.getRight();
				}
				else {
					holdptr = holdptr.getLeft();
				}
			}
			else {break;}
		}
		if(holdptr == null) {return null;}
		else {return holdptr.getValue();}
		
	}
	
	public void inOrderTraverse() {
		Node<K,V> holdptr = root;
		traversal(holdptr);
	}
	
	private Node<K,V> nodeLookup(K key){
		Node<K,V> holdptr = root;
		while(holdptr!=null) {
			if(holdptr.getKey().compareTo(key)!=0 && holdptr.getKey()!=null) {
				if(holdptr.getKey().compareTo(key)>0) {
					holdptr = holdptr.getRight();
				}
				else {
					holdptr = holdptr.getLeft();
				}
			}
			else {
				break;
			}
		}
		return holdptr;
	}
	
	private void traversal(Node<K,V> n) {
		if(n != null) {
			traversal(n.getLeft());
			nodePrint(n);
			traversal(n.getRight());
		}
	}
	
	private void nodePrint(Node<K,V> n) {
		System.out.println("(" + n.getKey() + ", " + n.getValue() + ")" );
	}
}
