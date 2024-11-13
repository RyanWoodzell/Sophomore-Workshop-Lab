package fileReader.src.java;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class fileMovement {

    public void CreateFolder(){

        String folderPath = "fileReader/src/NewTopicFolder"; // The path where you want to create the folder

        File newFolder = new File(folderPath);

        if (newFolder.mkdir()) {
            System.out.println("Folder created successfully.");
        } else {
            System.out.println("Failed to create folder.");
        }
    }


    public void addarticle(){
        Scanner scanner = new Scanner(System.in);
        String articlepath = scanner.nextLine();

        try {
                File newFile = new File(articlepath);

                if (newFile.createNewFile()) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }


}
