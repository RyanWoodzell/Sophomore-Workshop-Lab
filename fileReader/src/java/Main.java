package fileReader.src.java;
import java.util.Scanner;

// Importing input output classes


// Main class
// ReadingFromFile
public class Main {

    // Main driver method
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome");

        boolean running = true;
        while (running) {
            System.out.println("_________________________________");
            System.out.println("Select an option");
            System.out.println("1. Select a topic");
            System.out.println("2. Add a new topic");
            System.out.println("3. Add a new article");
            System.out.println("4. Exit");
            fileMovement fileMovement = new fileMovement();
            String choice = scanner.next();
            scanner.nextLine();

            switch (choice) {
                case "1":
                    FileReaderEJR fileReader = new FileReaderEJR();
                    fileReader.run();
                    break;
                case "2":
                    fileMovement.createFolder();
                    break;
                case "3":
                    fileMovement.addArticle();
                    break;
                case "4":
                    System.out.println("Exiting the program");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }}

