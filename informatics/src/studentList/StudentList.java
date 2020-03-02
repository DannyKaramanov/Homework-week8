package studentList;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

import fmi.informatics.extending.Student;

public class StudentList {

	public static void main(String[] args) {

		generateStudents();
	}

	public static void generateStudents() {
		List<Student> studentList = Arrays.asList(
				Student.StudentGenerator.make(), 
				Student.StudentGenerator.make(),
				Student.StudentGenerator.make(), 
				Student.StudentGenerator.make());

		studentList.forEach((s) -> System.out.println(
				"Име: " + s.getName() + 
				"	Години: " + s.getAge() + 
				" 	ЕГН: " + s.getEgn() + 
				" 	Университет: " + s.getUniversity() + 
				" 	Специалност: " + s.getSpeciality() + 
				" 	Ф-н номер: " + s.getFacNumber()));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nНатиснете А за възходящо сортиране по специалност или D за низходящо сортиране ");
		while(true) {
			try {
				char sortAorB = sc.next().charAt(0);
				if (sortAorB == 'A') {
					sortASC(studentList);
					studentList.forEach((s) -> System.out.println(
						"Име: " + s.getName() + 
						"	Години: " + s.getAge() + 
						" 	ЕГН: " + s.getEgn() + 
						" 	Университет: " + s.getUniversity() + 
						" 	Специалност: " + s.getSpeciality() + 
						" 	Ф-н номер: " + s.getFacNumber()));
				}
				else if (sortAorB == 'D') {
					sortDESC(studentList);
					studentList.forEach((s) -> System.out.println(
						"Име: " + s.getName() + 
						"	Години: " + s.getAge() + 
						" 	ЕГН: " + s.getEgn() + 
						" 	Университет: " + s.getUniversity() + 
						" 	Специалност: " + s.getSpeciality() + 
						" 	Ф-н номер: " + s.getFacNumber()));
				}
			
			} catch (InputMismatchException e) {
				sc.next().charAt(0);
				System.err.println("Моля въведете A или D ");
			}
		}
		
	}

	public static void sortASC(List<Student> studentList) {
		studentList.sort((a, b) -> {
			return a.getSpeciality().compareTo(b.getSpeciality());
		});

	}


	public static void sortDESC(List<Student> studentList) {
		studentList.sort((a, b) -> {
			return b.getSpeciality().compareTo(a.getSpeciality());
		});

	}
}
