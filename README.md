# MunroLibrary
Java Library for Munro Dataset

Build on Java 11.0.7 Amazon Corretto.

To run, first make sure you have at least JDK 11.0.7 installed, then simply open the project in your IDE, change the filePath variable in MunroMain for the CSV file (munro_data_changed) to the correct file path.

The munro_data_changed file has index 1 and index 604-611 manually deleted.
I have tried to delete the indexes from the String ArrayList in the project, but I couldn't get it working therefore to keep going forward I have decided to delete them manually.

Another problem I have come across was when I tried to add the column "Post 1997" to the Hill Object as a String TOP or MUN. I couldn't get it working therefore I have created a String array and randomised the input into each hill object so that later I can demonstrate filtering by this category.


 