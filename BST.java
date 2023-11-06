/* DSA
 * BST Fall 2023
 */
import java.util.*;

public class BST {
	private int element;
	private BST left;
	private BST right;
	
	// constructors
	BST(int element){
		this.element = element;
		left = null;
		right = null;
	}
	
	BST(int element, BST left, BST right){
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	// setters & getters
	public int getElement() { return element; }
	public BST getLeft() { return left; }
	public BST getRight() { return right; }
	
	public void setElement(int elt) { element = elt; }
	
	public void setLeft(BST newLeft) { left = newLeft; } 
	
	public void setRight(BST newRight) { right = newRight; } 
	
	// methods
	public boolean contains(int item) { 

	} 
	
	public BST findMin() { 

	}

	public BST findMax() { 
		
	}

	public boolean add(int item){
		// cannot have a null root elt - will always create node w/
		if(item < this.element) {
			if (left != null) {
				// recurse on left subtree
				return left.add(item);
			}
			left = new BST(item);
			return true;
		}
		else if(item > this.element) {
			if ( right != null) {
				return right.add(item);
			}
			right = new BST(item);
			return true;
		}
		return false;
	} 
	
	public boolean remove(int item) { // do not implement yet
		
	}

	// traversals
	private void visit() { System.out.print(element + " "); }
	
	public void inOrder() { // visits left, parent, right
		if (left !=null) { left.inOrder(); }
		this.visit();
		if (right!=null) { right.inOrder(); }
	}
	
	public void preOrder() { // parent, left, right
		this.visit();
		if (left != null) { left.preOrder(); }
		if (right!= null) { right.preOrder(); }
	}

	public void postOrder() { // left, right, parent
		if (left != null) { left.postOrder(); }
		if (right!= null) { right.postOrder(); }
		this.visit();
	}
	
	public void breadthFirst() {
		
	}
	
	public static void main(String[] arg) {
		BST test = new BST(10);
		test.add(5);
		test.add(35);
		test.add(7);
		test.add(10);
		test.postOrder();
	}
}
