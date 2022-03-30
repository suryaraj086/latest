package db;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import myexception.CustomException;

public class DBLayer implements Storage {
	
	public long idNo=0;
	public long accNo=0;
	Cache cache=new Cache();
	
	public long getAccNo() {
		return accNo;
	}
	public long getIdNo() {
		return idNo;
	}
	
	public Cache mapToFile(Map<Long,Map<Long, AccountInfo>> inpAccountMap,Map<Long, CustomerInfo> customerMap) throws CustomException, Exception {
		
        if(!inpAccountMap.isEmpty())
        {
        	
    			Class.forName("com.mysql.cj.jdbc.Driver");  
    			try(Connection con=DriverManager.getConnection(  
    					"jdbc:mysql://localhost:3306/bank","root","1234");)  	//here bank is database name, root is username and password  
    			{
    				DatabaseMetaData dbm = con.getMetaData();
    				// check if "employee" table is there
    				ResultSet tables = dbm.getTables(null, null, "cusomerdata", null);
    				if (tables.next()) {
    				  // Table exists
    					tables.getString("accountdata");
    					
    				}
    				else {
						
					}
    			int i=0;
    			Iterator<Long> itr = customerMap.keySet().iterator();
    			while (itr.hasNext())
    			{
    			    Long key = itr.next();
    			    CustomerInfo value = customerMap.get(key);
    			    String name= value.getName(); 
    			    int age=value.getAge();
    			   char gender= value.getGender();
    			   PreparedStatement stmt=con.prepareStatement("INSERT INTO customerdata " + "VALUES (?,?,?,?)");
    				stmt.setLong(1,key);
    				stmt.setString(2,name);
    				stmt.setInt(3,age);
    				stmt.setString(4,String.valueOf(gender));
    				stmt.executeUpdate();
    				i++;
    			}
    			
    			Iterator<Long> itreate = inpAccountMap.keySet().iterator();
    			while (itreate.hasNext())
    			{
    			    Long id = itreate.next();
    			    Map<Long, AccountInfo> value = inpAccountMap.get(id);
    			    Iterator<Long> itreate1 = value.keySet().iterator();
    			    while (itreate1.hasNext())
        			{
    			       Long accNo = itreate1.next();
    			       AccountInfo account = value.get(accNo);
    			       String name= account.getName();
        			   Long balance=account.getBalance();
        			   String branch= account.getBranch();
        			   boolean status=account.isStatus();
        			   PreparedStatement stmt=con.prepareStatement("INSERT INTO accountdata " + "VALUES (?,?,?,?,?,?)");
        				stmt.setLong(1,id);
        				stmt.setLong(3,accNo);
        				stmt.setString(4, branch);
        				stmt.setString(2,name);
        				stmt.setLong(5, balance);
        				stmt.setBoolean(6, status);
        				stmt.executeUpdate();
        			}
    				i++;
    			}
    			
    			System.out.println("rows affected for customerdata and accountdata table "+i);
    			cache.storeInCache(inpAccountMap,accNo,idNo,customerMap);
    			inpAccountMap.clear();
    			customerMap.clear();
            	}
        	    catch (Exception e) {
        		e.printStackTrace();
			}
    			return cache;
        }
         throw new CustomException("map is empty");  
}

	@Override
	public Cache readFromFile() throws IOException, ClassNotFoundException {
		
	    Map<Long,Map<Long, AccountInfo>> inpAccountMap=new HashMap<Long, Map<Long,AccountInfo>>();
		
		Map<Long, CustomerInfo> customerMap=new HashMap<Long, CustomerInfo>();
		Class.forName("com.mysql.cj.jdbc.Driver");  
		try(Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/bank","root","1234");)  	//here bank is database name, root is username and password  
		{
			  String query = "SELECT * FROM accountdata";
		      java.sql.Statement st = con.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		        Long id = (long) rs.getLong("id");
		        String name = rs.getString("name");
		        long accountNumber = rs.getLong("accountnumber");
		        String branch = rs.getString("branch");
		        boolean status = rs.getBoolean("status");
		        Long balance = rs.getLong("balance");
		        AccountInfo accObj=new AccountInfo();
		        accNo=accountNumber;
		        accObj.setAccountNumber(accountNumber);
		        accObj.setBalance(balance);
		        accObj.setBranch(branch);
		        accObj.setId(id);
		        accObj.setName(name);
		        accObj.setStatus(status);
		        Map<Long, AccountInfo> tempMap=inpAccountMap.get(id);
		        if(tempMap==null)
		        {
		        	tempMap=new HashMap<Long,AccountInfo>();
		        	inpAccountMap.put(id, tempMap);
		        }
		        tempMap.put(accountNumber,accObj);
		      }
		      
		      query = "SELECT * FROM customerdata";
		      java.sql.Statement st1 = con.createStatement();
		      ResultSet rs1 = st1.executeQuery(query);
		      while (rs1.next())
		      {
		        Long id = rs1.getLong("id");
		        String name = rs1.getString("name");
		        String gender = rs1.getString("gender");
		        int age = rs1.getInt("age");
		        idNo=id;
		        CustomerInfo cusObj=new CustomerInfo();
		        cusObj.setAge(age);
		        cusObj.setCustomerId(id);
		        char gen=gender.charAt(0);
		        cusObj.setGender(gen);
		        cusObj.setName(name);
		        customerMap.put(id, cusObj);
		        
		      }
		      
		      cache.storeInCache(inpAccountMap,accNo,idNo,customerMap);
		      st.close();
		      st1.close();    
		}
			
		 catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return cache;
	}
	
	@Override
	public void setAccNo(long accNumber) {
		this.accNo=accNumber;
		
	}
	
	@Override
	public void setIdNo(long id) {
	this.idNo=id;
		
	}

//	public Cache store(long id,String name,char gender,int age,String branch,long accNo,long balance,boolean status) {
//		Class.forName("com.mysql.cj.jdbc.Driver");  
//	try(Connection con=DriverManager.getConnection(  
//			"jdbc:mysql://localhost:3306/bank","root","1234");)  
//	{
//	  	PreparedStatement stmt=con.prepareStatement("INSERT INTO customerdata " + "VALUES (?,?,?,?)");
//	  	stmt.setLong(1,id);
//	  	stmt.setString(2,name);
//	  	stmt.setInt(3,age);
//		stmt.setString(4,String.valueOf(gender));
//	    stmt.executeUpdate();
//	  PreparedStatement stmt=con.prepareStatement("INSERT INTO accountdata " + "VALUES (?,?,?,?,?,?)");
//		stmt.setLong(1,id);
//		stmt.setLong(3,accNo);
//		stmt.setString(4, branch);
//		stmt.setString(2,name);
//		stmt.setLong(5, balance);
//		stmt.setBoolean(6, status);
//		stmt.executeUpdate();
//		cache.storeInCache(inpAccountMap,accNo,idNo,customerMap);
//		return cache;
//	}
//	}


}
