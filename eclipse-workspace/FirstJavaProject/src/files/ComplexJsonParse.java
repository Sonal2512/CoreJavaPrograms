package files;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	public static void main(String[] arg) {
	JsonPath js=new JsonPath(Payload.coursePrice());
	
	//Print number of courses returned by API
	
	int count=js.getInt("courses.size()"); //array size
	System.out.println(count);
	
	//Print purchase amount
	int totalAmount=js.getInt("dashboard.purchaseAmount"); //direct value
	System.out.println(totalAmount);
	
	//Print title (attribute) of first course
	
	String titleFirstCourse = js.get("courses[0].title");
	System.out.println(titleFirstCourse);
	
	//Print All course titles and their respective Prices
	
	for(int i=0; i<count; i++) {
		String courseTitles=js.get("courses["+i+"].title");   //needs to provide return type so adding value in string variable
		System.out.println(js.get("courses["+i+"].price"));   
		System.out.println(courseTitles);
	}
	
	//Print no of copies sold by RPA Course
	
	for(int i=0; i<count; i++) {
		
		String courseTitles=js.get("courses["+i+"].title"); 
		if(courseTitles.equalsIgnoreCase("RPA")) 
		{
			int copies= js.get("courses["+i+"].copies");
			System.out.println(copies);
			break;
		}
		
	}
	
	//Verify if Sum of all Course prices matches with Purchase Amount
	
	}
}
		
