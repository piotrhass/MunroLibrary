package hass.piotr;

//Imports
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Munro {

    //Fields
    private final String filePath;
    private ArrayList<String> dataFrame;
    private ArrayList<Hill> hills;

    //Constructor
    public Munro(String filePath) throws IOException {
        System.out.println("Munro ArrayList Initialized");
        this.filePath = filePath;
        dataFrame = new ArrayList<String>();
        readDataFromFile(filePath);
        hills = convertToHill(dataFrame);
    }

    //Returns filePath variable
    public String getFilePath() {
        return filePath;
    }

    //Returns dataFrame ArrayList of type String
    public ArrayList<String> getDataFrame() {
        return dataFrame;
    }

    //Returns hills ArrayList of type Hill
    public ArrayList<Hill> getHills() {
        return hills;
    }

    /*Converts data from a CSV file and returns a String ArrayList.
     *Using Buffered Reader and File Reader that checks the path parameter, loop through the CSV file and add each index to String ArrayList.*/
    public ArrayList<String> readDataFromFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            dataFrame.add(line);
        }
        bufferedReader.close();
        return dataFrame;
    }

    /*Converts the ArrayList of Strings into Hill objects and returns a Hill ArrayList
     *First, initialize a empty Hill ArrayList.
     *Next, loop through the String ArrayList and split each object column by ",".
     *Next, assign each column value into right variables.
     *Finally, add the hill object into the Hill ArrayList and return the complete Hill ArrayList.*/
    public ArrayList<Hill> convertToHill(ArrayList<String> hillsStrings) {
        ArrayList<Hill> hills = new ArrayList<>();
        for (String hillString : hillsStrings) {
            String[] column = hillString.split(",");
            double doBIHNumber = Double.valueOf(column[1]);
            String name = column[6];
            double heightFeet = Double.valueOf(column[10]);
            String gridRef = column[13];
            String[] type = {"MUN", "TOP"};
            int randomNumber = new Random().nextInt(type.length);
            hills.add(new Hill(doBIHNumber, name, heightFeet, gridRef, type[randomNumber]));
        }
        return hills;
    }

    /*Sort the Hill ArrayList by Height.
     *Using the Collections sort Method we sort the Array By comparing two objects to each other using the hill double height parameter.
     *If the Ascending parameter is set to true then we sort the ArrayList in Ascending order, else it's set to false then we sort it in Descending order.*/
    public void sortByHeight(ArrayList<Hill> hillsArray, boolean ascending) {
        if (ascending) {
            System.out.println("Sorting ArrayList by Height Ascending");
        } else {
            System.out.println("Sorting ArrayList by Height Descending");
        }
        Collections.sort(hillsArray, new Comparator<Hill>() {
            @Override
            public int compare(Hill o1, Hill o2) {
                if (ascending) {
                    return Double.compare(o1.getHeightFeet(), o2.getHeightFeet());
                } else {
                    return Double.compare(o2.getHeightFeet(), o1.getHeightFeet());
                }
            }
        });
    }

    /*Sort the Hill ArrayList by Name.
     *Using the Collections sort Method we sort the Array By comparing two objects to each other using the hill name parameter.
     *If the Ascending parameter is set to true then we sort the ArrayList in Ascending order, else it's set to false then we sort it in Descending order.*/
    public void sortByName(ArrayList<Hill> hillsArray, boolean ascending) {
        if (ascending) {
            System.out.println("Sorting ArrayList by Name Ascending");
        } else {
            System.out.println("Sorting ArrayList by Name Descending");
        }
        Collections.sort(hillsArray, new Comparator<Hill>() {
            @Override
            public int compare(Hill o1, Hill o2) {
                if (ascending) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return o2.getName().compareTo(o1.getName());
                }
            }
        });
    }

    /*Sort the Hill ArrayList by Height and Name.
     *First the ArrayList is sorted by Name Ascending then it is sorted by height.
     *Using the Collections sort Method we sort the Array By comparing two objects to each other using the hill height parameter.*/
    public void sortByHeightAndName(ArrayList<Hill> hillsArray) {
        System.out.println("Sorting ArrayList by Height and Name");
        sortByName(hillsArray, true);
        Collections.sort(hillsArray, new Comparator<Hill>() {
            @Override
            public int compare(Hill o1, Hill o2) {
                if ((o1.getHeightFeet() == o2.getHeightFeet())) {
                    return Double.compare(o1.getHeightFeet(), o2.getHeightFeet());
                } else {
                    return Double.compare(o2.getHeightFeet(), o1.getHeightFeet());
                }
            }
        });
    }

    /*Filter the Hill ArrayList by double height and return a new Hill ArrayList with 10 or less Results.
     *Loop through original ArrayList and if ((hill height is equal to the height parameter) and (the size of the new ArrayList is under 10)) add the item to the new arrayList.*/
    public ArrayList<Hill> filterByHeight(ArrayList<Hill> hillsArray, double height) {
        ArrayList<Hill> filteredHills = new ArrayList<>();
        System.out.println("Filtering by Height(Feet): " + height);
        for (Hill hill : hillsArray) {
            if ((hill.getHeightFeet() == height) && (filteredHills.size() <= 10)) {
                filteredHills.add(hill);
            }
        }
        return filteredHills;
    }

    /*Filter the Hill ArrayList by String type and return a new Hill ArrayList with 10 Results.
     *Loop through original ArrayList and if ((hill type is equal to the type parameter) and (the size of the new ArrayList is under 10)) add the item to the new arrayList.*/
    public ArrayList<Hill> filterByType(ArrayList<Hill> hillsArray, String type) {
        ArrayList<Hill> filteredHills = new ArrayList<>();
        System.out.println("Filtering by type: " + type.toUpperCase());
        for (Hill hill : hillsArray) {
            if ((hill.getType() == type) && (filteredHills.size() <= 10)) {
                filteredHills.add(hill);
            }
        }
        return filteredHills;
    }

    //Print the Hill ArrayList by looping through it and printing out each index item.
    public void printHillArray(ArrayList<Hill> hillsArray) {
        for (Hill hill : hillsArray) {
            System.out.println(hill.toString());
        }
    }

    //Print the String ArrayList by looping through it and printing out each index item.
    public void printDataFrame(ArrayList<String> dataFrame) {
        for (String str : dataFrame) {
            System.out.println(str);
        }
    }
}
