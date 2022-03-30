package db;

import java.io.*;
import java.util.Map;
import myexception.CustomException;

public class PersistLayer implements Storage  {

    private long accNo=0;
    private long idNo=0;
    
    public long getAccNo() {
		return accNo;
	}
    
    public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
    public long getIdNo() {
		return idNo;
	}
    
  	public void setIdNo(long idNo) {
		this.idNo = idNo;
	}
  	
    public Cache mapToFile(Map<Long,Map<Long, AccountInfo>> inpAccountMap,Map<Long, CustomerInfo> customerMap) throws CustomException, IOException {
    	Cache cache=new Cache();
        if(!inpAccountMap.isEmpty())
        {
            File file=new File("accountmap.txt");
            try( FileOutputStream fos = new FileOutputStream(file,false);
                 ObjectOutputStream oos = new ObjectOutputStream(fos);)
            {
                oos.writeObject(inpAccountMap);
                oos.writeObject(accNo);
                oos.writeObject(idNo);
                oos.writeObject(customerMap);
                cache.storeInCache(inpAccountMap,accNo,idNo,customerMap);
            }
            return cache;
        }
      throw new CustomException("Map is empty");
    }

    @SuppressWarnings("unchecked")
	public Cache readFromFile() throws IOException, ClassNotFoundException, CustomException {
    	Cache cache=new Cache();
    	File file=new File("accountmap.txt");
    	if(file.exists())
    	{
        try( FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis);)
        {
           cache.accountMap = (Map<Long, Map<Long, AccountInfo>>) ois.readObject();
           accNo =  (long) ois.readObject();
           cache.accNo= accNo;
           idNo = (long) ois.readObject();
           cache.idNo=idNo;
           cache.customerMap = (Map<Long, CustomerInfo>) ois.readObject();
        }
        return cache;
    	}
        throw new CustomException("file not exists");
    }
}
