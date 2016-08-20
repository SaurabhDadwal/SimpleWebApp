package itu.oops.lab;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


/**
 * @author FNU Manita
 * Professor Victor Yu
 * This class will create the GUI Interface for display panel and update panel for the book records:
 * User can add, update, delete and navigate through the records
 *
 */
public class BookFrame extends JFrame {

    /**
	 *default serialVersionID 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Default Constructor of BookFrame.
	 * It will create the window for desired specifications and provide listener
	 */
	public BookFrame() {
        setTitle("Book Maintenance");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int width = 400, height = 200;
        setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
        	//check if the window close event is triggered
            public void windowClosing(WindowEvent e) {
            	//exit the program
                System.exit(0);
            }
        });
        
        //Generate the content pane of the container
        Container contentPane = getContentPane();
        //Create the object of BookPanel and initialize the panel
        BookPanel panel = new BookPanel();
        //add panel to the content pane
        contentPane.add(panel);
    }

    @SuppressWarnings("deprecation")
	public static void main(String[] args)  {
        //create instance for BookFrame class
        JFrame bookFrame = new BookFrame();
        bookFrame.show();
    }
}
