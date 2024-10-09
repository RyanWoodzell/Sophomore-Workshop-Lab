package fileReader.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class readFile {

    //Establish necessary fields

    ArrayList<String> file = new ArrayList<>();
    ArrayList<String> stopWords = new ArrayList<>();
    ArrayList<String> cleanedFile = new ArrayList<>();

    //Use methods to read and clean text file

    public ArrayList<String> readAndClean(String filePath) throws Exception{
        readInstanceFile(filePath);
        removeStopWords();
        return cleanedFile;

    }

    //Read file requested based on directed file path

    public void readInstanceFile(String filePath) throws Exception{

        // Passing the path to the file as a parameter

        FileReader fr = new FileReader(filePath);

        // Declaring loop variable

        int i;

        ArrayList<Character> chars = new ArrayList<Character>();
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Character> stopWordsChars = new ArrayList<Character>();
        String word = "";

        // Holds true till there is nothing to read

        while ((i = fr.read()) != -1){

            chars.add((char)i);
        }

        //adds a space so the reader will know to seperate the final word

        chars.add(' ');

        //Grammar Exclusion

        for(char c: chars){
            if ((c == ' ')||(c =='.')||(c==',')||(c==':')||(c=='?')||(c=='!')||(c==';')){

                if ((c =='.')||(c==',')||(c==':')||(c=='?')||(c=='!')||(c==';')){
                    //skip the punctuation
                    continue;
                }

                else {
                    //Adds the combined characters into the words ArrayList
                    words.add(word);
                    word = "";
                }

            }else{
                //Adds the characters to make a String
                word = word + c;

            }
        }

        //set fields

        this.file= words;
        cleanedFile = words;

    }

    //get the stopwords from txt file

    public void getStopWordsFromFile() throws Exception{

        // File path is passed as parameter
        File file = new File("fileReader/src/stopwords.txt");

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

        //update stopWordsList
        this.stopWords=stopWordsList;
    }
    public void removeStopWords() throws Exception {

        //obtain stop words from stop word txt file that will be compared.
        getStopWordsFromFile();

        //clone the original ArrayList
        this.cleanedFile=(ArrayList<String>) file.clone();

        //Traverse through stop words list. If any element in cleanedfile is a stop word, it will be removed.
        for (int j = 0; j<this.stopWords.size(); j++) {
            cleanedFile.remove(stopWords.get(j));

        }

    }
    public ArrayList<String> getStopWords(){
        return stopWords;
    }

    //getter methods

    public ArrayList<String> getFile() {
        return file;
    }
    public ArrayList<String> getCleanedFile(){
        return cleanedFile;
    }
}
