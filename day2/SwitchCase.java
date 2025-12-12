package week1.day2;

public class SwitchCase {
	public static void main(String args[]) {
		String browser="firefox";
		switch (browser) {
		case "chrome":
			System.out.println("chrome opened successfully");
			break;
			
			
		case "firefox":
			System.out.println("firefox opened successfully");
			break;
			
		case "edge":
			System.out.println("edge opened successfully");
			break;
			
		default:
			System.out.println("ie launched successfully");
			break;
			
		}
	}

}
