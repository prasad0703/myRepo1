package myPack;
import java.util.*;

//Method level generics
public class MyMain {

	public static void main(String[] args) {
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("a");
		//generic object passed to non generic area
		m1(a1);
		System.out.println(a1);
		//generics concept only at compile time
		ArrayList l = new ArrayList<String>();
		l.add("String");
		l.add(1);
		l.add(true);
		System.out.println(l);
		
	}
	//non generic method
	public static void m1(ArrayList al) {
		//allowed to add any object
		al.add(10.2);
	}
	
	
	//all bounded types as class level can be applied at method level
	public <T extends Number> void m() {}
	
	//below code not compiled as it's having same erasure
	//public static void a(ArrayList<String> a) {}
	//public static void a(ArrayList<Integer> a) {}
	
}

