package userOperations;

public class User {
	String name;

	public User(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public boolean equals(Object o) {
		User u = (User) o;
		if (this.name.equals(u.name)) {
			return true;
		} else
			return false;
	}
	
	public String getName() {
		return name;
	}
}
