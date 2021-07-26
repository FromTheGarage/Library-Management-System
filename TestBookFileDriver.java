import java.util.ArrayList;
import java.util.Scanner;

public class TestBookFileDriver {		//Test for Book class
	public static void main(String[] args) {
		Book newBook1 = new Book();
		newBook1.setName("Paradise Lost");
		newBook1.setGenre("Fiction");
		newBook1.setAuthor("John Milton");
		newBook1.setISBN(1);
		newBook1.setID(1);
	
		
		Book newBook2 = new Book();
		newBook2.setName("Cfire Lost");
		newBook2.setAuthor("John C.F. Milton");
		newBook2.setGenre("Fiction");
		newBook2.setISBN(2);
		newBook2.setSummary("This one is a classic!");
		newBook2.setID(12);
		newBook2.setPageCount(500);
		newBook2.setTotalCopies("20");
		newBook2.setAvailableCopies(10);





		
		Book newBook3 = new Book();
		newBook3.setName("Titel Lost");
		newBook3.setGenre("Fiction");
		newBook3.setISBN(3);
		
		Book newBook4 = new Book();
		newBook4.setName("Candy Lost");
		newBook4.setGenre("Fiction");
		newBook4.setISBN(4);
		
		
		ArrayList<Book> bookList = new ArrayList();
		bookList.add(newBook1);
		bookList.add(newBook2);
		bookList.add(newBook3);
		bookList.add(newBook4);
		
		MyFileWriter fw = new MyFileWriter();
		fw.writeListToFile(bookList); //Write the list of books to a file
		
		ArrayList<Book> bookList2 = new ArrayList();
		MyFileReader myFileReader = new MyFileReader();
		
		//Load books from the file 
		bookList2 = myFileReader.readCsvFile("BookFile.csv");
		
		//Use a for loop to find books to remove
		for(int i = 0; i < bookList2.size(); i++) {
			Book book = bookList2.get(i);
			System.out.println(book.getName() + '\t');
			System.out.println(book.getGenre() + '\t');
			System.out.println(book.getISBN() + '\t');
			System.out.println();
			
			
			//Update or remove the book from the list
			if(book.getName().equals("X")) {
				System.out.println(" Removing book: " + book.getName());
			}
			//Remove
			bookList2.remove(book);
			
			//Updating a Book can be any field based on a search criteria
			if(book.getName().equals("Paradise Lost")) {
				System.out.println(" Updating book " + book.getName());
				book.setName("Gone with the Wind"); 
			}
			System.out.println(" New list after removal " + bookList2);
			//Write the new book list to the file
			fw.writeListToFile(bookList2);
		}		
		
	}

}
