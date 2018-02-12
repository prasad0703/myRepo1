package myPack;

public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<String> myStr = new Gen<String>("Prasad");
		Gen<Integer> myInt = new Gen<Integer>(10);
		myStr.printObjectClass();
		System.out.println(myStr.getObjectValue());
		myInt.printObjectClass();
		System.out.println(myInt.getObjectValue());
	}

}

class Gen<T>{
	T a;
	public Gen(T a) {
		this.a = a;
	}
	public void printObjectClass() {
		System.out.println("Object belongs to class:"+a.getClass().getName());
	}
	public T getObjectValue() {
		return a;
	}
}