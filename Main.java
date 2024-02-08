import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		// ask random or user input
		Scanner input = new Scanner(System.in);
		Student[] students;
		
		System.out.println("Enter 1 to generate list of students with grades. "
				+ "\nEnter 2 to manually input students with grades.");
		
		int menuOpt = input.nextInt();
		
		while (menuOpt != 1 && menuOpt != 2) {
			System.out.println("Invalid option. Please reenter 1 or 2");
			menuOpt = input.nextInt();
		}
		
		if (menuOpt == 1) {
			System.out.println("How many students would you like to generate? (1 - 20)");
			
			int numStudents = input.nextInt();
			
			while (numStudents < 1 || numStudents > 20) {
				System.out.println("Invalid option. Please reenter a number between 1 and 20");
				menuOpt = input.nextInt();
			}
			
			students = new Student[numStudents];
			
			char letter = 'A';
			for (int i = 0; i < numStudents; i++) {
				String name = "Student " + letter;
				int grade = ThreadLocalRandom.current().nextInt(0, 101);
				students[i] = new Student(name, grade);
				letter ++;
			}
			
			System.out.println("\nStudent List:");
			for (Student student : students) {
				System.out.println(student);
			}
			
		} else {
			
			System.out.println("How many students would you like to record? (1 - 20)");

			int numStudents = input.nextInt();
			
			while (numStudents < 1 || numStudents > 20) {
				System.out.println("Invalid option. Please reenter a number between 1 and 20");
				menuOpt = input.nextInt();
			}
			
			students = new Student[numStudents];

			for (int i = 0; i < numStudents; i++) {
				input.nextLine();
				System.out.print("Name: ");
				String name = input.nextLine();
				System.out.print("Grade: ");
				int grade = input.nextInt();
				
				while (grade < 0 || grade > 100) {
					System.out.println("Invalid grade. Please enter a number between 0 and 100");
					grade = input.nextInt();
				}
				
				students[i] = new Student(name, grade);
			}
			
			System.out.println("\nStudent List:");
			for (Student student : students) {
				System.out.println(student);
			}
			
		}
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Sorting student list using quick sort...\n");
		QuickSort<Student> qs = new QuickSort<Student>(students, 0, students.length - 1);
		Student[] sortedStudents = qs.quickSort(students, 0, students.length - 1);
		
		System.out.println("\nSorted Student List:");
		for (Student student : sortedStudents) {
			System.out.println(student);
		}
		
		System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Sorting (unsorted) student list using merge sort...\n");
		MergeSort<Student> ms = new MergeSort<Student>(students);
		sortedStudents = ms.mergeSort();
		
		System.out.println("\nSorted Student List:");
		for (Student student : sortedStudents) {
			System.out.println(student);
		}
	}

}
