package theory.datastructures;


public class Implement {
	public static void main(String args[]) {
		BST<Integer> sTree = new BST<Integer>();
		Node<Integer> root=sTree.root;
		root=new Node<Integer>(7,null,null,null);
		root.left=new Node<Integer>(4,null,null,null);
		root.left.left=new Node<Integer>(2,null,null,null);
		root.left.right=new Node<Integer>(5,null,null,null);
		root.right=new Node<Integer>(9,null,null,null);
		root.right.left=new Node<Integer>(8,null,null,null);
		root.right.right=new Node<Integer>(10,null,null,null);
		root.right.right.right=new Node<Integer>(11,null,null,null);
		sTree.root=root;
		//sTree.inOrder();
		
		//sTree.inOrder();
		Heap<Integer> heap=new Heap<Integer>();
		heap.add(56);
		heap.add(22);
		for(int i=32;i<200;i+=2){
			heap.add(i*4%67);
		}
		heap.heapSortMax();
		sTree.inOrder();
sTree.preOrderNoRec();

		
	

	}
}
