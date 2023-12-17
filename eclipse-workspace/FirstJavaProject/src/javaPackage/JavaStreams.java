package javaPackage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) {

		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		
		//Calculate count if name starts with A by using loops
		
		int count=0;
		for(int i=0; i<names.size(); i++)
		{
			if(names.get(i).startsWith("A"))
			count++;
		}
		System.out.println("Count is: " + count);
		
	    //Calculate count if name starts with A by using streams
		//Create a streamPerform intermediate operation on the initial stream to convert it into another stream
		//Perform terminal operation to the final stream to get result. Without terminal operation no use of the intermediate operation
		//Terminal operation will return a result only if intermediate operation is "true"
		//Stream perform parallel operations instead of one by one iteration like loops
	
		long c=names.stream().filter(name->name.startsWith("A")).count(); //return type of count is long by default. It is a terminal operation.
		
		//In above sentence we are first converting ArrayList to stream and then add filter with condition and then termination command.
		//-> lambda operation
		System.out.println(c);
		
		//Create stream instead ofAarrayList
		long d=Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->        //s can be any variable name
		{
		s.startsWith("R");
		return true;     //o/p: 0 as it returns the results only when filter operation value is true. so make it true to get results.
		}).count();
		System.out.println(d);
		
		//Print the only 1 (first) name having length more than 4
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		//forEach command is used to print all the elements of the stream
		//limit generally limits the output and it is a terminal operation.
		
		//Use stream map to transform whole string and print names
		//Take out names end with a and apply upper case to them and print
		Stream.of("Abhijeet","Dona","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print manes which have first letter a and sort it
		//If array is given then first convert Arrays to List and then apply filter and sort
		List<String> students= Arrays.asList("Anay","Bela","Arnav","Yuga","Reva");
		students.stream().filter(s->s.startsWith("A")).sorted().forEach(s->System.out.println(s));
		
		//Merging of two different lists we already have i.e.names and students
		Stream<String> newStream = Stream.concat(names.stream(), students.stream());
		newStream.sorted().forEach(s->System.out.println(s)); //sort and print
		
		//Use collect() method to collect the results. Collect the stream results into the list
		List<String> is = Stream.of("Abhijeet","Dona","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());	
		System.out.println(is.get(0));	//to verify
		
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		//Print unique numbers from this array
		
		values.stream().distinct().forEach(s->System.out.println(s));
		//Sort the array and get 3rd index
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
		
	}
}
