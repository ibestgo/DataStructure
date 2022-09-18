package one.bestgo.search.graph;

import java.util.LinkedList;

public class TNode<T> {
  private T value;
  private LinkedList<TNode<T>> children;

  public TNode(T value) {
    this.value = value;
    this.children = new LinkedList<>();
  }

  // It's not good as user has to create a node.
//  public void addChild(TreeNode<T> child) {
//    if(child != null) {
//      children.add(child);
//    }
//  }

  // This would be better
  public TNode<T> addChild(T child) {
    TNode<T> childNode = new TNode<>(child);
    children.add(childNode);
    return childNode;
  }

  public T getValue() {
    return value;
  }

  public LinkedList<TNode<T>> getChildren() {
    return children;
  }

  @Override
  public String toString() {
    // String.valueOf will transform a given object that is null to the String "null",
    // whereas .toString() will throw a NullPointerException.
    return String.valueOf(this.value);
  }
}
