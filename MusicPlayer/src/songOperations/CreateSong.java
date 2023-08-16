package songOperations;

import java.util.ArrayList;

public class CreateSong {
	ArrayList<Song> availableSongs=new ArrayList<>();
	
	public ArrayList<Song> createAlbum()
	{
		availableSongs.add(new Song("S1"));
		availableSongs.add(new Song("S2"));
		availableSongs.add(new Song("S3"));
		availableSongs.add(new Song("S4"));
		availableSongs.add(new Song("S5"));
		availableSongs.add(new Song("S6"));
		availableSongs.add(new Song("S7"));
		availableSongs.add(new Song("S8"));
		availableSongs.add(new Song("S9"));
		availableSongs.add(new Song("S10"));
		return availableSongs;
	}
}
