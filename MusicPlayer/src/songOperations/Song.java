package songOperations;

public class Song {
	String title;

	public Song(String title){
	this.title=title;
	}
	
	public String toString()
	{
		return title;
	}
	
	public boolean equals(Object o) {
		Song s=(Song)o;
		if(this.title.equals(s.title)) {
			return true;
		}
		else
			return false;
	}
	
	public String getTitle() {
		return title;
	}

}
