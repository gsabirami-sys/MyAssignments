package week1.day2;
public class Browser {
	
	//Method with one input argument
			public void launchBrowser(String browserName)
			{
				System.out.println("Edge");
			}
			//Method that returns a string
			public String loadUrl()
			{
				return "URL Loaded successfully";
			}

			public static void main(String args[])
			{
				Browser obj1=new Browser();
				obj1.launchBrowser("browser lauched successfully");
				String s1=obj1.loadUrl();
				System.out.println(s1);
			}

}
