import java.util.InputMismatchException;
import java.util.Scanner;

/*There is essentially a single admin, but many Users in this program. Users will be maintained in a list
  An admin has-a book handler (kind of program), but is not a book handler themselves*/

public class libraryAdmin {		//This class models a library administrator/librarian
	private String email;		//Admins login with their email and password
	private String password;								

	public libraryAdmin() {		//no-arg (default) constructor

	} //end libraryAdmin()

	public libraryAdmin(String email,String password) {		//Constructor (email, password)
		this.email = email;
		this.password = password;
	}	//end libraryAdmin (email, password)

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void login(libraryAdmin librarian) {		//allow an admin to login to the system
		Scanner input = new Scanner(System.in);	
		
		try {
			System.out.println("Enter your email address: ");
			String email = input.nextLine();
			if(email.isEmpty()) {
				throw new Exception();
			}
			librarian.setEmail(email);
			System.out.println();

			System.out.println("Enter your password: ");
			String pass = input.nextLine();
			if(pass.isEmpty()) {
				throw new Exception();
			}
			librarian.setPassword(pass);

			System.out.println();
			System.out.println("Login successful");
			System.out.println();		
			loadSystemMenu();
			
		} catch(Exception e) {
			System.out.println();
			System.out.println("ERROR: Empty value entered");
			login(librarian);
		}
		

		//Prompt user to enter information. Their input will be used to create a user
		//SALMA CODE EXCEPTION HANDLING

		
	} //end login()

	public void loadSystemMenu() {		//load the admin's option menu					
		Scanner input = new Scanner(System.in);
		Book book = new Book();
		libraryUser user = new libraryUser();
		BookHandler handler = new BookHandler();
		UserHandler handler2 = new UserHandler();
		System.out.println("Select an option: ");
		System.out.println("1) Add book to catalog");
		System.out.println("2) Remove book from catalog");
		System.out.println("3) View books in catalog");
		System.out.println("4) Add a new user");
		System.out.println("5) Remove a user");
		System.out.println("6) View users registered in system");
		System.out.println("7) Sign out");

		try {
			int option = Integer.parseInt(input.next());

			if(option == 1) {		//Add new book object to list of books
				while (true) {
					try {
						input.nextLine();

						System.out.println("Enter the title: ");
						book.setName(input.nextLine());

						System.out.println("Enter the author: ");
						book.setAuthor(input.nextLine());

						System.out.println("Enter the genre: ");
						book.setGenre(input.nextLine());

						System.out.println("Enter the ISBN: ");
						book.setISBN(Long.parseLong(input.next()));

						input.nextLine();

						System.out.println("Enter the total number of copies: ");
						book.setTotalCopies(input.nextLine());

						System.out.println("Enter the ID: ");
						book.setID(Integer.parseInt(input.next()));

						input.nextLine();
						System.out.println("Enter the summary: ");
						book.setSummary(input.nextLine());

						System.out.println("Enter the page count: ");
						book.setPageCount(input.nextInt());

						input.nextLine();
						System.out.println("How many copies are available?");
						book.setAvailableCopies(input.nextInt());
						input.nextLine();

						BookHandler.getBookList().add(book);
						handler.addBooktoBookFile(book);

						handler.displayBooksFromFile();
						loadSystemMenu();

					} catch (NumberFormatException e) {
						System.out.println();
						System.out.println("ERROR: Must enter an integer value here");
						loadSystemMenu();
					} catch(InputMismatchException ie) {
						System.out.println();
						System.out.println("ERROR: Must enter an integer value here");
						loadSystemMenu();
					}
					finally {

					}




				}

			}

			else if(option == 2) {		//Remove a book
				input.nextLine();
				System.out.println("Enter the title of the book: ");
				String title = input.nextLine();
				handler.removeBookByTitle(title);
				loadSystemMenu();


			}

			else if(option == 3) {		//View list of books
				input.nextLine();
				handler.displayBooksFromFile();
				loadSystemMenu();
			}

			else if(option == 4) {		//add a user

				try {
					input.nextLine();
					System.out.println("Enter user's name: ");
					user.setName(input.nextLine());

					System.out.println("Enter the user's ID: ");
					user.setID(input.nextInt());
					input.nextLine();

					UserHandler.getUserList().add(user);
					handler2.addUserToUserFile(user);
					handler2.displayUsersFromFile();
					loadSystemMenu();	
				} 
				catch(InputMismatchException ie) {
					System.out.println();
					System.out.println("ERROR: User ID must be an integer. Please try again");
					System.out.println();
					loadSystemMenu(); 
				}
				


			}

			else if(option == 5) {		//remove a user
				input.nextLine();
				try {
					System.out.print("Enter the user's name: ");
					String name = input.nextLine();

					System.out.print("Enter the user's ID: ");
					int id = input.nextInt();
					System.out.println();

					handler2.removeUser(name, id);
					System.out.println();
					System.out.println();
					loadSystemMenu();

				} catch(NumberFormatException e) {
					System.out.println();
					System.out.println("ERROR: User ID must be an integer. Please try again");
					System.out.println();
					loadSystemMenu();
				}

				catch(InputMismatchException ie) {
					System.out.println();
					System.out.println("ERROR: User ID must be an integer. Please try again");
					System.out.println();
					loadSystemMenu(); 
				}

			}

			else if(option == 6) {		//View list of users
				handler2.displayUsersFromFile();
				loadSystemMenu();
			}

			else if(option == 7) {		//Sign out 
				System.out.println("You have been signed out");
				ACA_Library_System.welcome();
			}

			else {
				throw new NumberFormatException();
			}

		} catch(NumberFormatException e) {
			System.out.println();
			System.out.println("ERROR: Invalid option. Please try again.");
			System.out.println();

			loadSystemMenu();

		}




	} //end loadSystemMenu()



} //end class libraryAdmin

