import java.util.Random;

public class Book {
	private String title;
	private String writer;
	private String publishers;
	private int number_pages;
	private int code;
	private boolean on_amanat;
	public Book(String title, String writer, String publishers, int number_pages ) {
		this.title = title;
		this.writer = writer;
		this.publishers = publishers;
		this.number_pages = number_pages;
		this.on_amanat = false;
		setCode();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublishers() {
		return publishers;
	}
	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}
	public int getNumber_pages() {
		return number_pages;
	}
	public void setNumber_pages(int number_pages) {
		this.number_pages = number_pages;
	}
	public boolean isOn_amanat() {
		return on_amanat;
	}
	public void setOn_amanat(boolean on_amanat) {
		this.on_amanat = on_amanat;
	}
	public int getCode() {
		return code;
	}
	public void setCode() {
		Random rand =  new  Random();
		this.code = rand.nextInt(1000000);
	}
	public String toString() {
		return "Title:"+title+"\t\tWriter:"+writer+"\tPublisher:"+publishers+"\tCode:"
			+code+"\tOn_amanat:"+on_amanat+"\t\tnumber_pages:"+number_pages;
	}
}
