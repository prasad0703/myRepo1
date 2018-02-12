package myPackage;

public class B {

	public synchronized void m(A a) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" started execution of m2 method");
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getName()+" trying to call A's last method");
		a.last();
	}
	public synchronized void last(){
		System.out.println("Inside B's last method");
	}
}
