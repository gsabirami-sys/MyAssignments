package week3day1assignment;

public class OddIndextoUpperCase {
	
	public static void main(String[] args) {
		String test="changeme";
		//convert the given String to chararray
		char[] charArray = test.toCharArray();
		
		
		for(int i=charArray.length-1; i>=0; i--)
			//
		{
			//check an odd index
			if(i%2!=0)
			{
				charArray[i]=Character.toUpperCase(charArray[i]);
				//Inside the loop, change the character to uppercase only if the index is odd 
			}
		}
		//print the characters with the expected output: cHaNgEmE 
		String result=new String(charArray);
		System.out.println(result);
	}

}
