class TryCatchFinally{
  static void division(int x, int y){
    try{
    int num= x/y;
    System.out.println("next-statement: Inside try block");
    System.out.println("The answer is "+num);
    }
    catch(Exception ex){
    System.out.println("Exception Occurred");
    }
    finally{
      System.out.println("next-statement: Outside of try-catch");
    }
  }
  public static void main(String args[]){
    division(10, 0);
    division(10, 2);
  }
}
