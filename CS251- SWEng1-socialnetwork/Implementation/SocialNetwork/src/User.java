import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;



public class User {
	private String username;
	
	private String password;
	
	private String profilepicture;
	
	private ArrayList<User> friendlist;
    
	private ArrayList<User> requests;
	
	private Date birthdate;
		
	private String phoneNumber;
	
	private String email;

	private String country;
  	
	private String gender;
	
	private boolean isPremium;
	
	private ArrayList<String> notifications;
	
	public User() {
		
	}
	
  	public User(User user) {
  		this.username = user.username;
		this.password = user.password;
		this.profilepicture = user.profilepicture;
		this.birthdate = user.birthdate;
		this.phoneNumber = user.phoneNumber;
		this.email = user.email;
		this.country = user.country;
		this.gender = user.gender;
		this.isPremium = user.isPremium;
		requests = new ArrayList<User>();
		friendlist = new ArrayList<User>();
		notifications = new ArrayList<String>();
  	}

  	public void modifyUserInfo() {
  	}

  	public void newOperation() {
  	}

  	public void createUser(String username, String password, String profilePicture, Date birthdate, String phoneNumber, String email, String country, String gender) {
  		this.username = username;
		this.password = password;
		this.profilepicture = profilePicture;
		this.birthdate = birthdate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.country = country;
		this.gender = gender;
		this.isPremium = false;
		requests = new ArrayList<User>();
		friendlist = new ArrayList<User>();
		notifications = new ArrayList<String>();
  	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getProfilePicture() {
		return profilepicture;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getCountry() {
		return country;
	}
	public String getGender() {
		return gender;
	}
	public boolean isPremium() {
		return isPremium;
	}

	public void sendRequset(User user) {
		requests.add(user);	
		notifications.add(user.username + " sent a friend request");
	}
	
	public boolean acceptRequest(User user) {
		int index = requests.indexOf(user);
		if (index == -1)
			return false;
		requests.remove(index);
		user.friendlist.add(this);
		user.notifications.add(this.username + " accepted your friend request");
		friendlist.add(user);
		return true;
	}

	public ArrayList<User> getFriends() {
		return friendlist;
	}

	public ArrayList<String> getNotifications() {
		return notifications;
	}

	public void upgrade() {
		isPremium = true;
	}
}