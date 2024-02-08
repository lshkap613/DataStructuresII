
public class Student implements Comparable<Student>{
	private String name;
	private int grade;
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Grade: " + grade + "%";
	}

	@Override
	public int compareTo(Student o) {
		return this.grade - o.grade; // ????????
	}
}
