import java.io.*;
import java.util.*;
class Link
{
public String linkvalue;
public String id; 
public String subject;
public String marks;  
public Link next; // next link in list
// -------------------------------------------------------------
public Link(String id, String subject, String marks, String linkvalue) // constructor
{
this.id = id;
this.subject = subject;
this.marks = marks;
this.linkvalue = linkvalue;
} 
// -------------------------------------------------------------
public void displayLink() // display ourself
{
System.out.println("" + linkvalue );
}
} // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
private Link first; // ref to first link on list
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
public void insertFirst(String id, String subject, String marks, String linkvalue)
{ // make new link
Link newLink = new Link( id,  subject,  marks, linkvalue);
newLink.next = first; // newLink --> old first
first = newLink; // first --> newLink
}
public void displayList()
{
System.out.println("List (first-->last): ");
Link current = first; // start at beginning of list
while(current != null) // until end of list,
{
current.displayLink(); // print data
current = current.next; // move to next link
}
System.out.println("");
}

public void displayAveragemorethan50subjects()
{
ArrayList<String> subjects=new ArrayList<String>();
boolean found = false;
int marks=0;
int subjectcount=0;
int individualsubjectcount=0;
int morethan50averagecount=0;
//System.out.println("List (first-->last): ");
Link current = first; // start at beginning of list
while(current != null) // until end of list,
{
//current.displayLink(); // print data
	for (String element : subjects) // or sArray
    {
        if(element.equals(current.subject)){
			found=true;
			break;
		}
    }
		if (!found) {
		subjects.add(current.subject);
		//System.out.println(" Subject added : "+current.subject);
		subjectcount++;
		found=false;
		}
current = current.next; // move to next link

}
//System.out.println(""+subjectcount);

for(String element : subjects){
	current = first;
	while(current != null) // until end of list,
	{
	//current.displayLink(); // print data
	if(element.equals(current.subject)){
	marks = marks + Integer.parseInt(current.marks);
	individualsubjectcount++;
	}
	current = current.next; // move to next link
	} // end of inner while
	if (individualsubjectcount>0){
	if ((marks/individualsubjectcount)>50) {
	morethan50averagecount++;
	System.out.println(""+element);
	}
	}
	marks=0;
	individualsubjectcount=0;
} //end of outer for

System.out.println(""+morethan50averagecount);
}//end of method

// -------------------------------------------------------------
} // end class LinkList
////////////////////////////////////////////////////////////////
class AverageFinderApp
{
public static void main(String[] args) throws IOException
{
 String linkvalue="";
 String id=""; 
 String subject="";
 String marks="";
 
LinkList theList = new LinkList(); // make new list
	File file = new File("newinput.txt");
    if (!file.exists()) {
      System.out.println("File does not exist.");
      return;
    }
    if (!(file.isFile() && file.canRead())) {
      System.out.println(file.getName() + " cannot be read from.");
      return;
    }
    try {
      FileInputStream fis = new FileInputStream("newinput.txt");
      DataInputStream in = new DataInputStream(fis);
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  String strLine;
	  String[] temp;
	  //char delimiter='|';
	  while ((strLine = br.readLine()) != null)   {
		temp=strLine.split("\\|");
		id = temp[0];
		subject = temp[1];
		marks = temp[2];
		//System.out.println (temp.length);
		/*for(int i=0;i<temp.length;i++){
			//System.out.print (" " + temp[i]);
		}*/
		//System.out.println ();
		theList.insertFirst( id,  subject,  marks,  strLine);
		//System.out.println (" Inserted values are : " + id + "  " + subject + " " + marks + " " + strLine);
		}
	}
     catch (IOException e) {
      e.printStackTrace();
    }
	//theList.displayList();
	theList.displayAveragemorethan50subjects();
} // end main()
} // end class AverageFinderApp
////////////////////////////////////////////////////////////////
