package Project;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client extends ThreadPoolExecutor {
    BlockingQueue a = new ArrayBlockingQueue(10);

    public Client(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> a) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, a);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println("Perform beforeExecute() logic");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null) {
            System.out.println("Perform exception handler logic");
        }
        System.out.println("Perform afterExecute() logic");
    }
   



}
