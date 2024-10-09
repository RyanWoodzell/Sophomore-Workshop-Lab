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


        ArrayList<String> electionArticle1= a.readAndClean("fileReader/src/Topic1Election/electionArticle1.txt");
        basicStatistics z = new basicStatistics(a.getFile(), a.getCleanedFile());
        z.readStatistics();
        /*ArrayList<String> electionarticle1 = a.readInstanceFile("fileReader/src/Topic1Election/electionArticle1.txt");
        ArrayList<String> electionarticle2 = b.readInstanceFile("fileReader/src/Topic1Election/electionArticle2.txt");
        ArrayList<String> electionarticle3 = c.readInstanceFile("fileReader/src/Topic1Election/electionArticle3.txt");
        ArrayList<String> olympicsarticle1 = d.readInstanceFile("fileReader/src/Topic2Olympics/OlympicArticle1.txt");
        ArrayList<String> olympicsarticle2 = e.readInstanceFile("fileReader/src/Topic2Olympics/OlympicArticle2.txt");
        ArrayList<String> olympicsarticle3 = f.readInstanceFile("fileReader/src/Topic2Olympics/OlympicArticle3.txt");

        //Read and clean imported files
        a.readInstanceFile("fileReader/src/Topic1Election/electionArticle1.txt");
        b.readInstanceFile("fileReader/src/Topic1Election/electionArticle2.txt");
        c.readInstanceFile("fileReader/src/Topic1Election/electionArticle3.txt");
        d.readInstanceFile("fileReader/src/Topic2Olympics/OlympicArticle1.txt");
        e.readInstanceFile("fileReader/src/Topic2Olympics/OlympicArticle2.txt");
        f.readInstanceFile("fileReader/src/Topic2Olympics/OlympicArticle3.txt");
        ArrayList<String> removedWords = a.removeStopWords();
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