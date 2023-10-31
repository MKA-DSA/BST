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
	
	} 
	
	public boolean remove(int item) { // do not implement yet
		
	}

	// traversals
	private void visit() { System.out.print(element + " "); }
	
	public void inOrder() { // visits left, parent, right

	}
	public void preOrder() { // parent, left, right

	}

	public void postOrder() { // left, right, parent

	}
	
	public void breadthFirst() {
		
	}
	
	public static void main(String[] arg) {
	
	}
}
