package homeLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutput {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getInput() { // TODO: change to another class??
        //System.console().readLine()//TODO: alternative
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    public static boolean getInputBool(boolean defaultChoice) {

        try {
            //System.console().readLine()
            String line = reader.readLine();
            switch (line) { //TODO: try look option from the other project might be more efficient/smarter
                case "yes":
                case "YES":
                case "Y":
                case "y":
                    return true;
                case "no":
                case "NO":
                case "n":
                case "N":
                    return false;
                default:
                    return defaultChoice;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return defaultChoice;
        }
    }
}
