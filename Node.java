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

  /*he said that is it a leaf did not need to be included inside of this if statment and
   * could instead happen before it
   */

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

          /*in this if statment he said there needed to be a spot where this node is changed
           * to no longer be a leaf node since its not anymore since it now has a child node
           */
        }

        //if the node is null create a new node
        if (node == null) {
          node.children[letter] = new Node();
          insert(node.children[letter], sequence, i + 1);

          /*im struggling to remember what he said about this one but he said it was wrong 
           * whatever he said he made it sound like it was much simpler
           */
        }
    }
  }

//print method
  public String print() {
    String s = "temp";
    return s;
  }

}
