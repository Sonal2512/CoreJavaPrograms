package javaPackage;

public class ReverseTheString {

	public static void main(String[] args) {
		// Print the string in reverse order
		
		String s= "enola";
		String t=""; //defining empty string
		
		for(int i=s.length()-1;i>=0;i--) {
			t=t+s.charAt(i); //concatenating s with t string
			
		}
		System.out.println(t);

	}

}
