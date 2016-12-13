// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////
class Link
{
public int categoryvalue;
public Link sister;
public Link daughter;
// -------------------------------------------------------------
public Link(int categoryvalue) // constructor
{
this.categoryvalue = categoryvalue;
//System.out.println("New Link created");
} 
// -------------------------------------------------------------
public void displayLink() // display ourself
{
System.out.print(" " + categoryvalue );
}
} // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
private Link first; // ref to first link on list
// -------------------------------------------------------------
public LinkList() // constructor
{
first = null; // no items on list yet
}
// -------------------------------------------------------------
public boolean isEmpty() // true if list is empty
{
return (first==null);
}
// -------------------------------------------------------------
// insert at start of list
public void insertFirst(int categoryvalue)
{ // make new link
Link newLink = new Link(categoryvalue);
if (newLink.categoryvalue < 0){
newLink.sister = first; // newLink --> old first
first = newLink; // first --> newLink
System.out.println("New sister created");
}
else{
newLink.daughter = first; // newLink --> old first
first = newLink; // first --> newLink
System.out.println("New daughter created");
}
}
// -------------------------------------------------------------

public void displayList()
{
System.out.print("List (first-->last): ");
Link current = first; // start at beginning of list
while(current != null) // until end of list,
{
current.displayLink(); // print data
current = current.daughter; // move to next link
//while (current.sister != null) current = current.sister; 
}
System.out.println("");
}
// -------------------------------------------------------------
} // end class LinkList
////////////////////////////////////////////////////////////////
class BreadCrumbTrail
{
public static void main(String[] args)
{
LinkList theList = new LinkList(); // make new list
theList.insertFirst(-1); 
theList.insertFirst(2);
theList.insertFirst(3);
theList.insertFirst(4);
theList.insertFirst(-2); 
theList.insertFirst(5);
theList.insertFirst(6);
theList.insertFirst(7);
theList.insertFirst(-3); 
theList.insertFirst(8);
theList.insertFirst(9);
theList.insertFirst(10);

theList.displayList(); // display list

//theList.displayList(); // display list
} // end main()
} // end class BreadCrumbTrail
////////////////////////////////////////////////////////////////
