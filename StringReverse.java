import java.io.*;
class StringReverse{
	
	public static String reverseString(String inputString){
		int head,tail;
		for(head=0,tail=inputString.length()-1;head<tail;head++,tail--){
			char temp = inputString.charAt(head);
			//inputString.charAt(head)=inputString.charAt(tail);
			//inputString.charAt(tail)=temp;
			// you can't do this with a string
		}
		return inputString;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n Please enter the string you want to reverse : ");
		String inputString = bufferRead.readLine();
		System.out.println("\n You have entered: "+inputString);
		char[] charArray = inputString.toCharArray();
		System.out.println("\n You have entered: "+charArray);
		inputString = reverseString(inputString);
		System.out.println("\n Reverse of the string is "+inputString);
		
	}
}