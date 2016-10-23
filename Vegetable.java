/**
 * Class for vegetable, an extention of ProduceItem. The constructor
 * for this class takes 2 strings (c and n) and a float (p), meant to represent code, 
 * name, and price. The constructor then calls super, passing the 2 strings
 * and float as parameters.
 * @author Steven Wojsnis
 *
 */
public class Vegetable extends ProduceItem {
	Vegetable(String c, String n, float p){
		super(c,n,p);
	}
}
