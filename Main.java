
import java.util.ArrayList;

import javax.swing.SwingUtilities;


public class Main {



	static int numOfSongs = 0;      //initialize number of songs as 0.      
	static ArrayList <Song> songList = new ArrayList<Song> (); //creates song array
	//  static ArrayList <String> stringSongList = new ArrayList<String>(); //creates string song array to hold song names

	static int numOfPlaylists = 0; // initialize number of playlists as 0.
	static ArrayList <Playlist> avaliablePlaylists = new ArrayList <Playlist> (); //creates playlist array
	//    static ArrayList <String> stringAvaliablePlayists = new ArrayList<String>(); //creates array to hold playlist names


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	



		createSong ("a","a1","a2","a2", "a3",1);
		createSong ("b","b1","b2" ,"b3", "b4",2);
		createSong ("c","a","a","a", "a",1);
		createSong ("d","a","a","a", "a",1);
		createSong ("e","a","a","a", "a",1);
		createSong ("f","a","a","a", "a",1);
		createSong ("g","a","a","a", "a",1);
		createSong ("h","a","a","a", "a",1);
		createSong ("i","a","a","a", "a",1);


		createPlaylist ("q1");               
		createPlaylist ("q2");
		createPlaylist ("q3");


		avaliablePlaylists.get(0).addSong("a", "a1");
		avaliablePlaylists.get(0).addSong("b", "b1");
		avaliablePlaylists.get(0).addSong("c", "a");
		avaliablePlaylists.get(0).addSong("d", "a");
		
	//	avaliablePlaylists.get(0).deleteSong(0);

		avaliablePlaylists.get(1).addSong("e", "a");
		avaliablePlaylists.get(2).addSong("f", "a");
		avaliablePlaylists.get(2).addSong("g", "a");
		avaliablePlaylists.get(1).addSong("h", "a");
		avaliablePlaylists.get(1).addSong("i", "a");


		//  stringSongList = toSongNames (songList);
		//   stringAvaliablePlayists = toPlaylistNames (avaliablePlayists);



		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}

	private static void createAndShowGUI() {
		//Create and set up the window.
		Gui mainFrame = new Gui ();     
		mainFrame.setVisible(true);                     

	}

	//create a song
	public static void createSong (String nameSong, String artist, String year, String nmOfAlbum, String genre, int numStars) 
	{
		Song newSong = new Song (nameSong,artist,year, nmOfAlbum, genre, numStars );
		songList.add (newSong);
		numOfSongs ++;
	}

	public static boolean deleteSong (String nameSong, String artist) //deletes songs from the song list
	{
		for (int i = 0 ; i < songList.size() ; i++)
		{
			if ( songList.get(i).getTitle().equals(nameSong) && songList.get(i).getArtist().equals(artist) ) //if the song's name and artist matches, then delete
			{
				songList.remove(i);
				return true;
			}
		}
		numOfSongs --;
		return false;
	}

	//creates an array of Song names

	public static ArrayList<String> toSongNames (ArrayList <Song> songs)
	{

		ArrayList<String> songNames = new ArrayList<String>();

		for (int i = 0 ; i < songList.size(); i ++)
		{
			songNames.add(songs.get(i).getTitle());  //stores each Song Object's title into string array

		}

		return songNames;

	}

	//creates playLists

	public static boolean createPlaylist (String name)
	{
		Playlist newPlayList = new Playlist (name);
		avaliablePlaylists.add (newPlayList);
		numOfPlaylists ++;
		return true;

	}
	//creates an  array of playlist names

	public static ArrayList<String> toPlaylistNames (ArrayList <Playlist> playlist)
	{

		ArrayList<String> stringPlaylist = new ArrayList<String>();

		for (int i = 0 ; i <  avaliablePlaylists.size(); i ++)
		{
			stringPlaylist.add(playlist.get(i).getName());  //stores each Song Object's title into string array

		}

		return stringPlaylist;

	}
	public static boolean deletePlaylist (String name)
	{
		for (int i = 0 ; i < avaliablePlaylists.size() ; i ++)
		{
			if (avaliablePlaylists.get(i).getName().equals((name)))
			{
				avaliablePlaylists.remove(i);
				System.out.println("deleted");
				numOfPlaylists --;
				return true;
			}
		}
		System.out.println("could not find");
		return false;
	}
	
	public static Playlist findPlaylist (String name)
	{
		for (int i = 0 ; i < avaliablePlaylists.size() ; i ++)
		{
			if (avaliablePlaylists.get(i).getName().equals((name)))
			{
				return avaliablePlaylists.get(i);
	
			}
		}
		System.out.println("could not find");
		return null;
	}

}


