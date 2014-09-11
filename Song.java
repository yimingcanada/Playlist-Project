public class Song
{
        //Stores the value for the information on the song.
    private String title;
    private String artist;
    private String year;
    private String nameOfAlbum;
    private int numStars;
    private String genre;
       

    //The constructor
    public Song (String title,String artist, String year, String nameOfAlbum, String genre, int numStars)
    {
      this.title = title;
      this.artist = artist;
      this.year = year;
      this.nameOfAlbum = nameOfAlbum;
      this.numStars = numStars;
      this.genre = genre;
      
    }

    //Returns the songs title
    public String getTitle ()
    {
        return title;
    }

    //Returns the songs artist
    public String getArtist ()
    {
        return artist;
    }
    
    public String getAlbum ()
    {
        return nameOfAlbum;
    }
    
    public int getStars ()
    {
        return numStars;
    }
    

    //Returns the songs year
    public String getYear ()
    {
        return year;
    }
    
        public String getGenre ()
    {
        return genre;
    }
    
        public void setTitle (String s)
        {
             title = s;
        }

        //Returns the songs artist
        public void setArtist (String s)
        {
             artist = s;
        }
        
        public void setAlbum (String s)
        {
             nameOfAlbum = s;
        }
        
        public void setStars (int i)
        {
             numStars = i ;
        }
        

        public void setYear (String i )
        {
           year = i;
        }
        
            public void setGenre (String s)
        {
            genre = s;
        }
    
}

