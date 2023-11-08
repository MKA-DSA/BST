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
		if(this.element == item) return true;
		if(item < this.element) {
			if(this.left == null) return false;
			return this.left.contains(item);
		}
		if(this.right == null) return false;
		return this.right.contains(item);
	} 
	
	public BST findMin() { 
		if(this.left != null) return this.left.findMin();
		return this;
	}

	public BST findMax() { 
		if(this.right != null) return this.right.findMax();
		return this;
	}
	
	private BST findMaxParent() { // never going to call on a BST w/ no right
		if (this.right.getRight() == null) {
			return this;
		}
		return this.right.findMaxParent();
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
		// trying to remove root, doesn't have children so can't remove
		if (this.left == null && this.right == null) return false;//it has no children
		return this.remove(item, null, false);
	}
	
	private boolean remove(int item, BST parent, boolean isLeft) {
		if (this.element == item) { // found the thing looking for
			// has no children, remove from parent (know that it isn't the root)
			if (right == null && left == null) {
				if (isLeft)  parent.setLeft(null);
				else  parent.setRight(null);
				return true;
			}
			// has one child, replace current node with child
			if (left == null) { //current node only has a right child
				if (isLeft)  parent.setLeft(right);
				else  parent.setRight(right);
				return true;
			}
			if (right == null) {
				if (isLeft)  parent.setLeft(left);
				else  parent.setRight(left);
				return true;
			}
			// has two children - get largest on left swap, recurse
			// findMaxParent()
			BST maxParent;
			BST toSwap;
			boolean toSwapisLeft = false;
			if (this.left.getRight() == null) {
				maxParent = this;
				toSwap = this.left;
				toSwapisLeft = true;
			}
			else {
				maxParent = this.left.findMaxParent();
				toSwap = maxParent.getRight();
			}
			int temp = toSwap.getElement();
			toSwap.setElement(element);
			element = temp; 
			return toSwap.remove(item, maxParent, toSwapisLeft);
		}
		// removing something other than current node
		if (item < this.element) {
			if (this.left != null) return this.left.remove(item, this, true);
			return false;
		}
		if (this.right != null) return this.right.remove(item, this, false);
		return false;
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
		//LinkedQueue 
		LinkedQueue<BST> Q = new LinkedQueue<BST>();
		Q.enqueue(this);
		while (!Q.isEmpty()) {
			BST current = Q.dequeue();
			if (current.getLeft() != null) Q.enqueue(current.getLeft());
			if (current.getRight() != null) Q.enqueue(current.getRight());
			current.visit();
		}
		
	}
	
	public static void main(String[] arg) {
		BST test = new BST(10);
		test.add(5);
		test.add(35);
		test.add(7);
		test.add(6);
		test.add(11);
		test.add(2);
		test.add(4);
		test.add(3);

		test.preOrder();
		test.remove(11);
		System.out.println();
		test.preOrder();
		System.out.println(test.contains(11));
		System.out.println(test.contains(3));
	}
}
