import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	ArrayList<Book> books = new ArrayList<>();
	ArrayList<User> users = new ArrayList<>();
	Person manager = new Person("Admin", 35, "Thran", "admin", "1234");
	static Scanner input = new Scanner(System.in);
	public Main() {
		loginMenu();
	}
	public static void main(String[] args) {
		new Main();
	}
	public void loginMenu() {
		System.out.println("Login Menu --------------------");
		String userName;
		String password;
		int x=0;
		do {
			System.out.println("1.Login Admin");
			System.out.println("2.Login User");
			System.out.println("3.Exit");
			x = input.nextInt();
		}while(x>3 || x<1);
		switch(x) {
		case 1:
			System.out.println("Login Admin --------------------");
			System.out.print("User Name : ");
			  userName = input.next();
			System.out.print("Password : ");
			  password = input.next();
			if(userName.compareTo(manager.getUserName())==0 && password.compareTo(manager.getPassword())==0)
			managerMenu();
			else {
			System.out.println("Wrong username or password");
			loginMenu();
			}
			break;
		case 2:
			System.out.println("Login User --------------------");
			int index=-1;
			System.out.print("User Name : ");
			 userName = input.next();
			System.out.print("Password : ");
			 password = input.next();
			for(int i=0;i<users.size() ; i++) {
					if(userName.compareTo(users.get(i).getUserName())==0 
							&& password.compareTo(users.get(i).getPassword())==0) {
						index = i;
						break;
				}
			}
			if(index == -1 ) {
				System.out.println("User not found.");
				loginMenu();
			}else
				userMenu(index);
		
			break;
		case 3:
			System.exit(0);
			break;
		}
	}
	public void managerMenu() {
		System.out.println("Menu Manager --------------------");
		int x=0;
		do {
			System.out.println("1.Add user");
			System.out.println("2.Remove user");
			System.out.println("3.List User");
			System.out.println("4.Add book");
			System.out.println("5.Remove book");
			System.out.println("6.Card renewal");
			System.out.println("7.List book");
			System.out.println("8.List amanat book");
			System.out.println("9.List didn't amanat book");
			System.out.println("10.Change Username and Password");
			System.out.println("11.Back");
			x = input.nextInt();
		}while(x>11 || x<1);
		switch(x) {
		case 1:
			add_user();
			break;
		case 2:
			remove_user();
			break;
		case 3:
			list_users();
			break;
		case 4:
			add_Book();
			break;
		case 5:
			remove_Book();
			break;
		case 6:
			card_renewal();
			break;
		case 7:
			list_book();
			break;
		case 8:
			list_amanat_book();
			break;
		case 9:
			list_not_amaat_book();
			break;
		case 10:
			managerChange();
			break;
		case 11:
			loginMenu();
			break;
		}
	}
	public void userMenu(int index){
		System.out.println("Menu User --------------------");
		int x=0;
		do {
			System.out.println("1.Amanat book");
			System.out.println("2.Return book");
			System.out.println("3.List My Books");
			System.out.println("4.List Book");
			System.out.println("5.Sreach with Name book ");
			System.out.println("6.Sreach with Name Writer");
			System.out.println("7.Sreach with Name publishers");
			System.out.println("8.Change Username and Password");
			System.out.println("9.Back");
			x = input.nextInt();
		}while(x>9 || x<1);
		switch(x) {
		case 1:
			amanat_book(index);
			break;
		case 2:
			return_book(index);
			break;
		case 3:
			System.out.println("List My book --------------------");
			for (int i = 0; i < users.get(index).books.size(); i++) {
				System.out.println(users.get(index).books.get(i).toString());
			}
			userMenu(index);
			break;
		case 4:
			System.out.println("List book --------------------");
			for (int i = 0; i < books.size(); i++) {
				System.out.println(books.get(i).toString());
			}
			userMenu(index);
			break;
		case 5:
			search_Name_book(index);
			break;
		case 6:
			search_Name_Writer(index);
			break;
		case 7:
			search_Name_Publisher(index);
			break;
		case 8:
			userChange(index);
			break;
		case 9:
			loginMenu();
			break;
		}
	}
	public void add_user() {
		System.out.println("Add User --------------------");
		System.out.print("Name : ");
		String name = input.next();
		System.out.print("Age : ");
		int age = input.nextInt();
		input.nextLine();
		System.out.print("Address : ");
		String address = input.nextLine();
		System.out.print("UserName : ");
		String Username = input.next();
		System.out.print("Password : ");
		String password = input.next();
		users.add(new User(name, age, address,Username, password));
				System.out.println("User or Success added.");
				managerMenu();
	}
	public void remove_user() {
		System.out.println("Remove User --------------------");
		System.out.print("Enter Id user for remove (Enter 0 for Back): ");
		int Id = input.nextInt();
		if(Id == 0)
			managerMenu();
		boolean b = false;
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getId() == Id) {
				users.remove(i);
				b = true;
				break;
		}}
			if(b == true) {
				System.out.println("User remove successfully");
				managerMenu();
			}else {
				System.out.println("User not found.");
				remove_user();
			}}
	public void list_users() {
		System.out.println("List Users --------------------");
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
		managerMenu();
	}
	public void add_Book() {
		System.out.println("Add Book --------------------");
		System.out.print("Title : ");
		String title = input.next();
		System.out.print("Writer : ");
		String writer = input.next();
		System.out.print("Publishers : ");
		String publishers = input.next();
		System.out.print("Number pages : ");
		int number_pages = input.nextInt();
		books.add(new Book(title, writer, publishers, number_pages));
		System.out.println("Book was added successfully.");
		managerMenu();
	}
	public void remove_Book() {
		System.out.println("Remove book --------------------");
		System.out.print("Enter Code book for remove (Enter 0 for Back): ");
		int code = input.nextInt();
		if(code == 0)
			managerMenu();
		boolean b = false;
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getCode() == code) {
				if(books.get(i).isOn_amanat()) {
					System.out.println("The book is on amanat");
					remove_Book();
				}
				books.remove(i);
				b = true;
				break;
		}}
			if(b == true) {
				System.out.println("book removed successfully");
				managerMenu();
			}else {
				System.out.println("book not found.");
				remove_Book();
			}
	}
	public void card_renewal() {
		System.out.println("Card Renewal --------------------");
		System.out.print("Enter Id User for Card Renewal (Enter 0 for Back): ");
		int id = input.nextInt();
		if(id == 0)
			managerMenu();
		boolean b = false;
		for (int i = 0; i < books.size(); i++) {
			if(users.get(i).getId()  == id) {
				users.get(i).card_renewal();
				b = true;
				break;
		}}
			if(b == true) {
				System.out.println("Card Renewal successfully");
				managerMenu();
			}else {
				System.out.println("User not found.");
				card_renewal();
			}
	}
	public void list_book() {
		System.out.println("List book --------------------");
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i).toString());
		}
		managerMenu();
	}
	public void list_amanat_book() {
		System.out.println("List amanat book --------------------");
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).isOn_amanat())
			System.out.println(books.get(i).toString());
		}
		managerMenu();
	}
	public void list_not_amaat_book() {
		System.out.println("List amanat book --------------------");
		for (int i = 0; i < books.size(); i++) {
			if(!books.get(i).isOn_amanat())
			System.out.println(books.get(i).toString());
		}
		managerMenu();
	}
	public void managerChange() {
		System.out.println("Manager Change Username and Password --------------------");
		System.out.print("User Name : ");
		String userName = input.next();
		System.out.print("Password : ");
		String password = input.next();
		if(userName.compareTo(manager.getUserName())==0 && password.compareTo(manager.getPassword())==0){
		System.out.print("new UserName : ");
		manager.setUserName(input.next());
		System.out.print("new Password : ");
		manager.setPassword(input.next());
		System.out.println("Username and Password successfully Changed.");
		managerMenu();
		}else {
		System.out.println("Wrong username or password");
		loginMenu();
		}
	}
	public void return_book(int index) {
		System.out.println("Return book --------------------");
		System.out.print("Enter Code book for return (Enter 0 for Back): ");
		int code = input.nextInt();
		if(code == 0)
			managerMenu();
		boolean b = false;
		for (int i = 0; i < users.get(index).books.size(); i++) {
			if(users.get(index).books.get(i).getCode() == code) {
					books.get(i).setOn_amanat(false);
					users.get(index).books.remove(i);
				b = true;
				break;
				
		}}
			if(b == true) {
				System.out.println("book returned successfully");
				userMenu(index);
			}else {
				System.out.println("book not found.");
				return_book(index);
			}
	}
	public void amanat_book(int index) {
		System.out.println("Amanat book --------------------");
		System.out.print("Enter Code book for Amanat (Enter 0 for Back): ");
		int code = input.nextInt();
		if(code == 0)
			managerMenu();
		boolean b = false;
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getCode() == code) {
				if(books.get(i).isOn_amanat()) {
					System.out.println("The book is on amanat");
					amanat_book(index);
				}else {
					books.get(i).setOn_amanat(true);
					users.get(index).add_Book(books.get(i));
				b = true;
				break;
				}
		}}
			if(b == true) {
				System.out.println("book amanated successfully");
				userMenu(index);
			}else {
				System.out.println("book not found.");
				amanat_book(index);
			}
	}
	public void search_Name_book(int index) {
		input.nextLine();
		System.out.println("Sreach with Name book  --------------------");
		System.out.print("Enter Name book for Sreach (Enter \"back\" for Back): ");
		String name = input.nextLine();
		if(name.compareTo("back")==0)
			userMenu(index);
		boolean b = false;
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().compareTo(name)==0) {
				System.out.println(books.get(i).toString());	
				b = true;
		}}
			if(b == true) {
				userMenu(index);
			}else {
				System.out.println("book not found.");
				search_Name_book(index);
			}
	}
	public void search_Name_Writer(int index) {
		input.nextLine();
		System.out.println("Sreach with Name Writer  --------------------");
		System.out.print("Enter Name Writer for Sreach (Enter \"back\" for Back): ");
		String name = input.nextLine();
		if(name.compareTo("back")==0)
			userMenu(index);
		boolean b = false;
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getWriter().compareTo(name)==0) {
				System.out.println(books.get(i).toString());	
				b = true;
		}}
			if(b == true) {
				userMenu(index);
			}else {
				System.out.println("book not found.");
				search_Name_Writer(index);
			}
	}
	public void search_Name_Publisher(int index) {
		input.nextLine();
		System.out.println("Sreach with Name publisher  --------------------");
		System.out.print("Enter Name publisher for Sreach (Enter \"back\" for Back): ");
		String name = input.nextLine();
		if(name.compareTo("back")==0)
			userMenu(index);
		boolean b = false;
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getPublishers().compareTo(name)==0) {
				System.out.println(books.get(i).toString());	
				b = true;
		}}
			if(b == true) {
				userMenu(index);
			}else {
				System.out.println("book not found.");
				search_Name_Publisher(index);
			}
	}
	public void userChange(int index) {
		System.out.println("User Change Username and Password --------------------");
		System.out.print("User Name : ");
		String userName = input.next();
		System.out.print("Password : ");
		String password = input.next();
		if(users.get(index).getUserName().compareTo(userName)==0 && users.get(index).getPassword().compareTo(password)==0){	
		System.out.print("new UserName : ");
		users.get(index).setUserName(input.next());
		System.out.print("new Password : ");
		users.get(index).setPassword(input.next());
		System.out.println("Username and Password successfully Changed.");
		userMenu(index);
		}else {
		System.out.println("Wrong username or password");
		userChange(index);
		}
	}
}
	
	
	
	
	

	
	