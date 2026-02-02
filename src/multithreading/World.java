package multithreading;

public class World extends Thread {

	
	@Override
	public void run() {
		for(int j=0;j<=30;j++) {
			System.out.println("World");
		}
	}
}
