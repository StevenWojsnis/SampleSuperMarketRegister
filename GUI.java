import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.File;
/**
 * Creates, and fills the GUI so that it contains the required information for the receipt.
 * 
 * @author Steven Wojsnis
 *
 */
public class GUI {
	protected static JMenuBar menuBar  = new JMenuBar();
	
	//public GUI(){
		
	//} // constructor
	
	/**
	 * CreateGUI is included to create the frame of the GUI. It also calls FillGui, which
	 * loads the data from the database.
	 */
	public GUI() {
		JFrame frame = new JFrame("Receipt"); // Instantiates a new JFrame object reference, with the title "Receipt"
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Allows user to exit window
		frame.setSize(100, 100); // Sets the size of the window
		frame.setLocation(200, 200); // Sets the location of the window
		frame.setLayout(new GridLayout(2,1)); // Sets the layout of the window
		
		JTextArea textArea = new JTextArea(15,50); // Instantiates a new TextArea (where the data will be printed)
		textArea.setEditable(false); // Makes the text area un-editable 
		JScrollPane scrollPane = new JScrollPane(textArea); // Instantiates a new JScrollPane object, with the component "textArea"
		frame.getContentPane().add(scrollPane); // adds scrollPane object reference to the ContentPane
		JLabel label = new JLabel("Receipt"); // Instantiates a new label object named "Receipt"
		frame.getContentPane().add(label); // Adds the label to the ContentPane
		
		frame.pack(); // Enlarges window if provided dimensions are too small
		

		createFileMenu(frame, textArea, label, FileMenuHandler.f);
		createDatabaseMenu(frame);
		frame.setVisible(true); // Allows the window to be viewed
		//FillGui(frame, textArea, label, FileMenuHandler.f); // Calls a method that will display the data
	} // CreateGUI()
	
	
	/**
	 * Loads the data from the database, then compares the "code" provided in the Transaction.txt
	 * file with the codes stored in ProduceItem objects from the database. Once a match is found,
	 * information from the matching object in the database is printed to the Jframe.
	 * 
	 * @param frame The "Receipt" window.
	 * @param textArea The area of the JFrame where the data will be printed.
	 * @param label Used to store and display the Total price.
	 */
	public static void FillGui(JFrame frame, JTextArea textArea, JLabel label, File file){
		DecimalFormat df = new DecimalFormat("$0.00"); // Formats numbers so that they appear as dollars with two decimal places.
		String result =""; //Creates new, empty, string
		
		float Total = 0; // Creates new Total value with value 0 - used to keep track of total cost
		int k = 0; // variable used to cycle through array containing weights of purchased items
		Database database = new Database(); // Instantiates Database class
		
		database.DatabaseInfo(); // Obtains information stored in the database
		TextFileInput in = new TextFileInput(file.toString()); // Instantiates TextFileInput class for file: "Transaction.txt"
		String line = in.readLine(); // Reads in first line of Transaction file, stores it in "line"
		
		float weight[] = new float[50]; // Array used to hold weight values from Transaction file
		String code = ""; // String used to hold cold values from Transaction file
		
		//String format = "%1$5s %2$-15s %3$-20s %4$-20s";
		
		while(line != null){
			StringTokenizer Tokenizer = new StringTokenizer(line,","); // Instantiates StringTokenizer class - reads items in "line" separated by commas
		
			code = Tokenizer.nextToken(); // Stores first value in line (the item code) in "code" 
			weight[k] = Float.parseFloat(Tokenizer.nextToken()); // Converts the second value in line to float, and stores it in weight[k]
			Total += database.getPrice(code)*weight[k]; // Increments total price by price of individual items (price per pound * weight)
			line = in.readLine(); // reads in the next line of Transaction file, stores it in line
			try{
			//Adds the data: code, price per pound, weight, and price (rounded to 2 decimals) to the "result" String 			
			if(database.getName(code)==null) throw new ItemNotFoundException("Item not in database."); // If this code is not found in the database, throw an error.
			else result += database.getName(code) + "     " + "$"+database.ToString(database.getPrice(code)) + "     "
				     + database.ToString(weight[k])+" lb" + "     " +df.format(database.getPrice(code)*weight[k]);
			} 
			
			// If "ItemNotFoundException" was thrown, this allows a user to manually enter a price.
			catch(ItemNotFoundException e){
				
				String price = JOptionPane.showInputDialog(null,"Item not in database, enter a price.");
				double dubPrice = Double.parseDouble(price) * weight[k];
				Total += dubPrice;
				result+= "Manually entered price: "+"$"+price+" per pound."+" Cost: "+df.format(dubPrice);
			}
			
			result += "\n"; // Skips a line in the "result" String
			
			k++;
		} //while
		
		textArea.setText(result); // Sets the value of the TextArea to hold the "result" String
		label.setText("The total price is: " + df.format(Total)); // Sets the value of the label to be the Total price (rounded to 2 decimals)
	} // FillGui
	
	/**
	 * Creates and adds the File menu to the JFrame
	 * @param frame
	 * @param textArea 
	 * @param label
	 * @param file
	 */
	private void createFileMenu(JFrame frame, JTextArea textArea, JLabel label, File file ) {

	      JMenuItem   item;
	      FileMenuHandler fmh  = new FileMenuHandler(frame, textArea, label, file);
	      JMenu  fileMenu = new JMenu("File");
	      item = new JMenuItem("Open");    //Open...
	      item.addActionListener( fmh );
	      fileMenu.add( item );

	      fileMenu.addSeparator();           //add a horizontal separator line
	    
	      item = new JMenuItem("Quit");       //Quit
	      item.addActionListener( fmh );
	      fileMenu.add( item );

	      frame.setJMenuBar(menuBar);
	      menuBar.add(fileMenu);
	      
	      //FillGui(frame, textArea, label, FileMenuHandler.f); // Calls a method that will display the data
	    
	   } //createMenu
	
	   /**
	    * Creates and adds the Database menu to the JFrame
	    * @param frame
	    */
	   private void createDatabaseMenu(JFrame frame) {
	
		      JMenuItem   item;
		      JMenu  fileMenu = new JMenu("Database");
		      DatabaseMenuHandler fmh  = new DatabaseMenuHandler(frame);

		      item = new JMenuItem("Open");    //Open...
		      item.addActionListener( fmh );
		      fileMenu.add( item );

		      fileMenu.addSeparator();           //add a horizontal separator line
		    
		      item = new JMenuItem("Fruits");       //Fruits
		      item.addActionListener( fmh );
		      fileMenu.add( item );
		      
		      fileMenu.addSeparator();           //add a horizontal separator line
			    
		      item = new JMenuItem("Vegetables");       //Vegetables
		      item.addActionListener( fmh );
		      fileMenu.add( item );

		      frame.setJMenuBar(menuBar);
		      menuBar.add(fileMenu);
		      
		    
		   } //createMenu
}
