package javaPackage;

public class SwapTheNumbers {

	public static void main(String[] args) {
		// using 3rd variable
		
		int a=5;
		int b=7;
		int temp;
		
		temp=a;
		a=b;
		b=temp;
		System.out.println("a: "+a);
		System.out.println("b: "+b);
		
		// Without using 3rd variable
		
		int c= 4;
		int d= 6;
		c=c+d;
		d=c-d;
		c=c-d;
		System.out.println("c: "+c);
		System.out.println("d: "+d);

	}

}
