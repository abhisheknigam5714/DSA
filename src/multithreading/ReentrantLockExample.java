package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	
	Lock lock= new ReentrantLock();
	
	
	
	public void innermethod() {
		lock.lock();
	}

}
