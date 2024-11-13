package fileReader.src.java;

import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderEJR {
    public void run() throws Exception {
        //User Interface
        boolean running = true;
        while(running){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the FileReader");
        System.out.println("Would you like to read articles about 1. The Olympics or 2. The Presidential Election. (Input 1 or 2)");
        int topicResponse = sc.nextInt();
            if(topicResponse == 1) {

            //Create read file objects

            readFile d = new readFile();
            readFile e = new readFile();
            readFile f = new readFile();

            //Read all olympic files and clean
            d.getTxt("fileReader/src/Topic2Olympics/OlympicsArticle1.txt");
            e.getTxt("fileReader/src/Topic2Olympics/OlympicArticle2.txt");
            f.getTxt("fileReader/src/Topic2Olympics/OlympicArticle3.txt");
            ArrayList<String> olympicsArticle1 = d.readAndClean("fileReader/src/Topic2Olympics/OlympicsArticle1.txt");
            ArrayList<String> olympicsArticle2 = e.readAndClean("fileReader/src/Topic2Olympics/OlympicArticle2.txt");
            ArrayList<String> olympicsArticle3 = f.readAndClean("fileReader/src/Topic2Olympics/OlympicArticle3.txt");

            //Gather Basic Statistics for each article

            basicStatistics O1 = new basicStatistics(d.getFile(), d.getCleanedFile());
            basicStatistics O2 = new basicStatistics(e.getFile(), e.getCleanedFile());
            basicStatistics O3 = new basicStatistics(f.getFile(), f.getCleanedFile());

            System.out.println("What Would you like to know:\n1.Which article uses the richest vocabulary?\n2.See the top words repeated in each article?\n3.Sentiment Analysis");
            System.out.println("Select 1/2/3 : ");
            int response = sc.nextInt();
            if(response == 1) {
                System.out.println("What amount of prevelent words would you like to see(integer):");
                int amount = sc.nextInt();

                //Richest Vocab
                System.out.println("Article 1");
                O1.topWords(amount);
                System.out.println("Article 2");
                O2.topWords(amount);
                System.out.println("Article 3");
                O3.topWords(amount);
            }
            else if(response == 2) {
                System.out.println("Article 1");
                O1.richestvocabulary();
                System.out.println("Article 2");
                O2.richestvocabulary();
                System.out.println("Article 3");
                O3.richestvocabulary();
            }
            else if(response == 3) {
                System.out.println("Would you like to analyze article 1, 2, or 3: ");
                int olympicSentimentResponse = sc.nextInt();
                if(olympicSentimentResponse == 1) {
                    O1.sentimentAnalysis(d.getOriginalFile());
                }
                else if(olympicSentimentResponse == 2) {
                    O2.sentimentAnalysis(e.getOriginalFile());
                }
                else if(olympicSentimentResponse == 3) {
                    O3.sentimentAnalysis(f.getOriginalFile());
                }
                else{
                    System.out.println("Please enter a number that corresponds to an article.");
                }

            }

        }
        else if(topicResponse == 2) {
            //Read and clean all election files.

            readFile a = new readFile();
            readFile b = new readFile();
            readFile c = new readFile();

            //Read and clean all election files.
                a.getTxt("fileReader/src/Topic1Election/electionArticle1.txt");
                b.getTxt("fileReader/src/Topic1Election/electionArticle2.txt");
                c.getTxt("fileReader/src/Topic1Election/electionArticle3.txt");
            ArrayList<String> electionArticle1 = a.readAndClean("fileReader/src/Topic1Election/electionArticle1.txt");
            ArrayList<String> electionArticle2 = b.readAndClean("fileReader/src/Topic1Election/electionArticle2.txt");
            ArrayList<String> electionArticle3 = c.readAndClean("fileReader/src/Topic1Election/electionArticle3.txt");

            //Gather basic statistics about election files
            basicStatistics E1 = new basicStatistics(a.getFile(), a.getCleanedFile());
            basicStatistics E2 = new basicStatistics(b.getFile(), b.getCleanedFile());
            basicStatistics E3 = new basicStatistics(c.getFile(), c.getCleanedFile());


            System.out.println("What Would you like to know:\n1.Which article uses the richest vocabulary?\n2.See the top words repeated in each article?\n3.Sentiment Analysis");
            System.out.println("Select 1/2/3 : ");
            int response = sc.nextInt();
            if(response == 1) {
                System.out.println("What amount of prevelent words would you like to see(integer):");
                int amount = sc.nextInt();

                //Richest Vocab
                System.out.println("Article 1");
                E1.topWords(amount);
                System.out.println("Article 2");
                E2.topWords(amount);
                System.out.println("Article 3");
                E3.topWords(amount);
            }
            else if(response == 2) {
                System.out.println("Article 1");
                E1.richestvocabulary();
                System.out.println("Article 2");
                E2.richestvocabulary();
                System.out.println("Article 3");
                E3.richestvocabulary();
            }
            else if(response == 3) {
                System.out.println("Would you like to analyze article 1, 2, or 3: ");
                int electionSentimentResponse = sc.nextInt();
                if(electionSentimentResponse == 1) {
                    E1.sentimentAnalysis(a.getOriginalFile());
                }
                else if(electionSentimentResponse == 2) {
                    E2.sentimentAnalysis(b.getOriginalFile());
                }
                else if(electionSentimentResponse == 3) {
                    E3.sentimentAnalysis(c.getOriginalFile());
                }
                else{
                    System.out.println("Please enter a number that corresponds to an article.");
                }

            }

        }

        System.out.print("Would you like to read again? Enter 'no' to stop.");
        String yesOrNo = sc.next();
        if(yesOrNo.equalsIgnoreCase("no")){
            running = false;
        }

    }
    }}

