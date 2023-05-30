package javaTester;

import java.util.Scanner;

public class JavaTopic06_For_ForEach {
	
	public static void main(String[] args) {
		
		//Ex1();
		//Ex2();
		//Ex3();
		//Ex4();
		//Ex5();
		//Ex6();
		//Ex7();
		
	}
	public static void Ex1 () {
//		1 - Viết chương trình nhập vào từ bàn phím số nguyên n và hiển thị ra các số từ 1 tới n mỗi số cách nhau bởi 1 khoảng trắng
//		· Ví dụ nếu nhập n = 10 thì chương trình sẽ hiển thị ra:
//		· 1 2 3 4 5 6 7 8 9 10

		Scanner scanner = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = scanner.nextInt();
		for (int i = 1; i<n ; i++) {
			System.out.print(i + " ");
		}	
	}
	public static void Ex2() {
//		
//		 2 - Cho số nguyên a và b được nhập vào từ bàn phím - hãy viết chương trình hiển thị ra màn hình các số từ a tới b
//		 · Ví dụ nếu nhập a = 5 và b = 9 thì chương trình sẽ hiển thị ra màn hình:
//		 · 5 6 7 8 9
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a & b: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int n = scanner.nextInt();
		for( int i=0 ;i < n;i++ ) {
			if(i>=a && i <=b)
			System.out.print(i + " ");
		}
		
	}
	public static void Ex3() {
//		
//		3 - Viết chương trình in ra console tổng các số chẵn từ dãy số nguyên có độ lớn từ 1 đến 10
//		· Lưu ý kiểm tra một số chẵn bằng cách thực hiện phép chia dư số đó với 2 - nếu kết quả phép chia dư là 0 thì đó là số chẵn
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = scanner.nextInt();
		int sum = 0;
		for(int i=1; i<=n; i++)
		{
			if(i%2==0)
			{
				System.out.println(i+ "");
				sum+=i;
			
			}
		
		}

		System.out.println("Sum: "+sum);
	}
	public static void Ex4() {
//		
//		4 - Viết chương trình nhập vào từ bàn phím số nguyên a và b - hiển thị ra màn hình tổng các số từ a tới b
//		· Ví dụ nếu nhập a = 5 và b = 9 thì chương trình sẽ hiển thị ra màn hình:
//		· 35
//		· Giải thích: 5 + 6 + 7 + 8 + 9 = 35
		
		
	}
	public static void Ex5() {
//		
//		5 - Viết chương trình nhập vào từ bàn phím số nguyên n và thực hiện hiển thị ra tổng các số lẻ từ 0 tới n
//		· Ví dụ nếu nhập n = 7 thì chương trình sẽ hiển thị ra màn hình:
//		· 16
//		· Giải thích: 1 + 3 + 5 + 7 = 16
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = scanner.nextInt();
		int sum = 0;
		for(int i=1; i<=n; i++)
		{
			if(i%2!=0)
			{
				System.out.println(i+ "");
				sum+=i;
			
			}
		
		}

		System.out.println("Sum: "+sum);
		
	}
	public static void Ex6() {
//		
//		6 - Viết chương trình nhập vào từ bàn phím số nguyên a và b. Sau đó hiển thị ra màn hình các số chia hết cho 3 từ a tới b:
//			· Ví dụ nếu nhập a = 1 và b = 20 thì chương trình sẽ hiển thị ra màn hình:
//			· 3 6 9 12 15 18


		
	}
	public static void Ex7() {
//		
//		7 - Viết chương trình nhập từ bàn phím số nguyên n và hiển thị ra màn hình n! (n giai thừa)
//		· Ví dụ nếu nhập n = 5 thì chương trình sẽ hiển thị ra màn hình:
//		· 120
//		· Giải thích: 1 * 2 * 3 * 4 * 5 = 120

		Scanner scanner = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = scanner.nextInt();
		int answer = 1;
		for(int i=1; i<=n; i++)
		{
			answer*= i;
		}

		System.out.println("Giai thua: "+answer);
	}
	
	
	
}
	
	
	
	
	
	

