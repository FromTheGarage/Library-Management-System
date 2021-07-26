import java.util.ArrayList;
import java.util.Scanner;

public class libraryUser {					/*This class models a person who uses the ACA Library System, like a college student or 
											other person w/ a library card*/

	private String name;					//Users need to specify their name, email, id, and pin to create an account and login
	private String email;
	private int id;
	private int pin;
	private static ArrayList<libraryUser>userList = new ArrayList<>();	/*A list to maintain the user objects. It's associated
																		with the class, not the objects (individual users)*/

	private ArrayList<Book> checkoutList = new ArrayList<>();			//List of books the user has checked out. This list is associated
																		//with users, so it is not static

	private ArrayList<Book> checkoutHistory = new ArrayList<>();
	
	public libraryUser() {												//Default constructor

	}	//end libraryUser()



	public libraryUser(String name, String email, int id, int pin, ArrayList<Book> checkoutList) {		//multiparameter constructor
		this.name = name;
		this.email = email;
		this.id = id;
		this.pin = pin;
		this.checkoutList = checkoutList;
	}	//end libraryUser(name, email, id, pin, checkoutList)


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public static ArrayList <libraryUser> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<libraryUser> userList) {
		libraryUser.userList = userList;
	}


	public ArrayList<Book> getCheckoutList() {
		return checkoutList;
	}



	public void setCheckoutList(ArrayList<Book> checkoutList) {
		this.checkoutList = checkoutList;
	}
	

	public ArrayList<Book> getCheckoutHistory() {
		return checkoutHistory;
	}



	public void setCheckoutHistory(ArrayList<Book> checkoutHistory) {
		this.checkoutHistory = checkoutHistory;
	}
	
	@Override
	public String toString() {
		return "Login Successful";			
	}	//end toString()

	//New user Login to system
	public void login() {										//allow user to login
		libraryUser user = new libraryUser();
		Scanner input = new Scanner(System.in);
		UserHandler handler = new UserHandler();
		
		try {
	
			//Prompt user to enter information. Their input will be used to create a user
			System.out.print("Enter your name: ");
			String name = input.nextLine();
			
			if(name.isEmpty()) {
				throw new Exception();
			}
			user.setName(name);
			
			System.out.println();
			
			System.out.print("Enter your email address: ");
			String email = input.nextLine();
			if(email.isEmpty()) {
				throw new Exception();
			}
			
			user.setEmail(email);

			System.out.print("Enter your ID number: ");
			String id = input.nextLine();
			user.setID(Integer.parseInt(id));

			System.out.print("Enter your PIN number: ");
			String pin = input.nextLine();
			user.setPin(Integer.parseInt(pin));
			
			handler.addUser(user);
			handler.addUserToUserFile(user);
			
			System.out.println();
			System.out.println(toString());
			System.out.println();
			loadSystemMenu();

			
		} catch(NumberFormatException e) {
			System.out.println();
			System.out.println("ERROR: Your ID/PIN must be an integer. Please try again.");
			login();
		} catch(Exception blank) {
			System.out.println();
			System.out.println("ERROR: Empty value entered");
			login();
		}
		 
		
	}	//end login()


	public void loadSystemMenu() {								//main menu for users
		BookHandler handler = new BookHandler();				//create a BookHandler that can get the bookList				
		UserHandler handler2 = new UserHandler();

		System.out.println("1) Book Search \n2) Checkout a book using ID \n3) Return book \n4) View currently held items \n5) View checkout history \n6) Sign out");
		Scanner input = new Scanner(System.in);
		
		try {
			int option = Integer.parseInt(input.nextLine());
			if(option == 1) {										//Search for a book
				System.out.println("Enter the title of the book: ");
				String bookTitle = input.nextLine();
				handler.searchByTitle(BookHandler.getBookList(), bookTitle);
				loadSystemMenu();
			}

			else if(option == 2) {									//Search for book using ID
				System.out.println("Enter the book ID: ");
				String id = input.nextLine();
				handler.checkBookOut(this, BookHandler.getBookList(), id);
				loadSystemMenu();
			}

			else if(option == 3) {									//Return a book using ID
				System.out.println("To return a book, enter the ID number:");
				String id = input.nextLine();
				handler.checkBookIn(this, BookHandler.getBookList(), id);
				loadSystemMenu();
			}

			else if(option == 4) {									//View current checkout list
				this.viewCheckoutList();
				loadSystemMenu();
			}
			
			else if(option == 5) {									//View checkout history
				this.viewCheckoutHistory();
				loadSystemMenu();
			}

			else if(option == 6) { 									//Sign out
				System.out.println("You have been signed out");
				ACA_Library_System.welcome();
			}
			
			else {
				throw new NumberFormatException();
			}
			
		}
		catch(NumberFormatException e) {
			System.out.println();
			System.out.println("ERROR: Must enter an integer value here");
			loadSystemMenu();
			
		}

		
	} //end loadSystemMenu()


	public static void printUsers() {							//Print the list of users

		System.out.println("List of users:");
		for(libraryUser x: libraryUser.getUserList()) {
			System.out.println(x.getName() + ", ID: " + x.getID());
		}
	}	//end printUsers()

	public void viewCheckoutList() {							//Print the list of books this user has checked out
		if(checkoutList.size() > 0) {
			System.out.println("Items currently on your account: ");
			for(Book item: this.getCheckoutList()) {
				System.out.println(item.getName());
			}	
		}
		
		else {
			System.out.println("You do not currently have any items checked out");
		}

	} //end viewCheckoutList()
	
	public void viewCheckoutHistory() {							//View the user's checkout history (list of all books ever checked out)
		System.out.println("Checkout History: ");
		for(Book item: this.getCheckoutHistory()) {
			System.out.println(item.getName());
		}
		
	}	//end viewCheckoutList()

} //end class libraryUser