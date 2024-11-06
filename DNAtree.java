import java.util.*;
import java.io.*;

public class DNAtree {
    public static void main(String[] args) throws Exception {

        Node.testFakeTree();

        /*String fileName = args[0];

        Node rootNode = new Node(null);

        try{
            File file = new File (fileName);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                //System.out.println(line);

                System.out.println("Tree dump:");

                if (line.contains("insert")) {
                    //System.out.println("in here");
                    String parts[] = line.split(" ");
                    String input = parts[1];
                    //System.out.println(input);
                    rootNode.insert(rootNode, input, 0); //edit this
                } else {
                    rootNode.print(rootNode, 0);
                    //System.out.println("sequence " + input + " inserted at level ");
                    }
                }
            
        } catch (FileNotFoundException e) {
            System.out.println("Invalid File");
        }*/
    }
}
