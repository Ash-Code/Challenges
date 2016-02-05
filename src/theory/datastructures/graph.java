package theory.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class graph {

	public static class listGraph {
		int x;

		listGraph link;

		public int costFunc(listGraph x, listGraph y) {
			if (x.link == y)
				return 1;
			else
				return 0;
		}

	}

	public static class Airport {
		ArrayList<Airport> ports;
		String name;
		boolean visited = false;

		public Airport(String name) {
			this.name = name;
			ports = new ArrayList<Airport>();
			ports.clear();

		}

		public int costFunction(Airport x, Airport y) {
			return 0;
		}

	}

	public static class Tree {

		Tree left, right;
		int data;

		public int costFunc(Tree x, Tree y) {
			if (x.left == y)
				return 1;
			if (x.right == y)
				return 2;
			else
				return 0;
		}

	}

	public static void bfs(Airport h) {
		LinkedList<Airport> q = new LinkedList<Airport>();
		q.add(h);
		Airport top = h;
		while (!q.isEmpty()) {

			top = q.removeFirst();
			System.out.println(top.name);
			
			for (int i = 0; i < top.ports.size(); i++) {
				if (!top.ports.get(i).visited){
					top.ports.get(i).visited = true;
					q.add(top.ports.get(i));
				}
			}

		}

	}

	public static void dfs(Airport h) {
		Stack<Airport> s = new Stack<Airport>();
		s.push(h);
	 Airport top;
		while(!s.isEmpty()){
			top = s.pop();
			System.out.println(top.name);
		// don't mark visited here when they are popped off coz they might already be on the stack i.e. visited.
			for(int i=0;i<top.ports.size();i++){
				if(!top.ports.get(i).visited){
					//mark them visited here while adding
					top.ports.get(i).visited = true;
				s.push(top.ports.get(i));
				
				}
			}
			
		}
	}

	public static void display(Airport h) {

		if (h.ports.isEmpty()) {
			System.out.println(h.name);

		}

		if (!h.ports.isEmpty()) {
			int i = 0;
			System.out.println(h.name);
			while (i < h.ports.size()) {
				display(h.ports.get(i));
				i++;
			}

		}
	}

	public static void main(String args[]) {

		Airport h = new graph.Airport("main");
		Airport b = new graph.Airport("bermuda");
		Airport c = new graph.Airport("Ceon");
		Airport d = new graph.Airport("denmark");
		Airport e = new graph.Airport("eiffel");
		Airport f = new graph.Airport("france");
		Airport g = new graph.Airport("Goa");

		h.ports.add(b);
		h.ports.add(c);
		c.ports.add(b);
		b.ports.add(c);
		c.ports.add(d);
		h.ports.add(f);
		h.ports.add(g);

		bfs(h);
		

		listGraph head, B = null, C = null;
		head = new graph.listGraph();
		B = new graph.listGraph();
		C = new graph.listGraph();
		head.link = B;
		B.link = C;
		C.link = null;

	}

}
