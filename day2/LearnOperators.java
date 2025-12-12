package week1.day2;

public class LearnOperators {

	public static void main(String args[])
	{
		/*
		 * Arithmetic operators
		 */
		int a=15;
		int b=10;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a/b);
		System.out.println(a%b);
	
	/*
	 * Assignment operator
	 */
	a+=5;//15+5=20
	System.out.println(a);
	b-=2;//10-2=8
	System.out.println(b);
	b*=14;//8*14=140
	System.out.println(b);
	
	/* comparision operator
	 * =,>,<,<=,>=,==
	 */
	int c=50; int d=50;
	System.out.println(c==d);
	System.out.println(c>=d);
	System.out.println(c<=d);
	System.out.println(c<d);
	/*
	 * Logical operator
	 */
	System.out.println((c==d)&&(c>=d));//50==50   50>=50      1+1=2
	System.out.println((c<d)&&(c>d));//0+0=0
	System.out.println((c<d)&&(c>d)||(c==d));//0+1=1
	/*
	 * preincrement and predecrement operator
	 * preincrement,predecrement,postincrement,postdecrement
	 */
	System.out.println(d++);//50 post decrement value won't be increment after assigning to the variable then increments
	System.out.println(d);//51
	System.out.println(++d);//
}
}