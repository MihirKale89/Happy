import java.io.*;
import java.util.*;
class PrimeNumbersRange{
  // Printing all prime numbers from 1 until the given max number

  void displayPrimeNumbers(int max){
    ArrayList<Integer> arrli = new ArrayList<Integer>(max);
    int num = 1;
    int index = 1;
    while (num <= max){
      arrli.add(num++);
    }
    num = 2;
    while (index != arrli.size() -1){
      boolean firstloop = true;
      for(int loopindex = num; loopindex <= arrli.get(arrli.size()-1); loopindex+=num){
        if (firstloop) {
          firstloop = false;
        }
        else{
          arrli.remove(new Integer(loopindex));
        }
      }
      num = arrli.get(index++);
    }
    System.out.println(arrli);
  }
  public static void main(String args[]){
    PrimeNumbersRange pnr = new PrimeNumbersRange();
    pnr.displayPrimeNumbers(100);
  }
}
