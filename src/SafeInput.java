import java.util.Scanner;
public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" +prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.isEmpty());

        return retString;
    }
    public static int getInt(Scanner pipe, String prompt){
        int retInt = 0;
        boolean proceed;
        do
        {
            System.out.print("\n" +prompt + ": ");

            if (pipe.hasNextInt()){
                retInt = pipe.nextInt();
                proceed = true;
            }else {
                pipe.nextLine();
                proceed = false;
            }
        }while (!proceed);
        return retInt;
    }
    public static double getDouble(Scanner pipe, String prompt){
        double retDouble = 0.0;
        boolean proceed;
        do
        {
            System.out.print("\n" +prompt + ": ");

            if (pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                proceed = true;
            }else {
                pipe.nextLine();
                proceed = false;
            }
        }while (!proceed);
        return retDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        int retInt = 0;
        boolean proceed;
        do
        {
            System.out.print("\n" +prompt + ": ");

            if (pipe.hasNextInt()){
                retInt = pipe.nextInt();
                if(retInt >= low && retInt <= high){
                    proceed = true;
                }else {proceed = false;}
            }else {
                pipe.nextLine();
                proceed = false;
            }
        }while (!proceed);
        return retInt;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double retDouble = 0.0;
        boolean proceed;
        do
        {
            System.out.print("\n" +prompt + ": ");

            if (pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                if (retDouble >= low && retDouble <= high){
                    proceed = true;
                }else {proceed = false;}
            }else {
                pipe.nextLine();
                proceed = false;
            }
        }while (!proceed);
        return retDouble;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt){
        boolean retBool = false;
        boolean proceed;
        String yOrN = "";
        do {
            System.out.print("\n" + prompt + ": ");
            yOrN = pipe.nextLine();
            if (yOrN.equalsIgnoreCase("y")){
                retBool = true;
                proceed = true;
            } else if (yOrN.equalsIgnoreCase("n")){
                retBool = false;
                proceed = true;
            }else {proceed = false;}
        }while(!proceed);
        return retBool;
    }
}

