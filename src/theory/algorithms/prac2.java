package theory.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class prac2 implements Comparable {
	public String name;
	public String lastName;

	public prac2(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() {
		return name;

	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public int compareTo(Object obj) {
		prac2 p = (prac2) obj;
		return this.name.compareTo(p.getName());
	}

	public static void main(String arg[]) {
		List<prac2> myList = new ArrayList<prac2>();

		myList.add(new prac2("Robert", "USA"));
		myList.add(new prac2("Andy", "UK"));
		myList.add(new prac2("Harish", "India"));
		Collections.sort(myList);

		for (prac2 prac2 : myList) {
			System.out.println("My name is " + prac2.getName());
		}
	}
}