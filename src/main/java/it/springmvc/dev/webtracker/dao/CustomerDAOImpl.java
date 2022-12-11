package it.springmvc.dev.webtracker.dao;

import it.springmvc.dev.webtracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session currentSession = sessionFactory.openSession();
        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
        // execute query and get results list
        List<Customer> customers = theQuery.getResultList();
        // return the results
        return customers;
    }


}
