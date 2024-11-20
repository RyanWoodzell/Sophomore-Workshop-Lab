package fileReader.src.java;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class fileMovement {

    public void createFolder(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the folder you would like to create");
        String folderName = scan.next();

        String folderPath = "fileReader/newTopics/"; // The path where you want to create the folder
        folderPath = folderPath + folderName;
        File newFolder = new File(folderPath);

        if (newFolder.mkdir()) {
            System.out.println("Folder created successfully.");
        } else {
            System.out.println("Failed to create folder.");
        }
    }
    public void moveFile(){
        Scanner scan = new Scanner(System.in);
        try {
            // Source file path
            System.out.println("Enter the file path of the article on your device");
            String filePath = scan.next();

            File sourceFile = new File(filePath);
            System.out.println("Enter the name of the folder you would like to move the article in:");
            String folderName = scan.next();
            String folderPath = "fileReader/newTopics/";
            folderPath = folderPath + folderName;
            // Destination folder path
            File destinationFolder = new File(folderPath);

            // Move the file
            Files.move(sourceFile.toPath(), destinationFolder.toPath().resolve(sourceFile.getName()), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File moved successfully!");

        } catch (IOException e) {
            System.out.println("Error moving file: " + e.getMessage());
        }
    }


    public void addArticle() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the folder you would like to add an article in:");
        String folderName = scanner.next();
        String articlePath = "fileReader/newTopics/";
        articlePath = articlePath + folderName;
        scanner.next();
        System.out.println("Enter the file path of the article on your device:");
        String article = scanner.next();



        try {
            File newFile = new File(articlePath);

            if (newFile.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        fileMovement fileMovement = new fileMovement();
        fileMovement.createFolder();
        //fileMovement.addArticle();
        fileMovement.moveFile();
    }
}

