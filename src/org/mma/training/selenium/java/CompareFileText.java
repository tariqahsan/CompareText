package org.mma.training.selenium.java;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompareFileText {
    public static void main(final String[] args) throws IOException {
    	
    	// Creating Scanner object
    	Scanner input = new Scanner(System.in);
    	// Read file with full path from the console
        System.out.print("Enter the first file name with full path : ");
        String firstFilePath = input.nextLine();
        System.out.print("Enter the second file name with full path : ");
        String secondFilePath = input.nextLine();
        System.out.println(firstFilePath);
        System.out.println(secondFilePath);
        
    	// Mac hardcoded file path
        //final Path firstFile = Paths.get("/home/src/main/resources/file1.txt");
        //final Path secondFile = Paths.get("/home/src/main/resources/file2.txt");
    	
    	// Windows hardcoded file path
        // final Path firstFile = Paths.get("C:\\Users\\Tariq Ahsan\\Desktop\\Training\\SeleniumWorkspace\\CompareText\\file1.txt");
        // final Path secondFile = Paths.get("C:\\Users\\Tariq Ahsan\\Desktop\\Training\\SeleniumWorkspace\\CompareText\\file2.txt");
        
        // Passing the file name with full path entered from the console
        final Path firstFile = Paths.get(firstFilePath);
        final Path secondFile = Paths.get(secondFilePath);
        final List<String> firstFileContent = Files.readAllLines(firstFile,
            Charset.defaultCharset());
        final List<String> secondFileContent = Files.readAllLines(secondFile,
            Charset.defaultCharset());

        System.out.println("First File  : " + diffFiles(firstFileContent, secondFileContent));
        System.out.println("Second File : " + diffFiles(secondFileContent, firstFileContent));
    }

    private static List<String> diffFiles(final List<String> firstFileContent,
        final List<String> secondFileContent) {
        final List<String> diff = new ArrayList<String>();
        int lineNumber = 1;
        for (final String line : firstFileContent) {
            if (!secondFileContent.contains(line)) {
            	System.out.println("Line # " + lineNumber + ": " + line);
                diff.add("Line # " + lineNumber + ": " + line);
            }
            // increment line number
            lineNumber++;
        }
        return diff;
    }
}
