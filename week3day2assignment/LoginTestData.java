package week3day2assignment;

public class LoginTestData extends TestData {
	
	 public void enterUsername() {
	        System.out.println("Entering Username");
	    }

	    public void enterPassword() {
	        System.out.println("Entering Password");
	    }
	    
	    public static void main(String[] args) {
	    	
	    	LoginTestData obj1=new LoginTestData();
	    	obj1.enterCredentials();
	    	obj1.navigateToHomePage();
	    	obj1.enterUsername();
	    	obj1.enterPassword();
	    

}
}
