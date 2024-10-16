package fileReader.src;

// Importing input output classes
import java.io.*;
import java.util.*;
import java.util.Arrays;


// Main class
// ReadingFromFile
public class Main {

    // Main driver method
    public static void main(String[] args) throws Exception {

        //Create file objects

        readFile a = new readFile();
        readFile b = new readFile();
        readFile c = new readFile();
        readFile d = new readFile();
        readFile e = new readFile();
        readFile f = new readFile();
        readFile g = new readFile();

        //read and clean files from their paths

        ArrayList<String> electionArticle1= a.readAndClean("fileReader/src/Topic1Election/electionArticle1.txt");
        ArrayList<String> electionArticle2 = b.readAndClean("fileReader/src/Topic1Election/electionArticle2.txt");
        ArrayList<String> electionArticle3 = c.readAndClean("fileReader/src/Topic1Election/electionArticle3.txt");
        ArrayList<String> olympicsArticle1 = d.readAndClean("fileReader/src/Topic2Olympics/OlympicsArticle1.txt");
        ArrayList<String> olympicsArticle2 = e.readAndClean("fileReader/src/Topic2Olympics/OlympicArticle2.txt");
        ArrayList<String> olympicsArticle3 = f.readAndClean("fileReader/src/Topic2Olympics/OlympicArticle3.txt");

        //Gather Basic Statistics from each file

        basicStatistics E1 = new basicStatistics(a.getFile(), a.getCleanedFile());
        basicStatistics E2 = new basicStatistics(b.getFile(), b.getCleanedFile());
        basicStatistics E3 = new basicStatistics(c.getFile(), c.getCleanedFile());
        basicStatistics O1 = new basicStatistics(d.getFile(), d.getCleanedFile());
        basicStatistics O2 = new basicStatistics(e.getFile(), e.getCleanedFile());
        basicStatistics O3 = new basicStatistics(f.getFile(), f.getCleanedFile());

        E1.readStatistics();
        E2.readStatistics();
        E3.readStatistics();
        O1.readStatistics();
        O2.readStatistics();
        O3.readStatistics();


        /*


        //Read and clean imported files

        //frequencies(removedWords);
        //int uniqueW = uniqueWords(textWords);
        //System.out.println(uniqueW);
        //basicStatistics(readFile(), removeStopWords(stopWords, textWords), uniqueWords(removeStopWords(stopWords, textWords)));
        String[] finalWords = listToArray(removedWords);
        countFreq(finalWords, finalWords.length);
        basicStatistics z = new basicStatistics(a.getFile(), a.getCleanedFile());
        z.readStatistics();

         */

    }}

    /*
    public static void countFreq(String arr[], int n) {
        boolean visited[] = new boolean[n];

        Arrays.fill(visited, false);

        // Traverse through array elements and
        // count frequencies
        for (int i = 0; i < n; i++) {

            // Skip this element if already processed
            if (visited[i] == true)
                continue;

            // Count frequency
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i].equalsIgnoreCase(arr[j])){
                    visited[j] = true;
                    count++;
                }
            }
            //print out
            System.out.println(arr[i] + " " + count);
        }
    }
    public static String[] listToArray(ArrayList<String> words){
        String[] str = new String[words.size()];

        for (int i = 0; i < words.size(); i++) {
            str[i] = words.get(i);
        }
        return(str);

    }
    }
*/