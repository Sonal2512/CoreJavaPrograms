package javaPackage;

public class MaxNumberOfMin_Mattrix {

	public static void main(String[] args) {
		// Find max number present in the same column of the min number of the matrix
		
		/* 2 4 5
		   3 4 7
		   1 2 9
		 */
		
		//First find out the column of the minimum number
		int abc[][]= {{2,4,5},{3,4,5},{1,2,9}};
		
		int min=abc[0][0]; //just assume that first number of the matrix is the minimum number
		int minColumn=0;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				
				if((abc[i][j])<min) {
					min=abc[i][j];
					minColumn=j;
				}
				
			}
		}
		int max=abc[0][minColumn];
		int k=0;
		while (k<3) {
			if (abc[k][minColumn]>max) {
				max=abc[k][minColumn];
			}
			k++;
		}
	
		System.out.println("mMinimum number of the matrix:"+min);
		System.out.println("Max number of the column:"+max);
	}
	
}
