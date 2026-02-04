package multithreading;

/*
 * run
 * start
 * sleep
 * join
 * priority
 * setName of the Thread
 * 
 */

class MyThread extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			Thread.currentThread().setName("Abhishek");
			for(int i=1;i<=5;i++) {
				Thread.currentThread().setPriority(MAX_PRIORITY);
				System.out.println(Thread.currentThread().getName()+"count-"+i);
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
}


public class ThreadMethods {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		myThread.interrupt();
		 
	}
	
	
	

}
