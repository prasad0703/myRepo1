package myPackage;

public final class Singleton {
	
	public static Singleton singleton = new Singleton();
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public void testMe() {
		System.out.println("Hey.. it's working!!");
	}

}
