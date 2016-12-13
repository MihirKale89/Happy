import java.io.*;
class Parent{
static final int x=100;
}
class Child extends Parent{
	public static void main(String args[]){
		System.out.println(" Final value :"+x);
	}
}