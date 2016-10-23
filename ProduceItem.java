/**
 * Provides a blueprint for the objects in which individual item's information will be stored.
 * 
 * @author Steven Wojsnis
 *
 */
public abstract class ProduceItem {
	String code; // Instance variable for code
	String name; // Instance variable for name
	float price; // Instance variable for price
	
	
	// No-arg constructor, sets value of all instance variables to either "" or 0
	public ProduceItem(){
		code = "";
		name = "";
		price = 0;
	} // no-arg constructor
	
	public ProduceItem(String c, String n, float p){
		code = c;
		name = n;
		price = p;
	} // 3-arg constructor
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
