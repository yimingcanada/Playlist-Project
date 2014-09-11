
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Gui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JLabel lblSlewisza;
	private JLabel lblName;
	private JLabel lblArtist;
	private JLabel lblTitleOfAlbum;
	private JLabel lblYearReleased;
	private JLabel lblGenre;
	private JLabel lblStarRating;

	private JTextField SongCreation_Name ;
	private JTextField SongCreation_Artist ;
	private JTextField SongCreation_Album ;
	private JTextField SongCreation_Year_Released ;
	private JTextField SongCreation_Genre ;
	private JTextField SongCreation_sRating;

	private JButton btnCreateSong;
	private JButton btnSongList;
	private JButton btnDeleteSong;

	private JSeparator separator_1;
	private JLabel lblName_1;
	private JTextField playlistCreation_name;

	private JButton btnCreatePlaylist;
	private JButton btnDeletePlaylist;

	private JLabel lblSongName;
	private JLabel lblSongArtist;
	private JLabel lblPlaylistName;
	private JLabel lblPlaylistIndex;

	private JTextField addToPlaylist_songName ;
	private JTextField addToPlaylist_songArtist ;
	private JTextField addToPlaylist_listName ;
	private JTextField addToPlaylist_listIndex ;

	private JButton btnDeleteSongFrom;
	private JButton btnAvaliablePlaylists;
	private JButton btnAddSongTo;
	private final JPanel playlistPane = new JPanel();
	private JLabel lblPlaylist;
	private JLabel lblSong;

	private JFrame frame;
	JLabel lblSongInfo;
	JLabel lblNumsongs;
	int playlistIndex = 0; //the current playlist

	Playlist currentPlaylist = Main.avaliablePlaylists.get(playlistIndex);
	Node currentNode =currentPlaylist.currentNode();
	private JButton btnGoToLast;
	JLabel lblPlaylistNameDisplay;
	JLabel lblByArtist;
	public Gui ()
	{


		setBounds(300, 150, 552, 682);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();             
		contentPane.setBackground(new Color(224, 255, 255));                    
		contentPane.setLayout(null);
		setContentPane(contentPane);

		lblSlewisza = new JLabel("Slewisza\u00A9");
		lblSlewisza.setBounds(217, -2, 87, 27);
		contentPane.add(lblSlewisza);

		lblName = new JLabel("Name");
		lblName.setBounds(21, 61, 46, 14);
		contentPane.add(lblName);

		lblArtist = new JLabel("Artist");
		lblArtist.setBounds(21, 86, 46, 14);
		contentPane.add(lblArtist);

		lblTitleOfAlbum = new JLabel("Title of Album");
		lblTitleOfAlbum.setBounds(21, 111, 86, 14);
		contentPane.add(lblTitleOfAlbum);

		lblYearReleased = new JLabel("Year Released");
		lblYearReleased.setBounds(21, 136, 86, 14);
		contentPane.add(lblYearReleased);

		lblGenre = new JLabel("Genre");
		lblGenre.setBounds(21, 161, 46, 14);
		contentPane.add(lblGenre);

		lblStarRating = new JLabel("Star Rating");
		lblStarRating.setBounds(21, 186, 86, 14);
		contentPane.add(lblStarRating);

		SongCreation_Name = new JTextField();
		SongCreation_Name.setBounds(128, 58, 86, 20);
		contentPane.add(SongCreation_Name);
		SongCreation_Name.setColumns(10);

		SongCreation_Artist = new JTextField();
		SongCreation_Artist.setBounds(128, 83, 86, 20);
		contentPane.add(SongCreation_Artist);
		SongCreation_Artist.setColumns(10);

		SongCreation_Album = new JTextField();
		SongCreation_Album.setBounds(128, 108, 86, 20);
		contentPane.add(SongCreation_Album);
		SongCreation_Album.setColumns(10);

		SongCreation_Year_Released = new JTextField();
		SongCreation_Year_Released.setBounds(128, 133, 86, 20);
		contentPane.add(SongCreation_Year_Released);
		SongCreation_Year_Released.setColumns(10);

		SongCreation_Genre = new JTextField();
		SongCreation_Genre.setBounds(128, 158, 86, 20);
		contentPane.add(SongCreation_Genre);
		SongCreation_Genre.setColumns(10);

		SongCreation_sRating = new JTextField();
		SongCreation_sRating.setBounds(128, 183, 86, 20);
		contentPane.add(SongCreation_sRating);
		SongCreation_sRating.setColumns(10);

		btnCreateSong = new JButton("Create Song");
		btnCreateSong.addActionListener(this);
		btnCreateSong.setBounds(65, 207, 105, 23);
		contentPane.add(btnCreateSong);

		btnSongList = new JButton("Song List");
		btnSongList.addActionListener(this);
		btnSongList.setBounds(65, 257, 105, 23);
		contentPane.add(btnSongList);

		btnDeleteSong = new JButton("Delete Song");
		btnDeleteSong.addActionListener(this);
		btnDeleteSong.setBounds(65, 232, 105, 23);
		contentPane.add(btnDeleteSong);

		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(244, 32, 2, 339);
		contentPane.add(separator_1);

		new JSeparator();
		separator_1.setBounds(10, 23, 467, 2);
		contentPane.add(separator_1);

		lblName_1 = new JLabel("Name");
		lblName_1.setBounds(268, 61, 36, 14);
		contentPane.add(lblName_1);

		playlistCreation_name = new JTextField();
		playlistCreation_name.setBounds(310, 58, 118, 20);
		contentPane.add(playlistCreation_name);
		playlistCreation_name.setColumns(10);

		btnCreatePlaylist = new JButton("Create Playlist");
		btnCreatePlaylist.addActionListener(this);
		btnCreatePlaylist.setBounds(310, 82, 118, 23);
		contentPane.add(btnCreatePlaylist);

		btnDeletePlaylist = new JButton("Delete Playlist");
		btnDeletePlaylist.addActionListener(this);
		btnDeletePlaylist.setBounds(310, 107, 118, 23);
		contentPane.add(btnDeletePlaylist);

		lblSongName = new JLabel("Song Name");
		lblSongName.setBounds(268, 161, 92, 14);
		contentPane.add(lblSongName);

		lblSongArtist = new JLabel("Song Artist");
		lblSongArtist.setBounds(268, 186, 92, 14);
		contentPane.add(lblSongArtist);

		lblPlaylistName = new JLabel("Playlist Name");
		lblPlaylistName.setBounds(268, 211, 92, 14);
		contentPane.add(lblPlaylistName);

		lblPlaylistIndex = new JLabel("Playlist Index");
		lblPlaylistIndex.setBounds(268, 236, 105, 14);
		contentPane.add(lblPlaylistIndex);

		addToPlaylist_songName = new JTextField();
		addToPlaylist_songName.setBounds(383, 158, 86, 20);
		contentPane.add(addToPlaylist_songName);
		addToPlaylist_songName.setColumns(10);

		addToPlaylist_songArtist = new JTextField();
		addToPlaylist_songArtist.setBounds(383, 183, 86, 20);
		contentPane.add(addToPlaylist_songArtist);
		addToPlaylist_songArtist.setColumns(10);

		addToPlaylist_listName = new JTextField();
		addToPlaylist_listName.setBounds(383, 208, 86, 20);
		contentPane.add(addToPlaylist_listName);
		addToPlaylist_listName.setColumns(10);

		btnAddSongTo = new JButton("Add Song to Playlist");
		btnAddSongTo.addActionListener(this);

		addToPlaylist_listIndex = new JTextField();
		addToPlaylist_listIndex.setBounds(383, 233, 86, 20);
		contentPane.add(addToPlaylist_listIndex);
		addToPlaylist_listIndex.setColumns(10);
		btnAddSongTo.setBounds(282, 263, 180, 23);
		contentPane.add(btnAddSongTo);

		btnDeleteSongFrom = new JButton("Delete Song from Playlist");
		btnDeleteSongFrom.addActionListener(this);
		btnDeleteSongFrom.setBounds(282, 288, 180, 23);
		contentPane.add(btnDeleteSongFrom);

		btnAvaliablePlaylists = new JButton("Avaliable Playlists");
		btnAvaliablePlaylists.addActionListener(this);  
		btnAvaliablePlaylists.setBounds(288, 313, 168, 23);
		contentPane.add(btnAvaliablePlaylists);
		playlistPane.setBounds(177, 394, 170, 52);
		contentPane.add(playlistPane);
		playlistPane.setLayout(null);

		lblPlaylist = new JLabel("Playlist:");
		lblPlaylist.setBounds(53, 0, 56, 22);
		playlistPane.add(lblPlaylist);




		lblPlaylistNameDisplay = new JLabel(currentPlaylist.getName());
		lblPlaylistNameDisplay.setBounds(53, 15, 56, 22);
		playlistPane.add(lblPlaylistNameDisplay);
		
		lblNumsongs = new JLabel("Num of songs in playlist: "+currentPlaylist.getNumSongs());
		lblNumsongs.setBounds(10, 33, 150, 14);
		playlistPane.add(lblNumsongs);


		JButton btnPreviousPlaylist = new JButton("Previous Playlist");
		btnPreviousPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( playlistIndex > 0) //only go to previous playlist if it exists
					playlistIndex --;
				currentPlaylist.setCurrentNode (currentPlaylist.getListHead()); //goes back to the first song of the playlist


				updateGUI ();

			}
		});
		btnPreviousPlaylist.setBounds(21, 405, 133, 27);
		contentPane.add(btnPreviousPlaylist);

		JButton btnNextPlaylist = new JButton("Next Playlist");
		btnNextPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (playlistIndex < Main.avaliablePlaylists.size()-1) //only go to next playlist if it exists
					playlistIndex ++;

				currentPlaylist.setCurrentNode (currentPlaylist.getListHead());
				System.out.println(playlistIndex);

				System.out.println(Main.avaliablePlaylists.get(playlistIndex).currentNode().getSong().getTitle());
				updateGUI ();
			}
		});
		btnNextPlaylist.setBounds(369, 405, 133, 27);
		contentPane.add(btnNextPlaylist);

		JPanel panel = new JPanel();
		panel.setBounds(177, 478, 170, 52);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNowPlaying = new JLabel("Now Playing:");
		lblNowPlaying.setBounds(50, 5, 86, 14);
		panel.add(lblNowPlaying);

		lblSong = new JLabel(currentNode.getSong().getTitle());
		lblSong.setBounds(10, 25, 62, 14);
		panel.add(lblSong);
		
		lblByArtist = new JLabel("by: " + currentNode.getSong().getArtist());
		lblByArtist.setBounds(82, 25, 98, 14);
		panel.add(lblByArtist);

		JButton btnPreviousSong = new JButton("Previous Song");
		btnPreviousSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentPlaylist.currentNode() != currentPlaylist.getListHead ())
					currentPlaylist.setCurrentNode (currentNode.getPrevious());
				updateGUI ();
			}
		});
		btnPreviousSong.setBounds(21, 492, 133, 27);
		contentPane.add(btnPreviousSong);

		JButton btnNextSong = new JButton("Next Song");
		btnNextSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (currentPlaylist.currentNode() != currentPlaylist.getLastNode ())

					currentPlaylist.setCurrentNode (currentNode.getNext());
				updateGUI ();
			}
		});
		btnNextSong.setBounds(369, 494, 133, 27);
		contentPane.add(btnNextSong);

		btnGoToLast = new JButton("Go to last song");
		btnGoToLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPlaylist.setCurrentNode (currentPlaylist.getLastNode());

				updateGUI ();
			}
		});
		btnGoToLast.setBounds(201, 576, 118, 23);
		contentPane.add(btnGoToLast);

		JButton btnShuffle = new JButton("Shuffle");
		btnShuffle.setToolTipText("Go to random song in this playlist");
		btnShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random r = new Random ();
				int randInt = r.nextInt(currentPlaylist.getNumSongs());
				currentPlaylist.setCurrentNode (currentPlaylist.getListHead());
				for (int i = 0 ; i < randInt ; i ++)
				{
					currentPlaylist.setCurrentNode (currentPlaylist.currentNode().getNext()) ; //goes to the node at the random index
				}

				updateGUI ();
			}
		});
		btnShuffle.setBounds(201, 610, 118, 23);
		contentPane.add(btnShuffle);
		
		lblSongInfo = new JLabel("Album: "+ currentNode.getSong().getAlbum() + "  Genre: " + currentNode.getSong().getGenre() + "  Year: " + currentNode.getSong().getYear() + "  Star rating: " + currentNode.getSong ().getStars());
		lblSongInfo.setBounds(65, 541, 415, 14);
		contentPane.add(lblSongInfo);

	}


	public void updateGUI ()
	{	
		
		currentPlaylist = Main.avaliablePlaylists.get(playlistIndex); //updates the current playlist and node
		currentNode = currentPlaylist.currentNode();

		lblPlaylistNameDisplay.setText(currentPlaylist.getName()); //gets the name of the playlist
		lblSong.setText(currentNode.getSong().getTitle());//gets the name of the current song at the current node
		
		
		lblSongInfo .setText("Album: "+ currentNode.getSong().getAlbum() + "  Genre: " + currentNode.getSong().getGenre() +
				"  Year: " + currentNode.getSong().getYear() + "  Star rating: " + currentNode.getSong ().getStars()); //updates the song info
		lblNumsongs.setText("Num of songs in playlist: "+currentPlaylist.getNumSongs()); 
		lblByArtist.setText("by: " + currentNode.getSong().getArtist());
		
	}

	JFrame makeSongListJpopWin ()
	{

		JFrame frame = new JFrame();
		frame.setContentPane(new SongList() );
		//Display the window.

		frame.setBounds(100, 100,300,210);

		frame.setVisible(true);         
		return frame;
	}

	JFrame makePlayListJpopWin ()
	{

		JFrame frame = new JFrame();
		frame.setContentPane(new PlaylistDisplay() );
		//Display the window.

		frame.setBounds(100, 100,430,300);

		frame.setVisible(true);         
		return frame;
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource () == btnSongList)               
		{

			makeSongListJpopWin ();

		}

		if (e.getSource () == btnDeleteSong)
		{
			Main.deleteSong (SongCreation_Name.getText(),SongCreation_Artist.getText() );
			SongCreation_Name.setText("");
			SongCreation_Artist.setText("");
		}

		if (e.getSource () == btnAvaliablePlaylists)
		{
			makePlayListJpopWin ();
		}

		if (e.getSource() == btnCreateSong)
		{
			String songName = SongCreation_Name.getText() ;
			String artist = SongCreation_Artist.getText() ;
			String album = SongCreation_Album.getText() ;
			String year = SongCreation_Year_Released.getText() ;
			String genre = SongCreation_Genre.getText() ;
			String sRating = SongCreation_sRating.getText ();

			if (songName.equals("")||artist.equals("") ||album.equals("")|| year.equals("") || genre.equals("") || sRating.equals (""))
			{
				JOptionPane.showMessageDialog(frame,
						"Please fill out the appropriate information before proceeding."  ,
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else
			{

				int sRatingInt =  Integer.parseInt (sRating);
				Main.createSong (songName,artist,album,year, genre,sRatingInt);


				JOptionPane.showMessageDialog(frame,							
						"Song " + songName + " by " + artist + " was added." );
			}

			SongCreation_Name.setText("") ;
			SongCreation_Artist.setText("") ;
			SongCreation_Album.setText("") ;
			SongCreation_Year_Released.setText("") ;
			SongCreation_Genre.setText("") ;
			SongCreation_sRating.setText ("");
		}



		if (e.getSource() == btnCreatePlaylist)
		{
			String playlistName = playlistCreation_name.getText (); 
			if(playlistName.equals (""))
			{
				JOptionPane.showMessageDialog(frame,
						"Please enter a playlist name."  ,
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				Main.createPlaylist (playlistName);

				JOptionPane.showMessageDialog(frame,							
						"Playlist " + playlistName + " was created." );
			}
			playlistCreation_name.setText("");
		}

		if (e.getSource() == btnAddSongTo)
		{//error check not avaliable
			String songName = addToPlaylist_songName.getText() ;
			String songArtist = addToPlaylist_songArtist.getText() ;
			String playlistName = addToPlaylist_listName.getText() ;
			String stringPlaylistIndex = addToPlaylist_listIndex.getText ();



			Playlist playlist = Main.findPlaylist(playlistName);
			if (playlist == null)
			{
				JOptionPane.showMessageDialog(frame,
						"Playlist does not exist"  ,
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if (stringPlaylistIndex.equals("")) 
				{	//no index was entered
					//add song to the end of playlist
					if(playlist.addSong(songName, songArtist)== false)
					{
						JOptionPane.showMessageDialog(frame,
								"Song does not exist"  ,
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else 
				{	//an index was given
					//add song to specific index of playlist
					int playListIndex =  Integer.parseInt (stringPlaylistIndex);
					playlist.addSong(playListIndex, songName, songArtist);
					System.out.println("song added to " + playListIndex);
				}
			}



		}       


		if (e.getSource() == btnDeleteSongFrom)
		{
			String songName = addToPlaylist_songName.getText() ;
			String songArtist = addToPlaylist_songArtist.getText() ;
			String playlistName = addToPlaylist_listName.getText() ;
			String playlistIndex = addToPlaylist_listIndex.getText ();


			Playlist playlist = Main.findPlaylist (playlistName);


			if (playlist == null)
			{
				JOptionPane.showMessageDialog(frame,
						"Playlist does not exist"  ,
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if (songName.equals("") && songArtist.equals (""))
				{
					int playListIndex =  Integer.parseInt (playlistIndex);
					playlist.deleteSong(playListIndex);


					System.out.println ("Song at " + playListIndex + " deleted");



				}

				else if (playlistIndex.equals (""))
				{
					//playlist.deleteSong (songName,songArtist);

					if(playlist.deleteSong (songName,songArtist) == true)
					{
						System.out.println ("song " + songName + " deleted");
					}
				}
			}



		}

		if (e.getSource() == btnDeletePlaylist)
		{
			Main.deletePlaylist (playlistCreation_name.getText());
		}



	}
}







