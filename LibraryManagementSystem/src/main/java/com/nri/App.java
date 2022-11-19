package com.nri;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
	
	static Configuration cfg;
	static SessionFactory sf;
	static Session session;
	static Transaction tx;
	
	private static Session getSession() {
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		return session;
	}
	
	private static void createRecord() {
		Library l1 = new Library();
        l1.setLibId(11);
        l1.setLibName("ABC");
        l1.setLibFees(500);
        
        Library l2 = new Library();
        l2.setLibId(12);
        l2.setLibName("PQR");
        l2.setLibFees(400);
        
        Library l3 = new Library();
        l3.setLibId(13);
        l3.setLibName("XYZ");
        l3.setLibFees(600);
        
        Book b1 = new Book();
        b1.setbId(51);
        b1.setbName("QWE");
        b1.setbAuthor("RTY");
        
        Book b2 = new Book();
        b2.setbId(52);
        b2.setbName("UIO");
        b2.setbAuthor("PAS");
        
        Book b3 = new Book();
        b3.setbId(53);
        b3.setbName("DFG");
        b3.setbAuthor("HJK");
        
        Book b4 = new Book();
        b4.setbId(54);
        b4.setbName("LZX");
        b4.setbAuthor("CVB");
        
        Book b5 = new Book();
        b5.setbId(55);
        b5.setbName("NMQ");
        b5.setbAuthor("QAZ");
        
        Book b6 = new Book();
        b6.setbId(56);
        b6.setbName("WSX");
        b6.setbAuthor("EDC");
        
        List<Book> listord1 = new ArrayList<Book>();
        listord1.add(b1);
        listord1.add(b2);
        
        List<Book> listord2 = new ArrayList<Book>();
        listord2.add(b3);
        listord2.add(b4);
        
        List<Book> listord3 = new ArrayList<Book>();
        listord3.add(b5);
        listord3.add(b6);
        
        l1.setBooks(listord1);
        l2.setBooks(listord2);
        l3.setBooks(listord3);
        
        session.save(l1);
        session.save(l2);
        session.save(l3);
        
        tx.commit();
        
        session.close();
        sf.close();
	}
	
	private static void rcrRetrieveAll() {
		session = getSession();

		
		Query query = session.createQuery("from Trainees");

		List<Library> listlib = query.getResultList();

		for (listlib l : listlib) {
			System.out.println(l + " ");
		}
		System.out.println();
		session.close();
	}
	
	private static void rcrRetrieveUnique(int libid) {
		session = getSession();

		
		Query query = session.createQuery("from Library where libid = :libid");
		query.setLong("libid", libid);

		Library l = (Library) query.uniqueResult();

		System.out.println(l + " ");
		session.close();
	}
	
	private static void rcrUpdate(int lid, String lname) {
		session = getSession();
		tx = session.beginTransaction();

		Query query = session.createQuery("update Trainees set tname = :traineename where tid= :traineeid");
		query.setLong("libid", lid);
		query.setString("libname", lname);

		int count = query.executeUpdate();

		System.out.println(count + " recod got updated");
		tx.commit();
		s.close();
	}

	private static void rcrDelete(int lid) {
		session = getSession();
		tx = session.beginTransaction();

		Query query = session.createQuery("delete Trainees where tid = :trid");
		query.setLong("lid", lid);

		int count = query.executeUpdate();

		System.out.println(count + " recod got deleted");
		tx.commit();
		s.close();
	}
	
    public static void main( String[] args )
    {
    	System.out.println( "Hibernate Mapping of Library to Book(1 to Many) is started ...." );
        
        
        
        
    }
}
