package fileReader.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class readFile {
    ArrayList<String> file;
    ArrayList<String> stopWords;
    public ArrayList<String> readInstanceFile(String filePath) throws Exception{
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
        this.file=words;
        return words;
    }
    public void getStopWords() throws Exception{
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
        this.stopWords=stopWordsList;
    }
    public ArrayList<String> removeStopWords() throws Exception {
        getStopWords();
        for (int i = 0; i < stopWords.size(); i++) {
            for (int j=0; j< file.size(); j++){
                if (stopWords.get(i).equals(file.get(j))){
                    file.remove(j);
                }
            }
        }
        //System.out.println(file);
        return file;
    }
}
