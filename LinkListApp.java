// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////
class Link
{
	public int iData; // data item (key)
	public double dData; // data item
	public Link next; // next link in list
// -------------------------------------------------------------
	public Link(int id, double dd) // constructor
	{
		iData = id; // initialize data
		dData = dd; // (next is automatically set to null)
	} //
// -------------------------------------------------------------
	public void displayLink() // display ourself
	{
		System.out.print("{" + iData + ", " + dData + "} ");
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
	public void insertFirst(int id, double dd)
	{ // make new link
		Link newLink = new Link(id, dd);
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}
// -------------------------------------------------------------
	public Link deleteFirst() // delete first item
	{ // (assumes list not empty)
		Link temp = first; // save reference to link
		first = first.next; // delete it: first-->old next
		return temp; // return deleted link
	}
// -------------------------------------------------------------
	public LinkList uniqueList() // finding only unique elements provided the Linked List is sorted
	{ // (assumes list not empty)
		if (first == null) return new LinkList()
		if (first.next == null) return this;
		Link temp1 = first; // save reference to link
		Link temp2 = temp1.next; // save reference to link
		if (temp1.iData == temp2.iData && temp2.next == null) return new LinkList()
		if (temp1.iData != temp2.iData && temp2.next == null) return this;
		Link temp3 = temp2.next; // save reference to link
		t1_to_be_deleted = false;
		t2_to_be_deleted = false;
		t3_to_be_deleted = false;
		first_set = false;
		while(temp3 != null || temp2 != null || temp1 != null)
		{
			if (temp3.iData != temp2.iData && temp2.iData != temp1.iData) {
				if (t1_to_be_deleted && temp1 == first) {
					first = first.next
					 
				}
				if () {

				}
				temp1 = temp1.next;
				temp2 = temp2.next;
				temp3 = temp3.next;
			}
			if (temp1.iData != temp2.iData && temp2.iData == temp3.iData) {
				temp1.next = temp3;
				delete temp2;
				t1_to_be_deleted = true;
				temp2 = temp3;
				if (temp2 != null) temp3 = temp3.next;
			}
			if (temp1.iData == temp2.iData && temp2.iData != temp3.iData) {
				temp1.next = temp3;
				delete temp2;
				t1_to_be_deleted = true;
				temp2 = temp3;
				if (temp3 != null) temp3 = temp3.next;
			}
		}
		return this; // return LinkList with only unique elements
	}
// -------------------------------------------------------------

	public void displayList()
	{
		System.out.print("List (first-->last): ");
		Link current = first; // start at beginning of list
			while(current != null) // until end of list,
			{
				current.displayLink(); // print data
				current = current.next; // move to next link
			}
		System.out.println("");
	}
// -------------------------------------------------------------
} // end of class LinkList

class LinkListApp
{
	public static void main(String[] args)
	{
		LinkList theList = new LinkList(); // make new list
		theList.insertFirst(22, 2.99); // insert four items
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		theList.displayList(); // display list
			while( !theList.isEmpty() ) // until its empty,
			{
				Link aLink = theList.deleteFirst(); // delete link
				System.out.print("Deleted "); // display it
				aLink.displayLink();
				System.out.println("");
			}
		theList.displayList(); // display list
		LinkList sortedList = new LinkList(); // make new list
		sortedList.insertFirst(3, 3.00); // insert five items
		sortedList.insertFirst(2, 2.00);
		sortedList.insertFirst(1, 1.00);
		sortedList.insertFirst(1, 1.00);
		sortedList.insertFirst(1, 1.00);
		sortedList.displayList(); // display list
	} // end main()
} // end class LinkListApp
