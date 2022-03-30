package reflector;

public class ReflectorTask {

	private String name;  
	private int id;  
	
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}
	
	public ReflectorTask()
	{
		System.out.println("hi this is default");
	}
	
	public ReflectorTask(String name,int id)
	{
		this.name=name;
		this.id=id;
	}
    
    @Override public String toString()
	{
    	return name+" "+id;
    }
    
}
