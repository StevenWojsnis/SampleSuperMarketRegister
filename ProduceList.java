
public class ProduceList {
	// LinkedList.java
	// 
	// This version uses three instance variables,
	// a pointer to the first node, a pointer to
	// the last node, and length, to make our
	// append and getLength methods more efficient
	// than the would be if our only instance
	// variable were a pointer to the first node.
	//
	// This version uses a dummy first node.  Hence
	// it needs less decision-making than it would
	// need if a dummy first node were not used.
	//

	/**
	 * Encapsulates a linked list of <code>String</code>.
	 */

	/**  First node in linked list - dummy node  */
	   public static ProduceNode first = new ProduceNode(null);

	/**  Last node in linked list  */
	   public static ProduceNode last = first;

	/**  Number of data items in the list.  */
	   private int length = 0;

	  /**
	    * Gets the number of data values currently
	    * stored in this LinkedList.
	    *
	    * @return the number of elements in the list.
	    */

	   public int getLength()  { 
	      return length; 
	   }


	   /**
	    * Appends a String data element to this
	    * LinkedList.
	    *
	    * @param data the data element to be appended.
	    */
	   public void append(ProduceItem d)
	   {

	     //  write the code here for append
		   ProduceNode toAppend=new ProduceNode(d);
		   last.next=toAppend;
		   last=toAppend;
		   length++;
	   }  // method append(String)


	   /**
	    * Prepends (adds to the beginning) a String data element to this
	    * LinkedList.
	    *
	    * @param data the data element to be prepended.
	    */
	   public void prepend(ProduceItem d)
	   {
		   ProduceNode toPrepend=new ProduceNode(d);
		   if(first==last){
			   last.next=toPrepend;
			   last=toPrepend; 
			   length++;
		   }
		   else{
			   toPrepend.next=first.next;
			   first.next=toPrepend;
		       length++;
		   }
	     //  write the code here for prepend

	   }  // method append(String)


	  /**
	   *  Prints the contents of the Linked List
	   *
	   */
	   public String toString() {
		   ProduceNode p = first.next;
	      String returnString = "";
	      while (p != null) {
	         returnString += p.data+" ";
	         p=p.next;
	      }
	      return returnString;
	   }

	  
	   /**
	    * Determines whether this ShortSequenceLinkedList is
	    * equal in value to the parameter object.
	    * They are equal if the parameter is of
	    * class ShortSequenceLinkedList and the two objects
	    * contain the same short integer values at
	    * each index.
	    *
	    * @param other the object to be compared
	    *          to this ShortSequenceLinkedList
	    *
	    * @return <code>true</code> if the parameter
	    *        object is a ShortSequenceLinkedList containing
	    *        the same numbers at each index as
	    *        this ShortSequenceLinkedList, <code>false</code>
	    *        otherwise.
	    */
	   public boolean equals(Object other)
	   {
	      if ( other == null 
	              || getClass() != other.getClass()
	              || length != ((ProduceList) other).length )
	          return false;

	      ProduceNode nodeThis = first;
	      ProduceNode nodeOther = ((ProduceList) other).first;
	      while ( nodeThis != null )
	      {
	          // Since the two linked lists are the same length,
	          // they should reach null on the same iteration.

	          if ( nodeThis.data != nodeOther.data )
	             return false;

	          nodeThis = nodeThis.next;
	          nodeOther = nodeOther.next;
	      }  // while

	      return true;
	   }  // method equals
	public ProduceItem getItem(int index){
		if(index<0||index>=length)
		throw new IllegalArgumentException("not acceptted");	
		ProduceNode a=first.next;
		for(int i=0;i<index;i++)
			a=a.next;
		return a.data;
	}




}  // class LinkedList

