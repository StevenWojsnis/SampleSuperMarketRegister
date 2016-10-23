/**
 * This class is used to create links of the ProduceList, with different
 * ProduceItems as the data in each element of the list.
 * @author Steven Wojsnis
 *
 */
public class ProduceNode {
	
	ProduceItem data;
	ProduceNode next;

	/**
	 * Sets data to be equal to d (makes the data equal to the produceItem passed through the constructor.
	 * Sets next equal to null (makes this element the last on the list).
	 * @param d : A ProduceItem
	 */
	ProduceNode(ProduceItem d)
	{
	   data = d;
	   next = null;
	}  // constructor
}  // class ProduceNode

