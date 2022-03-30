package thread;

public class RunnableThread implements Runnable{

	private long sleepTime;
    private int value;
    
    public int getValue() {
        return value;
    }



    public void setValue(int value) {
        this.value = value;
    }
    
	public void run(){
        System.out.println("Thread Running "+Thread.currentThread().getName());
        System.out.println("Thread Priority "+Thread.currentThread().getPriority());
        System.out.println("Thread Priority "+Thread.currentThread().getState());
        System.out.println("Going to sleep "+Thread.currentThread().getName());
        try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("After sleep "+Thread.currentThread().getName());
       
        while (value<5) {
            System.out.println("The value is "+getValue());

            System.out.println("The thread is running "+Thread.currentThread().getName());
            value++;

        } 
    }
    public RunnableThread()
    {
    	
    }
    public RunnableThread(long sleep)
    {
    	this.sleepTime=sleep;
    }

}
