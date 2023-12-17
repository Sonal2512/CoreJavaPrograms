package javaPackage;

import java.util.Scanner;

public class PrimeNumber {

	
	public static int mainLogic(int number){
		
		for(int i=2;i<=number-1;i++) {
			if(number%i==0){
				System.out.println("the number is not a prime number");
				break;
			}
			else
				System.out.println("the number is a prime number");
			break;
		}
		return number;
	}	
	
	public static int allPrimeNumbers(int number){
		
		for(int i=2;i<=number-1;i++) {
		
		}
		return number;
	}
	public static void main(String[] args) {
		
		//Check if given number is prime or not
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number=");
		
		int number= scanner.nextInt();
		mainLogic(number);
		allPrimeNumbers(number);
		
		}
		}
		
	


