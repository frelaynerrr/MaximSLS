package com.maxim.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maxim.spring.entity.Customer;

	// should apply repository to DAO  implementation
	// for spring to be able to scan it

@Repository
public class CustomerDAOImp implements CustomerDAO {

	// inject the session factory by using Autowired
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// let spring to start and stop transacion itself
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		
		// get current hibernate session - > create query - > execute query and get list
		// - > return the resul list
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

}
