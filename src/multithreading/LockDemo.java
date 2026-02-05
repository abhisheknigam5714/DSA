package multithreading;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
class BankAccount {
	public int balance = 100;

	public synchronized void  withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + "attempting to withdraw......" + amount);
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + "Withdraw in process.....");
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.getMessage();
		}
		balance -= amount;
		System.out.println(
				Thread.currentThread().getName() + "Withdraw complted...." + "Remaining Balance....." + balance);
	}

}


*/

class BankAccount {
	public int balance = 100;
	Lock lock = new ReentrantLock();

	public void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + "attempting to withdraw......" + amount);
		try {
			if (lock.tryLock(1000,TimeUnit.MILLISECONDS)) {
				if (balance >= amount) {
					try {
						System.out.println(Thread.currentThread().getName() + "Withdraw in process.....");
						Thread.sleep(2000);
						balance -= amount;
						System.out.println(Thread.currentThread().getName() + "Withdraw complted...."
								+ "Remaining Balance....." + balance);
					} catch (Exception e) {
						e.getMessage();
					} finally {
						lock.unlock();// free the resources
					}

					
				}
				else {
					System.out.println("Insufficient Balance...");
				}

			}
			else {
				System.out.println("Could not acqire the lock.by."+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
		
			Thread.currentThread().interrupt();
		}
		
		if(Thread.currentThread().isInterrupted()) {
			System.out.println("Thread is interuupted........and you can perform any task");
		}

	}

}

public class LockDemo {
	public static void main(String[] args) {
		BankAccount sbi = new BankAccount();

		Runnable task = new Runnable() {

			@Override
			public void run() {
				sbi.withdraw(25);
				
			}
		};
		Thread t1 = new Thread(task, "thred-1");
		Thread t2 = new Thread(task, "thred-2");
		t1.start();
		t2.start();
	}
}
