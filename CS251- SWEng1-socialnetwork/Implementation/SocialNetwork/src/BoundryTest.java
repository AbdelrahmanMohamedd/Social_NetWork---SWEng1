import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoundryTest {
	
	
	@Test
	public void signUPTest() throws ParseException {
	  	UserControl uc1 = new UserControl();
		UserControl uc2 = new UserControl();
		UserControl uc3 = new UserControl();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	    Date date = formatter.parse("15/12/1999");
	    UserInterface b = new UserInterface();
		Assert.assertEquals(b.signUP(uc1,"Khaled", "123456", "landscape.bmp", date, "012760166539" , "khaled@email.com", "egypt" , "male"),true);
		Assert.assertEquals(b.signUP(uc2,"Khaled", "1234", "date.bmp", date, "01016192209" , "khaled12@email.com", "egypt" , "male"),false);
		Assert.assertEquals(b.signUP(uc3,"hatem", "123", "cat.bmp", date, "01113289755" , "khaled@email.com", "egypt" , "male"),false);
		Database.clear();

	}

    @Test
    public void addFriendTest() throws ParseException {
  		UserControl uc1 = new UserControl();
  		UserControl uc2 = new UserControl();
  		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
  	    Date date = formatter.parse("15/12/1999");
  	    UserInterface b = new UserInterface();
  		uc1.signup("Khaled", "123456", "landscape.bmp", date, "012760166539" , "khaled@email.com", "egypt" , "male");
  		uc2.signup("Hussien", "1234", "date.bmp", date, "01016192209" , "khaled12@email.com", "egypt" , "male");
  		uc1.Login("Khaled", "123456");
  		uc2.Login("Hussien", "1234");
  		Assert.assertEquals(b.addFriend(uc1, "Hussien"), true);
  		Assert.assertEquals(b.addFriend(uc1, "Hatem"), false); //not in the database
  		Database.clear();
  		 
     }
  
  
	@Test
    public void acceptFriendTest() throws ParseException {

		UserControl uc1 = new UserControl();
		UserControl uc2 = new UserControl();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	    Date date = formatter.parse("15/12/1999");
	    UserInterface b = new UserInterface();
		uc1.signup("Khaled", "123456", "landscape.bmp", date, "012760166539" , "khaled@email.com", "egypt" , "male");
		uc2.signup("Hussien", "1234", "date.bmp", date, "01016192209" , "khaled12@email.com", "egypt" , "male");
		uc1.Login("Khaled", "123456");
		uc2.Login("Hussien", "1234");
		uc1.addFriend(uc1.searchUser("Hussien"));
		Assert.assertEquals(b.acceptFriend(uc2, "Khaled"), true);
		Assert.assertEquals(b.acceptFriend(uc2, "Khaled"), false); //request doesn't exist
		Assert.assertEquals(b.acceptFriend(uc2, "Hatem"), false); //request doesn't exist

		Database.clear();

	}
}
