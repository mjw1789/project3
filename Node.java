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
  public void insert (Node node, String sequence, int i) {
    if (i < sequence.length()){
      char letter = sequence.charAt(i);
      if (node == null) {
        node.children[letter] = new Node();
      }
      insert(node.children[letter], sequence, i + 1);
    } else {
      node.children["$"] = new Node();
    } 
  }

//print method
  public String print() {
    String s = "temp";
    return s;
  }

}
