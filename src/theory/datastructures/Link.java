package theory.datastructures;

public class Link<T> {
	T object;
	
	Link<T>next;

	public Link(T o) {
		object = o;
		
		next=null;
	}
}
