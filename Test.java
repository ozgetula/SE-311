package Project;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test
{
    public static void main(String[] args)
    {
        Integer threadCounter = 0;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(10);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                10, 5000, TimeUnit.MILLISECONDS, blockingQueue);

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r,
                                          ThreadPoolExecutor executor) {
                System.out.println("DemoTask Rejected : "
                        + ((Thread_Pool) r).getName());
                System.out.println("Waiting for a second !!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Lets add another time : "
                        + ((Thread_Pool) r).getName());
                executor.execute(r);
            }
        });
        // Let start all core threads initially
        executor.prestartAllCoreThreads();
        while (true) {
            threadCounter++;
            // Adding threads one by one
            System.out.println("Adding DemoTask : " + threadCounter);
            executor.execute(new Thread_Pool(threadCounter.toString()));

            if (threadCounter == 10)
                break;
        }
    }

}
