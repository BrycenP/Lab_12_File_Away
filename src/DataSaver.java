import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;
/**
 *
 * @author wulft
 *
 * Demonstrates how to use Java NIO, a thread safe File IO library
 * to write a text file
 */
public class DataSaver
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList <String>recs = new ArrayList<>();

        boolean cont = true;

        while (cont){
            String firstName = SafeInput.getNonZeroLenString(in, "Enter your first name here");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter your last name here");
            String email = SafeInput.getRegExString(in, "Enter your email here", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
            int idNumber = SafeInput.getRangedInt(in, "Enter your ID number here", 0, 999999);
            int birthYear = SafeInput.getRangedInt(in, "Enter the year you were born here", 1900, 2100);
            in.nextLine();

            String record = firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + birthYear;
            recs.add(record);

            cont = SafeInput.getYNConfirm(in, "Do you want to add another record?");

        }
        String fileName = SafeInput.getNonZeroLenString(in, "Enter the filename to save the data (including .csv extension)");

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));
            for(String rec : recs)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
