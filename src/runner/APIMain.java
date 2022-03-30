package runner;

import java.util.*;
import myexception.CustomException;
import db.*;

class APIMain {
    Scanner scan=new Scanner(System.in);
    
    private APILayer logicLayer=new APILayer();
    
    private void accountMethod() throws CustomException {
        long id = 0;
        long accNumber = logicLayer.persistLayer.getAccNo();
        System.out.println("How many account data you want to enter");
        int data=scan.nextInt();
        scan.nextLine();
        for(int i=0;i<data;i++)
        {
            AccountInfo pjClass=new AccountInfo();
            System.out.println("Enter the name");
            String name=scan.nextLine();
            System.out.println("Enter the branch");
            String branch=scan.nextLine();
            accNumber++;
            System.out.println("Enter the customer id");
            id=scan.nextLong();
            scan.nextLine();
            pjClass.setName(name);
            pjClass.setId(id);
            pjClass.setBranch(branch);
            pjClass.setAccountNumber(accNumber);
            logicLayer.persistLayer.setAccNo(accNumber);
            logicLayer.addAccount(pjClass,id,accNumber);
            System.out.println("The account number is "+accNumber);
        }
    }

    private void customerMethod() throws CustomException {
        long id = 0;
        id=logicLayer.persistLayer.getIdNo();
        System.out.println("How many customer data you want to enter");
        int data=scan.nextInt();
        scan.nextLine();
        for(int iter=0;iter<data;iter++)
        {
            CustomerInfo pjClass=new CustomerInfo();
            System.out.println("Enter the name");
            String name=scan.nextLine();
            id++;
            System.out.println("Enter the gender");
            char gender=scan.next().charAt(0);
            scan.nextLine();
            System.out.println("Enter the age");
            int age=scan.nextInt();
            scan.nextLine();
            pjClass.setName(name);
            pjClass.setAge(age);
            pjClass.setCustomerId(id);
            pjClass.setGender(gender);
            logicLayer.persistLayer.setIdNo(id);
            logicLayer.addCustomer(pjClass,id);
            System.out.println("The customer id is "+id);
        }
    }


    public static void main(String[] args) {
        APIMain mainObj=new APIMain();
        boolean temp=false;
        Scanner scan=new Scanner(System.in);
        while(!temp)
        {
            System.out.println("0.Exit\n1.Add new account\n2.Add new customer\n3.Retrieve account details "
                    + "\n4.Retrieve customer details\n5.Check account balance\n6.Deposit amount"
                    + "\n7.Withdraw amount\n8.Change account status\n9.Save data to file"
                    + "\n10.Retrieve from file");
            
            System.out.println("\nEnter the choice:");
            int choice=scan.nextInt();
            switch (choice) {
                case 0:	{
                    temp=true;
                    break;
                }
                case 1: {
                    try
                    {
                        mainObj.accountMethod();
                        break;
                    }
                    catch (Exception e) {
                        System.out.println(e);
                        // e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    try
                    {
                        mainObj.customerMethod();
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }
                case 3: {
                    try
                    {
                        System.out.println("Enter the id to retrieve the data:");
                        Long inpId=scan.nextLong();
                        System.out.println(mainObj.logicLayer.retrieveAccount(inpId));
                        System.out.println("Enter the one account to retrieve the data:");
                        long accNumber1=scan.nextLong();
                        System.out.println(mainObj.logicLayer.retrieveFromManyAccount(inpId,accNumber1));
                    }
                    catch (CustomException e) {
                        System.out.println(e);
                    }
                    break;
                }
                case 4: {
                    try
                    {
                        System.out.println("Enter the id to retrieve the data:");
                        Long inpId=scan.nextLong();
                        System.out.println(mainObj.logicLayer.retrieveCustomer(inpId));
                    }
                    catch (Exception e) {
                        System.out.println(e);
                        //e.printStackTrace();
                    }
                    break;
                }
                case 5: {
                    try
                    {
                        System.out.println("Enter the id number");
                        long id=scan.nextInt();
                        System.out.println("Enter the account number");
                        long accountNumber=scan.nextInt();
                        System.out.println("The balance is "+mainObj.logicLayer.checkBalance(id,accountNumber));

                    }
                    catch (Exception e) {
                        System.out.println(e);
                        //e.printStackTrace();
                    }
                    break;
                }
                case 6: {
                    try {
                        System.out.println("Enter the id number");
                        long id=scan.nextInt();
                        System.out.println("Enter the account number");
                        long accountNumber=scan.nextInt();
                        System.out.println("Enter the Deposit amount");
                        long depositAmount=scan.nextInt();
                        System.out.println(mainObj.logicLayer.deposit(accountNumber,id,depositAmount));
                    } catch (CustomException e) {
                        //e.printStackTrace();
                        System.out.println(e);
                    }
                    break;
                }
                case 7: {
                    try {
                        System.out.println("Enter the id number");
                        long id=scan.nextInt();
                        System.out.println("Enter the account number");
                        long accountNumber=scan.nextInt();
                        System.out.println("Enter the withdrawAmount amount");
                        long withdrawAmount=scan.nextInt();
                        System.out.println(mainObj.logicLayer.withdrawal(accountNumber,id,withdrawAmount));
                    } catch (CustomException e) {
                        //e.printStackTrace();
                        System.out.println(e);
                    }
                    break;
                }
                case 8: {
                    try {
                        System.out.println("Enter the id number");
                        long id=scan.nextInt();
                        System.out.println("Enter the account number");
                        long accountNumber=scan.nextInt();
                        System.out.println("Enter the new status of account in boolean");
                        Boolean status=scan.nextBoolean();
                        System.out.println(mainObj.logicLayer.changeStatus(id,accountNumber,status));
                    } catch (CustomException e) {
                        System.out.println(e);
                    }
                    break;
                }
                case 9: {
                    try {
                        mainObj.logicLayer.writeFile();
                        System.out.println("Successfully saved to file");

                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }
                case 10:
                {
                    try
                    {
                        mainObj.logicLayer.readFile();
                        System.out.println("Retrieved from file successfully");
                    }
                    catch (Exception e) {
                        System.out.println(e);
                        e.printStackTrace();
                    }
                    break;
                }
                default:
                    System.out.println("Unexpected value: " + choice);
            }
        }
        scan.close();
        mainObj.scan.close();
    }
}