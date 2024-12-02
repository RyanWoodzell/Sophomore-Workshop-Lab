package fileReader.src.java;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class fileMovement {
    public void createFolder(){

        //Scanner object
        Scanner scan = new Scanner(System.in);

        //retrieve the folderName the user would like to create
        System.out.println("Enter the name of the folder you would like to create");
        String folderName = scan.next();

        //create the path to the new folder
        String folderPath = "fileReader/allTopics/"; // The path where you want to create the folder
        folderPath = folderPath + folderName;

        //create new file
        File newFolder = new File(folderPath);

        //check if folder was created successfully
        if (newFolder.mkdir()) {
            System.out.println("Folder created successfully.");
        } else {
            System.out.println("Failed to create folder.");
        }

        //close scanner

    }


    public void moveFile(String desiredPath){
        Scanner scan = new Scanner(System.in);

        try {
            // Source file path
            System.out.println("Enter the file path of the article on your device");
            String filePath = scan.next();

            File sourceFile = new File(filePath);

            // Destination folder path
            File destinationFolder = new File(desiredPath);

            // Move the file
            Files.move(sourceFile.toPath(), destinationFolder.toPath().resolve(sourceFile.getName()), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File moved successfully!");

        } catch (IOException e) {
            System.out.println("Error moving file: " + e.getMessage());
        }

    }


    public void addArticle() {
        Scanner scanner = new Scanner(System.in);

        //offer the option of moving an article or adding
        System.out.println("Would you like to add an article, or move one from your device to our program:(add/move)");

        //response
        String addOrMove = scanner.nextLine().toLowerCase();

        //if statement for both choices
        if (addOrMove.equals("move")) {

            //retrieve name of folder
            System.out.println("Enter the name of the folder you would like to move an article in:");
            String folderName = scanner.next();

            //check if folder exists to prevent error
            if(checkIfFolderExists(folderName)){

                //create new path and move file
                String articlePath = "fileReader/allTopics/";
                articlePath = articlePath + folderName;
                moveFile(articlePath);

            }else{
                //folder does not exist
                System.out.println("Folder does not exist.");
                return;
            }

        }else if (addOrMove.equals("add")) {

            //retrieve name of folder
            System.out.println("Enter the name of the folder you would like to add an article in:");
            String folderName = scanner.next();

            //check if folder exists
            if(checkIfFolderExists(folderName)){

                String articlePath = "fileReader/allTopics/";
                articlePath = articlePath + folderName;
                createTxtFile(articlePath, scanner);

            }else{

                System.out.println("Folder does not exist.");
                return;

            }
        }

        //scanner close

        }

    //create TxtFile
    public void createTxtFile(String articlePath, Scanner scanner){

        Scanner sc = new Scanner (System.in);

        System.out.println("Enter a file name: ");
        String fileName = sc.nextLine();

        //create file path
        articlePath = articlePath + "/"+ fileName;
        articlePath = articlePath + ".txt";

        //read each input line by line, exiting when the user types exit.
        try (

             FileWriter writer = new FileWriter(articlePath)) {

            System.out.println("Enter text to write to the file (type 'exit' to finish):");

            while (true) {

                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {

                    //if user selects exit, file creation is stopped.
                    break;

                }

                writer.write(input + System.lineSeparator());
            }

            System.out.println("File created successfully.");

        } catch (IOException e) {

            System.out.println("An error occurred: " + e.getMessage());

        }

    }

    //method to check if folder is existing to prevent error.
    public boolean checkIfFolderExists(String folderName) {

        String folderPath = "fileReader/allTopics/";
        folderPath = folderPath + folderName;

        File folder = new File(folderPath);

        return folder.exists() && folder.isDirectory();
    }


    public static void main(String[] args) {
        //fileMovement fileMovement = new fileMovement();
        //fileMovement.createFolder();
        //fileMovement.addArticle();
        //fileMovement.moveFile();
    }}


