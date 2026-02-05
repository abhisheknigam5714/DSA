package multithreading;
import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteExample {

	private int balance = 100;

	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	private final Lock readLock = lock.readLock();

	private final Lock writeLock = lock.writeLock();

	public void increase(int balance) {
		writeLock.lock();
		try {
			this.balance = this.balance + balance;
		} catch (Exception e) {
			e.toString();
		} finally {
			writeLock.unlock();
		}
	}

	public int getBalance() {
		readLock.lock();
		try {
			return balance;
		}
		catch(Exception e) {
			e.toString();
		}
		finally {
			readLock.unlock();
		}
		return balance;
	}

	public static void main(String[] args) {

		ReadWriteExample example = new ReadWriteExample();
		Runnable readtask = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i <= 5; i++) {
					example.getBalance();
				}

			}
		};

		Runnable writeTask = new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 5; i++) {
					example.increase(5);
				}

			}
		};

		Thread thread = new Thread(writeTask);
		Thread thread2 = new Thread(readtask);

		thread.start();
		thread2.start();
		try {
		thread.join();
		thread2.join();
		}
		catch(Exception e) {
			e.toString();
		}
	}

}
