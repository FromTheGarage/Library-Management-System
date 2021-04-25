
// Models a book object
public class Book {
	
	private String name, author, genre, summary, totalCopies;
	private int availableCopies, id, pageCount;
	private long isbn;

	public Book() {			
		
	}
	public Book(String name, String author, String genre, String totalCopies) { 
		this.name = name;	//The title of the book
		this.author = author;
		this.genre = genre;
		this.totalCopies = totalCopies;
		
	}
	
	public Book(String name, String author, String genre, int isbn, int id, String summary, int pageCount, String totalCopies, int availableCopies) {
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.isbn = isbn;
		this.id = id;
		this.summary = summary;
		this.pageCount = pageCount;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
	}

	public String getName() {
		return name;
	}	
	
	public void setName(String title) {
		this.name = title;
	}	

	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getAvailableCopies() {
		return Integer.toString(availableCopies);
	}

	public void setAvailableCopies(int AvailableCopies) {
		this.availableCopies = AvailableCopies;
	}
	
	
	public String getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(String totalCopies) {
		this.totalCopies = totalCopies;
	}
	public String getID() {
		return Integer.toString(id);
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getPageCount() {
		return Integer.toString(pageCount);
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public String getISBN() {
		return Long.toString(isbn);
	}
	
	public void setISBN(long isbn) {
		this.isbn = isbn;
	}	
	
	
	public void checkout() {
		this.availableCopies -= 1;
	}	//end checkout()
	
	public void checkin() {
		this.availableCopies += 1;
	}	//end checkin()
	
	public void detailDisplay() {		//Display book details after user looks it up
		System.out.println("Name: " + getName() + "\nAuthor: " + getAuthor() + "\nGenre: " + getGenre() + "\nSummary: " + getSummary()
		+ "\nCopies available: " + getAvailableCopies() +"\nID (Use to checkout): " + getID() +"\n");
	}	//end detailDisplay()
	
}	//end class Book
