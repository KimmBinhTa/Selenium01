package javaTester;

import java.util.Scanner;

public class JavaTopic02Datatype {
	public static void main(String[] args) {
			
			Ex1();
			Ex2();
			Ex3();
			
		}

	public static void Ex1() {
	/*Viết chương trình tạo ra 2 biến a và b kiểu số nguyên, sau đó gán giá trị cho a = 6, b = 2 
		//và hiển thị ra màn hình thông tin sau:
		· a + b = {P1}
		· a - b = {P2}
		· a * b = {P3}
		· a / b = {P4}
		· Trong đó:
		· {P1} là tổng của a và b
		· {P2} là hiệu của a và b
		· {P3} là tích của a và b
		· {P4} là thương của a và b*/
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input number a: ");
		int a = scanner.nextInt();
		System.out.println("a = "+a);
		
		System.out.print("Input number b: ");
		int b = scanner.nextInt();
		System.out.println("b = "+b);
		
		int P1 = a+b;
		System.out.println("Sum a&b:" +P1);
		int P2 = a-b;
		System.out.println("Difference a&b:" +P2);
		int P3 = a*b;
		System.out.println("Product a&b:" +P3);
		int P4 = a/b;
		System.out.println("Quotient a&b:" +P4);
		
		
	}
	
	public static void Ex2() {
		/*Cho trước hình chữ nhật có chiều dài và chiều rộng lần lượt là 7.5 và 3.8. 
		 * Viết chương trình hiển thị diện tích của hình chữ nhật này ra màn hình giống như sau:
			· Area = {P}
			· Với {P} là diện tích của hình chữ nhật*/
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input length: ");
		float length = scanner.nextInt();
		System.out.println("length = "+length);
		
		System.out.print("Input width: ");
		float width = scanner.nextInt();
		System.out.println("width = "+width);
		
		float P = length*width;
		System.out.println("Area:"+P);
		
		
	}
	
	public static void Ex3() {
		/* Viết chương trình tạo ra biến name kiểu chuỗi các ký tự - gán giá trị cho biến name = "Automation Testing" 
		 * và thực hiện hiển thị ra màn hình dòng chữ:· Hello Automation Testing*/
		
		String name = "Automation Testing";
		System.out.println("Hello " +name );

	}
	

}
