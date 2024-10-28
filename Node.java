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

    //set the current letter to the correct one in the sequence
    if (i < sequence.length()){
      char letter = sequence.charAt(i);

        //if the node is not a leaf then do not create a new node and use the exsiting one
        if (node.isLeaf == false) {
          insert(node.children[letter], sequence, i + 1);
        }

        //if the node is a leaf then create a new node to put the current character in
        if (node.isLeaf == true) {
          node.children[letter] = new Node();
          insert(node.children[letter], sequence, i + 1);
        }

        //if the node is null create a new node
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
