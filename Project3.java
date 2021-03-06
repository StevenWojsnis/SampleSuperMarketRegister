/**
 * The program loads data from a database array containing information about grocery items.
 * That information is then loaded into several objects. Each item receives its own object,
 * and therefore its own set of instance variables.
 * 
 * The program also reads in information from a "Transaction.txt" file, meant to simulate
 * a real-life transaction.
 * 
 * The program runs through the objects containing various produce items, comparing a
 * provided code with the instance variable code of these objects.
 * Once a match it found, the price of that item is calculated.
 * 
 * Finally, the program creates and fills a GUI with the name, price per pound (lb),
 * purchased weight, and price, along with a label that displays the total price.
 * 
 * Instructor Guozhen An
 * Lab Section B
 *
 * @author Steven Wojsnis
 * 
 *
 */
public class Project3 {
	public static GUI gui;
	/**
	 * Main method, included to create the GUI (which in turn loads data).
	 * @param args
	 */
	public static void main(String[] args){
		
		gui = new GUI();
		//GUI.CreateGUI(); // Calls on a method within the GUI class that creates the receipt GUI

	}
}
