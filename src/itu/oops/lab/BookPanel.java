/**
 * 
 */
package itu.oops.lab;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 * @author FNU Manita
 * Professor Victor Yu
 * This class will create a display panel and update panel for the book records:
 * User can add, update, delete and navigate through the records
 *
 */
public class BookPanel extends JPanel implements ActionListener, DocumentListener, KeyListener {
	
	/**
	* default serialVersionID
	*/
	private static final long serialVersionUID = 1L;
	// buttons for add, update,delete and exit
	private JButton addButton, modifyButton, removeButton, exitButton;
	
	// labels for code, title and price
	private JLabel bookCodeLabel, bookTitleLabel, bookPriceLabel;
	
	// buttons for navigation
	private JButton firstButton, prevButton, nextButton, lastButton;
	
	// Text box field to enter book code, book title, bookPrice
	private JTextField bookCodeField, bookTitleField, bookPriceField;
	
	// addFlaf defaulted to true
	public static boolean addFlag = false;
	
	// for local currency instance
	public static NumberFormat currency = NumberFormat.getCurrencyInstance();
	
 	Book currentBook = null;
	
	/*
	 * Constructor to create Labels, Fields and Buttons
	 */
	public BookPanel() {
			
		bookCodeLabel = new JLabel("Code: ");
		bookCodeField = new JTextField("", 9);
		bookTitleLabel = new JLabel("Title: ");
		bookTitleField = new JTextField("", 30);
		bookPriceLabel = new JLabel("Price: ");
		bookPriceField = new JTextField("", 9);
		
		//create panel for crud operation
		JPanel updatePanel = new JPanel();
		/*
		 * create buttons for Add, Update, delete and Exit
		 */
		addButton = new JButton("Add");
		modifyButton = new JButton("Update");
		removeButton = new JButton("Delete");
		exitButton = new JButton("Exit");
		/*
		 * Apply buttons to the panel
		 */
		updatePanel.add(addButton);
		updatePanel.add(modifyButton);
		updatePanel.add(removeButton);
		updatePanel.add(exitButton);
		
		// create panel for navigator
		JPanel navigatorPanel = new JPanel();
		/*
		 * create buttons for First, Prev, Next and Last
		 */
		firstButton = new JButton("First  ");
		prevButton = new JButton("Prev  ");
		nextButton = new JButton("Next ");
		lastButton = new JButton("Last ");
		/*
		 * Apply buttons to the panel
		 */
		navigatorPanel.add(firstButton);
		navigatorPanel.add(prevButton);
		navigatorPanel.add(nextButton);
		navigatorPanel.add(lastButton);
		
		//Listener for BookCode Field
		bookCodeField.addKeyListener(this);
		//Listener for BookTitle Field
		bookTitleField.addKeyListener(this);
		//Listener for BookPrice Field
		bookPriceField.addKeyListener(this);
		//Listener for codefield value
		bookCodeField.getDocument().addDocumentListener(this);
		//Listener for BookTitle value
		bookTitleField.getDocument().addDocumentListener(this);
		//Listener for BookPrice value
		bookPriceField.getDocument().addDocumentListener(this);
		//Listener for add Button
		addButton.addActionListener(this);
		//Listener for modify Button
		modifyButton.addActionListener(this);
		//Listener for remove Button
		removeButton.addActionListener(this);
		//Listener for exit Button
		exitButton.addActionListener(this);
		//Listener for first Button
		firstButton.addActionListener(this);
		//Listener for previous Button
		prevButton.addActionListener(this);
		//Listener for next Button
		nextButton.addActionListener(this);
		//Listener for last Button
		lastButton.addActionListener(this);
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.weightx = 100;
		gridConstraints.weighty = 100;
		gridConstraints.ipadx = 5;
		
		//specify the grid location for labels
		gridConstraints.anchor = GridBagConstraints.EAST;
		gridConstraints = getConstraints(gridConstraints, 1, 1, 1, 1);
		add(bookCodeLabel, gridConstraints);
		gridConstraints = getConstraints(gridConstraints, 1, 2, 1, 1);
		add(bookTitleLabel, gridConstraints);
		gridConstraints = getConstraints(gridConstraints, 1, 3, 1, 1);
		add(bookPriceLabel, gridConstraints);
		
		//specify the grid location for text field
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints = getConstraints(gridConstraints, 2, 1, 3, 1);
		add(bookCodeField, gridConstraints);
		gridConstraints = getConstraints(gridConstraints, 2, 2, 3, 1);
		add(bookTitleField, gridConstraints);
		gridConstraints = getConstraints(gridConstraints, 2, 3, 3, 1);
		add(bookPriceField, gridConstraints);
		
		//specify the grid location for all the buttons
		gridConstraints.anchor = GridBagConstraints.CENTER;
		gridConstraints = getConstraints(gridConstraints, 1, 4, 4, 1);
		add(updatePanel, gridConstraints);
		gridConstraints = getConstraints(gridConstraints, 1, 5, 4, 1);
		add(navigatorPanel, gridConstraints);
		
		/*
		 * On the first invoke, display the existing Book records provided in helper class 
		 */
		BookDB.displayExistingRecords();
		/*
		 * Getting First Book record displayed in beginning
		 */
		currentBook = BookDB.getFirstBook();
		/*
		 * display the value of current record i.e name, code and price
		 */
		performBookDisplay();
		/*
		 * Controlling the buttons
		 */
		enableButtons(true);
		
	}
	
		
	/**
	 * @param gridConstraints
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return GridBagConstraints
	 * This method will specify the coordinates of the grid
	 */
	private GridBagConstraints getConstraints(GridBagConstraints gridConstraints, int x, int y, int width, int height) {
		/*
		 * specify the x, y, width and height magnitudes
		 * 	
		 */
		gridConstraints.gridx = x;
		gridConstraints.gridy = y;
		gridConstraints.gridwidth = width;
		gridConstraints.gridheight = height;
		return gridConstraints;
	}
	
	
	/**
	 * This method will assign the value of current book to the fields
	 */
	private void performBookDisplay() {
		bookCodeField.setText(currentBook.getBookCode());
		bookTitleField.setText(currentBook.getBookTitle());
		bookPriceField.setText(currency.format(currentBook.getPrice()));
	}
	
	
	/**
	 * @param flag1
	 * This method will enable or disable the buttons according to purpose
	 */
	private void enableButtons(boolean flag1) {
		boolean flag2 = false;
		if (flag1 == false) {
		    flag2 = true;
		}
		modifyButton.setEnabled(flag2);
		addButton.setEnabled(flag1);
		removeButton.setEnabled(flag1);
		firstButton.setEnabled(flag1);
		nextButton.setEnabled(flag1);
		prevButton.setEnabled(flag1);
		lastButton.setEnabled(flag1);
	}
	
