import java.util.*;
import java.io.*;

public class DNAtree {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];

        Node rootNode = new Node(null);

        try{
            File file = new File (fileName);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();

                if (line.contains("insert")) {
                    String parts[] = line.split(" ");
                    String input = parts[1];
                    rootNode.insert(rootNode, input, 0); //edit this
                } else if (line.contains("print")) {
                    Scanner fileReader2 = new Scanner(file);
                    while (fileReader2.hasNextLine()) {
                        line = fileReader2.nextLine();
                        //System.out.println(line);
                        if (line.contains("insert")) {
                            String parts[] = line.split(" ");
                            String input = parts[1];
                            System.out.println("sequence " + input + " inserted at level ");
                        }
                    }
                    System.out.println("Tree dump:");
                    String I = "I";
                    for (int i = 0; i < rootNode.height(rootNode); i++) {
                        System.out.println(I);
                        I = "  " + I;
                    }
                    rootNode.print(rootNode, 0);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid File");
        }
    }
}
