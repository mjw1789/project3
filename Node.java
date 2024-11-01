import java.util.*;
import java.io.*;

public class Node {
  private boolean isLeaf;
  private Node[] children;
  private int level;
  private String sequence;
  private String data;

  public Node(String data) {
    this.data = data;
    children = null;
}

//insert method
  public void insert (Node node, String sequence, int i) {
    //base case - if no tree exists yet
    if (node == null) {
      Node root = new Node(sequence);
    }

    //set the current letter to the correct one in the sequence
    if (i < sequence.length()){
      char letter = sequence.charAt(i);
      int letterNumber = letterNum(letter);


    if (node.data != null && node.level() == 0) {
      String s = node.data;
      node.data = null;
      node.isLeaf = false; //not sure about this
      insert (node.children[letterNumber], s, i);
      insert(node.children[letterNumber], sequence, i);
    } else if (node.data != null && node.level() != 0) {
        node.children[4] = new Node(node.data);
        node.data = null;
        node.isLeaf = false; //not sure about this
        insert (node.children[letter], sequence, i);
    }

    //does it matter if it is a leaf or not?
    if (node.children[letterNumber] == null && node.data == null) {
      insert(node.children[letterNumber] = new Node(null), sequence, i);
    }

    if (node.children[letterNumber] != null && node.data == null) {
      insert(node.children[letterNumber], sequence, i);
    }
    //end of sequence insert sequence into last node
  }
  node.data = sequence;
}

//print method
  public String print() {
    String s = "temp";
    return s;
  }

  public int letterNum(char c){
    if (c == 'A') {
      return 0;
    }
    if (c == 'C') {
      return 1;
    }
    if (c == 'G') {
      return 2;
    }
    if (c == 'T') {
      return 3;
    }
    return 4;
  }

  private int level (Node node) {
  }

}
