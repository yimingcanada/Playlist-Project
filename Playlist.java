import java.util.*;

public class Playlist
{


	//Stores the reference to a playlists head
	private Node head;
	//Stores the reference to a playlists tail
	private Node tail;
	//Stores the playlists name
	private String name;
	//Stores the number of songs a playlist has
	private int sizeOfList = 0;
	//Stores the reference to the current node
	private Node current;



	//The constructor
	public Playlist (String listName)
	{
		name = listName;
	}



	//Add a new song to the end of the list.
	public boolean addSong (String nameSong, String artist)
	{      

		Song newSong = null;

		Song [] songArray = Main.songList.toArray(new Song[Main.songList.size()]);
		//convert the Arraylist in main storing Songs into an Array 

		for (int i = 0; i < Main.numOfSongs; i ++)
		{


			if (songArray[i].getTitle().equals(nameSong) && songArray[i].getArtist().equals(artist))
				//checks to see if both the song name and song artist correspond to the same song
				//in the songArray. Also checks if they exist
			{
				newSong = songArray[i];

				Node newNode = new Node (tail, newSong);

				if (head == null)// if the head doesn't exist, the newnode becomes the head
				{
					head = newNode;
					current = head;

				}
				else
				{
					tail.setNext(newNode); //if head exists, just add it to the last node

				}


				tail = newNode;
				sizeOfList ++;
				return true;

			}               

		}

		return false; //song name and song artist don't match or do not exist in the song Array

	}


	//Add a new song to the list at the specified index
	public boolean addSong (int index, String nameSong, String artist)
	{
		Song newSong = null;



		for (int i = 0; i < Main.numOfSongs; i ++)
		{

			if (Main.songList.get(i).getTitle().equals(nameSong) && Main.songList.get(i).getArtist().equals(artist))
			{	//checks if the name of the song and the artist matches with all the songs
				newSong =  Main.songList.get(i);

				Node newNode = new Node (current, newSong); //creates node assigned to the song

				if(index == 0)
				{
					current = head;//set current as the head from before
					head = newNode; //reassign the head
					newNode.setNext(current); // new head points to old head
				}

				if (index == sizeOfList)
				{
					tail.setNext(newNode); // old tail points to new node

					tail = newNode; // new node become tail

				}
				else 
				{
					current = head;

					for (int j = 0 ; j < index -1 ; j ++) //goes to the node 1 unit left of the index given
					{
						current = current.getNext();                 
					}

					Node newNodetoPoint = current.getNext(); //this is the current node, or the node at the index given

					current.setNext (newNode); //the previous node now points to the new node
					newNode.setPrevious(current);

					newNode.setNext (newNodetoPoint);//and the new node points to the node at the index given, thus adding it between the previous node and the "current" node
					newNodetoPoint.setPrevious(newNode);//and vice versa, to make the current node point back towards the new node

				} 
				sizeOfList ++;
				return true;
			}
		}
		return false; //if song name and song artist still doesn't match or do not exist in the song Array
	}


	//delete a song from this playlist with this index. Return false if song not found, return true if successful
	public boolean deleteSong (int index)
	{
		if (index >= sizeOfList || index < 0)
		{
			return false; //the index does not exist
		}

		current = head;
		if (index == 0) //if the head is being deleted, the next node becomes the head
		{
			head = head.getNext();
			return true;
		}

		if (index == sizeOfList -1) //if the index is the last one, the code below will not work, since it will go to the node after the last one
		{
			tail.getPrevious().setNext(null); //removes reference to tail, goes into garbage collection
			tail=tail.getPrevious(); //tail moves 1 index lower
			return true;
		}

		for (int i = 0 ; i < index -1 ; i ++) //goes to the previous node to the index
		{
			current = current.getNext();                 
		}



		Node nodeToPoint = current.getNext().getNext();//makes the previous node point to the node after the node being deleted
		nodeToPoint.setPrevious (current);

		current.setNext(nodeToPoint);//the node two spaces right from the current node is now the next node
		sizeOfList --;

		return true;
	}


	//delete a song from this playlist with this song name and artist. Return false if song not found, return true if successful
	public boolean deleteSong (String name, String artist)
	{
		if (findPos (name, artist) == -1)
		{
			return false;
		}

		deleteSong (findPos (name, artist));

		return true;
	}


	//Play the next song in the list
	public Node nextNode ()
	{
		return current.getNext();
		//return the next Node in the list here
	}


	public Node currentNode ()
	{
		return current;
		//return the current Node in the list here
	}
	public void setCurrentNode (Node c)
	{
		current = c;
	}

	public Node getLastNode ()
	{
		return tail;
		//return the last song in the list
	}


	//A method that finds the song  required using the song's title & artist. Returns the position number
	public int findPos (String title ,String artist)
	{
		int pos = 0;
		current = head;

		while (current != null)
		{
			if (current.getSong().getTitle().equals(title) && current.getSong().getArtist ().equals(artist))		
			{//checks to see if both the song name and song artist correspond to the same song
				//in the songArray. Also checks if they exist
				return pos;                    
			}
			pos ++;
			current = current.getNext();
		}       
		return -1;
	}


	//Returns the number of songs in the playlist
	public int getNumSongs ()
	{
		return sizeOfList;
	}


	//Returns a reference to the head of the playlist
	public Node getListHead ()
	{
		return head;
	}


	//A method that prints out the names of all songs in the list. 

	public ArrayList <String> listSongs()
	{

		current = head;

		ArrayList <String> list = new ArrayList<String> ();
		while (current !=  null)
		{
			list.add(current.getSong().getTitle());
			current = current.getNext();

		}
		current = head;//resets the current back to the head just in case, give errors sometimes if not reset since outside classes access the current node
		return list;
	}

	//set the head of the list
	public void setHead (Node n)
	{
		head = n;
	}

	//Set the tail of the list
	public void setTail (Node n)
	{
		tail = n;
	}


	//Return the name of this playlist
	public String getName ()
	{
		return name;
		//return the name of the playlist
	}





}
