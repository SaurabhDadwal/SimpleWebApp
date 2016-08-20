/**
 * 
 */
package itu.oops.lab;

import java.util.ArrayList;

/**
 * @author FNU Manita
 * Professor Victor Yu
 * This class is a simple utility class to create, update and delete records accoring to user generated events
 * User can add, update, delete and navigate through the records
 *
 */
public class BookDB {
	
	//field for list of book records
	private static ArrayList<Book> bookList;
	// field for currentIndex of the records
	private static int currentIndex;
	/*
	 * Initialize the bookList with the records
	 */
	public static void displayExistingRecords(){

    	bookList = new ArrayList<Book>();

    	bookList.add(new Book("JAVA", "Java Programming - Herbert Schildt", 87.00));
    	bookList.add(new Book("CSC", "Fundamentals of JavaScript Frameworks", 21.50));
    	bookList.add(new Book("ORA", "Oracle DataBase Utilities", 89.95));
    	bookList.add(new Book("BIG", "Big Data Engineering", 198.50));
    	bookList.add(new Book("PYT", "Work Like a PRO with Python", 620.00));
    	bookList.add(new Book("EXC", "Learn Excel for Windows 7", 425.00));
    	bookList.add(new Book("ROR", "Ruby on Rails:Concepts and ISPF", 100.00));
    	bookList.add(new Book("DB2", "DB2 for the COBOL Programmer, Part 1", 306.50));
    	bookList.add(new Book("RWR", "Report Writer", 222.00));
    	bookList.add(new Book("TPM", "Technical Program Management", 27.00));
    }
	
	/**
	 * @return ArrayList
	 * This method will return the list of book records
	 */
	public static ArrayList<Book> getCurrentBookList(){
		return bookList;
	}
	
	/**
	 * @param book
	 */
	public static void addBook(Book book){
		if(bookList.isEmpty()){
			bookList = new ArrayList<Book>();
			bookList.add(book);
			//currentIndex = (bookList.size() - 1);
		}else {
			bookList.add(new Book(book.getBookCode(), book.getBookTitle(), book.getPrice()));
		}
		
	}
	
	/**
	 * @param book
	 */
	public static void updateBookRecord(Book book){
		
		(bookList.get(currentIndex)).setBookCode(book.getBookCode());
		(bookList.get(currentIndex)).setBookTitle(book.getBookTitle());
		(bookList.get(currentIndex)).setPrice(book.getPrice());
	}
	
	
	/**
	 * @param book
	 * This method will remove the current book record
	 */
	public static void removeBook(String bookCode){
		
		for(int i=0;i<bookList.size();i++){
			if((bookList.get(i).getBookCode()).equalsIgnoreCase(bookCode)){
				bookList.remove(i);
				//currentIndex = (bookList.size()-1);
			}
		}
	}
	
	/**
	 * @param book
	 * This method will return the first book record
	 */
	public static Book getFirstBook(){
		Book firstBook = null;
		if(!bookList.isEmpty()){
			firstBook = bookList.get(0);
			currentIndex = 0;
		}
		return firstBook;
	}
	
	/**
	 * @param book
	 * This method will return the previous book record
	 */
	public static Book getPreviousBook(){
    	
    	Book previousBook;
    	if(currentIndex != 0){
    		previousBook = bookList.get(currentIndex - 1);
    		currentIndex = currentIndex - 1;
    	}
    	else
    		previousBook = bookList.get(0);
    	return previousBook;
    }

	/**
	 * @param book
	 * This method will return the next book record
	 */
    public static Book getNextBook() {

    	Book nextBook;
    	if(currentIndex != bookList.size() - 1){
    		currentIndex = currentIndex + 1;
    		nextBook = bookList.get(currentIndex);
    	}
    	else
    		nextBook = bookList.get(bookList.size() - 1);
        return nextBook;

    }

    /**
	 * @param book
	 * This method will return the last book record
	 */
    public static Book getLastBook(){

        Book lastBook = bookList.get(bookList.size() - 1);
        currentIndex = bookList.size()-1;
        return lastBook;
    }
	

}
