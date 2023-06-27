package in.ineuron.controller;

import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

public class ControllerApp {

	private static Scanner scanner = null;

	public static void main(String[] args) {

		while (true) {

			System.out.println("**************************************");
			System.out.println("____Press 1 for Insert operation_____");
			System.out.println("____Press 2 for select operation_____");
			System.out.println("____Press 3 for Update operation_____");
			System.out.println("____Press 4 for Delete operation_____");
			System.out.println("____Press 5 for exit the application__");

			scanner = new Scanner(System.in);
			String id = scanner.nextLine();

			switch (id) {
			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updationOperation();
				break;
			case "4":
				deletionOperation();
				break;
			case "5":
				System.out.println("*********Thank You For Using Application********");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Enter Correct choice");
				break;
			}

		}
	}

	private static void deletionOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentsService();

		scanner = new Scanner(System.in);

		System.out.println("Enter id :");
		int sid = scanner.nextInt();
		String msg = studentService.deleteStudent(sid);

		if (msg.equalsIgnoreCase("success")) {
			System.out.println("Row Deleted Succesfully");
		} else {
			System.out.println("No record found");
		}

	}

	private static void updationOperation() {

		IStudentService studentService = StudentServiceFactory.getStudentsService();

		scanner = new Scanner(System.in);
		Student newstudent = null;

		System.out.println("Enter id :");
		int sid = scanner.nextInt();
		scanner.nextLine();
		Student std = studentService.searchStudent(sid);

		if (std != null) {
			newstudent = new Student();
			newstudent.setSid(std.getSid());

			System.out.println("Old Name is: " + std.getSname() + "  Enter New Name: ");
			String newname = scanner.nextLine();

			if (newname.equals("") || newname == "") {
				newstudent.setSname(std.getSname());
			} else {
				newstudent.setSname(newname);
			}

			System.out.println("Old age is:-" + std.getSage() + "  Enter New age:  ");
			String newAge = scanner.nextLine();

			if (newAge.equals("") || newAge == "") {
				newstudent.setSage(std.getSage());
			} else {
				newstudent.setSage(Integer.parseInt(newAge));
			}

			System.out.println("Old Address is:-" + std.getSaddress() + "   Enter New Address: ");
			String newAddress = scanner.nextLine();

			if (newAddress.equals("") || newAddress == "") {
				newstudent.setSaddress(std.getSaddress());
			} else {
				newstudent.setSaddress(newAddress);
			}

			String res = studentService.updateStudent(newstudent);

			if (res.equalsIgnoreCase("success")) {
				System.out.println("Record Updated successfully");
			} else {
				System.out.println("Record not Updated");
			}
		} else {
			System.out.println("No record found of id  " + sid);
		}
	}

	private static void selectOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentsService();

		scanner = new Scanner(System.in);

		System.out.println("Enter id :");
		int sid = scanner.nextInt();
		Student std = studentService.searchStudent(sid);

		if (std != null) {
			System.out.println("Id\tName\tAge\tAddress");
			System.out.println(std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddress());
		} else {
			System.out.println("No record found of id  " + sid);
		}

	}

	private static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentsService();

		scanner = new Scanner(System.in);

		System.out.println("Enter Name :");
		String name = scanner.nextLine();

		System.out.println("Enter Age :");
		String age = scanner.nextLine();

		System.out.println("Enter Address: ");
		String address = scanner.nextLine();

		String msg = studentService.addStudent(name, Integer.parseInt(age), address);

		if (msg.equalsIgnoreCase("Success")) {
			System.out.println("Inserted successfull");
		} else {
			System.out.println("Insertion unsuccessfull");
		}
	}

}
