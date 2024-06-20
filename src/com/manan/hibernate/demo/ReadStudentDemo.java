package com.manan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manan.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
								
					Student tempStudent=new Student("Selena","Gomez","selena@gmail.com");
					//start transaction
					session.beginTransaction();
					//save the student object
					System.out.println("Saving the student");
					session.save(tempStudent);
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Saved Student Generated Id: "+tempStudent.getId());
					//Get a new session and start transaction
					session=factory.getCurrentSession();
					session.beginTransaction();
					//Retrieve student based on the Id: Primary Key
					System.out.println("\nGetting the student with the Id: "+tempStudent.getId());
					Student myStudent=session.get(Student.class, tempStudent.getId());
					System.out.println("Get complete Student: "+myStudent);
					//Commit the Transaction
					System.out.println("Student Object saved!!");
					
				}
				finally {
					session.close();
					System.exit(0);
				}
	}

}
