package org.multithreading;

import java.util.concurrent.TimeUnit;

public class StopThreadUsingVolatile {

    private static volatile boolean stopRequested;


    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested)
                    i++;
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);

        stopRequested = true;
    }
}