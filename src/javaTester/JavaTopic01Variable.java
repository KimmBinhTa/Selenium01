package javaTester;

public class JavaTopic01Variable {
	
	int number1 = 9;
	int aa = 1;
	int bb = 2;
	
	static int number2 = 8;
	
	public static void main(String[] args) {
		JavaTopic01Variable java1 = new JavaTopic01Variable();
		JavaTopic01Variable java2 = new JavaTopic01Variable();
		
		//L1
		java1.MethodA();
		//Number1 = 10, number2 = 9
		
		//L2
		java2.MethodB();
		
		
		//Number1(Java1) = 10 Number1(Java2) =10 		
		
	}

	public void MethodA() {
		int number3;
		number2++;
		number1++;
		System.out.println("METHOD A: ");
		System.out.println("Number1 "+ number1);
		System.out.println("Static number2 "+ number2);
		System.out.println("============================= ");
	}
	
	public void MethodB() {
		number2++;
		number1++;
		System.out.println("METHOD B: ");
		System.out.println("Number1 "+ number1);
		System.out.println("Static number2 "+ number2);
	}
}
