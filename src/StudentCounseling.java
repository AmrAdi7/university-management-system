package final_advance;

public class StudentCounseling {
	private String studentId;
	private String acceptanceDate;
	private String dob;
	private String choiseOfDepartment;
	private String departmentAdmission;

	public StudentCounseling(String studentId, String acceptanceDate, String dob, String section,
			String departmentName) {
		this.studentId = studentId;
		this.acceptanceDate = acceptanceDate;
		this.dob = dob;
		this.choiseOfDepartment = section;
		this.departmentAdmission = departmentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getAcceptanceDate() {
		return acceptanceDate;
	}

	public String getDob() {
		return dob;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setAcceptanceDate(String acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getChoiseOfDepartment() {
		return choiseOfDepartment;
	}

	public void setChoiseOfDepartment(String choiseOfDepartment) {
		this.choiseOfDepartment = choiseOfDepartment;
	}

	public String getDepartmentAdmission() {
		return departmentAdmission;
	}

	public void setDepartmentAdmission(String departmentAdmission) {
		this.departmentAdmission = departmentAdmission;
	}
}
