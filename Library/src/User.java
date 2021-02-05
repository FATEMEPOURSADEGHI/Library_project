import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class User extends Person{
	ArrayList<Book> books ;
	int Id;
	int credit_card_day;
	Date registartion_date;
	public User(String name, int age, String address, String userName, String password) {
		super(name, age, address, userName, password);
		 books = new ArrayList<>();
		 setId();
		 registartion_date = new Date();
		this.credit_card_day = 365;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public int getId() {
		return Id;
	}
	public void setId() {
		Random rand =  new  Random();
		Id = rand.nextInt(1000000);
	}
	public int getCredit_card_day() {
		return credit_card_day;
	}
	public void card_renewal() {
		this.credit_card_day = 365;
	}
	public Date getRegistartion_date() {
		return registartion_date;
	}
	public void add_Book(Book b) {
		books.add(b);
	}
	public void remove_Book(Book b) {
		books.remove(b);
	}
	public String toString() {
		return "Name:"+getName()+"\tAge:"+getAge()+"\tAddress:"+getAddress()+"\tId:"+getId()+"\tCredit_card_day:"
					+getCredit_card_day()+"\tRegistartion_date:"+getRegistartion_date();
	}
}
