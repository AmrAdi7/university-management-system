package final_advance;

public class StudentPerformance {
	private String studentId;
	private String smesterName;
	private String paperId;
	private String paperName;
	private String marks;
	
	public StudentPerformance(String studentId, String smesterName, String paperId, String paperName, String marks) {
		super();
		this.studentId = studentId;
		this.smesterName = smesterName;
		this.paperId = paperId;
		this.paperName = paperName;
		this.marks = marks;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getSmesterName() {
		return smesterName;
	}

	public String getPaperId() {
		return paperId;
	}

	public String getPaperName() {
		return paperName;
	}

	public String getMarks() {
		return marks;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setSmesterName(String smesterName) {
		this.smesterName = smesterName;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	
	
	
}
