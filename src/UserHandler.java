import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserHandler {
	private static ArrayList<libraryUser> userList = new ArrayList<libraryUser>();	//List of library users 
	File userListFile = new File("UserFile.csv");	//file to write userList info to
	MyFileWriter fw = new MyFileWriter();		//will write to files
	MyFileReader fr = new MyFileReader();		//will read from files

	public static ArrayList<libraryUser> getUserList()	{	
		return userList;
	}

	public void setUserList(ArrayList<libraryUser> userList) {
		UserHandler.userList = userList;
	}

	public void createUserListFile() {		//Create csv file that holds user info
		Scanner input = new Scanner(System.in);

		try {
			if(userListFile.exists()) {
				System.out.println("The UserFile.csv file already exists!");
			}

			else {
				throw new FileNotFoundException();
				
			} 
		}
		catch(FileNotFoundException e) {
			System.out.println();
			System.out.println("The userFile.csv Does Not Exist. \n1) Create new userFile \n2) End program");
			int option = input.nextInt();

			if(option == 1) {
				fw.writeUserListToFile(userList); //Create userList csv
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The userFile.csv file has been created!");
			}

			if(option == 2) {
				System.exit(0);
			}

		}

	}


	public void addUser(libraryUser userObject) {		//add a user to the userList
		userList.add(userObject);
	}	//end addUser()

	public void removeUser(String name, int id) { 	//remove a user based on matching name and id values
		System.out.println("Attempting to remove " + name + "...");
		for(libraryUser user: UserHandler.getUserList()) {
			if(user.getName().contains(name) && user.getID() == id ) {
				System.out.println("USER FOUND!");
				System.out.println(name + " has been removed from the system!");
				System.out.println();
				userList.remove(user);
				fw.writeUserListToFile(userList);
				System.out.println("Current User List:");
				System.out.println();
				displayUsersFromFile();
				return;
			}

			else {
				System.out.println("searching...");						
			}
		}

		System.out.println("The user does not exist");
		return;

	}	//end removeUserByName()


	public void addUserToUserFile(libraryUser userObject) {		//Add user info to CSV
		userList = fr.readUserCsvFile("UserFile.csv");

		//Check for duplicates
		userList.add(userObject);
		fw.writeUserListToFile(userList);
	}	//end addUserToUserFile()


	public void displayUsers() {		//display the list of users
		System.out.println("***********START DISPLAY*************\n\n");
		for(libraryUser user: UserHandler.getUserList()) {
			System.out.println(user.getName() + ",  "+ "ID: " + user.getID());	
		}

		System.out.println("***********END DISPLAY*************\n\n");

	}	//end displayUsers()

	public void displayUsersFromFile() {		//display list of users (from file)
		userList = fr.readUserCsvFile("UserFile.csv");
		System.out.println("***********START DISPLAY*************\n\n");

		for(libraryUser user: userList) {
			System.out.println(user.getName() + ",  "+ "ID: " + user.getID());	
		}
		System.out.println("***********END DISPLAY*************\n\n");
	}	//end displayUsersFromFile()

}	//end class UserHandler