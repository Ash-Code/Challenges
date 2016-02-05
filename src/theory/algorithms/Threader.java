package theory.algorithms;

import java.util.ArrayList;

public class Threader {

	public static void main(String args[]){
	
		StatClass test=new StatClass();
		StatClass test2=new StatClass();
	test.x1++;
	StatClass.x1++;
	test2.x1++;
	test2.list=new ArrayList<Integer>();
	test2.list.add(4);
	System.out.println(test.x1+" "+StatClass.x1+" "+test2.x1+" "+test.list);
		
		
	}
	
	
}
