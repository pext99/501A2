import java.lang.reflect.Method;
import java.util.Arrays;


public class Inspector {
	public void inspect(Object obj, boolean recursive){
		Class reflectClass = ClassA.class;
		Method mArray[] = reflectClass.getMethods();
		System.out.println(Arrays.toString(mArray));
		
		/*Object myObj = new Object();
		Class classObject = myObj.getClass();
		System.out.println(classObject);*/
		
		/*Class reflectClass1 = ClassB.class;
		String className1 = reflectClass1.getName();
		System.out.println(className1);*/
	}
}
