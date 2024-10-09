package fileReader.src;

import java.io.FileReader;
import java.util.ArrayList;

public class readFile {
    public static ArrayList<String> readInstanceFile(String filePath) throws Exception{
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
    }
}
