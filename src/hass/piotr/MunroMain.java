package hass.piotr;

import java.io.IOException;

public class MunroMain {

    /*File path to the munro_data_changed.
    Please use the changed csv file and change the variable path to the correct location.*/
    public static final String filePath = "C:\\Users\\piotr\\IdeaProjects\\javamasterclass\\MunroLib\\src\\hass\\piotr\\munro_data_changed.csv";

    public static void main(String[] args) throws IOException {

        /*All the possible test cases have been set.
         *There will be a lot of data printed in the terminal therefore please comment out the methods you don't want to check for easier readability*/

        //Initialize the object
        Munro munro = new Munro(filePath);

        //Original DataSet converted into a String Array
        System.out.println("Original Dataset\n");
        munro.printDataFrame(munro.getDataFrame());

        //Dataset converted into Hill Object Array
        System.out.println("Original Converted into Hills\n");
        munro.printHillArray(munro.getHills());

        //Array sorted by Height Ascending
        System.out.println("\n");
        munro.sortByHeight(munro.getHills(),true);
        munro.printHillArray(munro.getHills());

        //Array sorted by Height Descending
        System.out.println("\n");
        munro.sortByHeight(munro.getHills(),false);
        munro.printHillArray(munro.getHills());

        //Array sorted by Name Ascending
        System.out.println("\n");
        munro.sortByName(munro.getHills(),true);
        munro.printHillArray(munro.getHills());

        //Array sorted by Name Descending
        System.out.println("\n");
        munro.sortByName(munro.getHills(),false);
        munro.printHillArray(munro.getHills());

        //Array sorted by Height and Name
        System.out.println("\n");
        munro.sortByHeightAndName(munro.getHills());
        munro.printHillArray(munro.getHills());

        //Array filtered by "MUN" category printing 10 items only
        System.out.println("\n");
        munro.printHillArray(munro.filterByType(munro.getHills(), "MUN"));

        //Array filtered by "TOP" category printing 10 items only
        System.out.println("\n");
        munro.printHillArray(munro.filterByType(munro.getHills(), "TOP"));

        //Array filtered by Height category printing 10 items only
        System.out.println("\n");
        munro.printHillArray(munro.filterByHeight(munro.getHills(), 918));

    }
}
