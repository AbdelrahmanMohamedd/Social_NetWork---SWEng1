import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class UserControl {

	private User user;

    public Vector  myUser;
    public Vector  myGroupControl;
    public Vector  myPageControl;
    public Vector  myPostControl;
    public Vector  myHashtagControl;

    public boolean signup(String username, String password, String profilePicture, Date birthdate, String phoneNumber, String email, String country, String gender) {
    	user = null;
    	if (Database.getUser(username) !=null  || Database.getUser(email) != null)
    		return false;
    	user = UserAuthentication.signUp(username, password, profilePicture, birthdate, phoneNumber, email, country, gender);
    	if (user != null){
    		Database.storeUser(this);
    		return true;
    	}
    	else 
    		return false;
    }
    
    public boolean Login(String username, String password)  {
    	user = UserAuthentication.logIn(username, password);
		if (user == null)
    		return false;
    	return true;
    }
    
    public boolean addFriend(User toAdd) {
    	if (!isLoggedin() || toAdd == null)
    		return false;
    	toAdd.sendRequset(user);
    	return true;
  	}

  	public boolean modifyUserType(String credential, String service) {
  		if (!isLoggedin()) 
  			return false;
  		
  		boolean upgraded = false;
  		if (user.isPremium()) {
  			System.out.println("Account is already premium");
  			return true;
  		} else {
  			if (service.equals("PayPal")) {
  				upgraded = WithdrawAPI.PayPal(credential, 99);
  			} else if (service.equals("CreditCard")) {
  				upgraded = WithdrawAPI.CreditCard(credential, 99);
  			} else {
  				System.out.println("Only pay through PayPal or CreditCard");
  			}
  		}
  		if (upgraded) {
  			user.upgrade();
  		}
  		return upgraded;
  	}

  	private boolean isLoggedin() {
  		if (user == null) {
  			System.out.println("Login First");
  			return false;
  		}
		return true;
	}

	public User searchUser(String username){
		if (!isLoggedin()) 
  			return null;
  		return Database.getUser(username);
  	}

  	public boolean acceptFriendRequest(String username){
  		if (!isLoggedin()) 
  			return false;
  		User found = this.searchUser(username);
  		return user.acceptRequest(found);
  	}

  	public User getUser() {
  		return user;
  	}

	public void getNotification() {
		if (!isLoggedin()) 
  			return;
		ArrayList<String> not = user.getNotifications();
		for (int i=0 ; i<not.size() ; i++)
			System.out.println(not.get(i));
	}

	public void makeAd() {
		if (!isLoggedin()) 
  			return;
		if (user.isPremium()) {
			user = new PremiumUser(user);
			((PremiumUser)user).createAd();
			System.out.println("Ad is created!");
		}
		else {
			System.out.println("Your account must be premium");
		}
	}
	
	public void modifyUserInfo() {
		
	}
}