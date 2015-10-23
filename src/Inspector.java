/*
 * CPSC 501 Assignment 2
 * By Andrew Chen
 * 10045041
 * References:
 * To print all elements in an array line by line (for readability)
 */
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.*;


public class Inspector {
	public void inspect(Object obj, boolean recursive){
		Class classObj = obj.getClass();
		Vector read = new Vector();
		
		//print/get declaring class
		Class declaringClass = obj.getClass(); //class object
		System.out.println("\nCLASS: " + declaringClass.getName() + "\n");
		Class superClass = declaringClass.getSuperclass();
		while (superClass != null && superClass.getName() != "java.lang.Object"){//traverse through hierarchy
			System.out.println("SUPERCLASS: " + superClass.getName());
			superClass = superClass.getSuperclass();
		}
		//print interfaces
		Class[] interfaces = declaringClass.getInterfaces();
		int interfaceLength = interfaces.length;
		for(int i = 0; i < interfaceLength; i++){
			System.out.println("INTERFACE: " + interfaces[i].getSimpleName());
		}
		System.out.println();//newline
		
		//stores all methods in an array		
		Method methodsArray[] = declaringClass.getMethods(); 
		int methodsArrayLength = methodsArray.length;
		//System.out.print("Methods in Class: \n");
		//name of method
		for(int i = 0; i < methodsArrayLength; i++){
			System.out.println("METHOD: " + methodsArray[i]);
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
		System.out.println();
		readFields(obj, classObj, read, recursive);
	}
	private void readFields(Object obj, Class classObj, Vector read, boolean recursive){
				//get fields
				Field fieldArray[] = classObj.getDeclaredFields();
				//prints name, modifier, type
				for(int i = 0; i < fieldArray.length; i++){
					System.out.println("FIELD: " + fieldArray[i].getName());
					
					Object getType = fieldArray[i].getType();
					String getModifier = Modifier.toString(fieldArray[i].getModifiers());

					System.out.println("\tType: " + getType);
					System.out.println("\tModifier: " + getModifier);
				}
				//recursive inspection
				for(int i = 0; i < fieldArray.length; i++){
					Field field = classObj.getDeclaredFields()[i];
					if(!fieldArray[i].getType().isPrimitive()){
						field.setAccessible(true);
						try{
							System.out.println("Hash code from: " + fieldArray[i].getName() + " - " + obj.hashCode());
							System.out.println("Value from: " + fieldArray[i].getName() + " - " + field.get(obj));
						}catch(IllegalArgumentException | IllegalAccessException e){
							e.printStackTrace();
						}
					}
				}
	}
}
