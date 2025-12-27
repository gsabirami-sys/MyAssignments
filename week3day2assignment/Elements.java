package week3day2assignment;

public class Elements {
	public static void main(String args[]) {
	//Button object
	Button button = new Button();
	button.submit();
	button.click();
	button.setText("abi");
	System.out.println("-------");
	//Textfield object
	
	Textfield txt=new Textfield();
	txt.getText();
	txt.click();
	txt.setText("Testing");
	 // CheckBoxButton object
    CheckBox checkBox = new CheckBox();
    checkBox.click();
    checkBox.submit();
    checkBox.setText("hi dad");
    checkBox.clickCheckButton();
    
    System.out.println("----------------");
    //Radio button object
    RadioButton rad=new RadioButton();
    rad.click();
    rad.submit();
    rad.setText("Hi dad");
    rad.selectRadioButton();

}
}