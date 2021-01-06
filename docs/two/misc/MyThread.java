package com.bestgo.misc;

public class MyThread implements Runnable {

  public MyThread() {
    Thread t1 = new Thread(this);
    t1.start(); // to start from ready state

    try {
      t1.wait();  // to got sleep state

      t1.notify();    // to get out of sleep
      t1.notifyAll();
    } catch(InterruptedException ex) {]
    }
  }

  @Override
  public void run() {

    // out of run loop to terminate
  }
}
