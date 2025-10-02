package final_advance;

public class Department {
	private String id;
	private String name;
	private String dateCreated;

	public Department(String id, String name, String dateCreated) {
		this.id = id;
		this.name = name;
		this.dateCreated = dateCreated;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}
