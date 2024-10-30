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
}

//insert method
  public void insert (Node node, String sequence, int i) {

    //set the current letter to the correct one in the sequence
    if (i < sequence.length()){
      char letter = sequence.charAt(i);

        //if the node is not a leaf then do not create a new node and use the exsiting one
        if (node.isLeaf == false) {
          if (node.children[letter] == null) {
            Node newNode = new Node(null);
            node.children[letter] = newNode;
          }
          insert(node.children[letter], sequence, i + 1);
        }

        //if the node is a leaf then create a new node to put the current character in
        if (node.isLeaf == true) {
          node.isLeaf = false;
          node.children[letter] = new Node(null);
          insert(node.children[letter], sequence, i + 1);
        }
        System.out.println(node);
    } /*else if (i == sequence.length()) {
      node.children["$"] = new Node(sequence);

    }*/
  }

//print method
  public String print() {
    String s = "temp";
    return s;
  }

}
