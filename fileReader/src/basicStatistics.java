package fileReader.src;

import java.util.ArrayList;

public class basicStatistics {
    static ArrayList<String> withstopwords;
    static ArrayList<String> withoutstopwords;
    static int uniquewords;

    public basicStatistics(ArrayList<String> withstopwords, ArrayList<String> withoutstopwords, int unqiuewords) {
        this.withstopwords = withstopwords;
        this.withoutstopwords = withoutstopwords;
        this.uniquewords = uniquewords;
    }

    public static void readsStatistics() {
        System.out.println("The number of words in the article before removing stopwords is " + withstopwords.size());
        System.out.println("The number of words in the article after removing stopwords is " + withoutstopwords.size());
        System.out.println("The number of unique words in the article is " + uniquewords);
    }

}