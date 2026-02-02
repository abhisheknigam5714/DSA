package multithreading;

public class Demo {
	
	public static void main(String[] args) {
		
	//	World world= new World();
	//	world.start();
		
		World2 world2= new World2();
		Thread thread= new Thread(world2);
		thread.start();
		
		
		for(int i=0;i<=20;i++) {
			System.out.println("Hello");
		}
	}

}
