import java.util.*;
import java.io.*;

public class Node {
  private boolean isLeaf;
  private Node[] children;
  private int level;

//constructor
public Node() {
  int level = 0;
  children = null;
  isLeaf = false;
}

//insert method
  public void insert (Node node, String sequence, int i) {
    if (i < sequence.length()){
      char letter = sequence.charAt(i);
        if (node.isLeaf == false) {
          insert(node.children[letter], sequence, i + 1);
        }
        if (node.isLeaf == true) {
          node.children[letter] = new Node();
          insert(node.children[letter], sequence, i + 1);
        }
        if (node == null) {
          node.children[letter] = new Node();
          insert(node.children[letter], sequence, i + 1);
        }
    }
  }

//print method
  public String print() {
    String s = "temp";
    return s;
  }

}
