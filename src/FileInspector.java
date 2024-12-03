import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 *
 * @author wulft
 *
 * Use the thread safe NIO IO library to read a file
 */
public class FileInspector
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")+"/src"));

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);
            chooser.rescanCurrentDirectory();

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int lines = 0;
                int words = 0;
                int characters = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    lines++;
                    words += rec.split("\\s").length;
                    characters += rec.length();
                    System.out.printf("\nLine %4d %-60s ", lines, rec);
                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
                System.out.println("Name: " + selectedFile.getName());
                System.out.println("Word count: " +words);
                System.out.println("Line count: " +lines);
                System.out.println("Character count: " + characters);



            } else  // User closed the chooser without selecting a file
            {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}