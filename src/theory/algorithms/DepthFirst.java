package theory.algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirst {
	
	static boolean grid[][];
	static int aa=0;

	private static class node {
		int x, y;

		private node(int x, int y) {
			this.x = x;
			this.y = y;

		}

	}

	public static int area(boolean grid[][], int x, int y) {

		node n = new node(x, y);
		Stack<node> s = new Stack<node>();
		node top;
		int area = 0;
		s.clear();
		s.push(n);

		while (!s.isEmpty()) {
			top = s.pop();

			if (top.x > 399 || top.x < 0)
				continue;
			if (top.y > 599 || top.y < 0)
				continue;

			if (grid[top.x][top.y] == true)
				continue;

			grid[top.x][top.y] = true;
			area++;

			s.push(new node(top.x + 1, top.y));
			s.push(new node(top.x, top.y - 1));
			s.push(new node(top.x - 1, top.y));
			s.push(new node(top.x, top.y + 1));

		}

		return area;
	}

	public static int Recurse(int x, int y) {
		node n = new node(x, y);
		
		
		if(n.x<0||n.x>399 || n.y>599 || n.y<0)
			return 0;
		
		if(grid[n.x][n.y]==true)
			return 0;
		
		grid[n.x][n.y]= true;
		
		aa+= Recurse(n.x+1,n.y);
		aa+= Recurse(n.x,n.y-1);
		aa+= Recurse(n.x-1,n.y);
		aa+=Recurse(n.x, n.y+1);
		
		return aa;

	}

	public static int Bfs(boolean grid[][], int x, int y) {

		node n = new DepthFirst.node(x, y);
		int area = 0;
		LinkedList<node> q = new LinkedList<node>();
		q.clear();
		q.add(n);
		node top;
		while (!q.isEmpty()) {
			top = q.removeFirst();

			if (top.x > 399 || top.x < 0 || top.y > 599 || top.y < 0)
				continue;

			if (grid[top.x][top.y] == true)
				continue;

			grid[top.x][top.y] = true;
			area++;
			q.add(new node(top.x + 1, top.y));
			q.add(new node(top.x, top.y - 1));
			q.add(new node(top.x - 1, top.y));
			q.add(new node(top.x, top.y + 1));

		}

		return area;
	}

	public static boolean[][] marker(String coordinates[], boolean grid[][]) {
		int x1 = Integer.parseInt(coordinates[0]);
		int y1 = Integer.parseInt(coordinates[1]);
		int x2 = Integer.parseInt(coordinates[2]);
		int y2 = Integer.parseInt(coordinates[3]);

		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				grid[i][j] = true;

			}

		}
		return grid;
	}

	public static void main(String arrgs[]) throws IOException {
		BufferedWriter w = new BufferedWriter(new FileWriter("C:/grid.txt"));
		BufferedWriter w2 = new BufferedWriter(new FileWriter("C:/gridR.txt"));

		int area = 2000000;
		grid = new boolean[400][600];
		for (int i = 0; i < 400; i++) {
			for (int j = 0; j < 600; j++) {
				grid[i][j] = false;
			}
		}
		String rectangles[] = { "48 192 351 207", "48 392 351 407",
				"120 52 135 547", "260 52 275 547" };

		String Coordinates[][] = new String[rectangles.length][4];

		for (int i = 0; i < rectangles.length; i++) {

			Coordinates[i] = rectangles[i].split(" ");
			grid = marker(Coordinates[i], grid);

		}

		for (int x = 0; x < 400; x++) {
			for (int y = 0; y < 600; y++) {
				if (grid[x][y])
					w.write("1");
				else
					w.write("0");
			}
			w.newLine();
		}
		w.close();

		while (area > 0) {
			area = 0;

			for (int i = 0; i < 400; i++) {
				for (int j = 0; j < 600; j++) {
					if (grid[i][j] == false) {
						area = Bfs(grid,i, j);
						System.out.println(area);
						break;
					}

				}
			}
		}

		for (int x = 0; x < 400; x++) {
			for (int y = 0; y < 600; y++) {
				if (grid[x][y])
					w2.write("1");
				else
					w2.write("0");
			}
			w2.newLine();
		}
		w2.close();

	}

}
