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
                    rootNode.print();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid File");
        }
    }
}
