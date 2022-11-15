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
		if(item==element) return true;
		if(item < element && left != null) return left.contains(item);
		if(item > element && right != null) return right.contains(item);
		return false;
	} //search
	
	public BST findMin() { 
		if(left == null) {
			return this;
		}
		return left.findMin();
	}
	private BST findMinParent() {
		if(getLeft() != null && getLeft().getLeft()==null) {
			return this;
		}
		else if (getLeft() != null) return left.findMinParent();
		return null;
	}

	public BST findMax() { 
		if(right == null) {
			return this;
		}
		return right.findMax();
		
	}
	private BST findMaxParent() {
		if(getRight() != null && getRight().getRight()==null) {
			return this;
		}
		else if (getRight() != null) return right.findMaxParent();
		return null;

	}
	
	public boolean add(int item){
		if (element == item) return false;
		if (element > item && left != null) return left.add(item);
		if (element > item && left == null) {
			left = new BST(item);
			return true;
		}
		if (right != null) return right.add(item);
		right = new BST(item);
		return true;	
	} 
	
	public boolean remove(int item) { 
		if(!(this.contains(item)))
			return false;
		remove(item, null);
		return true; 
		
	}
	
	private void remove(int item, BST parent) { // this is only called if item in tree
		if(element == item) { //found the item to remove
			if(left==null && right==null && parent!=null) {
				if(parent.getLeft() != null && parent.getLeft().getElement()==item) {
					parent.setLeft(null);
				}
				else parent.setRight(null);
			}
			else if (left==null && right==null && parent==null) { return; }
		
			// found item, know it isn't a leaf
			else if (getLeft()==null) {
				BST temp = this.getRight().findMin();
				int t = temp.getElement();
				temp.setElement(this.getElement());
				this.setElement(t);
				temp.remove(item, this.getRight().findMinParent());
			}
			else {
				BST temp = this.getLeft().findMax();
				int t = temp.getElement();
				temp.setElement(this.getElement());
				this.setElement(t);
				temp.remove(item, this.getLeft().findMaxParent());
			}
		}
		// haven't found the item yet
		else if(item>element) {
			System.out.println("about to call remove" + getRight() + " " +  this);
			getRight().remove(item,this);
		}
		else {
			getLeft().remove(item,this);
		}
	}
		
	// traversals
	private void visit() { System.out.print(element + " "); }
	public void inOrder() { // visits left, parent, right
		if(left!=null)	left.inOrder();
		visit();
		if(right!=null) right.inOrder();
	}
	public void preOrder() { // parent, left, right
		visit();
		if(left!=null) left.preOrder();
		if(right!=null) right.preOrder();
	}

	public void postOrder() { // left, right, parent
		if(left!=null) left.postOrder();
		if(right!=null) right.postOrder();
		visit();
		
		
	}
	public void breadthFirst() {
		ArrayList<BST> Q = new ArrayList<BST>();
		Q.add(this);
		while(Q.size() > 0) {
			BST current = Q.remove(0);
			if(current.getLeft() != null) {
				Q.add(current.getLeft());
			}
			if(current.getRight() != null) {
				Q.add(current.getRight());
			}
			current.visit();
		}
		
	}
	
	public String toString() { return element + " "; }
	
	public static void main(String[] arg) {
		BST bst = new BST(8);
		int[] vals = {4,1,7, 5,6, 9,-2,0,19,2,9,10,12};
		for (int v: vals)bst.add(v);
		System.out.print("In order: ");
		bst.inOrder();
		//System.out.println(bst.contains(19));
		//System.out.println(bst.contains(38));
		//System.out.println(bst.findMin());
		//System.out.println(bst.findMax());
		//System.out.println(bst.findMinParent());
		//bst.remove(8);
		System.out.print("In order: ");
		bst.inOrder();
		System.out.println();
		System.out.print("Pre order: ");
		bst.preOrder();
		System.out.println();

		System.out.print("Post order: ");
		bst.postOrder();
		System.out.println();
		bst.breadthFirst();
		
	}
}
