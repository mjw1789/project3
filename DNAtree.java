import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DNAtree {
    public static void main(String[] args) throws Exception {

        String fileName = args[0];
        List<String > inputs = new ArrayList<>();
        inputs.add("testing");
        boolean good = true;

        Node rootNode = null;


        try{
            File file = new File (fileName);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine(); //reads the file gets each line


                if (line.contains("insert")) { //checks if current line is an insert
                    String parts[] = line.split(" ");
                    String input = parts[1];
                    if (inputs.contains(input)) {
                        System.out.println("sequence " + input + " already exits");
                    } else { // if current line isn't an insert it will always be a print
                        if (rootNode == null) {
                            rootNode = new Node(input);
                            System.out.println("sequence " + input + " inputed at level 0");
                            inputs.add(input);
                        } else {
                            int temp = rootNode.insert(rootNode, input, 0); 
                            System.out.println("sequence " + input + " inputed at level " + temp);
                            inputs.add(input);
                            
                        }
                    }

                } else {
                    int y = 0;
                    if (y == 0) {
                        System.out.println("Tree dump:");
                        y++;
                    }
                    rootNode.print(rootNode, 0);
                    }
                }
            
        } catch (FileNotFoundException e) {
            System.out.println("Invalid File");
        }
    }
}
