package org.multithreading;


import java.util.concurrent.TimeUnit;

/* Let’s consider a situation where two threads perform a read an write operation to the same variable. **/
public class StopThreadBad {
    private static boolean stopRequested;
    public static void main(String[] args) throws InterruptedException {
/***
 * There is a background thread (backgroundThread) that will increment the value of “i” until the “stopRequested” boolean becomes true.
 * After starting the thread by the main thread of the program, it sleeps for 1 second and makes the “stopRequested” to true.
 * Ideally, the program should run for 1 second and after the “stopRequested” has become true, the “backgroundThread” should end, terminating the whole program.
 * But the program keeps on executing without getting terminated.
 * The problem occurs with the write operation on the “stopRequested” variable. There is no guarantee that the change of the value in “stopRequested” variable
 * (from the main thread) becoming visible to the “backgroundThread” that we created. As the write operation to the “stopRequested” variable to true from the
 * main method is invisible to the “backgroundThread”, it will go into an infinite loop.
 *
 */

        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested)
                    i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
/*
 * As the main thread and our “backgroundThread” is running on two different cores inside the processor, the “stopRequested” will be loaded into the cache of
 * the core that executes the “backgroundThread”. The main thread will keep the updated value of the “stopRequested” value in a cache of a different core.
 * Since now the “stopRequested” value resides in two different caches, the updated value may not be visible to the “backgroundThread”.
 */
        stopRequested = true;
    }
}
