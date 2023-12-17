package javaPackage;

public class StringManupulations {

	public static void main(String[] args) {
		// define string, string is not only a data type but a inbuilt class in java
		
		//String literal
		String a= "Hello World";// this variable will also act as an object, no need to create an object separately as below.
		
		//By creating object of string class
		//String a=new String(); //this is useful to distinguish when the another string variable has same value.
		
		System.out.println(a.charAt(8));
		System.out.println(a.indexOf("W"));
		System.out.println(a.indexOf("g")); //when the character is not present in the string it gives -1 as an output
		System.out.println(a.substring(2, 7));
		System.out.println(a.substring(5));
		System.out.println(a.concat("!!How are you!!"));
		System.out.println(a.length());//length
		System.out.println(a.trim());
		System.out.println(a.toLowerCase());
		System.out.println(a.toUpperCase());
		String b[]=a.split("o"); //o is there for 2 times so it has split the string in 3 parts ow it normally split in 2 parts only
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
		System.out.println(a.replace("H","F"));
	}

}
 