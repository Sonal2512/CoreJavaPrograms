package javaPackage;

public class FebonacciSeries {
	
	public int febonacci(int n){
		if (n<=1) 
			return n;
		else
			return febonacci(n-1)+febonacci(n-2);
		
	}
	

	public static void main(String[] args) {
		
		FebonacciSeries temp= new FebonacciSeries();
		
		for(int i=0; i<=5; i++) {
			
			System.out.print(temp.febonacci(i));
			System.out.print("\t");
			}
		}

	
}

