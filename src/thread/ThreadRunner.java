package thread;
import java.util.Scanner;

public class ThreadRunner {

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
      Thread objectThread=new Thread();
        switch (choice) {
            case 1: 
            {
                try {
                    ExtendedThread objThread=new ExtendedThread();
                    Thread obj=new Thread(objThread);
                    obj.start();
                }
                catch (Exception e) {
                    System.out.println("unable to create new thread");
                }
                break;
            }
            case 2:
            {
                try {
                    ExtendedThread objThread=new ExtendedThread();
                    objThread.run();
                    Thread obj=new Thread(objThread);
                    obj.setName("Extended Thread");
                    obj.start();
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
                	ExtendedThread objThread=new ExtendedThread();
                    objThread.run();
                    Thread obj=new Thread(objThread);
                    obj.start();
                    obj.setName("EXTENDED THREAD");
                    Thread obj1=new Thread(objThread);
                    obj1.start();
                    obj1.setName("EXTENDED THREAD1");
                    Thread obj2=new Thread(objThread);
                    obj2.start();
                    obj2.setName("EXTENDED THREAD2");
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
                	ExtendedThread objThread=new ExtendedThread(sleep);
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
                	long sleep;
                	System.out.println("Enter the length");
                    int length=scan.nextInt();
                	for(int itr=0;itr<length;itr++)
                	{
                    System.out.println("Enter the sleep :");
                    sleep=scan.nextLong();
                	ExtendedThread objThread=new ExtendedThread(sleep);
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
            case 6:
            {
                try 
                {
                	ExtendedThread objtThread=new ExtendedThread();
                	long sleep;
                	System.out.println("Enter the length");
                    int length=scan.nextInt();
                	for(int itr=0;itr<length;itr++)
                	{
                    System.out.println("Enter the sleep :");
                    sleep=scan.nextLong();
                	ExtendedThread objThread=new ExtendedThread(sleep);
                	 objtThread.setBool(true);
                	Thread obj=new Thread(objThread);
                    obj.start();
                	}
                	
                	System.out.println( objectThread.isAlive());
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