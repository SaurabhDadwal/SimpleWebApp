package itu.oops.lab;
/**
 * @author FNU Manita
 * Professor Victor Yu
 * This class will create a simple Book with field:
 * bookCode, bookTitle, price 
 *
 */
public class Book {
	
	//data field bookCode
    private String bookCode;
    //data field bookTitle 
    private String bookTitle;
    //data field price
    private double price;
    
    /*
     * Default constructor
     */
    public Book() {
        this("", "", 1.00);
    }
    
    /*
     * Overloaded constructor
     */
    public Book(String code, String title, double bookPrice) {
        bookCode = code;
        bookTitle = title;
        price = bookPrice;
    }

    /**
	 * @return the bookCode
	 */
	public String getBookCode() {
		return bookCode;
	}

	/**
	 * @param bookCode the bookCode to set
	 */
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
        return "BookCode: " + bookCode + "\n"
                + "BookTitle: " + bookTitle + "\n"
                + "Price: " + price + "\n";
    }

    
}
