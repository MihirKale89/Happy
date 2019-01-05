import java.io.*;
class PasswordCheckOkta{
  // Whether a password is valid with several conditions: at a vowels,
  // not triple consecutive vowels or consonants,
  // and no double consecutive letters except for "ee" and "oo"

  void validPassword(String str){
    boolean tripleConsecutiveCheck = true;
    // System.out.println(" Checking string length "+str.length());
    for(int index = 0; index < str.length()-2; index++){
      // System.out.println("Validating character "+str.charAt(index));
      if (str.charAt(index) == str.charAt(index+1) && str.charAt(index+1) == str.charAt(index+2)) {
        tripleConsecutiveCheck = false;
      }
    }
    boolean doubleConsecutiveCheck = true;
    for(int index = 0; index < str.length()-1; index++){
      if (str.charAt(index) == str.charAt(index+1) && str.charAt(index) != 'e' && str.charAt(index) != 'o') {
        doubleConsecutiveCheck = false;
      }
    }
    if (tripleConsecutiveCheck && doubleConsecutiveCheck) {
      System.out.println("The password "+str+" is valid.");
    }
    else{
      System.out.println("The password "+str+" is not valid.");
    }
  }
  public static void main(String args[]){
    System.out.println(" Checking a few passwords :");
    PasswordCheckOkta pco = new PasswordCheckOkta();
    pco.validPassword("MihirKale");
    pco.validPassword("MihirKaleee");
  }
}
