package thread;

public class ExtendedThread extends Thread {

    private long sleepTime;
    private int value;
    private boolean bool;


    public boolean isBool() {
		return bool;
	}




	public void setBool(boolean bool) {
		this.bool = bool;
	}




	public void run(){
        System.out.println("Thread Running "+Thread.currentThread().getName());
        System.out.println("Thread Priority "+Thread.currentThread().getPriority());
        System.out.println("Thread Priority "+Thread.currentThread().getState());
        System.out.println("Going to sleep "+Thread.currentThread().getName());

        try 
        {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("After sleep "+Thread.currentThread().getName());
        //Thread.dumpStack();
        while (!bool) {

            System.out.println("The thread is running "+Thread.currentThread().getName());

        }

    }




    public ExtendedThread()
    {

    }

    public ExtendedThread(long sleep)
    {
        this.sleepTime=sleep;
    }
}
      

    

