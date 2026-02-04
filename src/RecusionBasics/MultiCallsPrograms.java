package RecusionBasics;

public class MultiCallsPrograms {
	
	
	public static int fib(int leng) {
		if(leng==0 || leng==1) {
			return leng;
		}
		else {
			return fib(leng-1)+fib(leng-2);
		}
	}
	public static void main(String[] args) {
		
		
		System.out.println(fib(6));
	}

}
