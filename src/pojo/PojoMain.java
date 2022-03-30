package pojo;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PojoMain {
	public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
try {
		PojoTask pojoObj=new PojoTask("hello", 5);
		System.out.println(pojoObj);
		System.out.println("Enter the string to set: ");
		String name=br.readLine();
		pojoObj.setName(name);
		System.out.println("Enter the integer to set: ");
		int identity=Integer.parseInt(br.readLine());
		pojoObj.setId(identity);
		System.out.println(pojoObj.getName());
		System.out.println(pojoObj.getId());
		br.close();
}
catch (Exception e)
{
System.out.println("Enter integer for set id");
//e.printStackTrace();
} 
}
}
