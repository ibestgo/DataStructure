package one.bestgo.misc;

// #1: Top level class can be either public or package-private.
// There is no top level protected or private class!!!
public class ProtectedFinal {
  // But a nested class can be a protected or private class.
  protected class Child1 {
  }
  private class Child2 {
  }

  // #2: protected final is used when a developer make sure no one alter it.
  protected final void method1() {
    System.out.println("method1");
  }
}

class Test extends ProtectedFinal {
  // A protected final method can be called from a subclass
  public void method2() {
    method1();
  }

//  // but can't override it as it is a final.
//  @Override
//  protected final void method1() {
//  }
}