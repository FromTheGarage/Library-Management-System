
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileWriter {

	public void writeListToFile(){	//Write to book file (CSV)


		//Delimiter used in CSV file
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		//CSV file header
		final String FILE_HEADER = "BookName, BookAuthor,Genre,ISBN, Summary, ID, Page Count, Total Copies, Copies Available";
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter("BookFile.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append("Gone with the Wind");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("Romance");
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append("12234566");
			/*	
			 */
			System.out.println("CSV file was created successfully !!!\nLoading...");
			fileWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void writeListToFile(Book book){

		//Delimiter used in CSV file
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		//CSV file header
		final String FILE_HEADER = "BookName, BookAuthor,Genre,ISBN, Summary, ID, Page Count, Total, Available";
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter("BookFile.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(book.getName());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(book.getGenre());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(book.getISBN());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(book.getSummary());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(book.getID());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(book.getPageCount());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(book.getTotalCopies());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(book.getAvailableCopies());
			fileWriter.append(COMMA_DELIMITER);

			/*	
			 */
			System.out.println("CSV file was created successfully !!!\nLoading...");
			fileWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}	//end writeListToFile(Book)


	public void writeListToFile(ArrayList<Book> bookList){

		//Delimiter used in CSV file
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		//CSV file header
		final String FILE_HEADER = "Title, Author,Genre,ISBN, Summary, ID,  Page Count, Total, Available";
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter("BookFile.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			for (Book book : bookList) {
				fileWriter.append(book.getName());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(book.getAuthor());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(book.getGenre());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(book.getISBN());
				fileWriter.append(COMMA_DELIMITER);


				fileWriter.append(book.getSummary());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(book.getID());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(book.getPageCount());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(book.getTotalCopies());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(book.getAvailableCopies());
				fileWriter.append(COMMA_DELIMITER);




				fileWriter.append(NEW_LINE_SEPARATOR);


			}


			System.out.println("CSV file was created successfully !!!\nLoading...");
			fileWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}	//end writeListToFile(ArrayList <Book>)


	public void writeUserListToFile(ArrayList<libraryUser> userList) {
		//Delimiter used in CSV file
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		//CSV file header
		final String FILE_HEADER = "Name, ID";
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter("userFile.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			for (libraryUser user : UserHandler.getUserList()) {
				fileWriter.append(user.getName());
				fileWriter.append(COMMA_DELIMITER);

				fileWriter.append(Integer.toString(user.getID()));
				fileWriter.append(COMMA_DELIMITER);


				fileWriter.append(NEW_LINE_SEPARATOR);


			}


			System.out.println("CSV file was created successfully !!!\nLoading...");
			fileWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	//end writeUserListToFile(ArrayList <libraryUser>)

	public void writeUserListToFile(libraryUser user) {		//Copy the user list to the CSV file
		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		//CSV file header
		final String FILE_HEADER = "Name, ID";
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter("userFile.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(user.getName());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(Integer.toString(user.getID()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append((CharSequence) user.getCheckoutList());
			fileWriter.append(COMMA_DELIMITER);
			/*	
			 */
			System.out.println("CSV file was created successfully !!!\nLoading...");
			fileWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}	//end writeUserListToFile(libraryUser)

} //end class MyFileWriter



