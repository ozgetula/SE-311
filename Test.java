package Project;
import javax.naming.LimitExceededException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test
{
    // Maximum number of threads in thread pool
    static final int MAX_T = 6;

    public static void main(String[] args)
    {


            Runnable h1 = new Thread_Pool("HThread");
            Runnable l2 = new Thread_Pool("LThread");
            Runnable h3 = new Thread_Pool("HThread");
            Runnable l4 = new Thread_Pool("LThread");
            Runnable l5 = new Thread_Pool("LThread");
            Runnable l6 = new Thread_Pool("LThread");

            // creates a thread pool with MAX_T no. of
            // threads as the fixed pool size(Step 2)
            ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

            // passes the Task objects to the pool to execute (Step 3)
            pool.execute(h1);
            pool.execute(l2);
            pool.execute(h3);
            pool.execute(l4);
            pool.execute(l5);
            pool.execute(l6);

            // pool shutdown ( Step 4)
            pool.shutdown();

        // creates five tasks

    }
}
