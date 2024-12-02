package fileReader.src.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderEJR {
    public void run() throws Exception {
        //User Interface
        //Makes 2 scanners, one for folder name and one for filename
        Scanner foldersc = new Scanner(System.in);
        Scanner filesc = new Scanner(System.in);

        //arraylist to collect filenames
        ArrayList<String> filenames = new ArrayList<>();

        //let user choose file to analyze
        System.out.println("Please enter the name of the folder you want to analyze: ");
        String folderName = foldersc.nextLine();
        //checks if folder exists. If it does exist then allow user to enter article names they want to analyze
        if(checkIfFolderExists(folderName)){
            System.out.println("Now you will enter names of the articles within that folder you want to analyze (do not write .txt after) ");
            boolean keepgettingfilenames = true;
            String getfilename;
            while(keepgettingfilenames){ //coninues while user wants to keep entering article names
                System.out.println("Do you want to enter an article name? (yes or no) ");
                getfilename = filesc.nextLine();
                if(getfilename.equalsIgnoreCase("yes")){
                    System.out.println("Enter article name: ");

                    String fname = filesc.nextLine();
                    filenames.add("fileReader/allTopics/" + folderName + "/" + fname + ".txt");
                }
                else if(getfilename.equalsIgnoreCase("no")){
                    keepgettingfilenames = false;
                }
                else{
                    System.out.println("Please enter yes or no");
                }
            }
        } else{
            System.out.println("Please enter an existing folder name ");
        }

        try{
            if(filenames.size()>0) { //ensures the user added articles
                analyzeArticles(folderName, filenames);
            }
            else {
                System.out.println("Make sure you analyze a folder with at least one article");
            }
        }catch (Exception e){
            System.out.println("Make sure all article names you entered are correct and they exist");
        }


    }

public void analyzeArticles(String folderPath, ArrayList fileNames) throws Exception {
    Scanner sc = new Scanner(System.in);
    readFile[] articles = new readFile[fileNames.size()];
    basicStatistics[] statistics = new basicStatistics[fileNames.size()];

    // Read and clean articles
    for (int i = 0; i < fileNames.size(); i++) {
        String filePath = (String)fileNames.get(i);
        articles[i] = new readFile();
        articles[i].getTxt(filePath);
        articles[i].readAndClean(filePath);

        statistics[i] = new basicStatistics(articles[i].getFile(), articles[i].getCleanedFile());
    }

    // Ask for analysis type
    System.out.println("What Would you like to know:\n1. Which article uses the richest vocabulary?\n2. See the top words repeated in each article?\n3. Sentiment Analysis");
    System.out.println("Select 1/2/3 : ");
    int response = sc.nextInt();

    switch(response) {
        case 1: //this case will check all articles richest vocab
            for (int i = 0; i < statistics.length; i++) {
                System.out.println("Article " + (i+1));
                statistics[i].richestvocabulary();
            }
            break;
        case 2: // this case will check all articles top words
            System.out.println("What amount of prevalent words would you like to see(integer):");
            int amount = sc.nextInt();
            for (int i = 0; i < statistics.length; i++) {
                System.out.println("Article " + (i+1));
                statistics[i].topWords(amount);
            }
            break;
        case 3: // this case will check all articles sentiment
            System.out.println("*Please wait for sentiment analysis to conclude, this may take a moment*");
            for (int i = 0; i < articles.length; i++) {
                // Perform sentiment analysis for each article
                System.out.println("Article " + (i+1));
                statistics[i].sentimentAnalysis(articles[i].getOriginalFile());
            }
            break;
        default:
            System.out.println("Invalid choice.");
    }

}
    public boolean checkIfFolderExists(String folderName) { //ensures the folder the user entered exists

        String folderPath = "fileReader/allTopics/";
        folderPath = folderPath + folderName;

        File folder = new File(folderPath);

        return folder.exists() && folder.isDirectory();

    }
}

