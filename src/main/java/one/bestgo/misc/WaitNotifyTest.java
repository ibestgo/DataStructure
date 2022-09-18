package one.bestgo.misc;

public class WaitNotifyTest {
  public static void main(String[] args) throws InterruptedException {
    WaitNotifyTest test = new WaitNotifyTest();
    test.start();   // create a thread that will do some task
    test.join();    // wait (main thread is blocked) until the task completed by the thread
    test.doNext();  // then do the next thing.
  }

  private void start() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          System.out.println("thread started working...");
          Thread.sleep(5000);   // simulate doing something
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        // once done, notify the thread in wait (i.e main thread in this case)
        synchronized (WaitNotifyTest.this) {
          System.out.println("thread done and notify the main thread");
          // notify(); // IllegalMonitorStateException
          WaitNotifyTest.this.notify();
        }
      }
    }).start();
  }
  private void join() {
    synchronized (this) { // an object of WaitNotifyTest. wait/notify should be called on the same object
      try {               // otherwise IllegalMonitorStateException
        System.out.println("main thread blocked until child thread done and notify me on this object");
        wait();   // main thread is blocked here
        System.out.println("main thread woke up again");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  private void doNext() {
    System.out.println("finally doing next");
  }
}
