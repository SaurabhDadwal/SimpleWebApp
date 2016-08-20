package demo;
import java.sql.*;

import javax.swing.JOptionPane;

//import sun.jdbc.odbc.JdbcOdbcDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BookDB {
    

    private static Connection connection;
    private static Statement scrollStatement;
    private static ResultSet books;
    private static Statement statement;

    public static void connect() throws ClassNotFoundException, SQLException {

    	String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/database1";
        String username ="root";
        String password ="root";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        scrollStatement = connection.createStatement();
        String query = "SELECT BookCode, BookTitle, BookPrice "
                + "FROM Book";
        books = scrollStatement.executeQuery(query);
//        statement = connection.createStatement(
//                ResultSet.TYPE_SCROLL_SENSITIVE,
//                ResultSet.CONCUR_READ_ONLY);

    }

    public static void open() throws SQLException {
        scrollStatement = connection.createStatement();
        String query = "SELECT BookCode, BookTitle, BookPrice "
                + "FROM Book";
        books = scrollStatement.executeQuery(query);
    }

    public static void close() {
        try {
            books.close();
            scrollStatement.close();
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
    }

    public static Book moveFirst() throws SQLException {
        books.first();
        Book firstBook = new Book(books.getString(1),
                books.getString(2),
                books.getDouble(3));
        return firstBook;
    }

    public static Book movePrevious() throws SQLException {
        if (books.isFirst() == false) {
            books.previous();
        } else {
            books.first();
        }
        Book previousBook = new Book(books.getString(1),
                books.getString(2),
                books.getDouble(3));
        return previousBook;

    }

    public static Book moveNext() throws SQLException {
        if (books.isLast() == false) {
            books.next();
        } else {
            books.last();
        }
        Book nextBook = new Book(books.getString(1),
                books.getString(2),
                books.getDouble(3));
        return nextBook;

    }

    public static Book moveLast() throws SQLException {
        books.last();
        Book lastBook = new Book(books.getString(1),
                books.getString(2),
                books.getDouble(3));
        return lastBook;
    }

    public static void addRecord(Book book) throws SQLException {
        String query = "INSERT INTO Book (BookCode, BookTitle, BookPrice) "
                + "VALUES ('" + book.getCode() + "', "
                + "'" + book.getTitle() + "', "
                + "'" + book.getPrice() + "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        close();
        open();
    }

    public static void updateRecord(Book book) throws SQLException {
        String query = "UPDATE Book SET "
                + "BookCode = '" + book.getCode() + "', "
                + "BookTitle = '" + book.getTitle() + "', "
                + "BookPrice = '" + book.getPrice() + "' "
                + "WHERE BookCode = '" + book.getCode() + "';";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    public static void deleteRecord(String bookCode) throws SQLException {
        String query = "DELETE FROM Book "
                + "WHERE BookCode = '" + bookCode + "'";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        close();
        open();
    }

    public ResultSet getResultSet() {
        return books;
    }

}
