package thread;

import java.util.Scanner;

public class RunnableRunner {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the task number");
        int choice=0;
        try
        {
            choice=scan.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Enter numbers only in choice");
        }

        switch (choice) {
            case 1: 
            {
                try
                {
                    RunnableThread objThread=new RunnableThread();
                    Thread obj=new Thread(objThread);
                    obj.start();
                }
                catch (Exception e) {
                    System.out.println("unable to create new thread");
                   // e.printStackTrace();
                }
                break;
            }
            case 2:
            {
                try {
                    RunnableThread objThread=new RunnableThread();
                    objThread.run();
                    Thread obj=new Thread(objThread);
                    obj.start();
                    obj.setName("RUNNABLE THREAD");
                }
                catch (Exception e)
                {
                    System.out.println("unable to create new thread");
                }
                break;
            }
            
            case 3:
            {
                try {
                    RunnableThread objThread=new RunnableThread();
                    objThread.run();
                    Thread obj=new Thread(objThread);
                    obj.start();
                    obj.setName("RUNNABLE THREAD");
                    Thread obj1=new Thread(objThread);
                    obj1.start();
                    obj1.setName("RUNNABLE THREAD1");
                    Thread obj2=new Thread(objThread);
                    obj2.start();
                    obj2.setName("RUNNABLE THREAD2");
                }
                catch (Exception e)
                {
                    System.out.println("unable to create new thread");
                }
                break;
            }
            case 4:
            {
                try 
                {
                	long sleep;
                	System.out.println("Enter the length");
                    int length=scan.nextInt();
                	for(int itr=0;itr<length;itr++)
                	{
                    System.out.println("Enter the sleep :");
                    sleep=scan.nextLong();
                    RunnableThread objThread=new RunnableThread(sleep);
                    Thread obj=new Thread(objThread);
                    obj.start();
                	}
                }
                catch (Exception e)
                {
                    System.out.println("unable to create new thread");
                    //e.printStackTrace();
                }
                break;
            }
            case 5:
            {
                try 
                {
                    RunnableThread objtThread=new RunnableThread();
                	long sleep;
                	System.out.println("Enter the length");
                    int length=scan.nextInt();
                	System.out.println("Enter the value");
                	  int value=scan.nextInt();
                	  objtThread.setValue(value);
                	for(int itr=0;itr<length;itr++)
                	{
                    System.out.println("Enter the sleep :");
                    sleep=scan.nextLong();
                    RunnableThread objThread=new RunnableThread(sleep);
                    Thread obj=new Thread(objThread);
                    obj.start();
                	}
                }
                catch (Exception e)
                {
                    System.out.println("unable to create new thread");
                    //e.printStackTrace();
                }
                break;
            }
            
        }
    scan.close();
    }
}