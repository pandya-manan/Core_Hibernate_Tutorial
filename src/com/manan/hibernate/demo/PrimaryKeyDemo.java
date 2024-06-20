package com.manan.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manan.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create Session
		Session session=factory.getCurrentSession();
		
		try
		{
			//Use the session object to save Java Object
			System.out.println("Creating a new student object!!");
			//create student object
			
			
			Scanner scan=new Scanner(System.in);
			Integer numberOfStudents;
			System.out.println("Enter the number of students");
			numberOfStudents=scan.nextInt();
			Student students[]=new Student[numberOfStudents];
			for(int i=0;i<numberOfStudents;i++)
			{
				System.out.println("Please enter the first name");
				String firstNameToSave=scan.next();
				System.out.println("Please enter the last name");
				String lastNameToSave=scan.next();
				System.out.println("Please enter the email to save");
				String emailToSave=scan.next();
				Student tempStudent=new Student();
				tempStudent.setEmail(emailToSave);
				tempStudent.setFirstName(firstNameToSave);
				tempStudent.setLastName(lastNameToSave);
				students[i]=tempStudent;
				
			}
			
			
			//start transaction
			session.beginTransaction();
			//save the student object
			System.out.println("Saving the students");
			for(int i=0;i<numberOfStudents;i++)
			{
				session.save(students[i]);
			}
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Student Object saved!!");
			scan.close();
			
		}
		finally {
			
			session.close();
			System.exit(0);
		}
	}

}
