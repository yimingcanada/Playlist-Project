import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListSelectionModel;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class PlaylistDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JList<String> playlistList;
	
	public static int playlistIndex;
	private JList<String> list;



	public PlaylistDisplay() {
	
		

		DefaultListSelectionModel m = new DefaultListSelectionModel();
		m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		m.setLeadAnchorNotificationEnabled(false);

	
		setLayout(null);
		

		playlistList = new JList<String>(toModel(Main.toPlaylistNames(Main.avaliablePlaylists))); //takes the names of all the playlists and converts them into defaultListModel for the JList to use
		playlistList.setBounds(0, 2, 170, 235);
		add(playlistList);

		playlistList.setSelectionModel(m);
		
		playlistList.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent me) //if clicked, send the index on the jList to the setTextOfLabel methods for them to update
			{
				int indexClicked = list.locationToIndex(me.getPoint());
				
			}
		});

		list = new JList<String>(toModel (Main.avaliablePlaylists.get(playlistIndex).listSongs()));
		list.setBounds(215, 2, 205, 235);
		add(list);

		playlistList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				playlistIndex = playlistList.getMaxSelectionIndex(); //gets the index of the selected playlist
				updateSongList ();
				
			}
		});

		updatePlaylistList ();
	}

	public void updateSongList ()
	{
		list.setModel(toModel (Main.avaliablePlaylists.get(playlistIndex).listSongs()));
	}

	public static DefaultListModel<String> toModel (ArrayList <String> s)
	{
		DefaultListModel<String> model = new DefaultListModel<String> ();

		for (int i = 0 ; i < s.size() ; i ++)
		{
			model.addElement(s.get(i));
		}

		return model;


	}
	public static void updatePlaylistList ()
	{
		playlistList.setModel(toModel (Main.toPlaylistNames(Main.avaliablePlaylists)));

	}

	   
}

