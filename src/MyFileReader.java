
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileReader {		//Read book catalog

	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";

	//Book attributes index
	private static final int BOOK_NAME = 0;
	private static final int BOOK_AUTHOR  = 1;
	private static final int BOOK_GENRE = 2;
	private static final int BOOK_ISBN = 3;
	private static final int BOOK_SUMMARY = 4;
	private static final int BOOK_ID = 5;
	private static final int BOOK_PAGE_COUNT = 6;
	private static final int BOOK_TOTAL = 7;
	private static final int BOOK_AVAILABLE = 8;
	
	//User attributes index 
	private static final int USER_NAME = 0;
	private static final int USER_ID = 1;




	//Reads CSV files and returns ArrayList that stores books
	public ArrayList<Book> readCsvFile(String filename) {

		ArrayList <Book> bookList = new ArrayList<Book>();
		BufferedReader fileReader = null;

		try {

			String line = "";    
			//Create the file reader
			fileReader = new BufferedReader(new FileReader(filename));

			//Read the CSV file header to skip it. First line only contains headings/titles.
			fileReader.readLine();

			//Read the file line by line starting from the second line

			while ((line = fileReader.readLine()) != null) {
				//Get all tokens available in line
				//Take every comma separated word and put into array called "tokens"
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {

					//token[0] is Book name, token[1] is Book Author, token[2] is Book Genre
					Book book  = new Book();
					book.setName(tokens[BOOK_NAME]);
					book.setAuthor(tokens[BOOK_AUTHOR]);
					book.setGenre(tokens[BOOK_GENRE]);
					book.setISBN(Long.parseLong(tokens[BOOK_ISBN]));
					book.setSummary(tokens[BOOK_SUMMARY]);
					book.setID(Integer.parseInt(tokens[BOOK_ID]));
					book.setPageCount(Integer.parseInt(tokens[BOOK_PAGE_COUNT]));
					book.setTotalCopies(tokens[BOOK_TOTAL]);
					book.setAvailableCopies(Integer.parseInt(tokens[BOOK_AVAILABLE]));
					bookList.add(book);
				}
			}



		}catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}
		return bookList;
		
	} //end readUserCsvFile()
	
	public ArrayList<libraryUser> readUserCsvFile(String filename) {

		ArrayList <libraryUser> userList = new ArrayList<libraryUser>();
		BufferedReader fileReader = null;

		try {

			String line = "";    
			//Create the file reader
			fileReader = new BufferedReader(new FileReader(filename));

			//Read the CSV file header to skip it. First line only contains headings/titles.
			fileReader.readLine();

			//Read the file line by line starting from the second line

			while ((line = fileReader.readLine()) != null) {
				//Get all tokens available in line
				//Take every comma separated word and put into array called "userTokens"
				String[] userTokens = line.split(COMMA_DELIMITER);
				if (userTokens.length > 0) {

					//userTokens[0] is the user's name, userTokens[1] is their ID
					Book book  = new Book();
					libraryUser user = new libraryUser();
					user.setName(userTokens[USER_NAME]);
					user.setID(Integer.parseInt(userTokens[USER_ID]));
					userList.add(user);
				}
			}



		}catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}
		return userList;

	} //end userCsvFile()

} //end class MyFileReader