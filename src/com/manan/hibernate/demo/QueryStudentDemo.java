package com.manan.hibernate.demo;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manan.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//Create Session Factory
				SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//Create Session
				Session session=factory.getCurrentSession();
				
				try
				{
					//start transaction
					session.beginTransaction();
					//query the students
					@SuppressWarnings("unchecked")
					List<Student> theStudents=session.createQuery("FROM Student s WHERE s.firstName LIKE '%Manan'").getResultList();
					displayStudents(theStudents);
					
					//commit transaction
					
					System.out.println("Retrieved Students from the database");
					
					//Query Students: lastName='Pandya' OR firstName='Shreyas'
					@SuppressWarnings("unchecked")
					List<Student> results=session.createQuery("FROM Student s WHERE s.firstName LIKE '%Manan' AND s.lastName LIKE '%Pandya'").getResultList();
					
					System.out.println("Displaying the students whose firstName like Manan");
					displayStudents(results);
					session.getTransaction().commit();
				}
				finally {
					session.close();
					System.exit(0);
				}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student student:theStudents)
		{
			System.out.println(student.toString());
		}
	}

}
