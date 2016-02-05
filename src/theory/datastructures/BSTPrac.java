package theory.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class BSTPrac {
	public static int sum;
	public static HashMap<Integer, LinkedList<Integer>> map;
	static int counter = 0;

	// ----------------Ancestors without Recursion//woooohoo!
	// just a regular dfs with stack. Another stack keeps record of the visited
	// nodes. But we only pop (from both) when we get a node that has already
	// been visited.
	public static void PrintParents(Node<Integer> root, Integer find) {
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		HashSet<Node<Integer>> set = new HashSet<Node<Integer>>();
		stack.push(root);
		Stack<Integer> ans = new Stack<Integer>();
		while (!stack.isEmpty()) {
			Node<Integer> x = stack.peek();
			if (set.contains(x)) {
				stack.pop();
				ans.pop();
				continue;
			}
			set.add(x);
			ans.push(x.data);
			if (x.data == find) {
				break;
			}
			if (x.left != null) {
				stack.push(x.left);
			}
			if (x.right != null) {
				stack.push(x.right);
			}

		}
		while (!ans.isEmpty())
			System.out.println(ans.pop());

	}

	// ---------------levelOrder Traversal

	public static ArrayList<ArrayList<Node>> level(Node root) {
		ArrayList<ArrayList<Node>> levels = new ArrayList<ArrayList<Node>>();
		LinkedList<Node> list = new LinkedList<Node>();
		levels.add(new ArrayList<Node>());
		levels.get(0).add(root);
		int curr = 0;
		while (levels.get(curr).size() > 0) {
			ArrayList<Node> temp = levels.get(curr);
			levels.add(new ArrayList<Node>());
			for (int i = 0; i < temp.size(); i++) {
				Node x = temp.get(i);
				System.out.print(x.data + " ");
				if (x.left != null)
					levels.get(curr + 1).add(x.left);
				if (x.right != null)
					levels.get(curr + 1).add(x.right);

			}
			curr++;
			System.out.println("");
		}

		return levels;
	}

	// ---------------find the right node

	// -----------------find the distance-------------\

	public static int getDistRoot(Node root, Node find) {
		if (root == null)
			return -1;
		if (root == find)
			return 0;

		int d1 = getDistRoot(root.left, find);
		int d2 = getDistRoot(root.right, find);
		if (d1 == d2 && d1 == -1)
			return -1;
		else
			return Math.max(d1, d2) + 1;

	}

	// ---------------------Function to find lowest common ancestor

	public static Node<Integer> lowestAnc(Node<Integer> node, Node<Integer> p,
			Node<Integer> q) {
		if (node == null)
			return null;
		if (node == p || node == q)
			return node;

		Node<Integer> left = lowestAnc(node.left, p, q);
		Node<Integer> right = lowestAnc(node.right, p, q);
		if (left != null) {
			if (right == null)
				return left;
			if (right != null)
				return node;
		} else {
			if (right != null)
				return right;
		}

		return null;
	}

	// -------------------------Function to get number of nodes at distance K
	// from leaf
	public static int getDist(Node<Integer> node, Node<Integer> leaf, int k) {
		if (node == null)
			return -1;
		if (node == leaf)
			return 1;
		if (node.left == null && node.right == null)
			return -1;

		int ret1 = getDist(node.left, leaf, k);
		int ret2 = getDist(node.right, leaf, k);
		if (ret1 == -1 && ret2 == -1)
			return -1;
		else {
			if (Math.max(ret1, ret2) == k) {
				// System.out.println(node.data);
				counter++;
			}
			return Math.max(ret1, ret2) + 1;
		}
	}

	public Node<Integer> buildTree() {

		return null;
	}

	public static void rec(Node<Integer> x) {
		if (x == null)
			return;

		rec(x.right);
		sum += x.data;
		x.data = sum - x.data;
		rec(x.left);

	}

	public static void verticalAlign(Node<Integer> rt, int level) {

		if (rt == null)
			return;

		System.out.println(" called   " + rt.data + " at level " + level
				+ " left " + (rt.left != null ? rt.left.data : null)
				+ " right: " + (rt.right != null ? rt.right.data : null));
		if (!map.containsKey(level)) {
			System.out.println("           no contain ");
			map.put(level, new LinkedList<Integer>());
			map.get(level).add(rt.data);
		} else {
			System.out.println("           yes contain ");
			map.get(level).add(rt.data);
		}

		verticalAlign(rt.left, level + 1);
		verticalAlign(rt.right, level - 1);

	}

	public static void main(String args[]) {
		BST<Integer> tree = new BST<Integer>();
		sum = 0;
		Node<Integer> root = tree.insert(11);
		root.left = new Node<Integer>(23, null, null, null);
		root.left.left = new Node<Integer>(4, null, null, null);
		root.left.right = new Node<Integer>(7, null, null, null);
		root.left.left.left = new Node<Integer>(19, null, null, null);
		root.left.right.left = new Node<Integer>(21, null, null, null);
		root.left.right.right = new Node<Integer>(8, null, null, null);
		root.right = new Node<Integer>(56, null, null, null);
		root.right.left = new Node<Integer>(43, null, null, null);
		root.right.right = new Node<Integer>(3, null, null, null);
		tree.inOrder();
		getDist(root, root.left.left.left, 3);
		System.out
				.println(lowestAnc(root, root.left.left.left, root.left).data);

		System.out.println(getDistRoot(root, root.left.right.left));
		System.out.println(counter);
		level(tree.root);
		PrintParents(root, 19);

	}
}
