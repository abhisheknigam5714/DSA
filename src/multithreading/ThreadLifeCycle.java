package multithreading;

import java.util.Iterator;

public class ThreadLifeCycle  extends Thread{
	@Override
	public void run() {
		System.out.println("Run method");
		try {
			Thread.sleep(4000);
			System.out.println("sleeped cycle");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadLifeCycle cycle= new ThreadLifeCycle();
		System.out.println(Thread.currentThread().getState());
		System.out.println(cycle.getState());
		cycle.start();
		
		cycle.join();
		System.out.println("sleeped main");
		Thread.sleep(3000);
		
		System.out.println(cycle.getState());
		

	}
}
