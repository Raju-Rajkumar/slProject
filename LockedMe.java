package com.lockedme;
import java.io.File; 
import java.io.FileWriter;
import java.util.LinkedList; 
import java.util.Scanner;


public class LockedMe {
static String fileName;
	static final String projectFilesPath = "D:\\Rajkumar T\\Phase 1 project"; 
static int option = 0;
	static final String errorMessage = "Error occured Please contact: admin@LockedMe.com";
		/*Getting user input using Scanner*/ 
	static Scanner userInput = new Scanner(System.in);
		
		/*This Function displays the Menu*/
	public static void displayMenu() { 
			System.out.println("\t\t____________________________________");
			System.out.println("\n\t\t\tLockedMe.com Welcomes You"); 
			System.out.println("\t\t____________________________________");
			System.out.println("\t\t\t1. Display all the files");
			System.out.println("\t\t\t2. Add a New File");
			System.out.println("\t\t\t3. Delete a File");
			System.out.println("\t\t\t4. Search a File"); 
			System.out.println("\t\t\t5. Exit");
			System.out.println("\t\tDeveloper Details: Rajkumar@lockedme.com");
			 System.out.println("______________________________________________________________________");
	}


	/*This method will return all the files in the directory*/
	public static void getAllFiles() {
		/*using try-catch block*/
		try {
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
		if (listOfFiles.length == 0) {
			System.out.println("Files are not present in the directory");
			} 
		else {
			for (var l : listOfFiles) {
				System.out.println("File: " + l.getName());
				}
			}
		} 
		catch (Exception ex) {
		System.out.println(errorMessage);
	}


}
	/*This method is used to create a new file into the directory */
	public static void createFile() { 
					int linesCount = 1;
					/*Using Try-Catch Block*/ 
					
		try {
			System.out.println("Enter File Name: ");
			fileName = userInput.nextLine();

			FileWriter myWriter = new FileWriter(projectFilesPath + "//" + fileName); 
			System.out.println("Enter how many Lines need for the file: ");
			linesCount = Integer.parseInt(userInput.nextLine());
			for (var i = 1; i <= linesCount; i++) {
				System.out.println("Enter the line "+i);
				myWriter.write(userInput.nextLine() + "\n");

					}
				System.out.println("File Created  Successfully.");
				myWriter.close();
				} 
		catch (Exception Ex) {
				System.out.println(errorMessage);


				}

}
	/* This method will delete the files to be deleted in the directory*/
	public static void deletefile() {
		
		
			/*Creating a Try Catch block*/
		
		try {
				String fileName;
				System.out.println("Enter the file name to be deleted: ");
				fileName = userInput.nextLine();
				File file = new File(projectFilesPath + "//" + fileName);
			if (file.exists()) {
					file.delete();
					System.out.println(fileName+" File successfully deleted.");
				} 
			else {
					System.out.println("File is not present in the directory");

				}
			}
		catch (Exception Ex) {
				System.out.println(errorMessage);
			}

}


	/* This method will search for files in the directory*/


	public static void searchFile() {
	/*Creating a try-catch block*/
		
		try {
			String fileName;
			System.out.println("Enter the file name to be searched: "); 
			fileName = userInput.nextLine();
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			LinkedList<String> filenames = new LinkedList<String>();
		for (var l : listOfFiles) {
					filenames.add(l.getName());
				}
			if (filenames.contains(fileName)) { 
				System.out.println("File is Available");
				} 
			else {

				System.out.println("File not available in the directory");

				}


		} 
		catch (Exception Ex) {

			System.out.println(errorMessage);

		}

}

	/* Main Method */
	public static void main(String[] args) {
		
		/*Using Do-while loop so that this application runs repeatedly*/ 
		do {
			displayMenu();
			System.out.println("Enter your Option: ");
			option = Integer.parseInt(userInput.nextLine());
	
			/*Using Switch Case*/
			switch (option) { 
				case 1:getAllFiles(); 
					break;
				case 2:createFile();
					break;
				case 3:deletefile(); 
					break;
				case 4:searchFile(); 
					break;
				case 5:System.exit(0); 
					break;
				default:System.out.println(" Option Invalid"); 
					break;
			}
			


		} 
			while (option > 0);

	}

}
