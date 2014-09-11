import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListSelectionModel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class SongList extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JList<String> Songlist; 
	private JButton SongInfoBtn;
	private JScrollPane SongScrollPane;

	public static int songNameIndex;



	public SongList() {


		setLayout(new BorderLayout());		

		Songlist = new JList<String>(toModel(Main.toSongNames(Main.songList))); //change to default list 
		SongInfoBtn = new JButton("Song Info");
		SongScrollPane = new JScrollPane(Songlist);

		DefaultListSelectionModel m = new DefaultListSelectionModel();
		m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		m.setLeadAnchorNotificationEnabled(false);

		Songlist.setSelectionModel(m);

		Songlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				songNameIndex = Songlist.getMaxSelectionIndex(); //gets the index of the selected song

			}
		});
		SongInfoBtn.addActionListener(this);
		
		JPanel topPanel = new JPanel ();
		topPanel.add(SongScrollPane);
		//topPanel.add(topMidPanel);
		topPanel.setLayout(new FlowLayout ());
		//topPanel.add(PlaylistScrollPane);
		
		
		add(SongScrollPane, BorderLayout.NORTH);
		add(SongInfoBtn, BorderLayout.SOUTH);

	}

	//Returns the songs title
	public static int getSongIndex ()
	{
		return songNameIndex;
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
	public static void updateSongList ()
	{
		Songlist.setModel(toModel (Main.toSongNames(Main.songList)));
		System.out.println(Main.toSongNames(Main.songList));


	}

	public void actionPerformed(ActionEvent e)  {
		// TODO Auto-generated method stub

		if(e.getSource () == SongInfoBtn)		
		{

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {


					makeEditSongWindow ();
				}
			});

		}

	}	

	public static void makeEditSongWindow ()
	{
		EditPage frame = new EditPage ();	
		frame.setVisible(true);		


	}


}
