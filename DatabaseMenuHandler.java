import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;

/** 
 * Checks to see if user clicked "Open" "Fruits" or "Vegetables." Then decides, based on what was 
 * clicked to either allow the user to select a file (to be used for the database), display
 * a list of fruit items in the database, or display a list of vegetable items in the database.
 * 
 * @author Steven Wojsnis
 */

public class DatabaseMenuHandler implements ActionListener{
	JFrame jframe;
	String result="";
	public static File d;
	public DatabaseMenuHandler (JFrame jf) {
	   jframe = jf;
	} //Constructor
	
	public void actionPerformed(ActionEvent event) {	
	   String menuName = event.getActionCommand();
	   if (menuName.equals("Open")){
	    	  
	      JFileChooser fd = new JFileChooser();
    	  fd.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
          fd.showOpenDialog(null);
  		  d = fd.getSelectedFile();
	   }
	   else if (menuName.equals("Fruits")){
		   JFrame frame = new JFrame("Fruits"); // Instantiates a new JFrame object reference, with the title "Receipt"
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Allows user to exit window
			frame.setSize(100, 100); // Sets the size of the window
			frame.setLocation(200, 200); // Sets the location of the window
			frame.setLayout(new GridLayout(2,1)); // Sets the layout of the window
			
			JTextArea textArea = new JTextArea(15,50); // Instantiates a new TextArea (where the data will be printed)
			textArea.setEditable(false); // Makes the text area un-editable 
			JScrollPane scrollPane = new JScrollPane(textArea); // Instantiates a new JScrollPane object, with the component "textArea"
			frame.getContentPane().add(scrollPane); // adds scrollPane object reference to the ContentPane
	       
			Database database = new Database(); // Instantiates Database class
			database.DatabaseInfo(); // Obtains information stored in the database
			ProduceNode a = database.List.first.next;

			//Loops through linked list, keeping track of all fruit items
			while(a.next != null){

				if(a.data instanceof Fruit){	
					result += a.data.code + "   " + a.data.name + "   " + a.data.price+"\n";
				}
				a = a.next;
			    
			}//while
			textArea.setText(result); // prints all fruit items in a JFrame text area
			result = "";
			frame.pack(); // Enlarges window if provided dimensions are too small
			frame.setVisible(true); // Allows the window to be viewed
			
	   }
	   else if (menuName.equals("Vegetables")){
		   JFrame frame = new JFrame("Vegetable"); // Instantiates a new JFrame object reference, with the title "Receipt"
		   frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Allows user to exit window
		   frame.setSize(100, 100); // Sets the size of the window
		   frame.setLocation(200, 200); // Sets the location of the window
		   frame.setLayout(new GridLayout(2,1)); // Sets the layout of the window
		
		   JTextArea textArea = new JTextArea(15,50); // Instantiates a new TextArea (where the data will be printed)
		   textArea.setEditable(false); // Makes the text area un-editable 
		   JScrollPane scrollPane = new JScrollPane(textArea); // Instantiates a new JScrollPane object, with the component "textArea"
		   frame.getContentPane().add(scrollPane); // adds scrollPane object reference to the ContentPane
		
		   textArea.setText("");
		   Database database = new Database(); // Instantiates Database class
		   database.DatabaseInfo(); // Obtains information stored in the database
		
		   
		   ProduceNode a = ProduceList.first.next;
		   
		   //Loops through linked list, keeping track of all vegetable items
		   while(a != null){

			   if(a.data instanceof Vegetable){   
				   result += a.data.code + "   " + a.data.name + "   " + a.data.price+"\n";
			   }
			   
			   a=a.next;
		   }//while
		   textArea.setText(result); // prints all vegetable items in a JFrame text area
		   result = "";
		   frame.pack(); // Enlarges window if provided dimensions are too small
		   frame.setVisible(true); // Allows the window to be viewed
	   }
	} //actionPerformed
}