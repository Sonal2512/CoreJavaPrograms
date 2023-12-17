package RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;        //for assertion compare equalTo command

import org.testng.Assert;

import files.Payload;

public class Basics {

	public static void main(String[] args) {
		
		//Validate if Add Place API is working as expected-->Update place with new address-->Get place to validate if new address is present in the response
    
		//given - all input details
		//when - submit the API (resource, http method)
		//Then- validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").      //fetching body data from Payload class present in files package
		body(Payload.addPlace()).when().post("maps/api/place/add/json")                     //resource in when method
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))      //all applicable assert response validation
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();                                        //extracting response in a string--> storing response in a string variable so no need to add log().all()  
	
		System.out.println(response);
		//use JsonPath class to extract the things from response, her ewe are extracting placeId bcoz it is needed for other validations
		
		JsonPath js=new JsonPath(response);  //for parsing json
		String placeId= js.getString("place_id");
		System.out.println(placeId);
		
		//Update place
		
		String newAddress = "70 Summer walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").      //fetching body data from Payload class present in files package
		body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"                          //use concatenation operator (+) at starting and ending to read it as variable not string
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json")                     //resource in when method
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get place
		String getPlaceResponse= given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1=new JsonPath(getPlaceResponse);  //for parsing json
		String actualAddress= js1.getString("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);   //requires TestNG 
		
	}
	

}
