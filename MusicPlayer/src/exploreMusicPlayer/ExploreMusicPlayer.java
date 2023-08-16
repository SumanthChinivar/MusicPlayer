package exploreMusicPlayer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import org.testng.annotations.Test;

import songOperations.CreateSong;
import songOperations.Song;
import userOperations.User;

public class ExploreMusicPlayer {

	@Test
	public void exploreMusicPlayer(){
		LinkedHashMap<Stack<Song>,User> musicPlayer=new LinkedHashMap<>();
		boolean i=true;
		while(i) {
		System.out.println("This music player is case sensitive");
		System.out.println("Please select the choice using numbers");
		System.out.println("1.Add a user");
		System.out.println("2.Play a song or view recent songs");
		System.out.println("3.Exit");
		System.out.println("Enter your choice");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the name of the user");
			String userName=sc.next();
			musicPlayer=addUser(musicPlayer,userName);
			break;
		case 2:
			boolean j=true;
			
			while(j) {
				System.out.println("The available users are");
				Collection<User> users = musicPlayer.values();
				System.out.println(users);
				System.out.println("Select a user");
				if(musicPlayer.values().size()==0) {
				System.out.println("If user is zero the system will create a user enter U1");
				}
				String user=sc.next();
			if(containsUser(musicPlayer,user)) {
			System.out.println("The options available are:");
			System.out.println("1.Play a song");
			System.out.println("2.View recently played songs");
			System.out.println("3.Exit");
			int selection=sc.nextInt();
			switch(selection) {
			case 1:
				musicPlayer=playSong(musicPlayer, sc, user);
				break;
			case 2:
				recentSongs(musicPlayer, sc, user);
				break;
			case 3:
				j=false;
			default:
			System.out.println("Enter a correct choice");	
			break;
			}
			}
			else {
				if(musicPlayer.values().size()==0) {
					addDefaultUser(musicPlayer);
				}
				else
				System.out.println("Enter a valid user");
			}
			}
			break;
		case 3:
			i=false;
		default:
			System.out.println("Enter a correct choice");
			break;
		}
		}
	}
	
	public LinkedHashMap<Stack<Song>, User> addUser(LinkedHashMap<Stack<Song>,User> musicPlayer, String userName){
		User newUser=new User(userName);
		if(!musicPlayer.containsValue(newUser)) {
		musicPlayer.put(new Stack(), newUser);
		System.out.println("User added successfully");
		}else
			System.out.println("User already exists");
		
		return musicPlayer;
	}
	

	public LinkedHashMap<Stack<Song>,User> playSong(LinkedHashMap<Stack<Song>,User> musicPlayer,Scanner sc,String user) {
		
		System.out.println("The available songs are:");
		CreateSong cs=new CreateSong();
		ArrayList allSongs=cs.createAlbum();
		System.out.println(allSongs);
		System.out.println("Enter a song to play");
		String selectedSong=sc.next();
		boolean flag=conatinsSong(allSongs,selectedSong);
		boolean values=containsUser(musicPlayer,user);
		if(flag) {
			for(Map.Entry<Stack<Song>, User> mp:musicPlayer.entrySet()) {
				boolean flag1=containsSong(mp.getKey(), selectedSong);
				if(mp.getValue().getName().equals(user)) {
				if(mp.getKey().size()<=2) {
					if(!flag1) {
					mp.getKey().add(new Song(selectedSong));
					
					}
				}
				else if(mp.getKey().size()>=3) {
					mp.getKey().remove(0);
					mp.getKey().add(new Song(selectedSong));
				}
			}
		}
	 }
		else
			System.out.println("Enter a correct song");
		return musicPlayer;
	}
	
	public boolean conatinsSong(ArrayList allSongs,String song) {
		for(Object o:allSongs) {
			Song s=(Song)o;
			if(song.equals(s.getTitle())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsSong(Stack allSongs,String song) {
		for(Object o:allSongs) {
			Song s=(Song)o;
			if(song.equals(s.getTitle())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsUser(LinkedHashMap<Stack<Song>,User> musicPlayer,String user) {
		Collection<User> allUsers = musicPlayer.values();
		for(Object o:allUsers) {
			User username=(User)o;
			if(username.getName().equals(user)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsUser(Collection<User> allUser) {
		for(Object o:allUser) {
			User username=(User)o;
			if(username.getName().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	public void recentSongs(LinkedHashMap<Stack<Song>, User> musicPlayer,Scanner sc,String user) {
		System.out.println("The recently played songs are:");
		for(Map.Entry<Stack<Song>, User> mp:musicPlayer.entrySet()) {
			if(mp.getValue().getName().equals(user)) {
				System.out.println(mp.getKey());
				break;
			}
		}
	}
	
	public boolean checkUserCount(LinkedHashMap<Stack<Song>,User> musicPlayer) {
	if(musicPlayer.values().size()==0) {
		return false;
	}
	return true;
	}
	
	public LinkedHashMap<Stack<Song>,User> addDefaultUser(LinkedHashMap<Stack<Song>,User> musicPlayer){
		if(!checkUserCount(musicPlayer)) {
			addUser(musicPlayer, "U1");
		}
		return musicPlayer;
	}
}
