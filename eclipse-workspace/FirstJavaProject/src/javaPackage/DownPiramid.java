package javaPackage;

public class DownPiramid {

	public static void main(String[] args) {
		int k=1;
		
		for(int i=1;i<=4;i++) {
			
			for(int j=1; j<=5-i; j++){
			
				System.out.print(k);
				System.out.print("\t");
				k++;
				
			}
			System.out.println();
			
		}
		System.out.println("*************");
       for(int i=1;i<=4;i++) {
			
			for(int j=1; j<=5-i; j++){
			
				System.out.print(j);
				System.out.print("\t");
			
				
			}
			System.out.println();
			
		}
       System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
       //printing stars
       
       for(int i=1;i<=4;i++) {
			
			for(int j=1; j<=5-i; j++){
			
				System.out.print("*");
				System.out.print("\t");
			
				
			}
			System.out.println();
		}

	}
}

