import java.io.*;
class NumberToWords{
	static String wordsValue(int number){
	int numCopy=number;
	int numLength=0;
	String numberInWords = "";
		if (numCopy==0) numLength=1;
		else{
			while (numCopy>0){
				numLength++;
				numCopy=numCopy/10;
			}
		}
	//System.out.println(" The length of the number is : "+numLength);
		while (numLength>0){
			switch (numLength){
				case 4: numberInWords = numberInWords + caseValue(number / 1000) + " Thousand "; 
						if (number%1000==0) numLength=0;
						number=number%1000;
						
						break;
				case 3: if(number > 99){
						numberInWords = numberInWords + caseValue(number / 100) + " Hundred ";
						if (number%100==0) numLength=0;
						number=number%100;
						if (number > 0) numberInWords = numberInWords + "and ";
						}
						break;
				case 2: if (number>10 && number<20) {
						numberInWords = numberInWords + caseValue(number);
						numLength=0;
						}
						else if(number > 9){
						numberInWords = numberInWords + caseValue(number - number%10);
						if (number%10==0) numLength=0;
						number=number%10;
						}
						break;
				case 1: numberInWords = numberInWords + caseValue(number);
						break;
				default: System.out.println(" The length of the number is : "+numLength);
						break;
			}				
			numLength--;
		}
		return numberInWords;
	}
	static String caseValue(int number){
		String numValue="";
		switch (number){
			case 0: numValue = "Zero"; break;
			case 1: numValue = "One"; break;
			case 2: numValue = "Two"; break;
			case 3: numValue = "Three"; break;
			case 4: numValue = "Four"; break;
			case 5: numValue = "Five"; break;
			case 6: numValue = "Six"; break;
			case 7: numValue = "Seven"; break;
			case 8: numValue = "Eight"; break;
			case 9: numValue = "Nine"; break;
			case 10: numValue = "Ten"; break;
			case 11: numValue = "Eleven"; break;
			case 12: numValue = "Twelve"; break;
			case 13: numValue = "Thirteen"; break;
			case 14: numValue = "Fourteen"; break;
			case 15: numValue = "Fifteen"; break;
			case 16: numValue = "Sixteen"; break;
			case 17: numValue = "Seventeen"; break;
			case 18: numValue = "Eighteen"; break;
			case 19: numValue = "Nineteen"; break;
			case 20: numValue = "Twenty "; break;
			case 30: numValue = "Thirty "; break;
			case 40: numValue = "Fourty "; break;
			case 50: numValue = "Fifty "; break;
			case 60: numValue = "Sixty "; break;
			case 70: numValue = "Seventy "; break;
			case 80: numValue = "Eighty "; break;
			case 90: numValue = "Ninety "; break;
			default: System.out.println(" Invalid entry"); break;
		}
		return numValue;
	}
	public static void main(String[] args) throws IOException{
		char carryon = (char)89;
		String lineReader="";
		int number;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		while(carryon=='Y' || carryon=='y'){
		System.out.print("\n Please enter the number you want to convert in words : ");
		number=Integer.parseInt(br.readLine());
		if (number<0 || number>10000) System.out.println(" Please enter a number between 0 and 10000 ");
		else{
		System.out.println(" The value of the number "+number+" in words is :- ");
		System.out.println(" "+wordsValue(number));
		}
		System.out.print("\n Do you want to carry on (y/n) : ");
		lineReader=br.readLine();
		carryon = lineReader.charAt(0);
		}
	}
}