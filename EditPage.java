import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditPage extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextField songName;
	private JTextField songArtist;
	private JTextField albumTitle;
	private JTextField yearReleased;
	private JTextField songGenre;
	private JTextField starRating;
	private JButton btnEdit;

	
	private int songIndex = SongList.getSongIndex();
	private Song songObj = Main.songList.get(songIndex);
	
	public EditPage() {
		
		setBounds(200, 100, 230, 280);	
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Name");
		label.setBounds(10, 44, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Artist");
		label_1.setBounds(10, 69, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Title of Album");
		label_2.setBounds(10, 94, 86, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Year Released");
		label_3.setBounds(10, 119, 86, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Genre");
		label_4.setBounds(10, 144, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Star Rating");
		label_5.setBounds(10, 169, 86, 14);
		contentPane.add(label_5);
		
		songName = new JTextField();
		songName.setText (songObj.getTitle());
		songName.setColumns(10);
		songName.setBounds(117, 41, 86, 20);
		contentPane.add(songName);
		
		songArtist = new JTextField();
		songArtist.setText (songObj.getArtist());
		songArtist.setColumns(10);
		songArtist.setBounds(117, 66, 86, 20);
		contentPane.add(songArtist);
		
		albumTitle = new JTextField();
		albumTitle.setText (songObj.getAlbum());
		albumTitle.setColumns(10);
		albumTitle.setBounds(117, 91, 86, 20);
		contentPane.add(albumTitle);
		
		yearReleased = new JTextField();
		yearReleased.setText (songObj.getYear());
		yearReleased.setColumns(10);
		yearReleased.setBounds(117, 116, 86, 20);
		contentPane.add(yearReleased);
		
		songGenre = new JTextField();
		songGenre.setText (songObj.getGenre());
		songGenre.setColumns(10);
		songGenre.setBounds(117, 141, 86, 20);
		contentPane.add(songGenre);
		
		starRating = new JTextField();
		starRating.setText (Integer.toString(songObj.getStars()));
		starRating.setColumns(10);
		starRating.setBounds(117, 166, 86, 20);
		contentPane.add(starRating);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(65, 194, 89, 23);
		btnEdit.addActionListener(this);
		contentPane.add(btnEdit);
	}

	
	public void actionPerformed(ActionEvent e)  {
		if(e.getSource () == btnEdit)		
		{
			
			
			songObj.setTitle(songName.getText());
			songObj.setArtist(songArtist.getText());
			songObj.setYear(yearReleased.getText());
			songObj.setGenre(songGenre.getText());
			songObj.setAlbum(albumTitle.getText());
			songObj.setStars(Integer.parseInt(starRating.getText()));
			
		
			this.dispose(); //close this JFrame
			SongList.updateSongList(); //updates the JList
				
			
		}
		
	}


	
}
