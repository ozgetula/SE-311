package Project;

import java.util.*;
import java.lang.*;

public class Thread_Pool implements Runnable{
    private String name;
    private int size;
    private int priority;

    public int getSize() {
        return size;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public Thread_Pool(String name){
       this.name=name;
    }

    @Override
    public void run() {
        Thread_Pool thread_pool = new Thread_Pool(getName());

        try{
            if (thread_pool.getName()=="HThread"){
                size=512;
                priority=1;
            }
            else if(thread_pool.getName()=="LThread"){
                size=256;
                priority=5;
            }
            else{
                System.out.println("Invalid type name");
            }
        }
        catch (Exception e){
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }
}
