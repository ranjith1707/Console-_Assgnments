package library;

public class Books {
	
  private int bookId;
  private String authorName;
  private String title;
  private String publication;
  private int count;
  public Books(int bookId,String publication,String title,String authour,int count){
	  this.setBookId(bookId);
	  this.setAuthorName(authour);
	  this.setTitle(title);
	  this.setPublication(publication);
	  this.setCount(count);
  }
public String getPublication() {
	return publication;
}
public void setPublication(String publication) {
	this.publication = publication;
}
public String getAuthorName() {
	return authorName;
}
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
}
