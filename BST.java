/* DSA
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
		if (element == item) {
			return true;
		}
		if (item > element && this.getRight() != null) {
			return this.getRight().contains(item);
		}
		if (this.getLeft() != null) {
			return this.getLeft().contains(item);
		}
		return false;
	} 
	
	public BST findMin() { 
		
	}

	public BST findMax() { 
		
	}

	public boolean add(int item){
		 if (element == item) {
			 return false;
		 } 
		 if (element > item) {
			 if (this.getLeft() == null) {
				 this.setLeft(new BST(item));
				 return true;
			 }
			 return this.getLeft().add(item);
		 }
		 else {
			 if (this.getRight() == null) {
				 this.setRight(new BST(item));
				 return true;
			 }
			 return this.getRight().add(item); 
		 }
	} 
	
	public boolean remove(int item) { // do not implement yet

	}
	
	

	// traversals
	private void visit() { System.out.print(element + " "); }
	
	public void inOrder() { // visits left, parent, right
		if (this.getLeft() != null) this.getLeft().inOrder();
		this.visit();
		if (this.getRight() != null) this.getRight().inOrder();
	}
	
	public void preOrder() { // parent, left, right
		this.visit();
		if (this.getLeft() != null) this.getLeft().inOrder();
		if (this.getRight() != null) this.getRight().inOrder();
	}

	public void postOrder() { // left, right, parent
		if (this.getLeft() != null) this.getLeft().inOrder();
		if (this.getRight() != null) this.getRight().inOrder();
		this.visit();
	}
	
	public void breadthFirst() {
		
		
	}
	
	public static void main(String[] arg) {
		BST test = new BST(10);
		test.add(5);
		test.add(35);
		test.add(7);
		test.add(6);
		System.out.println();
		System.out.print("pre order: ");
		
		test.preOrder();
		System.out.println();

		System.out.print("in order: ");
		test.inOrder();
		System.out.println();

		System.out.print("post order: ");
		test.postOrder();
		
		

	/*	test.add(2);
		test.add(4);
		test.add(3);
		
		System.out.println();
		System.out.print("pre order: ");
		
		test.preOrder();
		System.out.println();

		System.out.print("in order: ");
		test.inOrder();*/
	//	System.out.println(test.contains(11));
		//System.out.println(test.contains(3));
	}
}
