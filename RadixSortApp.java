// linkList.java
// demonstrates linked list
// to run this program: C>java RadixSortApp // Code in work on Line 87
////////////////////////////////////////////////////////////////
class Link
{
	public int iData; // data item (key)
	public Link next; // next link in list
// -------------------------------------------------------------
	public Link(int id) // constructor
	{	
		iData = id; // initialize data
		// (‘next’ is automatically set to null)
	} // 
// -------------------------------------------------------------
	public void displayLink() // display ourself
	{
		System.out.print("{" + iData + "} ");
	}
} // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
	public Link first; // ref to first link on list
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
	public void insertFirst(int id)
	{ // make new link
		Link newLink = new Link(id);
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}
// insert at end of list
	public void insertLast(int id)
	{ // make new link
		Link newLink = new Link(id);
		Link current = first; 
		if (first == null) first = newLink;
		else{
			while(current.next != null) current = current.next;
			current.next = newLink;	
		}
	}
// -------------------------------------------------------------
	public Link deleteFirst() // delete first item
	{ // (assumes list not empty)
		Link temp = first; // save reference to link
		first = first.next; // delete it: first-->old next
		return temp; // return deleted link
	}
	
	public void displayList()
	{
		System.out.print("List (first-->last): ");
		Link current = first; // start at beginning of list
			while(current != null) // until end of list,
			{
				current.displayLink(); // print data
				current = current.next; // move to next link
			}
		
	}
// -------------------------------------------------------------
} // end of class LinkList

class RadixSortApp
{
	public static LinkList theList = new LinkList(); // make new list
	public static LinkList[] list = new LinkList[10];
	static void  radixsort(LinkList masterlist, int numdigits)
	{
		// int index;
		for(int i=0; i<10; i++){
			list[i] = new LinkList();
		}
		for(int i=1; i<=numdigits; i++){
			distribute(masterlist, i);
			coalesce(masterlist);
		}
	}
	
	static void distribute(LinkList masterlist, int i)
	{
		System.out.println("\n In distribute now");
		int j, divisor;
		divisor=10;
		for(int temp=1;temp<i;temp++) divisor=divisor*divisor;
		for(j=0;j<=9;j++){
			list[j].first=null;	
		}
		Link current = masterlist.first;
		while (current!= null){
			j= (current.iData % divisor);
			list[j].insertLast(current.iData);
			current = current.next;
		}
	}
	
	static void coalesce(LinkList masterlist)
	{
		System.out.println("In coalesce now");
		int j;
		masterlist.first=null;
		Link current;
		for(j=0;j<=9;j++){
			current=list[j].first; 
			if (current!=null){ 
				masterlist.insertLast(current.iData);
				while(current.next!=null) masterlist.insertLast(current.iData);
			}
		}
		masterlist.displayList();
	}
	public static void main(String[] args)
	{
		
		theList.insertLast(239); // insert ten items
		theList.insertLast(234);
		theList.insertLast(878);
		theList.insertLast(879);
		theList.insertLast(123);
		theList.insertLast(358);
		theList.insertLast(416);
		theList.insertLast(317);
		theList.insertLast(137);
		theList.insertLast(225);
		theList.displayList(); // display list
		radixsort(theList, 3);
		theList.displayList();
	} // end main()
} // end class RadixSortApp
