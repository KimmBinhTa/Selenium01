package javaTester;

import java.util.Scanner;

public class JavaTopic05_Switch_Case {
	
	public static void main(String[] args) {
		
		Ex1();
	//	Ex2();
		Ex3();
		
	}
	

	public static void Ex1() {
//		1 - Viết chương trình in ra tên các chữ số nhập vào bằng tiếng Anh - các số này là 1 trong các số nguyên từ 1 đến 10. 
//		· Ví dụ gán a bằng 1 thì chương trình chạy sẽ in ra “One”, gán a = 2 thì in ra “Two”
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("BT1-Input n: ");
		int n = scanner.nextInt();
		
		switch(n) {
		case(1):
			System.out.println("One");
			break;
		case(2):
			System.out.println("Two");
			break;
		case(3):
			System.out.println("Three");
			break;
		case(4):
			System.out.println("Four");
			break;
		case(5):
			System.out.println("Five");
			break;
		case(6):
			System.out.println("Six");
			break;
		case(7):
			System.out.println("Seven");
			break;
		case(8):
			System.out.println("Eight");
			break;
		case(9):
			System.out.println("Nine");
			break;
		case(10):
			System.out.println("Ten");
			break;
		default:
			break;
		}
		
	}
	
	//public static void Ex2() {
////		2 - Nhập vào 2 số nguyên a và b - nhập vào phép toán +, -, *, /, %
////		· Thực hiện tính toán theo phép toán nhập vào với hai số a, b và in ra kết quả
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("BT2-Input a & b: ");
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
//		String logical = scanner.next();
//		switch() {
//		
//		}
//	}
	public static void Ex3() {
//		· Nhập tháng 1 hiển thị ra màn hình là 31
//		· Nhập tháng 2 hiển thị ra màn hình là 28
//		· ..
//		· Nhập tháng 12 hiển thị ra màn hình là 31
		Scanner scanner = new Scanner(System.in);

		System.out.print("Input month: ");
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 12:
			System.out.println(31);
			break;
		case 2:

			System.out.println("28||29");
			break;
		
		case 4:
		case 6:
		case 9:
		case 10:
		case 11:
			System.out.println(30);
			break;

		default:
			break;
		}
		
		
	}
}
