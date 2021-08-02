# SE-311
1.THOUGHT PROCESS
1.1 Making a research for all patterns was our first step. We evaluated them and decided which 
ones will suit our project for creating a Thread Pool. We agreed to use chain of responsibility, 
command, prototype, memento and flyweight patterns in our Project.
2. PATTERNS
2.1 Chain Of Responsibility
Chain of responsibility is a behavioral design pattern. This pattern is used for allocating memory, 
creating thread table and assign apriority level (4th part) in our project. It allows functions to run 
sequentially.
2.2 Command
Command is a behavioral pattern that turns a request into an object. In our system, we used this 
pattern to tell the method “run” what to do when new threads has been created in Test class. 
When run method is executed, we used the change method in Memory and State classes.
2.3 Prototype
We used this creational design pattern, because we have some threads and all of them have size 
and priority. The values of their size and priority are not the same but all threads have the same 
structure since they are in the same pool.
2.4 Memento
We used this behavioral design pattern to set and save the state. E.g. Date in our State class, size 
and priority in our Thread_Pool class. Also, it does the transition between idle and busy 
according to usage place of the threads that we created in our thread pool.
2.5 Flyweight
Our main goal for using Flyweight pattern was to control the thread creation so that it can not 
exceed the total memory. But unfortunately, we could not manage that. We wanted to create 
threads if there is enough memory location for it. If there is not, we wanted our program to throw 
an exception to give a warning about exceeding memory limit.
