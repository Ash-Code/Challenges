package theory.datastructures;

public class Implementing {
public static void main(String args[]){
	Trie dict=new Trie();
	  dict.add("are");
      dict.add("area");
      dict.add("base");
      dict.add("cat");
      dict.add("cater");        
      dict.add("basement");
      
      String input = "caterer";
      System.out.print(input + ":   ");
      System.out.println(dict.longestPrefix(input));              

      input = "basement";
      System.out.print(input + ":   ");
      System.out.println(dict.longestPrefix(input));                      
       
      input = "are";
      System.out.print(input + ":   ");
      System.out.println(dict.longestPrefix(input));              

      input = "arex";
      System.out.print(input + ":   ");
      System.out.println(dict.longestPrefix(input));              

      input = "basemexz";
      System.out.print(input + ":   ");
      System.out.println(dict.longestPrefix(input));                      
       
      input = "xyz";
      System.out.print(input + ":   ");
      System.out.println(dict.longestPrefix(input));      
       
}
}
