import java.util.*;
import java.io.*;

public class Node {
  private String sequence;
  //private boolean isLeaf;
  private Node[] children;
  private int level;

//constructor
public Node() {
  int level = 0;
  children = null;
}

//insert method
  public void insert (Node root, String sequence) {

    for (int i=0; i < sequence.length(); i++) {
       char currentChar = sequence.charAt(i);
       System.out.print(currentChar);
    }

  }

//print method
  public String print() {
    String s = "temp";
    return s;
  }

//method to check if a node is a leaf or an interior node
  public boolean isLeaf(Node node) {
    if (node.children == null) {
      return true;
    } else {
      return false;
    }
  }

}
