
public class Book {

	private String bookTitle;
	private String authorName;
	private int ID;
	private int price;
	private static int numBooks; 
	
	public Book(String title, String author, int bookPrice) {
		numBooks++;
		ID = numBooks;
		title = bookTitle;
		author = authorName;
		bookPrice = price;
	}

//getters

	public String getTitle() {
		return bookTitle;
	}

	public String getAuthor() {
		return authorName;
	}

	public int getID() {
		return ID;
	}

	public int getPrice() {
		return price;
	}

//setter for price

	public void setPrice(int bookPrice) {
		bookPrice = price;
	}

}
