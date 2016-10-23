/**
 * Class for fruit, an extention of ProduceItem. The constructor
 * for this class takes 2 strings (c and n) and a float (p), meant to represent code, 
 * name, and price. The constructor then calls super, passing the 2 strings
 * and float as parameters.
 * @author Steven Wojsnis
 *
 */
public class Fruit extends ProduceItem {
	Fruit(String c, String n, float p){
		super(c,n,p);
	}
}
