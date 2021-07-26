
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BookHandler {		//Handles book operations like adding or removing books from the list

	private static ArrayList<Book> bookList = new ArrayList<Book>();	//List of books in the library
	File bookListFile = new File("BookFile.csv");	//file to write bookList info to
	MyFileWriter fw = new MyFileWriter();		//will write to files
	MyFileReader fr = new MyFileReader();		//will read from files

	public static ArrayList<Book> getBookList() {		//return bookList (memory references only)
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {		
		BookHandler.bookList = bookList;
	}

	public static void printBookList() {		//Print the bookList. getBookList returns only the references to the locations of the books
		for(Book book: bookList) {
			System.out.println(book.getName());
		}
	}

	public ArrayList<Book> createNewBookArrayList() {		
		ArrayList<Book> arrayOfBooks = new ArrayList<Book>();
		Book book1 = new Book("Harry Potter and the Deathly Hallows","J.K. Rowling","Fantasy", 101, 1, "", 250, "20", 20);
		arrayOfBooks.add(book1);
		Book book2 = new Book("I Don't Have Enough Faith to Be Atheist","Someone","Non-Fiction", 102, 2, "" , 200, "20", 20);
		arrayOfBooks.add(book2);
		Book book3 = new Book("Mortal Instruments: City of Bones","Cassandra Clare","Supernatural", 103, 3, "", 225, "20", 20);
		arrayOfBooks.add(book3);
		Book book4 = new Book("7 Habits of an Highly Effective Teen","Someone","Non-Fiction", 104, 4, "", 145, "20", 20);
		arrayOfBooks.add(book4);
		Book book5 = new Book("The Giving Tree","Shel Silverstein","Children", 105, 5, "", 283, "20", 20);
		arrayOfBooks.add(book5);
		Book book6 = new Book("Twilight","Stephenie Meyer","Romance", 106, 6, "" , 200, "20", 20);
		arrayOfBooks.add(book6);
		Book book7 = new Book("Mr. Perfect","Linda Howard","Mystery", 107, 7, "" , 200, "20", 20);
		arrayOfBooks.add(book7);
		Book book8 = new Book("Dear Killer","Katherine Ewell","Young Adult", 108, 8, "" , 200, "20", 20);
		arrayOfBooks.add(book8);
		Book book9 = new Book("Green Rider","Kristen Britain","Science-Fiction", 109, 9, "" , 200, "20", 20);
		arrayOfBooks.add(book9);
		Book book10 = new Book("Hamlet","William Shakespeare","Classic Literature", 110, 10, "" , 200, "20", 20);
		arrayOfBooks.add(book10);
		Book book11 = new Book("Matilda","Roald Dahl","Children", 111, 11, "" , 200, "20", 20);
		arrayOfBooks.add(book11);
		Book book12 = new Book("C.J.'s Fate","Kay Hooper","Romance", 112, 12, "" , 200, "20", 20);
		arrayOfBooks.add(book12);
		Book book13 = new Book("The First Prophet (Bishop Files)","Kay Hooper","Supernatural", 113, 13, "" , 200, "20", 20);
		arrayOfBooks.add(book13);
		Book book14 = new Book("The Warrior Heir","Cinda Williams Chima","Fantasy", 114, 14, "" , 200, "20", 20);
		arrayOfBooks.add(book14);
		Book book15 = new Book("Dorothy Must Die","Danielle Paige","Young Adult", 115, 15, "" , 200, "20", 20);
		arrayOfBooks.add(book15);
		Book book16 = new Book("A Wrinkle in Time","Madeleine L'Engle","Fantasy", 116, 16, "" , 200, "20", 20);
		arrayOfBooks.add(book16);
		Book book17 = new Book("Great Expectations","Charles Dickens","Classic Literature", 117, 17, "" , 200, "20", 20);
		arrayOfBooks.add(book17);
		Book book18 = new Book("The Giver","Lois Lowry","Science-Fiction", 118, 18, "" , 200, "20", 20);
		arrayOfBooks.add(book18);
		Book book19 = new Book("The Diary of a Young Girl","Anne Frank","Non-Fiction", 119, 19, "" , 200, "20", 20);
		arrayOfBooks.add(book19);
		Book book20 = new Book("The Book Thief","Markus Zusak","Historical Fiction", 120, 20, "" , 200, "20", 20);
		arrayOfBooks.add(book20);
		Book book21 = new Book("True Grit","Charles Portis","Historical Fiction", 121, 21, "" , 200, "20", 20);
		arrayOfBooks.add(book21);
		Book book22 = new Book("In the Time of the Butterflies","Julia Alvarez","Historical Fiction", 122, 22, "" , 200, "20", 20);
		arrayOfBooks.add(book22);
		Book book23 = new Book("Julius Caeser","William Shakespeare","Classic Literature", 123, 23, "" , 200, "20", 20);
		arrayOfBooks.add(book23);
		Book book24 = new Book("Fablehaven","Brandon Mull","Fantasy", 124, 24, "" , 200, "20", 20);
		arrayOfBooks.add(book24);
		Book book25 = new Book("Cinder","Marissa Meyer","Science-Fiction", 125, 25, "" , 200, "20", 20);
		arrayOfBooks.add(book25);
		Book book26 = new Book("Keeper of the Lost Cities","Shannon Messenger","Children", 126, 26, "" , 200, "20", 20);
		arrayOfBooks.add(book26);
		Book book27 = new Book("Percy Jackson and the Lightning Thief","Rick Riordan","Young Adult", 127, 27, "" , 200, "20", 20);
		arrayOfBooks.add(book27);
		Book book28 = new Book("The Cuckoo's Calling","J.K. Rowling","Mystery", 128, 28, "" , 200, "20", 20);
		arrayOfBooks.add(book28);
		Book book29 = new Book("The 19th Christmas","James Patterson","Suspense", 129, 29, "" , 200, "20", 20);
		arrayOfBooks.add(book29);
		Book book30 = new Book("The Hate You Give","Angie Thomas","Young Adult", 130, 30, "" , 200, "20", 20);
		arrayOfBooks.add(book30);
		return arrayOfBooks;
	}	//end createNewBookList()


	public void createBookListFile() throws FileNotFoundException {		
		Scanner input = new Scanner(System.in);
		//Hard code and create BookList
		
		//SALMA CODE EXCEPTION HANDLING
		try {
			if(bookListFile.exists()) {
				System.out.println("The BookFile.csv file already exists !");
			} 

			else {
				throw new FileNotFoundException();
			}

		}
		catch(FileNotFoundException e) {
			System.out.println("The BookFile.csv file Does Not Exist. \n1) Create new BookFile \n2) End program ");
			int option = input.nextInt();

			if(option == 1) {
				bookList = createNewBookArrayList(); //Add 30 preloaded books to list
				fw.writeListToFile(bookList);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					e.printStackTrace();
				}
				System.out.println("The BookFile.csv file has been created.... !");
			}

			if(option == 2) {
				System.exit(0);
			}

		}
	}	//end createBookListFile()


	public void addBook(Book bookObject) {		//add a book to the bookList

		bookList.add(bookObject);

	}	//end addBook()

	public void removeBook(Book bookObject) {		//remove a book from the bookList

		bookList.remove(bookObject);

	}	//end removeBook()

	public void displayBooks() {		//display the bookList

		System.out.println("***********START DISPLAY*************\n\n");
		for(Book book: BookHandler.getBookList()) {
			System.out.println(book.getName() + ",  "+ "Author: " + book.getAuthor() + ",  "+ "Genre: " + book.getGenre() + ", Total copies: " + book.getTotalCopies() + ", Available copies: " + book.getAvailableCopies());	
		}

		System.out.println("***********END DISPLAY*************\n\n");

	}	//end displayBooks()

	public void displayBooksFromFile() {		//display (read) books from the bookList csv file
		bookList = fr.readCsvFile("BookFile.csv");
		Iterator<Book> it = bookList.iterator(); 
		System.out.println("***********START DISPLAY*************\n\n");

		for(Book book: BookHandler.getBookList()) {
			System.out.println(book.getName() + " "+ book.getAuthor() + "  "+ book.getGenre() );	
		}


		System.out.println("***********END DISPLAY*************\n\n");

	}	//end displayBooksFromFile()


	//For Admins
	public void searchByAuthors(String authorName) {		

	}	//end searchByAuthors()

	//For Admins and Users
	public void searchByTitle(ArrayList<Book> bookList, String bookTitle) {	
		System.out.println("Searching...");

		Iterator<Book> it = bookList.iterator();  		//traverse through and copy booklist into list

		while(it.hasNext()) {
			Book book = it.next(); 
			if(book.getName().contains(bookTitle)) { 	
				System.out.println("Title found!");
				System.out.println();
				book.detailDisplay();
				return;
			}

			else {
				System.out.println("...");
			}

		}
		System.out.println("No results for " + "'" + bookTitle + "'");
		return;

	}	//end searchByTitle()

	public void checkBookOut(libraryUser user, ArrayList<Book> bookList, String bookID) {		//Search for books based on ID
		Scanner input = new Scanner(System.in);
		Iterator<Book> it = bookList.iterator();
		Book book = new Book();
		System.out.println("Attempting to check item out...");


		while(it.hasNext()) {
			book = it.next();
			if(book.getID().equals(bookID)) {
				if(book.getAvailableCopies().equals("0")) {		//Can't check out books w/ no available copies
					System.out.println("Sorry, there are no copies available");
					return;
				}
				System.out.println("You have just checked out the following item: " + book.getName());
				user.getCheckoutList().add(book);
				book.checkout();
				user.getCheckoutHistory().add(book);
				fw.writeListToFile(bookList);
				user.viewCheckoutList();
				return;

			}
			else {
				System.out.println("...");
			}
		}
		System.out.println("Item not available");
		return;
	}	//end checkBookOut()

	public void checkBookIn(libraryUser user, ArrayList<Book> bookList, String bookID) {		//Allow user to return a book they're holding	
		Scanner input = new Scanner(System.in);
		Iterator<Book> it = bookList.iterator();
		Book book = new Book();

		while (it.hasNext()) {
			book = it.next();
			if(book.getID().equals(bookID)) {
				System.out.println("Item found!\n " + "Title: " + book.getName() + ", " + "ID: " + book.getID() +"\nReturn this item? \n1)Yes \n2)No\n ");
				int option = input.nextInt();
				if(option == 1){
					System.out.println("You have returned: " + book.getName());
					user.getCheckoutList().remove(book);
					book.checkin();
					bookList.add(book);
					fw.writeListToFile(bookList);
					input.nextLine();
					return;
				}
				else if(option == 2){
					input.nextLine();
					return;
				}
			}
		}
		System.out.println("Invalid ID");

	}	//end checkBookIn()

	public void addBooktoBookFile(Book bookObject) {		//write a new book into the bookList csv file
		// Before I add a Book I need to do load all the books from the file to the bookList
		bookList = fr.readCsvFile("BookFile.csv");
		System.out.println(" Current BookList size: " + (bookList.size()) );
		// Check to see if the Book is a Duplicate and if I just to add a copy of the book	
		bookList.add(bookObject);
		System.out.println(" New BookList size: " +(bookList.size() ));
		System.out.println(bookObject.getName() + " has been added!");
		// Write the ArrayList to the File 
		fw.writeListToFile(bookList);
	}	//end addBooktoBookFile()

	public void removeBookByTitle(String bookTitle2) {		//remove a book from the bookList by using its title
		ArrayList<Book> toRemove = new ArrayList<Book>();	//removal list, prevents concurrent access error (ConcurrentModificationException)
		System.out.println();
		bookList = fr.readCsvFile("BookFile.csv");

		System.out.println("Attempting to remove " + bookTitle2 +"...");

		for(Book book: BookHandler.getBookList()) {
			if(book.getName().contains(bookTitle2)) {
				toRemove.add(book);
				System.out.println(book.getName() + " was removed!");
				bookList.removeAll(toRemove);
				fw.writeListToFile(bookList);
				displayBooks();
				return;
			}

			else {
				System.out.println("...");
			}
			
		}
		System.out.println("No results for " + bookTitle2);
		return;


	}	//end removeBookByTitle()

}	//end class BookHandler
