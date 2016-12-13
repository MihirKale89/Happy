
class Parent{
	void display(){
		System.out.println(" This is a parent method");
	}
}
class Child extends Parent{
	void display(){
		System.out.println(" This is a child method");
	}
	public static void main(String args[]){
		Parent parent1 = new Child();
		parent1.display();
		Parent parent2 = new Parent();
		parent2.display();
		Child child1 = new Child();
		child1.display();
		//Child child2 = new Parent();
		//child2.display();
	}
}