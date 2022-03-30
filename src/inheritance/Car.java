package inheritance;

public class Car {
	
	private int yearOfMake;
	private String engineNumber;
	private String type;
	
	public Car()
	{}
	public Car(String input)
	{
		System.out.println(input);
	}
	
	public void setYearOfMake(int yearOfMake)
	{
		this.yearOfMake=yearOfMake;
	}
	public int getYearOfMake()
	{
		return yearOfMake;
	}
	public void setEngineNumber(String engineNumber)
	{
		this.engineNumber=engineNumber;
	}
	public String getEngineNumber()
	{
		return engineNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String maintenance() {
		return "The car in under maintenance";
	}
	
}
