package javaPackage;

public class SortingOfArray {

	public static void main(String[] args) {
		
		int a[]= {2,6,1,4,9};
		
		for(int i=0;i<a.length;i++) {
			
			for(int j=i+1;j<a.length;j++) {
				
				if(a[i]>a[j]){
					
					//Swap
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		
		//Retrieve Array values
		for(int i=0;i<a.length;i++) {
		System.out.println(a[i]);
		}

	}

}
