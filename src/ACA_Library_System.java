import java.io.FileNotFoundException; //SALMA ADDED
import java.util.Scanner;

public class ACA_Library_System {

	public static void main(String[] args) throws FileNotFoundException {			//This driver class needs objects to access the methods of the other classes

		BookHandler handler = new BookHandler();		//Create a BookHandler object to access its methods
		UserHandler handler2 = new UserHandler();		//Create a UserHandler object to access its methods

		handler.setBookList(handler.createNewBookArrayList());	//Create starting list of books
		handler.createBookListFile();	//Create bookList file
		handler2.createUserListFile();

		welcome();										
	}


	public static void welcome() {		// Welcome User To Library System. This also serves as the return menu when a user logs out
		Scanner input = new Scanner(System.in);
		libraryUser user = new libraryUser();
		libraryAdmin librarian = new libraryAdmin();
		System.out.print("\t\t\t\t\tWelcome to the ACA Public Library System! \n\nPlease register a new account to access the system.");
		System.out.println();
		System.out.println("Enter 1 to register as a user or 2 to register as an Administrator. Or, enter 3 to close the system: ");


		while(true) {			//Login Options

			//SALMA CODE EXCEPTION HANDLING

			try {
				int option = Integer.parseInt(input.nextLine());	//ensures input is parsed as integer, prevents generation of InputMismatchException 

				if(option == 1) {	//Login as a user
					user.login();
				}
				else if(option == 2) {	//Login as an admin
					librarian.login(librarian);
				}

				else if (option == 3) {		//Close the system
					System.exit(0);
				}
				
				//SALMA CODE EXCEPTION HANDLING

				else {
					throw new NumberFormatException();
				}

			} catch(NumberFormatException e) {
				System.out.println();
				System.out.println("ERROR: Invalid option. Must enter either 1,2, or 3");
				System.out.println();

			}

		}	//end loop

	} //end welcome()


} //end class ACA_Library_System()