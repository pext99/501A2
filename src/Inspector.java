/*
 * CPSC 501 Assignment 2
 * By Andrew Chen
 * 10045041
 * References:
 * To print all elements in an array line by line (for readability)
 * http://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
 */
import java.lang.reflect.Method;
import java.util.Arrays;


public class Inspector {
	public void inspect(Object obj, boolean recursive){
		//get declaring class
		Class declaringClass = obj.getClass();
		System.out.println("\nDeclaring class: " + declaringClass.getName() + "\n");
		
		//stores all methods in an array
		Method methodsArray[] = declaringClass.getMethods(); 
		System.out.print("Methods in Class: \n");
		Arrays.asList(methodsArray).stream().forEach(s -> System.out.println(s)); //to print all elements of an array line by line 
		//System.out.println("Methods in Class: " + Arrays.toString(methodsArray));
		
		//get all methods within the class
		/*Class methodsInClass = ClassA.class;
		Method methodsArray[] = methodsInClass.getMethods();
		System.out.println(Arrays.toString(methodsArray));
		*/
		
		/*Object myObj = new Object();
		Class classObject = myObj.getClass();
		System.out.println(classObject);*/
		
		/*Class reflectClass1 = ClassB.class;
		String className1 = reflectClass1.getName();
		System.out.println(className1);*/
	}
}
