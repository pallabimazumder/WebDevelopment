package com.nri.I_HibernetBasic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class TestORM 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate Started...." );
        
        //We need object of Configure session for hibernate
        Configuration config = new Configuration();
        SessionFactory factory = config.configure().buildSessionFactory();
        Session session = factory.openSession();
        
        customer custobj = new customer();
        custobj.setCustid(11);
        custobj.setCustname("Pallabi");
        custobj.setCustcity("Kolkata");
        
        Orders ordobj = new Orders();
        ordobj.setOrdId(51);
        ordobj.setOrdName("pizza");
        ordobj.setOrdPrice(500);
        
        custobj.setOrder(ordobj);
        
        //Now we need to start transaction before asking hibernate to save our object into database
        Transaction tx = session.beginTransaction();
        
        session.save(custobj);   //to save the record
        
        
        //Retrieves the value
        customer c1 = (customer)session.get(customer.class, 13);
        System.out.println(c1);
        
        customer c2 = (customer)session.load(customer.class, 13);
        System.out.println(c2);
        
        //get fires up a select query even when there is not print statement[eager loading]
        //load doesn't fire up select unless we are printing the information[lazy loading]

        tx.commit();

        session.close();
        factory.close();
  
    }
}
