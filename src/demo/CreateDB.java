package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDB {

    public static void main(String args[]) throws Exception {

        // This will load the MySQL driver, each DB has its own driver
        //Class.forName("com.mysql.jdbc.Driver");

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/database1";
        String username ="root";
        String password ="root";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        // Statements allow to issue SQL queries to the database
        Statement scrollStatement = connection.createStatement();

        scrollStatement.executeUpdate("DROP TABLE if exists Book");

        scrollStatement.executeUpdate("CREATE TABLE Book(BookCode VARCHAR(5), BookTitle NVARCHAR(60), BookPrice Decimal)");

        scrollStatement.executeUpdate("INSERT INTO Book VALUES('919',	'qqqqqqqqqqqq',	2222.00)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('MBAL','MVS Assembler Language',56.00)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('MJIG','MVS JCL Instructor''s Guide',100.00)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('MJLR','MVS JCL (2nd. Ed.)',42.50)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('MWMM','Word 6: How to use the Mail Merge Feature',9.95)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('null','null',0.00)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('OSUT','OS Utilities',17.50)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('PREX','Work Like a PRO with Excel 5 for Windows',20.00)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('PRMW','Work like a PRO with Word 6 for Windows',20.00)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('PRW7','Work like a PRO with Word for Windows 95',25.00)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('PRX7','Work Like a PRO with Excel for Windows 95',25.00)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('qqqq','MVS TSO, Part 1:Concepts and ISPF',100.00)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('qwe','dDB2 for the COBOL Programmer, Part 1',36.50)");
        scrollStatement.executeUpdate("INSERT INTO Book VALUES('RW', 'Report Writer', 222.00)");

        scrollStatement.close(); //option
        connection.close();	//required to insert last element
    }
}
