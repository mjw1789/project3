import java.util.*;
import java.io.*;
import java.util.List;

public class Node {
  private boolean isLeaf;
  private Node[] children = {null, null, null, null, null};
  private String data;

  public Node(String data) {
    this.data = data;
    this.isLeaf = true;
}

  public Node() {
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

      if (node.isLeaf) {
        String s = node.data;
        node.data = null;
        node.isLeaf = false; //not sure about this
        insert (node, s, i++);
        insert(node.children[letterNumber], sequence, i++);
      } else if (!node.isLeaf) {
        if(node.children[letterNumber] == null) {
          node.children[letterNumber] = new Node(sequence);
        }
        else {
          insert(node.children[letterNumber], sequence, i);
        }
      }
    }
}

int indent = 0;
//print method
  public void print(Node node, int level) {

    //int indent = 0;
    String space = "  ";

    if (node == null) {
      if (indent == 0) {
        System.out.println("E");
        return;
      } else {
        String print = "";
          for (int i = 0; i < indent; i++) {
              print = print + space;
          }
          System.out.println(print + "E");
          return;
      }
    }
      if (!node.isLeaf) {
        if(indent == 0) {
          System.out.println("I");
          indent++;
        } else {
          String print = "";
          for (int i = 0; i < indent; i++) {
              print = print + space;
          }
          System.out.println(print + "I");
          indent++;
        }
        
        print(node.children[0], level + 1);
        print(node.children[1], level + 1);
        print(node.children[2], level + 1);
        print(node.children[3], level + 1);
        print(node.children[4], level + 1);
        indent--;

      }
      if (node.isLeaf) {
        if (node.data != null){
          String print = "";
          for (int i = 0; i < indent; i++) {
            print = print + space;
        }
          System.out.println(print + node.data);
        }
      }
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

  public static void testFakeTree() {
    Node root = new Node();
    root.isLeaf = false;
    root.children[0] = new Node("AAA");
    Node n3 = new Node();
    root.children[3] = n3;
    n3.children[0] = new Node("AA");
    root.print(root, 0);
  }
}
