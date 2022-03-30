package fileread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
public class FileReadMain
{ 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    FileHandling fileObj = new FileHandling("");
    int length;
    
    //method1
    public void fileCreated() throws Exception
    {
    System.out.println("Enter the file name:");
    String  strName = br.readLine();
    System.out.println("Enter the file path:");
    String strPath = br.readLine();
    System.out.println("Enter the length:");
    length = Integer.parseInt(br.readLine());
    System.out.println("Enter the sentence to write on file :");
    String[] strWrite = new String[length];
    StringBuilder inputString=new StringBuilder();
    for(int itr=0;itr<length;itr++)
    {
        strWrite[itr]=br.readLine();
        inputString.append("\n");
        inputString.append(strWrite[itr]);
    }
    String strInp=inputString.toString();
    fileObj.fileCreate(strName,strPath,strInp);
    }
    
    //method2
    private void propertyMethod() throws Exception {
        Properties propObj=fileObj.createProperties();
        System.out.println("Enter the file path to create properties in a file :");
        String strPath = br.readLine();
        System.out.println("Enter the length of properties");
        length=Integer.parseInt(br.readLine());
        for(int iterate=0;iterate<length;iterate++)
        {
            System.out.println("Enter the key: ");
            String strKeyArr=br.readLine();
            System.out.println("Enter the value: ");
            String strValueArr=br.readLine();
            propObj = fileObj.storeInProperties(propObj,strKeyArr,
            		strValueArr,strPath);
        }
		
	}
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileHandling fileObj = new FileHandling("");
        FileReadMain mainObj=new FileReadMain();
        System.out.println("Enter the task number");
        int choice = 0;
        try
        {
            choice =  Integer.parseInt(br.readLine());
        }
        catch (Exception e)
        {
            System.out.print("Enter numbers only");
            System.exit(0);
        }
        switch (choice){

            case 1:
            {
            	try {
            	mainObj.fileCreated();
            	}
                catch (Exception e) 
            	{
					// TODO Auto-generated catch block
            		System.out.println("The length should be number or file already exists");
					//e.printStackTrace();
				}
            	break;
            }

            case 2:
            {
                try
                {
                	mainObj.propertyMethod();
                }
                catch (Exception e)
                {				// TODO Auto-generated catch block
            		System.out.println("The file path is invalid or file can't be null");
            		e.printStackTrace();
                }
                break;
            }
            
            case 3:
            {
                try
                {
                    System.out.println("Enter the file path :");
                    String strPath = br.readLine();
                    System.out.println(fileObj.loadFromProperties(strPath));
                }
                catch (Exception e)
                {				// TODO Auto-generated catch block
                    System.out.print("The file path is invalid or file can't be null");
                   // e.printStackTrace();
                }
                break;
            }
            
            case 4:
            {
                try
                {
                    System.out.println("Enter the file path to create :");
                    String strPath = br.readLine();
                    fileObj.fileCreateInDir(strPath);
                    mainObj.fileCreated();
                    mainObj.propertyMethod();
                    Properties propObj=fileObj.createProperties();
                    System.out.println("Enter the file path to load properties : ");
                    String path = br.readLine();
                    propObj =  fileObj.loadFromProperties(path);
                    System.out.println(propObj);
                    
                }
                catch (Exception e)
                {				// TODO Auto-generated catch block
                   System.out.print("Enter a valid path or the length should be "
                    		+ "integer");
                   //e.printStackTrace();  
                }
                break;
            }
            
            case 5:
            {
                FileHandling testObjArg = new FileHandling("hi");
            	System.out.println(testObjArg);
            	break;
            }
            
            default:
            {
                System.out.println("Enter Task Number between 1 to 5");
            }
            
      }br.close();
   }
}