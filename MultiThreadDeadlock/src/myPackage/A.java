package myPackage;

public class A {
	public synchronized void m(B b) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" started execution of m1 method");
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getName()+" trying to call B's last method");
		b.last();
	}
	public synchronized void last(){
		System.out.println("Inside A's last method");
	}
}
