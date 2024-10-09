package fileReader.src;// Java Program to Illustrate reading from
// FileReader using FileReader class

// Importing input output classes
import java.io.*;
import java.util.*;
import java.util.Arrays;


// Main class
// ReadingFromFile
public class Main {

    // Main driver method
    public static void main(String[] args) throws Exception {
        ArrayList<String> stopWords = getStopWords();
        readFile a = new readFile();
        ArrayList<String> textWords = a.readInstanceFile("fileReader/src/Hello World.txt");
        ArrayList<String> removedWords = removeStopWords(stopWords, textWords);
        //frequencies(removedWords);
        //int uniqueW = uniqueWords(textWords);
        //System.out.println(uniqueW);
        //basicStatistics(readFile(), removeStopWords(stopWords, textWords), uniqueWords(removeStopWords(stopWords, textWords)));
        String[] finalWords = listToArray(removedWords);
        countFreq(finalWords, finalWords.length);
        System.out.print("hello");
    }

    public static ArrayList<String> getStopWords() throws Exception{
        // File path is passed as parameter
        File file = new File(
                "fileReader/src/stopwords.txt");

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        ArrayList<String> stopWordsList= new ArrayList<String>();
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) {
            // Place String Into Array List
            stopWordsList.add(st);
        }
        return stopWordsList;
    }
    /*public static ArrayList<String> readFile(String filePath) throws Exception{
        // Passing the path to the file as a parameter
        FileReader fr = new FileReader(
                //"C:\\Users\\ryanw\\IdeaProjects\\untitled\\src\\Hello World.txt");
                filePath);
        // Declaring loop variable
        int i;
        ArrayList<Character> cars = new ArrayList<Character>();
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Character> stopWordsChars = new ArrayList<Character>();
        String word = "";
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1){

            cars.add((char)i);
            //System.out.print((char)i);
            }
        cars.add(' ');
        for(char c: cars){
            if ((c == ' ')||(c =='.')||(c==',')||(c==':')||(c=='?')||(c=='!')||(c==';')){
                if ((c =='.')||(c==',')||(c==':')||(c=='?')||(c=='!')||(c==';')){
                    continue;
                }
                else {
                    words.add(word);
                    word = "";
                }
            }else{
                word = word + c;

            }
        }
        return words;
    }*/
    public static ArrayList<String> removeStopWords(ArrayList<String> stopWords, ArrayList<String> words){
        for (int i = 0; i < stopWords.size(); i++) {
            for (int j=0; j< words.size(); j++){
                if (stopWords.get(i).equals(words.get(j))){
                    words.remove(j);
                }
            }
        }
        System.out.println(words);
        return words;
    }
    public static int uniqueWords(ArrayList<String> words){
        Object[] object = words.toArray();
        //need to implement a if statement to make everything in array lowercase
        for (int i = 0; i < object.length; i++) {
            object[i] = object[i].toString().toLowerCase();
        }
        Set result = new HashSet(Arrays.asList(object));
        return(result.size());
    }
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
    public static void basicStatistics(ArrayList<String> withstopwords, ArrayList<String> withoutstopwords, int unqiuewords){
        System.out.println("The number of words in the article before removing stopwords is " + withstopwords.size());
        System.out.println("The number of words in the article after removing stopwords is "+ withoutstopwords.size());
        System.out.println("The number of unique words in the article is " + unqiuewords);

    }
    public static String[] listToArray(ArrayList<String> words){
        String[] str = new String[words.size()];

        for (int i = 0; i < words.size(); i++) {
            str[i] = words.get(i);
        }
        return(str);

    }
    }
