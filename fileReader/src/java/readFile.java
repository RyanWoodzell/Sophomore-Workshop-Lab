//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package fileReader.src.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class readFile {
    ArrayList<String> file = new ArrayList();
    ArrayList<String> stopWords = new ArrayList();
    ArrayList<String> cleanedFile = new ArrayList();
    String finalText = "";

    public readFile() {
    }

    public ArrayList<String> readAndClean(String filePath) throws Exception {
        this.readInstanceFile(filePath);
        this.removeStopWords();
        return this.cleanedFile;
    }

    public void readInstanceFile(String filePath) throws Exception {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder stringBuilder = new StringBuilder();
        new StringBuilder();

        String line;
        while((line = br.readLine()) != null) {
            String cleanedLine = line.replaceAll("[^\\sa-zA-Z0-9]", "");
            stringBuilder.append(cleanedLine).append(" ");
        }

        String[] wordsArray = stringBuilder.toString().split("\\s+");
        ArrayList<String> words = new ArrayList();
        String[] var10 = wordsArray;
        int var11 = wordsArray.length;

        for(int var12 = 0; var12 < var11; ++var12) {
            String word = var10[var12];
            if (!word.isEmpty()) {
                words.add(word.toLowerCase());
            }
        }

        this.file = words;
        this.cleanedFile = new ArrayList(words);
    }

    public void getStopWordsFromFile() throws Exception {
        File file = new File("fileReader/src/stopwords.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> stopWordsList = new ArrayList();

        String st;
        while((st = br.readLine()) != null) {
            stopWordsList.add(st);
        }

        this.stopWords = stopWordsList;
    }

    public void removeStopWords() throws Exception {
        this.getStopWordsFromFile();
        this.cleanedFile = (ArrayList)this.file.clone();
        Iterator var1 = this.stopWords.iterator();

        while(var1.hasNext()) {
            String stopWord = (String)var1.next();

            for(int i = 0; i < this.cleanedFile.size(); ++i) {
                this.cleanedFile.remove(stopWord);
            }
        }

    }

    public void getTxt(String filePath) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            try {
                StringBuilder sb = new StringBuilder();

                while(true) {
                    String line;
                    if ((line = br.readLine()) == null) {
                        String fileContent = sb.toString();
                        this.finalText = fileContent;
                        break;
                    }

                    sb.append(line);
                }
            } catch (Throwable var7) {
                try {
                    br.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            br.close();
        } catch (IOException var8) {
            IOException e = var8;
            System.err.println("Error reading the file: " + e.getMessage());
        }

    }

    public ArrayList<String> getStopWords() {
        return this.stopWords;
    }
    public ArrayList<String> getFile() {
        return this.file;
    }

    public ArrayList<String> getCleanedFile() {
        return this.cleanedFile;
    }

    public String getOriginalFile() {
        return this.finalText;
    }
}
