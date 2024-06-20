package com.manan.hibernate.demo;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manan.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
					Random rand=new Random();
					Integer studentId=rand.nextInt(100);
					Student tempStudent=new Student(studentId,"Manan H","Pandya","pandyamanan100@gmail.com");
					//start transaction
					session.beginTransaction();
					//save the student object
					System.out.println("Saving the student");
					session.save(tempStudent);
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Student Object saved!!");
					
				}
				finally {
					session.close();
				}
	}

}