	/**
	 * @param currencyString
	 * @return double currency
	 */
	private double parseCurrency(String currencyString) {
		if (currencyString.charAt(0) == '$') {
		    currencyString = currencyString.substring(1);
		}
		return Double.parseDouble(currencyString);
	}
	
	/**
	 * @param ActionEvent
	 * @return nothing
	 * This method will perform the action according to the event provided by the buttons or fields
	 */
	public void actionPerformed(ActionEvent event) {
		try {
		    Object action = event.getSource();
		    //exit is the action
		    if (action == exitButton) {
		        System.exit(0);
		    } else if (action == firstButton) {
		    	// first button invokes the action
		        currentBook = BookDB.getFirstBook();
		        performBookDisplay();
		        enableButtons(true);
		    } else if (action == prevButton) {
		    	// Previous button invokes the action
		        currentBook = BookDB.getPreviousBook();
		        performBookDisplay();
		        enableButtons(true);
		    } else if (action == nextButton) {
		    	// Next button invokes the action
		        currentBook = BookDB.getNextBook();
		        performBookDisplay();
		        enableButtons(true);
		    } else if (action == lastButton) {
		    	// Last button invokes the action
		        currentBook = BookDB.getLastBook();
		        performBookDisplay();
		        enableButtons(true);
		    } else if (action == addButton) {
		    	// Add button invokes the action
		    	bookCodeField.requestFocus();
		        enableButtons(false);
		        bookCodeField.setText("");
		        bookTitleField.setText("");
		        bookPriceField.setText("");
		        addFlag = true;
		    } else if (action == modifyButton) {
		    	//Update button invokes the action
		        double price = parseCurrency(bookPriceField.getText());
		        //get the updated values from fields
		        Book book = new Book(bookCodeField.getText(),
		        		bookTitleField.getText(),
		                price);
		        if (addFlag == false) {
		        	//update the records if update button triggered the event
		            BookDB.updateBookRecord(book);
		            currentBook = book;
		        }
		        if (addFlag == true) {
		        	//add the record if add button triggered the event
		            BookDB.addBook(book);
		            currentBook = BookDB.getFirstBook();
		            addFlag = false;
		        }
		        currentBook = book;
		        //display the current record
		        performBookDisplay();
		        enableButtons(true);
		    } else if (action == removeButton) {
		    	//delete the record if Delete button triggered the event
		        BookDB.removeBook(currentBook.getBookCode());
		        //Go to the first record
		        firstButton.requestFocus();
		        firstButton.doClick();
		        performBookDisplay();
		        enableButtons(true);
		    }
		} catch (NumberFormatException nfe) {
			//display the exception to the user
		    JOptionPane.showMessageDialog(this, nfe.getMessage());
		} 
	}
	
	/**
	 * @param ActionEvent
	 * @return nothing
	 * This method will check which key has been pressed by the user
	 */
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//check if the key pressed is Esc key
		if (keyCode == KeyEvent.VK_ESCAPE) {
		    performBookDisplay();
		    enableButtons(true);
		    bookCodeField.requestFocus();
		}
	}
	
		
	public void insertUpdate(DocumentEvent e) {
		enableButtons(false);
	}
	
	public void removeUpdate(DocumentEvent e) {
		enableButtons(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

		
}
