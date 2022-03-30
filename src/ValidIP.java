

import java.util.*;

public class ValidIP {

	public static void main(String[] args) {

		     Scanner sc = new Scanner(System.in);
		     int t = sc.nextInt();

		     while (t-- > 0) {
		         String s = sc.next();
		         Solution1 obj = new Solution1();

		         if (obj.isValid(s))
		             System.out.println(1);
		         else
		             System.out.println(0);
		     }
		     sc.close();
		 }


	}


class Solution1
{
	 public boolean isValid(String s) {
		 
		 
		 if(!s.contains(".") || s.endsWith("."))
		 {
		     return false;
		 }
		 
		 String[] splitted=s.split("\\.");
	
		 if(splitted.length!=4)
		 {
		     return false;
		 }
		 
		 for(int iter=0;iter<splitted.length;iter++)
		 {
			 int len=splitted[iter].length();
			 
			 if(len>3)
			 {
				 return false;
			 }
			 
			 if(len!=1 && splitted[iter].startsWith("0"))
			 {
				 return false;
			 }
			  int num=0;
			 try {
				num=Integer.parseInt(splitted[iter]);
			} catch (NumberFormatException ex) {
				return false;
			}
			 if(num<0 || num>255)
			 {
				 return false;
			 }
		 }
		 return true;
	   /*    s=s.replace(".",",");
	     int dots = 0;
	     // counting dots
	     for (int i = 0; i < s.length(); i++) {
	         if (s.charAt(i) == ',') dots++;
	     }
	     if (dots != 3) 
	     {
	         return false;
	     }
	     String[] arr=s.split(",");
	     if(arr.length<4 || arr.length>4)
	     {
	         return false;
	     }
	      int[] out=new int[arr.length];
	      for(int i=0; i<arr.length; i++) {
	          if(arr[i].length()>3 ||arr[i].equals(" ")|| arr[i].equals("") || arr[i].matches("[a-zA-Z]+") == true )
	          {
	              return false;
	          }
	          if(arr[i].length()>1 && arr[i].charAt(0)=='0')
	          {
	              return false;
	          }
	          out[i] = Integer.parseInt(arr[i]);
	   }
	     boolean bool[]=new boolean[out.length];
	     int j=0;
	     for(int i=0;i<out.length;i++)
	     {
	         if(out[i]>=0 && out[i]<=255)
	         {
	             bool[j]=true;
	             j++;
	         }
	         else
	         {
	             bool[j]=false;
	             j++;
	         }
	     }
	    for (boolean value : bool) {
	     if (!value)
	         return false;
	 }
	 return true;*/
	 }
}


//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
