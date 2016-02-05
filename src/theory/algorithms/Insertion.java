package theory.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Insertion {
	static StreamTokenizer st;
	static BufferedReader bf;

	public static ArrayList<Integer> InsertionSort(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			int j = i;
			int key = a.get(i);
			while (j > 0 && a.get(j - 1) > key)
				j--;
			for (int k = i; k > j; k--)
				a.set(k, a.get(k - 1));

			a.set(j, key);

		}

		return a;

	}

	public static void main(String args[]) throws IOException {
		ArrayList<Integer> a = new ArrayList<Integer>();

		st = new StreamTokenizer(bf = new BufferedReader(new FileReader(
				"C:/data2.txt")));
		st.nextToken();
		while ((int)st.nval != -1) {
			
			a.add((int) st.nval);
			st.nextToken();

		}

		a = InsertionSort(a);
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

}
