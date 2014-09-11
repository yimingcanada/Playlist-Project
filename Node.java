
public class Node {
	
	
    //Stores the reference to this nodes song
    private Song currentSong;
    //Stores the reference to the node that follows this one in the list
    private Node next;
    
	private  Node previous;

    //The constructor
    public Node (Node p, Song s)
    {
    	previous = p;
        currentSong = s;
    }

    //Returns the reference to this nodes song
    public Song getSong ()
    {
        return currentSong;
    }

    //Returns the reference to the next node in the list
    public Node getNext ()
    {
        return next;
    }

    //set a new next node in the list
    public void setNext (Node n)
    {
        next = n;
    }
    /**
 	 * @return the previous node
 	 */
 	public Node getPrevious() {
 		return previous;
 	}

	public void setPrevious(Node p) {
		// TODO Auto-generated method stub
		previous = p;
	}

 
 	
}