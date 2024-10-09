package fileReader.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class basicStatistics {
    static ArrayList<String> withstopwords;
    static ArrayList<String> withoutstopwords;
    static int uniquewords;

    public basicStatistics(ArrayList<String> withstopwords, ArrayList<String> withoutstopwords) {
        this.withstopwords = withstopwords;
        this.withoutstopwords = withoutstopwords;
        this.uniquewords = uniquewords;
    }

    public static void readStatistics() {
        System.out.println("The number of words in the article before removing stopwords is " + withstopwords.size());
        System.out.println("The number of words in the article after removing stopwords is " + withoutstopwords.size());
        uniqueWords(withoutstopwords);
        System.out.println("The number of unique words in the article is " + uniquewords);
    }
    public static void uniqueWords(ArrayList<String> words){
        Object[] object = words.toArray();
        //need to implement a if statement to make everything in array lowercase
        for (int i = 0; i < object.length; i++) {
            object[i] = object[i].toString().toLowerCase();
        }
        Set result = new HashSet(Arrays.asList(object));
        uniquewords = result.size();
    }
}