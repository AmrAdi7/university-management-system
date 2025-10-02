package final_advance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UniversityManagement {
	private static ArrayList<Department> departments = new ArrayList<>();
	private static ArrayList<Employee> employees = new ArrayList<>();
	private static ArrayList<StudentCounseling> studentCounselings = new ArrayList<>();
	private static ArrayList<StudentPerformance> studentPerformances = new ArrayList<>();

	public static void main(String[] args) {
		loadEmployeeData("C:/Users/DELL/Desktop/Advanced programming/Dataset-20240528/Employee_Information.csv");
		loadDepartmentData("C:/Users/DELL/Desktop/Advanced programming/Dataset-20240528/Department_Information.csv");
		loadStudentPerformanceData(
				"C:/Users/DELL/Desktop/Advanced programming/Dataset-20240528/Student_Performance_Data.csv");
		loadStudentCounselingData(
				"C:/Users/DELL/Desktop/Advanced programming/Dataset-20240528/Student_Counceling_Information.csv");
		
		System.out.println(employees.isEmpty());
		System.out.println(employees.get(0).getId());
		Department dept = getDepartmentById("IDEPT5528");
        if (dept != null) {
            System.out.println("Department ID: " + dept.getId() + ", Name: " + dept.getName() + ", Created: " + dept.getDateCreated());
        } else {
            System.out.println("Department not found");
        }

		// System.out.println(employees.isEmpty()); 
		// getStudentAndEmployeeByDepartment("IDEPT5127");
		// System.out.println(getDepartmentStatistics("IDEPT8473"));
		// System.out.println(getStudentPerformanceStatistics("SID20131143"));

	}

	public static void loadDepartmentData(String filePath) {
		try (Scanner scanner = new Scanner(new File(filePath))) {
			// for skip first index  
			scanner.nextLine(); 
			while (scanner.hasNextLine()) {
				String[] data = scanner.nextLine().split(",");
				departments.add(new Department(data[0], data[1], data[2]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void loadEmployeeData(String filePath) {
		try (Scanner scanner = new Scanner(new File(filePath))) {
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String[] data = scanner.nextLine().split(",");
				employees.add(new Employee(data[0], data[1], data[2], data[3]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void loadStudentCounselingData(String filePath) {
		try (Scanner scanner = new Scanner(new File(filePath))) {
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String[] data = scanner.nextLine().split(",");
				studentCounselings.add(new StudentCounseling(data[0], data[1], data[2], data[3], data[4]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void loadStudentPerformanceData(String filePath) {

		try (Scanner scanner = new Scanner(new File(filePath))) {
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String[] data = scanner.nextLine().split(",");
				studentPerformances.add(new StudentPerformance(data[0], data[1], data[2], data[3], data[4]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// task 1
	public static Department getDepartmentById(String id) {
		for (Department dept : departments) {
			if (dept.getId().equals(id)) {
				return dept;
			}
		}
		return null;
	}

	public static Employee getEmployeeById(String id) {
		for (Employee emp : employees) {
			if (emp.getId().equals(id)) {
				return emp;
			}
		}
		return null;
	}

	public static StudentCounseling getStudentCounselingById(String id) {
		for (StudentCounseling sc : studentCounselings) {
			if (sc.getStudentId().equals(id)) {
				return sc;
			}
		}
		return null;
	}

	public static StudentPerformance getStudentPerformanceById(String id) {
		for (StudentPerformance sp : studentPerformances) {
			if (sp.getStudentId().equals(id)) {
				return sp;
			}
		}
		return null;
	}

	// task 2
	public static List<StudentCounseling> getStudentsByDepartmentAndDateRange(String department, String dobStart,
			String dobEnd, String acceptanceStart, String acceptanceEnd) {
		List<StudentCounseling> result = new ArrayList<>();
		for (StudentCounseling sc : studentCounselings) {
			if (sc.getDepartmentAdmission().equals(department) && sc.getDob().compareTo(dobStart) >= 0
					&& sc.getDob().compareTo(dobEnd) <= 0 && sc.getAcceptanceDate().compareTo(acceptanceStart) >= 0
					&& sc.getAcceptanceDate().compareTo(acceptanceEnd) <= 0) {
				result.add(sc);
			}
		}
		return result;
	}

	// task 3
	public static HashMap<String, Object> getStudentPerformanceStatistics(String studentId) {
		HashMap<String, Object> stats = new HashMap<>();
		int numPapers = 0, totalMarks = 0, maxMarks = Integer.MIN_VALUE, minMarks = Integer.MAX_VALUE;
		int numSemesters = 0;
		List<String> semesters = new ArrayList<>();

		for (StudentPerformance sp : studentPerformances) {
			if (sp.getStudentId().equals(studentId)) {
				numPapers++;
				int marks = Integer.parseInt(sp.getMarks());
				totalMarks += marks;
				if (marks > maxMarks)
					maxMarks = marks;
				if (marks < minMarks)
					minMarks = marks;
				if (!semesters.contains(sp.getSmesterName())) {
					semesters.add(sp.getSmesterName());
					numSemesters++;
				}
			}
		}

		stats.put("Number of Papers", numPapers);
		stats.put("Total Marks", totalMarks);
		stats.put("Maximum Marks", maxMarks);
		stats.put("Minimum Marks", minMarks);
		stats.put("Number of Semesters", numSemesters);
		if (numPapers > 0) {
			stats.put("Average Marks", (double) totalMarks / numPapers);
		} else {
			stats.put("Average Marks", 0.0);
		}

		return stats;
	}

	// task 4
	public static HashMap<String, Integer> getDepartmentStatistics(String departmentId) {
		int employeeCount = 0;
		int studentCount = 0;

		for (Employee emp : employees) {
			if (emp.getDepartmentId().equals(departmentId)) {
				employeeCount++;
			}
		}

		for (StudentCounseling sc : studentCounselings) {
			if (sc.getDepartmentAdmission().equals(departmentId)) {
				studentCount++;
			}
		}

		HashMap<String, Integer> stats = new HashMap<>();
		stats.put("Number of Employees", employeeCount);
		stats.put("Number of Students", studentCount);

		return stats;
	}

	// task 5
	public static void getStudentAndEmployeeByDepartment(String departmentId) {
		System.out.println("Employees:");
		for (Employee emp : employees) {
			if (emp.getDepartmentId().equals(departmentId)) {
				System.out.println(emp.getId() + ", " + emp.getDob() + ", " + emp.getDateOfJoining());
			}
		}

		System.out.println("Students:");
		for (StudentCounseling sc : studentCounselings) {
			if (sc.getDepartmentAdmission().equals(departmentId)) {
				System.out.println(sc.getStudentId() + ", " + sc.getAcceptanceDate() + ", " + sc.getDob() + ", "
						+ sc.getDepartmentAdmission() + ", " + sc.getChoiseOfDepartment());
			}
		}
	}
}
