package com.manan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manan.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//Create Session Factory
				SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//Create Session
				Session session=factory.getCurrentSession();
				
				try
				{
					Integer studentId=2;
					
					session=factory.getCurrentSession();
					session.beginTransaction();
					System.out.println("Getting the student whose Id is: "+studentId);
					Student myStudent=session.get(Student.class, studentId);
					System.out.println("Updating the student");
					myStudent.setFirstName("Riddhi");
					
					
					
					//Commit the Transaction
					session.getTransaction().commit();
					System.out.println("Student Object updated!!");
					
					session=factory.getCurrentSession();
					session.beginTransaction();
					System.out.println("Updating the email address of all students");
					session.createQuery("UPDATE Student set email='riddhi@gmail.com'").executeUpdate();
					session.getTransaction().commit();
					
				}
				finally {
					session.close();
					System.exit(0);
				}
	}

}
