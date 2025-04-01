package co.edu.unbosque.model;

public class ExcelDTO {

	private Integer id;
	private String user;
	private String date;

	public ExcelDTO() {
		// TODO Auto-generated constructor stub
	}

	public ExcelDTO(String user, String date) {
		super();
		this.user = user;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ExcelDTO [id=" + id + ", user=" + user + ", date=" + date + "]";
	}

}
