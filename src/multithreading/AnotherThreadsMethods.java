package multithreading;


//
//class NewThread extends Thread{
//	
//	public NewThread(String name) {
//		super(name);
//	}
//	
//	@Override
//	public void run() {
//		for(int i=1;i<=5;i++) {
//			Thread.yield();
//			System.out.println(Thread.currentThread().getName()+" count"+i);
//			
//		}
//	}
//	
//}





class NewThread extends Thread{
	
	public NewThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Demon Thread");
		}
	}
	
}
public class AnotherThreadsMethods {
	
	public static void main(String[] args) {
		NewThread newThread = new NewThread("Demon");
		newThread.setDaemon(true);
		newThread.start();
		System.out.println("Main Thread");
		
		
	}

}
