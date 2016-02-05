package theory.datastructures;

public class ANode {
	int height;
	int key;
	ANode left;
	ANode right;

	public ANode(int key) {
		this.key = key;
		left = null;
		right = null;
		height = 1;
	}
}
