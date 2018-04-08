package myPack;
import java.util.*;

//Wildcards
public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<X> a2 = new ArrayList<X>();
		ArrayList<A> a3 = new ArrayList<A>();
		m1(a1);
		m2(a1);
		m3(a2);
		m4(a3);
		//m5(a3);
		
		//**************************
		ArrayList<String> al1 = new ArrayList<String>();
		ArrayList<?> al2 = new ArrayList<String>();
		ArrayList<? extends Number> al3 = new ArrayList<Integer>();
		//ArrayList<? extends Number> al4 = new ArrayList<String>(); -->C.E
		ArrayList<? super String> al5 = new ArrayList<Object>();
		//ArrayList<?> al6 = new ArrayList<?>(); -->C.E
		//ArrayList<?> al6 = new ArrayList<? extends Number>(); -->C.E
		
	}
	
	public static void m1(ArrayList<String> al) {
		//can add string and null
	}
	public static void m2(ArrayList<?> al) {
		//cannot add anything except null, best suitable for read only
	}
	public static void m3(ArrayList<? extends X> al) {
		//cannot add anything except null, best suitable for read only
		//reason:-all children of X might have different implementations of Parent Class. Hence cannot add parent class object
	}
	public static void m4(ArrayList<? super X> al) {
		//if X is class we can call this method by passing arraylist of either X type or
		//its super classes
		//we can add X type of objects and null
		//reason:- X might have all required implementations of Parent Classes. Hence can always add child class object
	}
	public static void m5(ArrayList<? super Y> al) {
		//if Y is interface we can call this method by passing arraylist of either Y type or
		//super classes of implementation class of Y
		//we can add Y type of objects and null
	}

}
class A{}
class X extends A{}
interface Y{}
class Z extends A implements Y{}
