package Mathematics;

public class EuclideanAlgo {
	public static void main(String[] args) {
	       int num1=50;
	       int num2=25;
	       while(num1>0&& num2>0){
	           if(num1>num2) num1=num1%num2;
	           else num2=num2%num1;
	           if(num1==0){
	               System.out.println(num2);
	               break;
	           }
	           if(num2==0){
	               System.out.println(num1);
	               break;
	           }
	       
	    }
}
}
