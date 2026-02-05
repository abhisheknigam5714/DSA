package multithreading;

class Counter {
	public int count = 0;

	public synchronized void increase() {
		/*
		synchronized (this) {
			count++;
		}
		*/
		
		count++;
	}

	public int getCount() {
		return count;
	}
}

class MyThread1 extends Thread {
	public Counter count;

	public MyThread1(Counter count) {
		this.count = count;

	}

	@Override
	public void run() {
		for (int i = 0; i <= 2000; i++) {
			count.increase();
		}
	}

}

public class SyncronizationDemo {

	
	public static void main(String[] args) {
		Counter counter= new Counter();
		MyThread1 myThread= new MyThread1(counter);
		MyThread1 myThread2= new MyThread1(counter);
		myThread.start();
		myThread2.start();
		
		try {
			myThread.join();
			myThread2.join();
		}
		catch(Exception e) {
			e.getMessage();
		}
		System.out.println(counter.getCount());
	}
}
