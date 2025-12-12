package week1.day2;

public class LearnIf {
	public static void main(String args[])
	{
	/*int b=32;
	 if(b>=51)
	 {
		 System.out.println("pass");
	 }

	 if(b>=35)
	 {
		 System.out.println("pass");
		 
	 }
	 else
	 {
		 System.out.println("fail");
	 }*/
		int marks=299;
		if (marks==450) {
			System.out.println("Distinction");
			
		}
		else if(marks>450)
		{
			System.out.print("Average");
		}
		else if(marks>=300)
		{
			System.out.println("Below average");
		}
		else {
			System.out.println("out of range");
		}
}
}