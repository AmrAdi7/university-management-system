# University Management System

## Overview
This project is a **University Management System** developed in Java using **Object-Oriented Programming (OOP)** principles and key **Design Patterns**.  
It simulates the management of university entities such as **Departments, Employees, Student Counseling, and Student Performance** while ensuring modularity, scalability, and maintainability.

---

## Features
- **Entity Classes**:  
  - `Department`, `Employee`, `StudentCounseling`, `StudentPerformance`  
  Represent university components with attributes and methods.

- **Design Patterns Used**:
  - **Factory Pattern** → Handles object creation for entities (DepartmentFactory, EmployeeFactory, etc.).  
  - **Observer Pattern** → Keeps related classes updated when changes occur (e.g., Department updates).  
  - **Singleton Pattern** → Ensures only one instance of `DataStorage` for centralized data management.

- **OOP Principles**:
  - **Encapsulation**: Attributes and methods grouped within classes.  
  - **Abstraction**: Hides implementation using abstract classes/interfaces (e.g., DataLoader).  
  - **Association & Aggregation**: Defines relationships among entities.  
  - **Scalability**: New features/entities can be added without major changes.

---

## Project Structure
```
University-management-system/
│── src/
│   ├── Department.java
│   ├── Employee.java
│   ├── StudentCounseling.java
│   ├── StudentPerformance.java
│   └── UniversityManagement.java
│
│── Dataset/
│   ├── Department_Information.csv
│   ├── Employee_Information.csv
│   ├── Student_Counseling_Information.csv
│   ├── Student_Performance_Data.csv
│   └── _Data_Source.txt
│
│── Project_Report_Amr_Adi.docx   # Detailed report with UML and explanations
│── README.md                     # Project documentation
│── .gitignore
```

---


## Example Use Cases
- Add new **Departments** and notify observers automatically.  
- Manage **Employees** and **Student Records** through factories.  
- Store and retrieve shared data using the **Singleton DataStorage**.

---

## Future Improvements
- GUI interface for user interaction.  
- Database integration instead of `.csv` datasets.  
- More advanced design patterns (e.g., Strategy, Proxy) for dynamic behaviors.

---

## Author
**Amr Adi**  
University Management System Project - Advanced Programming  
2024/2025
