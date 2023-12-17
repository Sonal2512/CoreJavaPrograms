package javaPackage;

public class MultiplicationTable{
	
	public void table(int value, int from, int to){
		for(int i=from;i<=to;i++) {
	    	 System.out.println(value*i);
	    	 
	     }
	}
	public static void main(String[] args) {
		// simple program for table of 5
     for(int i=1;i<=10;i++) {
    	 System.out.println(5*i);
     }
     
     System.out.println("***************");
     
     //generic table by passing values
     MultiplicationTable x= new MultiplicationTable();
     x.table(7, 11, 20);
    	 
     }
   
    
	}
	
	


