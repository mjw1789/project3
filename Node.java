import java.util.*;
import java.io.*;
import java.util.List;

public class Node {
  private boolean isLeaf;
  private Node[] children = {null, null, null, null, null};
  private String data;

// node constructor
  public Node(String data) {
    this.data = data;
    this.isLeaf = true;
}

  public Node() {
  }

/*
 * This function:
 * 1) Checks if the length of the sequence String parameter is less than the int i counter
 * 2) If it is then it will continue into the if statement
 *      - If it is not it will go to the else condition which creates a new node in the $ spot
 * 4) In the if statement it will take the current letter in the sequence by looking at what is 
 *    the character in the position of int i in the sequence, then it will call the letterNum 
 *    function on it to turn that char into an int so it can be used for the array positions
 * 4) In the if statement it will check if the leaf is a node
 * 5) If the leaf is a node it will take whatever data is stored in the node and then
 *    make the node an interior node before recursively calling insert on both the sequence
 *    and the data from the node you hit
 * 6) If it is not a leaf it will check if the node pointer is null
 *      - If it is null it will create a new node with the current letter as the pointer and 
 *        then it will insert the sequence into that new node
 *      - If it is not null it will resursively call insert on the next node with the currect
 *        letter pointer
 */
  public int insert (Node node, String sequence, int i) {
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
    } else {
      node.children[4] = new Node(sequence);
    }
    return 0; //doesn't matter, here so code won't get mad
}

int indent = 0;


/*
 * This function:
 * 1) Takes in a node arguemnt and an int level argument
 * 2) checks if the node is null and if it is you continue into the if statement
 *      - check if indent is equal to 0 and if it is then just print "E"
 *      - if it is not (else statement) then have a loop add the amount of spaces in
 *        front of the E that will be printed based on the int amount of indent
 * 3) checks if node is not a leaf 
 *      - If it is not a leaf then check if indent is 0
 *        - If indent is 0 then print "I" and add 1 to the int indent value
 *        - If it is anything other than 0 (else statement) then loop through indent size
 *          adding a space in front for each loop then print the proper spaces in front of "I"
 *          then add 1 to indent value
 * 4) Iterate through all the children in the array and recursively call print on them
 * 5) Subtract one fron indent value
 * 6) Check if node is a leaf
 *      - If it is a leaf check if it is not null and if that is the case then iterate through 
 *        the loop adding spaces for each time you go through based on the length of indent, then
 *        print the spaces and the node data that is stored in the node
 */
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

  /*
   * This function:
   * 1) Takes in a char argument
   * 2) Converts the char value into an int based on what letter it is
   * 3) Returns the proper int value
   */

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
  
}
