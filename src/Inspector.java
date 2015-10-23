/*
 * CPSC 501 Assignment 2
 * By Andrew Chen
 * 10045041
 * References:
 * To print all elements in an array line by line (for readability)
 */
import java.lang.reflect.*;
import java.util.Arrays;


public class Inspector {
	public void inspect(Object obj, boolean recursive){
		Class classObj = obj.getClass();
		
		//print/get declaring class
		Class declaringClass = obj.getClass(); //class object
		System.out.println("\nDeclaring class: " + declaringClass.getName() + "\n");
		Class superClass = declaringClass.getSuperclass();
		while (superClass != null && superClass.getName() != "java.lang.Object"){//traverse through hierarchy
			System.out.println("Superclass: " + superClass.getName());
			superClass = superClass.getSuperclass();
		}
		//print interfaces
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
		//name of method
		for(int i = 0; i < methodsArrayLength; i++){
			System.out.println(methodsArray[i]);
			//return parameter types
			Class[] parameterTypes = methodsArray[i].getParameterTypes();
			int parameterLength = parameterTypes.length;
			for(int j = 0; j < parameterLength; j++){
				System.out.println("\tParameter Type: " + parameterTypes[j].toString());
			}
			//return the exception types
			Class<?>[] exceptionTypes = methodsArray[i].getExceptionTypes();
			int exceptionLength = exceptionTypes.length;
			for(int j = 0; j < exceptionLength; j++){
				System.out.println("\tException Types: " + exceptionTypes[j].toString());
			}
			//return the return types
			Class returnTypes = methodsArray[i].getReturnType();
			System.out.println("\tReturn Types: " + returnTypes.getSimpleName());
			//return the modifiers of method
			String modifierTypes = Modifier.toString(methodsArray[i].getModifiers());
			System.out.println("\tModifier Types: " + modifierTypes);
		}
		//http://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
		//Arrays.asList(methodsArray).stream().forEach(s -> System.out.println(s + "\n\t")); //to print all elements of an array line by line
		
		//get constructors
		Constructor constructorsArray[] = classObj.getDeclaredConstructors();
		for(int i = 0; i < constructorsArray.length; i++){
			//print the constructor name
			System.out.println("CONSTRUCTORS: " + constructorsArray[i].toString());
			Class parameterTypes[] = constructorsArray[i].getParameterTypes();
			//print parameter types
			for(int j = 0; j < parameterTypes.length; j++){
				System.out.println("\tConstructor Parameters: " + parameterTypes[j].getSimpleName());
			}
			//print the modifiers of method
			String modifierTypes = Modifier.toString(constructorsArray[i].getModifiers());
			System.out.println("\tModifier Types: " + modifierTypes);
		}
		
		//get fields
		Field fieldArray[] = declaringClass.getDeclaredFields();
		//prints name, modifier, type
		for(int i = 0; i < fieldArray.length; i++){
			System.out.println("FIELD: " + fieldArray[i].getName());
			String getModifier = Modifier.toString(fieldArray[i].getModifiers());
			Object getType = fieldArray[i].getType();
			System.out.println("\tType: " + getType);
			System.out.println("\tModifier: " + getModifier);
			
		}
		
		/*//print field name
			if (fieldArray[i].getType().isPrimitive()){
				System.out.println("FIELD (primitive): " + fieldArray[i].getName());
			}
			else if(fieldArray[i].getType().isArray()){
				try {
					fieldArray[i].setAccessible(true);
					for(int j = 0; j < Array.getLength(fieldArray[j].get(obj)); j++){
						System.out.println("asdf" + Array.get(obj, j));
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("not primitive");
			}*/
		
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
