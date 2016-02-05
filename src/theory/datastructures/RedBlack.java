package theory.datastructures;

public class RedBlack {
	final int RED = 0;
	final int BLACK = 1;
	final int INF = Integer.MAX_VALUE;

	public class node {
		int key, color;
		node left, right, p;

		public node(int key, int color) {
			this.key = key;
			this.color = color;
		}

	}

	public class RBTree {
		node Nil = new node(INF, BLACK);
		node root;

		public RBTree() {

		}

		public void rotateLeft(node z) {
			node y = z.right;
			node p = z.p;
			node mid = y.left;
			if (mid != Nil)
				mid.p = z;

			z.right = mid;
			y.left = z;
			z.p = y;
			y.p = p;
			if (p == Nil)
				root = y;
			else if (z == p.left)
				p.left = y;
			else
				p.right = y;

		}

		public void rotateRight(node z) {
			node y = z.left;
			node p = z.p;
			node mid = y.right;
			if (mid != Nil)
				mid.p = z;

			z.left = mid;
			y.right = z;
			z.p = y;
			y.p = p;
			if (p == Nil)
				root = y;
			else if (z == p.left)
				p.left = y;
			else
				p.right = y;
		}

		public void print(node x) {
			if (x == null || x == Nil)
				return;
			print(x.left);
			System.out.println("[" + x.key + "("
					+ (x.p == null ? "null" : x.p.key) + ")"+(x.color==RED?"RED":"BLACK")+"]");
			print(x.right);
		}

		public void insert(node z) {
			if (root == null) {
				root = z;
				z.p = Nil;
				z.left = Nil;
				z.right = Nil;
				z.color = BLACK;
				return;
			} else {
				node y = root;
				node x = y;
				while (x != null && x != Nil) {
					y = x;
					if (z.key <= x.key)
						x = x.left;
					else
						x = x.right;
				}

				if (z.key <= y.key)
					y.left = z;
				else
					y.right = z;
				z.p = y;
				z.left = Nil;
				z.right = Nil;
				System.out.println("inserted " + z.key + " " + z.p.key + " "
						+ z.p.left.key + " " + z.p.right.key);
				fixupInsert(z);
			}

		}

		public void fixupInsert(node z) {
			while (z.p.color == RED) {

				node p = z.p;
				node gp = z.p.p;
				System.out.println(z.key + " " + p.key + " " + gp.key);
				if (p == gp.left) {

					if (gp.right.color == RED) {
						System.out.println("Case1");
						gp.right.color = BLACK;
						p.color = BLACK;
						z = gp;
						z.color = RED;
					} else {
						if (z == p.right) {
							System.out.println("case2");
							rotateLeft(p);
						}
						p.color = BLACK;
						gp.color = RED;
						z = p;
						System.out.println("Case3");
						rotateRight(gp);
						System.out.println("    new root: " + root.key);
					}
				} else {
					if (gp.left.color == RED) {
						System.out.println("Case1S");
						gp.left.color = BLACK;
						p.color = BLACK;
						z = gp;
						z.color = RED;
					} else {
						if (z == p.left) {
							System.out.println("Case2S");
							rotateRight(p);
						}
						p.color = BLACK;
						gp.color = RED;
						z = p;
						System.out.println("Case3S");
						rotateLeft(gp);
						System.out.println("    new root: " + root.key);
					}
				}
			}
			root.color = BLACK;
		}

	}

	public void run() {
		RBTree tree = new RBTree();
		tree.insert(new node(2, RED));
		// tree.print(tree.root);
		tree.insert(new node(3, RED));
		tree.insert(new node(5, RED));
		tree.insert(new node(7, RED));
		tree.insert(new node(8, RED));
		tree.insert(new node(9, RED));
		tree.print(tree.root);
		
	}

	public static void main(String args[]) {
		new RedBlack().run();

	}

}
