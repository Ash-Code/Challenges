package theory.datastructures;

public class AVL {
	public ANode root;

	public AVL() {
		root = null;
	}

	// Amazing algo.. maybe the least complex implementation possible
	public void insert(int key) {
		// every node is updated. Every node gets a
		// new/old node reassigned after
		// modification
		
		root = insertNode(root, key);
	}

	public ANode insertNode(ANode r, int key) {
		if (r == null){// when insert position found, return the pointer to the
						// new node and let the parents handle it
			//System.out.println(key+" root is "+root);
			return new ANode(key);
		}
		
		//System.out.println("Parents handling ");
		
		if (r.key >= key)// parents handling it
			r.left = insertNode(r.left, key);
		else
			r.right = insertNode(r.right, key);
		//System.out.println("   handled "+r.key+"'s child lr= "+r.left+" "+r.right+"    root is? "+root);
		// ---------------------------insertion complete

		r.height = Math.max(getHeight(r.left), getHeight(r.right)) + 1;// -------Now
																		// check

		int balance = getHeight(r.left) - getHeight(r.right);
		//System.out.println("          bal "+balance);
		// ----------------------All cases.
		if (balance > 1 && (r.left != null && key <= r.left.key)) {
			return rotateRight(r);
		}
		if (balance > 1 && (r.left != null && key > r.left.key)) {
			r.left = rotateLeft(r.left);
			return rotateRight(r);
		}
		if (balance < -1 && (r.right != null && r.right.key < key)) {
			return rotateLeft(r);
		}
		if (balance < -1 && (r.right != null && r.right.key >= key)) {
			r.right = rotateRight(r.right);
			return rotateLeft(r);
		}
		return r;// return this nodes pointer so that the parents can reassign
	}

	public void inOrder() {
		inOrder(root);
	}
	public void preOrder(){
		preOrder(root);
	}

	private void inOrder(ANode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.key + " ");
		inOrder(root.right);
	}
	
	private void preOrder(ANode root){
		if(root==null)
			return;
		preOrder(root.left);
		preOrder(root.right);
		System.out.print(root.key+" ");
	}

	public int getHeight(ANode x) {
		if (x == null)
			return 0;
		else
			return x.height;
	}

	public ANode rotateRight(ANode x) {
		ANode y = x.left;
		ANode T2 = y.right;
		y.right = x;
		x.left = T2;

		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

		return y;
	}

	public ANode rotateLeft(ANode x) {
		ANode y = x.right;
		ANode T2 = y.left;
		x.right = T2;
		y.left = x;

		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

		return y;
	}

}
