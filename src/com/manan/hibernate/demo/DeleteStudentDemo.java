package com.manan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manan.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//Create Session Factory
				SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//Create Session
				Session session=factory.getCurrentSession();
				
				try
				{
					Integer studentId=2;
					Integer studentId1=4;
					session=factory.getCurrentSession();
					session.beginTransaction();
					System.out.println("Deleting the student whose Id is: "+studentId);
					
					Student toDeleteStudent=session.get(Student.class, studentId);
					//Direct delete function
//					session.delete(toDeleteStudent);
					
					System.out.println("Deleting the student whose Id is: "+studentId1);
					//Query delete function
					session.createQuery("DELETE FROM Student where Id=4").executeUpdate();
					
					session.getTransaction().commit();
					
				}
				finally {
					session.close();
					System.exit(0);
				}
	}

}
