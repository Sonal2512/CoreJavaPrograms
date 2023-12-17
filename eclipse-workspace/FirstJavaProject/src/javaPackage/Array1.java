package javaPackage;

public class Array1 {

	public static void main(String[] args) {
		//declaration type 1
		int a[]= {1,20,35};//memory is dynamically allocated so we can add/delete the values
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		//Declaration type 2
		
		String b[]= new String[3];
		b[0]= "Hello";
		b[1]= "World";
		b[2]= "ok";
		
		for(int i=0;i<b.length;i++) {
			System.out.println(b[i]);
		}

		//Reverse the array a[]
		
		for (int i=a.length-1;i>=0;i--) {
			System.out.println(a[i]);
		}
	}

}
