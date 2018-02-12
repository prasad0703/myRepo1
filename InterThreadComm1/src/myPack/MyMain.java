package myPack;

public class MyMain {

	public static void main(String[] args) throws InterruptedException {
		ThreadB b = new ThreadB();
		b.start();
		//Thread.sleep(10000);// if child thread get chance 1st then main thread will wait forever
		synchronized(b) {
			b.wait();
			//b.wait(10000);// if main thread waits forever timeout can be given
			//(no guarantee for notification then)
			System.out.println(b.total);
		}
		
	}

}
class ThreadB extends Thread{
	int total = 0;
	public void run() {
		synchronized(this) {
			for(int i = 1; i<=100; i++) {
				total = total + i;
			}
			this.notify();
		}
		
	}
	
}
