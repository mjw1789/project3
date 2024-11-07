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
  public int insert (Node node, String sequence, int i) {
    //base case - if no tree exists yet

    //set the current letter to the correct one in the sequence
    if (i < sequence.length()){
      char letter = sequence.charAt(i);
      int letterNumber = letterNum(letter);

      if (node.isLeaf) {
        String s = node.data;
        node.data = null;
        node.isLeaf = false; //not sure about this
        insert (node, s, i);
        return insert(node, sequence, i);
      } else if (!node.isLeaf) {
        if(node.children[letterNumber] == null) {
          node.children[letterNumber] = new Node(sequence);
          return i + 1;
        }
        else {
          return insert(node.children[letterNumber], sequence, i + 1);
        }
      }
    }
    return 17; //check this later
}

int indent = 0;
//print method
  public void print(Node node, int level) {

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
    root.children[4] = new Node("TGC");
    Node n2 = new Node();
    Node n3 = new Node();
    root.children[0] = n2;
    n2.isLeaf = false;
    n3.isLeaf = false;

    n2.children[0] = n3;
    n3.children[0] = new Node("AAA");
    n3.children[4] = new Node("AA");
    root.print(root, 0);
  }
}
