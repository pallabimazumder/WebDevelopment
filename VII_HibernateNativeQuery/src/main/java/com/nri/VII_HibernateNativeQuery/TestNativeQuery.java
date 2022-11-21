package com.nri.VII_HibernateNativeQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class TestNativeQuery 
{	
	
	static Configuration cfg;
	static SessionFactory sf;
	static Session s;
	static Transaction tx;

	private static Session getSession() {
		
		cfg = new Configuration();
		sf = cfg.configure().buildSessionFactory();
		s = sf.openSession();
		return s;
		
	}
	
	private static void rcrdInsert() {
		
		Library l1 = new Library();
		l1.setLibId(11);
		l1.setLibName("CS IT Library");
		l1.setLibFees(200);
		
		Library l2 = new Library();
		l2.setLibId(12);
		l2.setLibName("ECE Library");
		l2.setLibFees(300);
		
		Library l3 = new Library();
		l3.setLibId(13);
		l3.setLibName("Civil Library");
		l3.setLibFees(250);
		
		s = getSession();
		tx = s.beginTransaction();
		
		s.save(l1);
		s.save(l2);
		s.save(l3);
		
		
		tx.commit();
		s.close();
		
	}
	
	private static void rcrdGetAll() {
		
		s = getSession();
		
		NativeQuery query = s.createNativeQuery("select * from library");
		
		List<Object []> listrows = query.getResultList();
		
		listrows.forEach(libobj ->{
			
			for(Object obj: libobj) {
				System.out.println(obj+" ");
			}
			System.out.println();
		});
	}
	
	private static void rcrdSearch(int lid) {
			
			s = getSession();
			
			
			NativeQuery query = s.createNativeQuery("select * from library where libId = ?");
			query.setParameter(1,  lid);
			
			
			
			List<Object []> listrows = query.getResultList();
			
			listrows.forEach(libobj ->{
				
				for(Object obj: libobj) {
					System.out.println(obj+" ");
				}
				System.out.println();
			});
			
			tx.commit();
			s.close();
		}
	
	private static void rcrdUpdate(int lid, String lname) {
		
		s = getSession();
		tx = s.beginTransaction();
		
		NativeQuery query = s.createNativeQuery("update library set libName = ? where libId = ?");
		query.setParameter(1,  lname);
		query.setParameter(1,  lid);
		
		
		int count = query.executeUpdate();
		System.out.println(count + " record got updated");
		
		tx.commit();
		s.close();
	}
	
	private static void rcrdDelete(int lid) {
			
			s = getSession();
			tx = s.beginTransaction();
			
			NativeQuery query = s.createNativeQuery("delete library where libId = ?");
			
			query.setParameter(2,  lid);
			
			
			int count = query.executeUpdate();
			System.out.println(count + " record got deleted");
			
			tx.commit();
			s.close();
		}
	
	
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hibernate Native Query Session using CRUD Operation......" );
        rcrdInsert();
        
        rcrdGetAll();
        
        rcrdSearch(11);
        
        rcrdUpdate(12, "Machanical Library");
        
        rcrdDelete(12);
    }
    
}



//we dont need to start a session for select operation.
//we do need session to be started for update, delete.

























