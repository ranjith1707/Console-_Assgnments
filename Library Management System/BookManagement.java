package library;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
public class BookManagement {
	Scanner scanner=new Scanner(System.in);
	ArrayList<Books> list=new ArrayList<Books>();
	
	void storeBook() {
		DataBaseConnection data=new DataBaseConnection();
		try {
			 Statement statement=data.getData();
			  ResultSet result=statement.executeQuery("select * from books");
			  while(result.next()) {
				  Books book=new Books(result.getInt(2), result.getString(3),result.getString(4),result.getString(5),result.getInt(6));
				  list.add(book);
			  }
			System.out.println("   >  Welcome To Admin Portal  <  ");
			}
			catch(Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
			}
		
	}
void bookmanager() {
	System.out.println("---------------------------------------------");
	System.out.println(" 1 > Add new Books \n 2 > Remove Book\n 3 > List Out books\n 4 > Search Books ");
	int option=scanner.nextInt();
	switch(option) {
	case 1:addBooks();
		break;
	case 2:removeBook();
		break;
	case 3:bookList();
		break;
	case 4:searchBook();
		break;
	}
	
	bookmanager();
}
void addBooks() {
	 DataBaseConnection data=new DataBaseConnection();
	System.out.print("Enter Book Id No : ");
	int bookId=scanner.nextInt();
	scanner.nextLine();
  System.out.print("Enter Book Authour Name : ");
  String authorName=scanner.nextLine();
  System.out.print("Enter Book Title : ");
  String title=scanner.nextLine();
  System.out.print(" Enter Book publication :");
  String publication=scanner.nextLine();
  System.out.print("Enter Count Of Book : ");
  int count=scanner.nextInt();
try {
 Statement statement=data.getData();
  int insert=statement.executeUpdate("insert into books(bookId,publication,title,authourName,cout)values("+bookId+",'"+publication+"','"+title+"','"+authorName+"',"+count+")");
System.out.println("   >  Book Added  <  ");
}
catch(Exception e) {
System.out.println("Exception");
e.printStackTrace();
}
}

void bookList() {
	System.out.println("All Books > ");
	for(Books m:list) {
		System.out.println("Book Id : "+m.getBookId()+"  ; Title : "+m.getTitle()+ " ; Count : "+m.getCount());
	}
}
void removeBook() {
	DataBaseConnection data=new DataBaseConnection();
	System.out.print("Enter Book Id No : ");
	int bookId=scanner.nextInt();
	scanner.nextLine();
 
try {
 Statement statement=data.getData();
  int delete=statement.executeUpdate("delete from books where bookId="+bookId+"");
System.out.println("   > Deleted  <  ");
}
catch(Exception e) {
System.out.println("Exception");
e.printStackTrace();
}
}void searchBook(){
	System.out.println("    > Chooes For Searching  < \n 1 > Search By Publication\n 2 > Search by Title\n ");
    int option =scanner.nextInt();
    switch(option) {
    case 1:System.out.println("Enter Publication Name : ");
    	break;
    case 2:System.out.println("Enter Title Name : ");
    	break;	
    }
    scanner.nextLine();
     String key=scanner.nextLine();
	for(Books m:list) {
		if(key.equals(m.getPublication())) {
			System.out.println("Atuthor Name : "+m.getAuthorName()+ "  ; Title : "+m.getTitle()+"  Count : "+m.getCount());
		}
		if(key.equals(m.getTitle())) {
			System.out.println("Atuthor Name : "+m.getAuthorName()+ "  ; Title : "+m.getTitle()+"  Count : "+m.getCount());
		}
	   
	}
}


}
