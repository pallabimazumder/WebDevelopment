package com.nri.V_HibernateFirstLevelCaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//First Level Caching --> Suppose in the first request from the APP, hibernate is requesting from the backend
// and again next request, hibernate is requesting from the same object and session is also same, then it wont go to the backend, rather retrieve 
// the data directly from the cache.


//Second Level Caching --> first request for a object using one session and second request for the same object but using different session
//In that case, it wont retrieve the data from the same cache, rather we need to make another cache memory 
//and data is retrieved from there.


//Basically, for each session there creates one cache memory.


public class TestFirstLevelCaching 
{
    public static void main( String[] args )
    {
        System.out.println( "Hiberate First Level Cache is enabled by default....." );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        Employee empobj = new Employee();
        empobj.setEmpid(11);
        empobj.setEmpname("Pallabi");
        empobj.setEmpcity("Kolkata");
        
        //session.save(empobj);
        
        
        //Retrieval of data
        Employee empobj2 = session.get(Employee.class, 11);
        System.out.println(empobj2);
        
        System.out.println("Some times after");
        
        Employee empobj3 = session.get(Employee.class, 11);
        System.out.println(empobj3);
        
        
        tx.commit();
        
        session.close();
        
        
        Session session2 = factory.openSession();
        Transaction tx2 = session.beginTransaction();
        
    
        
        Employee empobjtwo = session2.get(Employee.class, session2);
        tx2.commit();
        
        session2.close();
        
        factory.close();
        
    }
}

//in first level caching, it will only fire up one single select operation.
//here both the object is using the same session.
//if two different session are created then separate query opertions will be fired up