import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;




public class UserInterface {
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");  
	
    public int check() {
    	return 0;
    }
    public boolean signUP(UserControl uc , String username, String password, String profilePicture, Date birthdate, String phoneNumber, String email, String country, String gender) {
    	return uc.signup(username, password, profilePicture, birthdate, phoneNumber, email, country, gender);
    }
    public boolean login(UserControl uc , String username, String password) {
    	return uc.Login(username, password);
    }
    public boolean addFriend(UserControl uc, String user) {
    	return uc.addFriend(uc.searchUser(user));
    }

    public boolean acceptFriend(UserControl uc, String user) {
    	return uc.acceptFriendRequest(user);
    }
    public void makeAd(UserControl uc) {
    	
    }
	public static void main(String[] args) throws ParseException, IOException {
		
		String out1 = "1- Register \n2- Login \n3- Exit";
		
		//////////////////////////////////////////////////////////////
		UserControl uc1 = new UserControl();
		UserControl uc2 = new UserControl();
	    Date date = formatter.parse("15/12/1999");
		boolean registered = uc1.signup("Khaled", "123456", "fruit", date, "012760166539" , "khaled@email.com", "egypt" , "male");
		boolean registered2 = uc2.signup("Hussien", "123456", "fruit", date, "012760166539" , "hussien@email.com", "egypt" , "male");
		if (registered == true && registered2 == true) {
			System.out.println("Signed up");
		}
		else {
			System.out.println("Sign up failed");
		}
		
		//////////////////////////////////////////////////////////////
		boolean loggedIn = uc2.Login("Hussien" , "123456");
		if (loggedIn == true) {
			System.out.println("Logged in");
		}
		else {
			System.out.println("Account doesn't exist!");
		}
		//////////////////////////////////////////////////////////////
		uc1.Login("Khaled", "123456");
		uc2.addFriend(uc2.searchUser("Khaled"));
		uc1.acceptFriendRequest("Hussien");
		System.out.println("_______________________________");
		System.out.println(uc1.getUser().getUsername());
		uc1.getNotification();
		System.out.print("Friends: ");
		for (int i=0 ; i<uc1.getUser().getFriends().size() ; i++) {
			System.out.print(uc1.getUser().getFriends().get(i).getUsername() + "   ");
		}
		System.out.println("\n_______________________________");
		System.out.println(uc2.getUser().getUsername());
		uc2.getNotification();
		System.out.print("Friends: ");
		for (int i=0 ; i<uc2.getUser().getFriends().size() ; i++) {
			System.out.print(uc2.getUser().getFriends().get(i).getUsername() + "   ");
		}
		/////////////////////////////////////////////////////////////
		System.out.println("\n_______________________________");
		System.out.println(uc1.getUser().getUsername());
		uc1.modifyUserType("khaled 1111", "CreditCard");
		System.out.println(uc1.getUser().isPremium());
		uc1.makeAd();
		/////////////////////////////////////////////////////////////
		System.out.println("_______________________________");
		System.out.println(uc2.getUser().getUsername());
		uc2.makeAd();
		/////////////////////////////////////////////////////////////
		System.out.println("_______________________________");
		UserControl uc3 = new UserControl();
		uc3.Login("Hatem", "11551");
		uc3.getNotification();
	}
}
