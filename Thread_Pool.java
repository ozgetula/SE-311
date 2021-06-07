package Project;
import javax.naming.LimitExceededException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


class Thread_Pool implements Runnable
{
    private String name;
    private int priority;
    private int size;


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Thread_Pool(String s){
        name = s;
    }

    public void run()
    {
        try
        {
            BlockingQueue threads = new ArrayBlockingQueue(6);
            int totalMemory = 1700;
            Thread_Pool thread_pool = new Thread_Pool(name);
            State state = new State();
            for (int i=0; i<=threads.remainingCapacity() ;i++){
                if (totalMemory>0){
                    if (thread_pool.name=="HThread"){
                        thread_pool.setPriority(1);
                        thread_pool.setSize(512);
                        totalMemory -= 512;
                    }
                    else if(thread_pool.name=="LThread"){
                        thread_pool.setPriority(5);
                        thread_pool.setSize(256);
                        totalMemory -= 256;
                    }
                    else{
                        System.out.println("Invalid");
                    }
                }
                else if (totalMemory<512 && thread_pool.name=="HThread"){
                    throw new LimitExceededException("Cannot exceed");
                }
                else if (totalMemory<256 && thread_pool.name=="LThread"){
                    throw new LimitExceededException("Cannot exceed");
                }
            }
            for (int i = 0; i<=threads.remainingCapacity(); i++)
            {
                if (i==0)
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    state.setState("IDLE");
                    System.out.println("Initialization Time for " + state.getState()  +" "+ name +" = " +ft.format(d) +" ------Priority : "+ thread_pool.getPriority() + " Size: "+ thread_pool.getSize());
                }
                else
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    state.setState("BUSY");
                    System.out.println("Executing Time for "+ state.getState() +" "+name +" = " +ft.format(d));
                }
                Thread.sleep(1000);
            }
            state.setState("IDLE");
            System.out.println(name+ " " + state.getState());


            System.out.println(totalMemory);


        }

        catch(InterruptedException | LimitExceededException e)
        {
            e.printStackTrace();
        }
    }
}
