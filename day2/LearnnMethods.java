package week1.day2;

public class LearnnMethods {
	//create a method
	/*
	 * public we can use anywhere(across classes,across package,across project or any project 
	 * private we can use only inside the class (we can't use across package or project)
	 * Default we can't declare public or private it is automatically taken as default
	 * default:we use inside the classes across the classes but unable to use across the package
	 */
	void addNumbers(int a,int b)
	{
		//void method returns nothing
		//no need to print return statement
		System.out.println("The output is " +(a+b));//return nothing so systout statement is mandatory
	}
        //quantity need to buy
	int noofBicycle(int quantity)
	{
		return quantity;
	}
	String bicycleDate(String color,String brand,String modelno)
	{
		return color+""+brand+""+modelno;
		
	}
	public static void main(String args[])
	{
		LearnnMethods lm1=new LearnnMethods();
		lm1.addNumbers(12,12);
		lm1.noofBicycle(2);
		int num=lm1.noofBicycle(2);//if we declare the variable then only we can use anywhere
		System.out.println(num);
			System.out.println("red"+" "+"honda"+" "+1235);
	}
}
