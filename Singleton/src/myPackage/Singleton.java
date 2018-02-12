package myPackage;

public class Singleton {
	
	public static Singleton singleton = new Singleton();
	
	private Singleton() {}
	
	public static Singleton getSingleton() {
		return singleton;
	}
	
	public void testMe() {
		System.out.println("Hey.. it's working!!");
	}

}
