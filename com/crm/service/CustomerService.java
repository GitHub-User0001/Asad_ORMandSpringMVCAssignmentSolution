package com.crm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Customer;

@Service
public class CustomerService {
	@SuppressWarnings("unused")
	@Autowired
	private SessionFactory factory;
	private Session session;

	public CustomerService(SessionFactory factory) {
		this.factory = factory;
		try {
			this.session = factory.getCurrentSession();

		} catch (Exception e) {
			this.session = factory.openSession();
		}
		System.out.println("Session Created");
		System.out.println(this.session);
	}

	@Transactional
	public void saveOrUpdate(Customer customer) {
		System.out.println("save" + customer);
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
	}

	@Transactional
	public Customer findCustomerById(int id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		tx.commit();
		return customer;
	}

	@Transactional
	public boolean delete(int id) {
		try {
			Transaction tx = session.beginTransaction();
			Customer record = session.get(Customer.class, id);
			session.delete(record);
			tx.commit();
		} catch (Exception e) {
			return false;

		}
		return true;
	}

	@Transactional
	public List<Customer>findAllCustomer(){
		Transaction tx= session.beginTransaction();
		List<Customer> customers=session.createQuery("from Customer").list();
		tx.commit();
		return customers;
		
	}

}
