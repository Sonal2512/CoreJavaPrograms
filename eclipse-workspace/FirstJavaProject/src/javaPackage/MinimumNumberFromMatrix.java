package javaPackage;

public class MinimumNumberFromMatrix {

	public static void main(String[] args) {
		/* 2 4 5
		   3 4 7
		   1 2 9
		 */
		int abc[][]= {{2,4,5},{3,4,5},{1,2,9}};
		
		int min=abc[0][0]; //just assume that first number of the matrix is the minimum number
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				
				if((abc[i][j])<min) {
					min=abc[i][j];
				}
				
			}
		}
		System.out.println("mMinimum number of the matrix:"+min);
		
		//maximum number of the matrix
				
		int max=abc[0][0]; //just assume that first number of the matrix is the minimum number
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				
				if((abc[i][j])>max) {
					max=abc[i][j];
				}
				
			}
		}
		System.out.println("maximum number of the matrix:"+max);
	}

}
