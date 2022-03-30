package fileread;
import java.io.*;
import java.util.Properties;
import myexception.CustomException;
import utilhelper.*;

public class FileHandling
{
    String inputString="";

    public Properties createProperties() {
        Properties property=new Properties();
        return property;

    }


    public void fileCreate(String strName,String strPath,String strWrite) throws CustomException, IOException
    {
        Utility.nullChecker(strPath);
        Utility.nullChecker(strName);
        Utility.nullChecker(strWrite);
        FileWriter write=new FileWriter(strPath + strName,true);
        try( BufferedWriter writer = new BufferedWriter(write))
        {
            Utility.nullChecker(writer);
            writer.write(strWrite);
        }
        catch (IOException e) {
            throw new CustomException(e);
        }
    }

    public Properties storeInProperties(Properties properties,String inputKey,
                                        String inputValue,String path)  throws CustomException
    {
        Utility.nullChecker(properties);
        try(FileOutputStream file=new FileOutputStream(path))
        {
            Utility.nullChecker(file);
            Utility.nullChecker(inputKey);
            Utility.nullChecker(inputValue);
            properties.setProperty(inputKey, inputValue);
            properties.store(file,"");
            return properties;
        }
        catch (IOException e) {
            throw new CustomException(e);
        }
    }

    public Properties loadFromProperties(String strPath) throws CustomException
    {
        Utility.nullChecker(strPath);
        try(FileInputStream file=new FileInputStream(strPath))
        {
            Utility.nullChecker(file);
            Properties properties =createProperties();
            properties.load(file);
            return properties;
        }
        catch (IOException e) {
            throw new CustomException(e);
        }
    }

    public void fileCreateInDir(String strPath) throws Exception
    {
        Utility.nullChecker(strPath);
        File file = new File(strPath);
        Utility.nullChecker(file);
        file.mkdirs();
    }

    public FileHandling(String inpString)
    {
        this.inputString=inpString;
    }

    @Override public String toString()
    {
        return inputString;
    }

}