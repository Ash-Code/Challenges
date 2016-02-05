package theory.datastructures;

public class TestAVL {

	public static void main(String args[]){
		AVL tree=new AVL();
		ANode root=null;
		for(int i=0;i<19;i++){
			//System.out.println("Sending root "+root);
			tree.insert(i);
		}
		System.out.println(tree.root);
		
		tree.preOrder();
		
	}
	
}
