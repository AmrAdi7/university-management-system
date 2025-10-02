package final_advance;

public class Employee {
	private String id;
	private String dob;
	private String dateOfJoining;
	private String departmentId;

	public Employee(String id, String dob, String dateOfJoining, String departmentId) {
		this.id = id;
		this.dob = dob;
		this.dateOfJoining = dateOfJoining;
		this.departmentId = departmentId;
	}

	public String getId() {
		return id;
	}

	public String getDob() {
		return dob;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
}
