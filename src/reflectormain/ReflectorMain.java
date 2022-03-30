package reflectormain;
import java.util.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectorMain {
	
	public static void main(String[] args) {
	
    try (Scanner scan = new Scanner(System.in)) {
		Class<?> classTemp=Class.forName("reflector.ReflectorTask");
		Object classObj=classTemp.getDeclaredConstructor().newInstance();
//		Method[] method = classTemp.getDeclaredMethods();
		Method setName = classTemp.getDeclaredMethod("setName",String.class);
		System.out.print("Enter the string : ");
		String inputString=scan.nextLine();
		setName.invoke(classObj,inputString);
		Method getName = classTemp.getDeclaredMethod("getName");
        System.out.println(getName.invoke(classObj));
		Constructor<?> cons=classTemp.getDeclaredConstructor(String.class,int.class);
		Object cObj= cons.newInstance("hello",2);
		System.out.println(cObj);
	}
	 
		catch (Exception e) {
System.out.println("second input should be integer");
//e.printStackTrace();
		}
}
}
	
