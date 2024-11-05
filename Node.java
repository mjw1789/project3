import java.util.*;
import java.io.*;
import java.util.List;

public class Node {
  private boolean isLeaf;
  private Node[] children = {null, null, null, null, null};
  //private int level;
  private String sequence;
  private String data;

  public Node(String data) {
    this.data = data;
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
        insert(node.children[letterNumber], sequence, i);
      } else if (!node.isLeaf) {
        if(node.children[letterNumber] == null) {
          node.children[letterNumber] = new Node(sequence);
        }
      }
    }
}


//print method
  public void print(Node node, int level) {
    if (node == null) {
      return;
    }
      System.out.println(node.data);
      print(node.children[0], level + 1);
      if(node.children[0] == null) {
        node.data = "E";
        System.out.println(node.data);
        }
      print(node.children[1], level + 1);
      if(node.children[1] == null) {
        node.data = "E";
        System.out.println(node.data);
      }
      print(node.children[2], level + 1);
      if(node.children[2] == null) {
        node.data = "E";
        System.out.println(node.data);
      }
      print(node.children[3], level + 1);
      if(node.children[3] == null) {
        node.data = "E";
        System.out.println(node.data);
      }
      print(node.children[4], level + 1);
      if(node.children[4] == null) {
        node.data = "E";
        System.out.println(node.data);
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

  public int height(Node node) {
    if (node == null) {
      return 0;
    }
    int H0 = height(node.children[0]);
    int H1 = height(node.children[1]);
    int H2 = height(node.children[2]);
    int H3 = height(node.children[3]);
    int H4 = height(node.children[4]);

    List<Integer> numbers = List.of(H0,H1,H2,H3,H4);
    int max = 0;
    for (int x = 0; x < 5; x++) {
      if (numbers.get(1) >= max) {
        max = numbers.get(1);
      }
    }
    System.out.println(H0);
    System.out.println(H1);
    System.out.println(H2);
    System.out.println(H3);
    System.out.println(H4);

    System.out.println(max);

    return max + 1;

  }
}
