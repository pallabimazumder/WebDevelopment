package com.nri.VIII_HQLCRUD;


import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;



public class TestHQL 
{
	
	static Configuration cfg;
	static SessionFactory sf;
	static Session s;
	static Transaction tx;
	
	private static Session getSession() {
			
		cfg = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Trainee.class)
				.addAnnotatedClass(Laptop.class);
		sf = cfg.buildSessionFactory();
		s = sf.openSession();
		return s;
			
	}
	
	private static void rcrdCreate() {
		
		s = getSession();
		
		
		Laptop l1 = new Laptop();
		l1.setLapId(11);
		l1.setLapName("Dell");
		
		Laptop l2 = new Laptop();
		l2.setLapId(12);
		l2.setLapName("HP");
		
		Laptop l3 = new Laptop();
		l3.setLapId(13);
		l3.setLapName("MAC");
		
		
		Trainee t1 = new Trainee();
		t1.setTid(89);
		t1.setTname("Pallabi");
		t1.setTmarks(100);
		t1.setLaptop(l1);
		
		Trainee t2 = new Trainee();
		t2.setTid(90);
		t2.setTname("Bhumi");
		t2.setTmarks(88);
		t2.setLaptop(l2);
		
		Trainee t3 = new Trainee();
		t3.setTid(91);
		t3.setTname("John");
		t3.setTmarks(54);
		t3.setLaptop(l3);

		tx = s.beginTransaction();
		
		s.save(l1);
		s.save(l2);
		s.save(l3);
		
		tx.commit();
		s.close();
		
	}
	
	
	private static void retrieveAll() {
		
		s = getSession();
		
		//SQL --> select column name from tablename
		//HQL --> from classname
		
		
		Query query = s.createQuery("from Trainee");
		
		List<Trainee> listTrainee = query.getResultList();
		
		for(Trainee t: listTrainee) {
			System.out.println(t);
		}
		
		s.close();

	}
	
	private static void retrieveRecord(int tid){
		
		s = getSession();

		
		
		Query query = s.createQuery("from Trainee where tid = :t");   //instead of wild card, in hibernate we use :variable name called "NAMED PARAMETER"
		query.setLong("t", tid);
		
		Trainee tr = (Trainee)query.uniqueResult();  //for unique result
		
		System.out.println(tr);
		
		s.close();

	}
	
	private static void rcrdUpdate(int tid, String tname) {
		
		s = getSession();
		tx = s.beginTransaction();
		
		
		Query query = s.createQuery("update Trainee set tname :name where tid = :id");
		query.setString("name", tname);
		query.setLong("id", tid);
		
		int count = query.executeUpdate();
		
		System.out.println(count + "recorded got updated");
		
		tx.commit();
		s.close();

	}
	
	private static void rcrdDelete(int tid) {
		
		s = getSession();
		tx = s.beginTransaction();
		
		
		Query query = s.createQuery("delete Trainee where tid = :id");

		query.setLong("id", tid);
		
		int count = query.executeUpdate();
		
		System.out.println(count + "recorded got deleted");
		
		tx.commit();
		s.close();

	}
	
	//Criteria API --> These are used for querying on the columns
	
	private static void projectionFirst() {
		
		s = getSession();
		
		double sumTotalMarks = (Double) s.createCriteria(Trainee.class)
				.setProjection(Projections.sum("tmarks"))             //setProjection--> retrieval of the value
				.uniqueResult();
		
		System.out.println("Sum total of trainees marks column as projected is " + sumTotalMarks) ;
		
	}
	
	private static void projectionpatternMatching() {
		
		s = getSession();
		
		long patternMatch = (Long) s.createCriteria(Trainee.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("tname", "%o%"))
				.uniqueResult();
		
		System.out.println("Total number of trainees with 'o' in name is: "+patternMatch);
		
	}
	
    public static void main( String[] args )
    {
        System.out.println("Table Being Created");
        rcrdCreate();
        
        System.out.println("Retreiving all data: ");
        retrieveAll();
        
        System.out.println("Retreiving unique data: ");
        retrieveRecord(11);
        
        rcrdUpdate(1, "Mosh");
        rcrdDelete(1);
        
        
    }
}














































