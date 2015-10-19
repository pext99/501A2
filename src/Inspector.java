/*
 * CPSC 501 Assignment 2
 * By Andrew Chen
 * 10045041
 * References:
 * To print all elements in an array line by line (for readability)
 */
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;


public class Inspector {
	public void inspect(Object obj, boolean recursive){
		//get declaring class
		Class declaringClass = obj.getClass(); //class object
		System.out.println("\nDeclaring class: " + declaringClass.getName() + "\n");
		
		Class[] interfaces = declaringClass.getInterfaces();
		int interfaceLength = interfaces.length;
		for(int i = 0; i < interfaceLength; i++){
			System.out.println("Interface: " + interfaces[i].getSimpleName());
		}
		System.out.println();//newline
		
		//stores all methods in an array		
		Method methodsArray[] = declaringClass.getMethods(); 
		int methodsArrayLength = methodsArray.length;
		System.out.print("Methods in Class: \n");
		for(int i = 0; i < methodsArrayLength; i++){
			System.out.println(methodsArray[i]);
			
			//return parameter types
			Class[] parameterTypes = methodsArray[i].getParameterTypes();
			int parameterLength = parameterTypes.length;
			for(int j = 0; j < parameterLength; j++){
				System.out.println("\tParameter Type: " + parameterTypes[j].toString());
			}
		}
		
		//http://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
		//Arrays.asList(methodsArray).stream().forEach(s -> System.out.println(s + "\n\t")); //to print all elements of an array line by line
		
		
		Class superClass = declaringClass.getSuperclass();
		while (superClass != null && superClass.getName() != "java.lang.Object"){//traverse through hierarchy
			System.out.println("Superclass: " + superClass.getName());
			superClass = superClass.getSuperclass();
		}
		
		//refactoring for getSuperclass
		/*Class subClass = null;
		while(superClass != null){
			String className = superClass.getName();
			System.out.println("\nSuperclass: is the Subclass of " + (className));
			subClass = superClass;
			superClass = subClass.getSuperclass(); 
		}*/
		
		//System.out.println("\nSuperclass: " + superClass);
		
		
		
		
		
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
