package myPackage;

public class MyThread extends Thread {
	A a = new A();
	B b = new B();
	public void threadMethod() throws InterruptedException {
		this.start();
		a.m(b);
	}
	public void run() {
		try {
			b.m(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
