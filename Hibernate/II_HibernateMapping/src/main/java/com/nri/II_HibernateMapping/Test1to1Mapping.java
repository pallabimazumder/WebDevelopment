package com.nri.II_HibernateMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test1to1Mapping 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate Mapping Started........" );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        
        customer c1 = new customer();
        c1.setCustid(11);
        c1.setCustname("Mac");
        c1.setCustcity("Delhi");
        
        
        
        customer c2 = new customer();
        c2.setCustid(11);
        c2.setCustname("June");
        c2.setCustcity("Kolkata");
       
        
        Orders o1 = new Orders();
        o1.setOrdId(51);
        o1.setOrdName("Donut");
        o1.setOrdPrice(300);
        o1.setCustomers(c1);
        
        Orders o2 = new Orders();
        o2.setOrdId(52);
        o2.setOrdName("Pasta");
        o2.setOrdPrice(500);
        o2.setCustomers(c1);
        
        c1.setOrder(o1);
        c2.setOrder(o2);
        
        session.save(o1);
        session.save(o2);
        
        session.save(c1);
        session.save(c2);
        
        
        tx.commit();
        
        session.close();
        factory.close();
        
        
    }
}
