package it.springmvc.dev.webtracker.dao;

import it.springmvc.dev.webtracker.entity.Customer;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@AllArgsConstructor
public class CustomerDAOImpl implements CustomerDAO{

    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
        // execute query and get results list
        List<Customer> customers = theQuery.getResultList();
        // return the results
        return customers;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // save the customer
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer theCustomer = currentSession.get(Customer.class,theId);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);
        theQuery.executeUpdate();
    }


}
