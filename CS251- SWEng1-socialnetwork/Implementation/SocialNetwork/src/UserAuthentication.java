import java.awt.Image;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class UserAuthentication {

	private static User user;

    public Vector  myUser;

    public static User signUp(String username, String password, String profilePicture, Date birthdate, String phoneNumber, String email, String country, String gender) {
    	
    	user = new User(); // initialize
    	user.createUser(username, password, profilePicture, birthdate, phoneNumber, email, country , gender);
    	return user;
    }

    public static User logIn(String username, String password) {
    	User login = Database.getUser(username);
    	if (login != null && login.getPassword().equals(password)) 
    		return login;    		
    	return null;
    }

    public void logout() {
    }

    public void deactivate() {
    }

    public void validate() {
    }

}