package hass.piotr;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static final String csvpath = "C:\\Users\\piotr\\IdeaProjects\\javamasterclass\\MunroLib\\Munro DataSet\\munro_data_changed.csv";
    public static boolean append = true;
    public static ArrayList<String> df = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        readDataFromFile(csvpath);
       //for (int i = 0; i<df.size();i++){
       //    System.out.println("Index number " + i + "    " + df.get(i) + "\n");
       //}

        ArrayList<Hill> hills = convertToHill(df);
        System.out.println("Converted:\n");
        for(Hill hill : hills){
            System.out.println(hill.toString());
        }

    }
    public static ArrayList<String> readDataFromFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            df.add(line);
        }
        bufferedReader.close();
        return df;
    }
    public static ArrayList<Hill> convertToHill(ArrayList<String> hillsStrings){
        ArrayList<Hill> hills = new ArrayList<>();
        for (String hillString : hillsStrings){
            String[] column = hillString.split(",");
            double doBIHNumber = Double.valueOf(column[1]);
            String name = column[6];
            double heightFeet = Double.valueOf(column[10]);
            String gridRef = column[13];
            String type = "MUN";

            hills.add(new Hill(doBIHNumber, name, heightFeet, gridRef, type));
        }
        return hills;
    }
    public static void writeToFile(String path, ArrayList<String> df) throws IOException{
        FileWriter fileWriter = new FileWriter(path,append);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (String line : df){
            printWriter.printf("%s" + "%n", line);
        }
        printWriter.close();
    }

}
