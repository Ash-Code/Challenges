package theory.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Merge {
	static StreamTokenizer st;
	static BufferedReader bf;

	public static ArrayList<Integer> MergeSort(ArrayList<Integer> a) {
		
		
		
		return null;
		

	}

	public static void main(String args[]) throws IOException {
		ArrayList<Integer> a = new ArrayList<Integer>();

		st = new StreamTokenizer(bf = new BufferedReader(new FileReader(
				"C:/data2.txt")));
		while ((int)st.nval != -1) {
			st.nextToken();
			a.add((int) st.nval);

		}

		a =MergeSort(a);
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

}
