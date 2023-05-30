package javaTester;

import java.util.Scanner;

public class JavaTopic07_While_Do {
	
	public static void main(String[] args) {
		Ex1();
		//Ex2();
		//Ex3();
		//Ex4();
		//Ex5();
		//Ex6();
		
		
	}
	
	public static void Ex1() {
//		1/  Viết chương trình nhập vào bàn phím số nguyên n và hiển thị ra các số chẵn từ n tới 100
//		· Ví dụ nếu nhập n = 90 thì chương trình sẽ hiển thị ra màn hình:
//		· 90 92 94 96 98 100
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = scanner.nextInt();
		int i = 2;
		do{
			System.out.print(i+"");
			i+=2;
		}while(i>=n && i<=100);
	       
	}
	public static void Ex2() {
//		Viết chương trình nhập từ bàn phím hai số nguyên a và b. Sau đó hiển thị ra màn hình các số từ a tới b mà chia hết cho cả 3 và 5
//		· Ví dụ nếu nhập a = 1, b = 50 thì chương trình sẽ hiển thị ra màn hình:
//		· 15 30 45
		
	       
	}
	public static void Ex3() {
//		3/ Viết chương trình nhập vào từ bàn phím số nguyên n và thực hiện hiển thị ra tổng các số lẻ từ 0 tới n
//		· Ví dụ nếu nhập n = 7 thì chương trình sẽ hiển thị ra màn hình:
//		· 16
//		· Giải thích: 1 + 3 + 5 + 7 = 16
	    Scanner scanner = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = scanner.nextInt();
		int sum = 0;
		int i = 1;
	    do {
	    	if(i%2!=0)
			{
				System.out.println(i+ "");
				sum+=i;
			}
	    	i++;
	    }while(i<=n);
	    System.out.println("Sum: "+sum);
	}
	
	public static void Ex4() {
		  
//		4/  Viết chương trình nhập vào từ bàn phím số nguyên a và b. Sau đó hiển thị ra màn hình các số chia hết cho 3 từ a tới b
//		· Ví dụ nếu nhập a = 1 và b = 20 thì chương trình sẽ hiển thị ra màn hình:
//		· 3 6 9 12 15 18
	}
	public static void Ex5() {
//		5/  Viết chương trình nhập từ bàn phím số nguyên n và hiển thị ra màn hình n! (n giai thừa)
//		· Ví dụ nếu nhập n = 5 thì chương trình sẽ hiển thị ra màn hình:
//		· 120
//		· Giải thích: 1 * 2 * 3 * 4 * 5 = 120
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = scanner.nextInt();
		int answer = 1;
		int i = 1;
	    do {
    		answer*=i;
    		i++;
	    }while(i<=n);
	    System.out.println("Giai thua: "+answer);
	}
	       
	
	public static void Ex6() {
		//6/  Viết chương trình in ra console tổng các số chẵn từ dãy số nguyên có độ lớn từ 1 đến 10
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = scanner.nextInt();
		int sum = 0;
		int i = 1;
	    do {
	    	if(i%2==0)
			{
				System.out.println(i+ "");
				sum+=i;
			}
	    	i++;
	    }while(i<=n);
	    System.out.println("Sum: "+sum);
	}
	
	
	
	
}
