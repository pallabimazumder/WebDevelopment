package com.nri.IV_HibernateMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestManyToManyMapping 
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
        c2.setCustname("John");
        c2.setCustcity("LA");
        
        List<customer> listCust = new ArrayList<customer>();
        listCust.add(c1);
        listCust.add(c2);
        
        Orders o1 = new Orders();
        o1.setOrdId(51);
        o1.setOrdName("Donut");
        o1.setOrdPrice(300);

        Orders o2 = new Orders();
        o2.setOrdId(52);
        o2.setOrdName("Pasta");
        o2.setOrdPrice(500);
        
        List<Orders> listOrd = new ArrayList<Orders>();
        listOrd.add(o1);
        listOrd.add(o2);
        
        c1.setOrder(listOrd);
        o1.setCustomers(listCust);
        
        c2.setOrder(listOrd);
        o2.setCustomers(listCust);
        
        session.save(o1);
        session.save(o2);

        session.save(c1);
        session.save(c2);

        tx.commit();
        
        session.close();
        factory.close();
        
        
    }
}
