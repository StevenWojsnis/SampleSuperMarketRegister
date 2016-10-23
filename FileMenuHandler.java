import javax.swing.*;
import java.io.File;
import java.awt.event.*;

/**
 * Checks to see if user clicked "Open" or "Quit." If "Open" was chosen, allows the user to select a file 
 * to be used for the transaction list. If "Quit" was chosen, the JFrame closes.
 * @author Steven Wojsnis
 *
 */
public class FileMenuHandler implements ActionListener {
   JFrame jframe; JTextArea textArea; JLabel label; File file;
   static File f;
   
   // The constructor sets various values equal to the values of the open JFrame
   public FileMenuHandler (JFrame jf, JTextArea txtArea, JLabel lbel, File fle) {
      jframe = jf;
      textArea = txtArea;
      label = lbel;
      file = fle;
   } //constructor
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      if (menuName.equals("Open")){
    	  if(DatabaseMenuHandler.d == null){
    		  JOptionPane.showMessageDialog(null, "Please select a database file before selecting a transaction file.");
    	  }
    	  else{	  
    		  JFileChooser fd = new JFileChooser();
    		  fd.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    		  fd.showOpenDialog(null);
    		  f = fd.getSelectedFile();
    	  
    		  GUI.FillGui(jframe, textArea, label, f); // Calls a method that will display the data
    	  }
      }
      else if (menuName.equals("Quit"))
         jframe.dispose();
   } //actionPerformed
}