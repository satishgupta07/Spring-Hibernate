package com.satishkumar06.SpringORM;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.satishkumar06.SpringORM.dao.StudentDao;
import com.satishkumar06.SpringORM.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    	
//    	Student student = new Student(2324,"Satish Kumar Gupta", "Lucknow");
//    	int r = studentDao.insert(student);
//    	System.out.println("done "+r);
    	
    	Scanner sc = new Scanner(System.in);
    	boolean go = true;
    	
    while(go) {
    	System.out.println("Press 1 for add new student");
    	System.out.println("Press 2 for display all student");
    	System.out.println("Press 3 for get detail of single student");
    	System.out.println("Press 4 for delete studnets");
    	System.out.println("Press 5 for update student");
    	System.out.println("Press 6 for exit");
    	
    	try {
    		int input = Integer.parseInt(sc.nextLine());
    		
    		switch (input) {
			case 1:
				System.out.println("Student ID : ");
				int studentId = Integer.parseInt(sc.nextLine());
				System.out.println("Student Name : ");
				String studentName = sc.nextLine();
				System.out.println("Student City : ");
				String studentCity = sc.nextLine();
				Student student = new Student(studentId,studentName,studentCity);
				studentDao.insert(student);
				break;
			case 2:
				List<Student> students = studentDao.gatAllStudents();
				for (Student student2 : students) {
					System.out.println(student2);
				}
				break;
			case 3:
				System.out.println("Student ID : ");
				int studentId1 = Integer.parseInt(sc.nextLine());
				System.out.println(studentDao.getStudent(studentId1));
				break;
			case 4:
				System.out.println("Student ID : ");
				int studentId2 = Integer.parseInt(sc.nextLine());
				studentDao.deleteStudent(studentId2);
				break;
			case 5:
				System.out.println("Student ID : ");
				int studentId3 = Integer.parseInt(sc.nextLine());
				System.out.println("Student Name : ");
				String studentName3 = sc.nextLine();
				System.out.println("Student City : ");
				String studentCity3 = sc.nextLine();
				Student student3 = new Student(studentId3,studentName3,studentCity3);
				studentDao.updateStudent(student3);
				break;
			case 6:
				go = false;
				break;
				
    		}
			
		} catch (Exception e) {
			System.out.println("Invalid Input Try with another one !!");
			System.out.println(e.getMessage());
		}
    }
   }
}
