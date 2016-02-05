package theory.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class prac3 {
	static int b;
	static String number, res;
	static ArrayList<String> word = new ArrayList<String>();

	public static void input() throws IOException {

		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new FileReader("C:/data2.txt")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		st.nextToken();

		while (st.nval != -1) {

			number = Long.toString((long) st.nval);
			System.out.println(number);
			st.nextToken();

			b = (int) st.nval;
			System.out.println(b);
			int i = 0;
			
			while (i < b) {
				st.nextToken();

				word.add((String) st.sval);
				System.out.println(word.get(i));
				i++;

			}
			System.out.println(number.length());
			System.out.println(solve(number, b, word));
			word.clear();
			st.nextToken();

		}

	}

	public static String solve(String number, int b, ArrayList<String> word) {

		boolean matching = true;
		boolean hit = true;
		boolean checker = false;
		ArrayList<String> converted = new ArrayList<String>();
		converted.clear();
		String result = "";

		String iresult = "";
		for (int i = 0; i < b; i++) {

			converted.add(converter(word.get(i)));

		}
		int pos = 0;

		while (pos < number.length() && hit) {
			hit = false;
			checker = false;
			iresult = "";
			for (int i = 0; i < b; i++) {

				if (converted.get(i).length() < (number.length() - pos +1) ) {
					if(pos>0){
						System.out.println(converted.get(i) + " " + converted.get(i).length() + " pos : "+ pos + " space " + (number.length()-pos));
					}
					matching = converted.get(i).equals(
							number.substring(pos, pos + converted.get(i).length() ) );
					if (matching) {
						if (converted.get(i).length() > iresult.length()) {
							iresult = word.get(i);
							hit = true;
						}
					}

					if (i == b - 1 && hit && pos < number.length()) {
						result += iresult + " ";
						pos = pos + (int) iresult.length();

						checker = true;
					}

					System.out.println(matching + " " + pos + " i =  " + i + " hit " + hit + " check " + checker);

				}
			}
			
			
		}
		if (pos == number.length())
			return result;
		else {

			System.out.println(result);
			System.out.println(pos);
			return "no solution";
		}
	}

	public static String converter(String s) {
		String conv = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'i' || s.charAt(i) == 'j')
				conv += "1";
			else if (s.charAt(i) == 'a' || s.charAt(i) == 'b'
					|| s.charAt(i) == 'c')
				conv += "2";
			else if (s.charAt(i) == 'd' || s.charAt(i) == 'e'
					|| s.charAt(i) == 'f')
				conv += "3";
			else if (s.charAt(i) == 'g' || s.charAt(i) == 'h')
				conv += "4";
			else if (s.charAt(i) == 'k' || s.charAt(i) == 'l')
				conv += "5";
			else if (s.charAt(i) == 'm' || s.charAt(i) == 'n')
				conv += "6";
			else if (s.charAt(i) == 'p' || s.charAt(i) == 'r'
					|| s.charAt(i) == 's')
				conv += "7";
			else if (s.charAt(i) == 't' || s.charAt(i) == 'u'
					|| s.charAt(i) == 'v')
				conv += "8";
			else if (s.charAt(i) == 'w' || s.charAt(i) == 'x'
					|| s.charAt(i) == 'y')
				conv += "9";
			else
				conv += "0";
		}

		return conv;

	}

	public static void main(String[] args) throws IOException {
		input();
	}

}
