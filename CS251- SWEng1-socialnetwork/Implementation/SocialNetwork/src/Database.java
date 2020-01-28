import java.util.ArrayList;


public class Database {
    private static ArrayList<UserControl> users = new ArrayList<UserControl>(); 
	

	public static void storeUser(UserControl user)  {
		users.add(user);
	}
	
	public static ArrayList<UserControl> loadUsers(){
		return users;	
	}
	
	public static User getUser(String search) {
		for (int i=0 ; i<users.size(); i++)
			if (users.get(i).getUser().getUsername().equals(search)) {
				return users.get(i).getUser();
			} else if (users.get(i).getUser().getEmail().equals(search)) {
				return users.get(i).getUser();
			}
		return null;
	}
	public static void backup() {
		
	}
	public static void clear () {
		users.clear();
	}
}
