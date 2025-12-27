package week3day2assignment;

public class TestClass {
	
	public static void main(String[] args) {

        // Superclass object
        BasePage basePage = new BasePage();
        basePage.findElement();
        basePage.clickElement();
        basePage.enterText("Base Text");
        basePage.performCommonTasks();

        System.out.println("--------------------");

        // Subclass object
        LoginPage loginPage = new LoginPage();
        loginPage.findElement();
        loginPage.clickElement();
        loginPage.enterText("Username");
        loginPage.performCommonTasks(); // Overridden method
    }

}
