package com.mikro.test.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mikro.test.dao.PhonebookDAO;
import com.mikro.test.model.Phonebook;

@Repository
public class PhonebookDAOImpl implements PhonebookDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(EntityManagerFactory entityManagerFactory) {
		sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
	}

	@Override
	public void addPhonebook(Phonebook phonebook) {
		sessionFactory.getCurrentSession().save(phonebook);
	}

	@Override
	public void addOrUpdatePhonebook(Phonebook phonebook) {
		sessionFactory.getCurrentSession().saveOrUpdate(phonebook);
	}

	@Override
	public void updatePhonebook(Phonebook phonebook) {
		sessionFactory.getCurrentSession().update(phonebook);
	}

	@Override
	public Phonebook getPhonebookByPk(Long phonebookId) {
		return (Phonebook) sessionFactory.getCurrentSession().get(Phonebook.class, phonebookId);
	}

	@Override
	public Phonebook getPhonebookByPhoneNumber(String phoneNumber) {
		return (Phonebook) sessionFactory.getCurrentSession().createQuery("FROM Phonebook P WHERE P.phoneNumber = :phoneNumber")
				.setParameter("phoneNumber", phoneNumber).uniqueResult();	
		
	}	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Phonebook> getAllPhonebook() {
		return sessionFactory.getCurrentSession().createQuery("FROM Phonebook").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Phonebook> getAllPhonebookPaginated(int pageSize, int pageNumber) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Phonebook ORDER BY id DESC")

				.setFirstResult(pageSize * pageNumber)//page number = pageSize * pageNumber
				.setMaxResults(pageSize)//pageSize
				
				.list();
	}
	
	@Override
	public void deletePhonebook(Long phonebookId) {
		Phonebook phonebook = (Phonebook) sessionFactory.getCurrentSession().load(Phonebook.class, phonebookId);
		if (phonebook != null) {
			this.sessionFactory.getCurrentSession().delete(phonebook);
		}
	}
	
}
