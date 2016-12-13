import java.io.*;
class StringMultiplier{
	static String stringProduct(String args[]){
		String strProd=args[0];
			for(int counter=1;counter<args.length;counter++){
				strProd = stringProd(strProd, args[counter]);
			}
		return strProd;
	}
	static String stringProd(String num1, String num2){
		String[] arr = new String[num2.length()];
		String strSum;
		int digit=0;
		int carry=0;
		int digsum=0;
		int shift=0; 
		
			for(int outercnt=arr.length-1; outercnt>=0; outercnt--){
				arr[outercnt]="";
				for(int shiftcopy=shift;shiftcopy>0;shiftcopy--){
					arr[outercnt]=0+arr[outercnt];
				}
				digit=0;
				carry=0;
				digsum=0;
				for(int innercnt=num1.length()-1; innercnt>=0; innercnt--){
					digsum=Character.getNumericValue(num2.charAt(outercnt))*
					Character.getNumericValue(num1.charAt(innercnt))+carry;
					digit=digsum%10;
					carry=digsum/10;
					arr[outercnt]=digit+arr[outercnt];
				}
				arr[outercnt]=carry+arr[outercnt];
				//System.out.println(" Iteration value "+arr[outercnt]);
				shift++;
			}
		strSum = stringSum(arr);
		return strSum;
	}	
	static String stringSum(String arr[]){
	String strSum=""; 
	int digit=0;
	int carry=0;
	int digsum=0;
	int shiftdifference=0;	
		for(int counter=1; counter < arr.length; counter++){
			shiftdifference = arr[0].length() - arr[counter].length();
			for(int shiftcounter=0; shiftcounter<shiftdifference; shiftcounter ++){
				arr[counter]=0+arr[counter];
			}
			//System.out.println(" Iteration value "+arr[counter]);
		}
		for(int sumcounter=arr[0].length()-1;sumcounter>=0;sumcounter--){
			digsum=carry;
			digit=0;
			carry=0;			
			for(int inner=arr.length-1; inner>=0; inner--){
				digsum=digsum+Character.getNumericValue(arr[inner].charAt(sumcounter));
			}
			digit=digsum%10;
			carry=digsum/10;
			strSum=digit+strSum;
		}
		strSum=carry+strSum;
		strSum=strSum.replaceFirst("^0+(?!$)", ""); // regex that deletes the leading zeroes
	return strSum;
	}
	public static void main(String args[])throws IOException{
		try{
		String[] numArr={"123","234","23"};
		System.out.println(" The product of 123,234,23 is "+stringProduct(numArr));
		int numberofterms=0;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);		
		System.out.print("\n Please enter the number of values you want to have a product of : ");
		numberofterms=Integer.parseInt(br.readLine());
		String[] prodArr=new String[numberofterms];
		for (int counter=0;counter<numberofterms; counter++){
			System.out.print("\n Please enter the value "+(counter+1)+" : ");
			prodArr[counter]=br.readLine();
		}
		System.out.println("\n The product of the entered values is : "+stringProduct(prodArr));
		}
		catch (NumberFormatException nfe){
			System.out.print("\n Please enter a valid numerical input ");
		}
	}
}