package javaTester;

import java.util.Scanner;

public class JavaTopic04_If_Else {
	
	
	public static void main(String[] args) {
//		BT1();
//		BT2();
//		BT3();
//		BT4();
//		BT5();
//		BT6();
//		BT7();
		BT4();
		
	}

	public static void BT1() {
//		1 - Viết chương trình nhập vào từ bàn phím số nguyên n
//		· Sau đó kiểm tra xem nếu n là số chẵn thì hiển thị ra:
//		· n là số chẵn
//		· Ngược lại nếu n là số lẻ thì hiển thị ra:
//		· n là số lẻ
		Scanner scanner = new Scanner(System.in);
		System.out.print("BT1-Input n: ");
		int n = scanner.nextInt();
		System.out.println("n: " +n);
		if(n%2 == 0) {
			System.out.println("n là số chẵn");
		}else {
			System.out.println("n là số lẻ");
		}
		
	}
	
	public static void BT2() {
//		 2 - Viết chương trình nhập vào từ bàn phím số 2 nguyên a và b. Sau đó hiển thị ra màn hình:
//		 · Nếu a lớn hơn hoặc bằng b thì hiển thị ra:
//		 · a lớn hơn hoặc bằng b
//		 · Ngược lại nếu a nhỏ hơn b thì hiển thị ra:
//		 · a nhỏ hơn hoặc bằng b
		Scanner scanner = new Scanner(System.in);
		System.out.println("BT2-Input a&b: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println("a: "+a+"\n" +"b: "+b);
		if(a > b) {
			System.out.println("a lớn hơn hoặc bằng b");
		}else {
			System.out.println("a nhỏ hơn hoặc bằng b");
		}
	}
	
	public static void BT3() {
//		3 - Viết chương trình nhập vào tên của 2 người, bạn hãy kiểm tra xem tên của 2 người này có giống nhau không
//		· Nếu có thì hiển thị ra:
//		· 2 người là cùng tên
//		· Ngược lại nếu tên của 2 người này không giống nhau thì hiển thị ra:
//		· 2 người là khác tên
		Scanner scanner = new Scanner(System.in);
		System.out.println("BT3-Input name1 & name2: ");
		String name1 = scanner.next();
		String name2 = scanner.next();
		System.out.println("Name 1: "+name1+"\n" +"Name 2: "+name2);
		if(name1.equals(name2)) {
			System.out.println("2 người là cùng tên");
		}else {
			System.out.println("2 người là khác tên");
		}
	}

	public static void BT4() {
//		4 - Viết chương trình nhập từ bàn phím 3 số nguyên. Sau đó hiển thị lên màn hình số lớn nhất trong 3 số này
//		· Ví dụ nếu bạn nhập:
//		· 4 7 3
//		· Màn hình sẽ hiển thị ra:
//		· 7
		Scanner scanner = new Scanner(System.in);
		System.out.print("BT4-Input số phần tử của mảng: ");
		int n  = scanner.nextInt();
		int [] arr = new int[n];
		System.out.print("BT4-Input phần tử của mảng: \n");
		for (int i=0; i<n; i++)
		{
			//System.out.println("a[%d] = " + i);
			arr[i] = scanner.nextInt();
		}
		int max = arr[0];
		
	
		for (int i = 0; i<n; i++)
		{
			if(max < arr[i])
				max = arr[i];
			
		}
		System.out.print("Max = ");
		System.out.println(max);
	}
	public static void BT5() {
//		5 - Viết chương trình nhập từ bàn phím số nguyên a. Bạn hãy kiểm tra xem a có nằm trong đoạn [10, 100] không
//		· Nếu có thì hiển thị ra màn hình:
//		· {P} nằm trong [10, 100]
//		· Ngược lại hiển thị ra màn hình:
//		· {P} không nằm trong [10, 100]
//		· Với {P} là giá trị của biến a
 
		Scanner scanner = new Scanner(System.in);
		System.out.print("BT5-Input a: ");
		int a  = scanner.nextInt();
		if (a >=10 && a <=100)
		{
			System.out.println("a nằm trong [10, 100]");
		}else {
			System.out.println("a không nằm trong [10, 100]");
		}
	}
	
	public static void BT6() {
//		6 - Viết chương trình nhập vào điểm của sinh viên. Hãy kiểm tra xem điểm nhập vào tương ứng với loại xếp hạng nào
//		· 0 < 5               Điểm D
//		· 5 < 7.5     	      Điểm C
//		· 7.5 < 8.5           Điểm B
//		· 8.5 - 10            Điểm A
		Scanner scanner = new Scanner(System.in);
		System.out.print("BT6-Input điểm của sinh viên: ");
		float a = scanner.nextFloat();
		if (a>=0 || a<5) {
			System.out.print("Điểm D");
		}else if (a>=5 || a<7.5) {
			System.out.print("Điểm C");
		}else if (a>=7.5 || a<8.5) {
			System.out.print("Điểm B");
		}else if (a>=8.5 || a<=10) {
			System.out.print("Điểm A");
		}
	
	}
	public static void BT7() {
//		7 - Viết chương trình nhập vào một tháng, hiển thị số ngày của tháng đó
//		· Nhập tháng 1 hiển thị ra màn hình là 31
//		· Nhập tháng 2 hiển thị ra màn hình là 28
//		· ..
//		· Nhập tháng 12 hiển thị ra màn hình là 31
		Scanner scanner = new Scanner(System.in);
		System.out.print("BT7-Input tháng: ");
		int a = scanner.nextInt();
		if(a==1) {
			System.out.print(31);
		}else if (a==2){
			System.out.print(28);
		}else if (a==3){
			System.out.print(31);
		}else if (a==4){
			System.out.print(30);
		}else if (a==5){
			System.out.print(31);
		}else if (a==6){
			System.out.print(30);
		}else if (a==7){
			System.out.print(31);
		}else if (a==8){
			System.out.print(31);
		}else if (a==9){
			System.out.print(30);
		}else if (a==10){
			System.out.print(31);
		}else if (a==11){
			System.out.print(30);
		}else if (a==12){
			System.out.print(31);
		}
	}
}
