package one.bestgo.misc;

// true singleton that is thread-safe
public class TrueSingleton {
  private static volatile TrueSingleton itself = null;

  private TrueSingleton() {
  }

  public static TrueSingleton getInstance() {
    if(itself == null) {
      synchronized(TrueSingleton.class) {
        // only 1 thread can enter here
        if(itself == null)
          itself = new TrueSingleton();
      }
    }
    return itself;
  }
}
