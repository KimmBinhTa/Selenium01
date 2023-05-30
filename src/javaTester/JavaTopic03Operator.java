package javaTester;

import java.util.Scanner;

public class JavaTopic03Operator {
	
	static int a;
	static int b;
	

	public static void Ex1() {
	/*1 - Viết chương trình nhập vào tên, tuổi của một người. Sau đó hiển thị ra màn hình:
		· After 15 years, age of {P1} will be {P2}
		· Với {P1} là tên của người đó, {P2} là tuổi của người đó sau 15 năm.
		· Ví dụ nếu bạn nhập:
		· Tuan 23
		· Thì màn hình sẽ hiển thị lên:
		· After 15 years, age of Tuan will be 38*/

		Scanner scanner = new Scanner(System.in);
		System.out.print("Input name: ");
		String name = scanner.next();
		System.out.println("Name: "+name);
		System.out.print("Input age: ");
		int P1 = scanner.nextInt();
		System.out.println("Age: " + P1);
		int P2=P1+15;
		System.out.println("After 15 years, age of "+ name +"will be " + P2);
		

		
	}
	
	public static void MySwap(int a1, int b1) {
	  
	        int temp = a1;                  
	        a1 = b1;             
	        b1 = temp;  
	        
	        a = a1;
	        b = b1;
	       
	    }
	public static void Input (int a1, int b1) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Input a&b: ");
		 a  = scanner.nextInt();
		 a = a1;
		 b = scanner.nextInt();
		 b = b1;
		System.out.println("a= "+a +", "+ "b= "+b);
		
	}
	
	public static void Ex2() {
	/*Cho 2 biến kiểu số nguyên a và b - viết chương trình hoán đổi giá trị của biến a và biến b. Sau đó hiển thị ra màn hình:
		· After swapping then a = {P1}, b = {P2}
		· Với {P1} và {P2} lần lượt là giá trị của a và b sau khi đã hoán đổi
		· Ví dụ nếu bạn nhập a = 3, b = 4 như bên dưới:
		· 3 4
		· Thì chương trình sẽ hiển thị ra:
		· After swapping then a = 4, b = 3*/
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Input a&b: ");
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
//		System.out.println("Before swapping: a= "+a +", "+ "b= "+b);
		Input(a,b);
		
		MySwap(a,b);
		System.out.println("After swapping: a= "+a +", "+ "b= "+b);
		

		
		
	}
	public static boolean Ex3() {
	/* 3 - Cho hai biến a và b kiểu số nguyên - viết chương trình hiển thị ra màn hình true nếu a lớn hơn b, 
	 *  ngược lại hiển thị ra false.
		· Ví dụ nếu bạn nhập a = 5, b = 4 giống như sau:
		· 5 4
		· Thì màn hình sẽ hiển thị ra:
		· true
		· Ví dụ khác, nếu bạn nhập a = 3, b = 4 giống như sau:
		· 3 4
		· Thì màn hình sẽ hiển thị ra:
		· false */
		Input(a,b);
		if (a>b) {
			System.out.println(a +""+ b);
			return false;
		}else {
			System.out.println(a +""+ b);
			return true;
		}
		

	}
	
	public static void main(String[] args) {
		
		Ex1();
		Ex2();
		Ex3();
		
	}
}
