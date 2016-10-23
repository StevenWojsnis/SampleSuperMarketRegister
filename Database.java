import java.util.StringTokenizer;
import java.io.File;

/**
 * Reads in data from the Database.txt file and provides methods for loading the data
 * into ProduceItem objects, and consequently checking these items based on their code.
 * 
 * @author Steven Wojsnis
 *
 */

public class Database {
	public static File data = DatabaseMenuHandler.d;
	public Database(){
		data = DatabaseMenuHandler.d;
	} // Constructor
	
	static int i = 0; // Used to represent row numbers in array containing Database info
	String[][] TempList = new String[50][4]; // Array used to store Database info
	static ProduceList List = new ProduceList(); // Instantiates a new ProduceList

	/**
	 * Temporarily stores data from the Database2.txt file in an array, which is then used to
	 * fill ProduceItem objects with data.
	 */
	
	public void DatabaseInfo(){
		// If statement ensures that, no matter how many times DatabaseInfo is called, the linked list remains the same.
		if(i==0){
			TextFileInput in = new TextFileInput(data.toString()); // New reference to TextFileInput Class
			String line = in.readLine(); // Reads in first line of "Database.txt"
		
			while(line != null){
				StringTokenizer Tokenizer = new StringTokenizer(line, ","); // New reference to StringTokenizer class. Reads values separated by commas in line

			
				if(Tokenizer.nextToken().equals("F")){ // Checks to see if item is a fruit
					List.append(new Fruit(Tokenizer.nextToken(),Tokenizer.nextToken(),Float.parseFloat(Tokenizer.nextToken()))); // Adds new fruit object to linkedlist
				}
				else {
					StringTokenizer Tokenizer2 = new StringTokenizer(line, ",");
					if(Tokenizer2.nextToken().equals("V")){ // Checks to see if item is a vegetable
						List.append(new Vegetable(Tokenizer2.nextToken(),Tokenizer2.nextToken(),Float.parseFloat(Tokenizer2.nextToken()))); // Adds new vegetable object to linkedlist
					}
				}
			
				line = in.readLine(); // Reads in next line of "Database.txt"
			
			}
		} // while
		i++;
		

	} // DatabaseInfo()
	
	/**
	 * Creates ProduceItem object references, fills them with data: code, name, price. Then
	 * checks to see if "code" matches the instance variable code in any of the objects.
	 * 
	 * @param code Value used to find the desired ProduceItem object reference
	 * @return The name stored in the ProduceItem object that has a matching code number
	 */
	
	public String getName(String code){
		
		
		for(int j=0;j<List.getLength();j++){
			if (List.getItem(j).getCode().equals(code)){
				return List.getItem(j).getName(); // If the input code matches the code value within an object, return the name instance variable of that object
			} 
		} //for
		
		return null;
	} //getName
	
	/**
	 * Creates ProduceItem object references, fills them with data: code, name, price. Then
	 * checks to see if "code" matches the instance variable code in any of the objects.
	 * 
	 * @param code Value used to find the desired ProduceItem object reference
	 * @return The price stored in the ProduceItem object that has a matching code number
	 */
	
	public float getPrice(String code){
		
			
		for(int j=0;j<List.getLength();j++){
			if (List.getItem(j).getCode().equals(code)){
				return List.getItem(j).getPrice(); // If the input code matches the code value within an object, return the price instance variable of that object
			}
		} //for
		
		return 0;
	} //getPrice
	
	
	/**
	 * Checks to see if the float value isn't displaying a last zero (for example, 2.2
	 * instead of 2.20). If this is the case, appends a "0" onto the value.
	 * 
	 * @param x Float value to be checked
	 * @return The original, or appended float in String form.
	 */
	
	public String ToString(float x){
		if (Float.toString(x).length() == 3) return (Float.toString(x)+"0");
		else return (Float.toString(x));
		
	}// ToString Override 

}

