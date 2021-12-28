package com.mikro.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mikro.test.dao.PhonebookDAO;
import com.mikro.test.model.Phonebook;
import com.mikro.test.service.PhonebookService;

@Service
@Transactional
public class PhonebookServiceImpl implements PhonebookService {
	
	@Autowired private PhonebookDAO phonebookDAO;

	@Override
	public void addPhonebook(Phonebook phonebook) {

		phonebookDAO.addPhonebook(phonebook);
	}

	@Override
	public void addOrUpdatePhonebook(Phonebook phonebook) {

		phonebookDAO.addOrUpdatePhonebook(phonebook);
	}

	@Override
	public void updatePhonebook(Phonebook phonebook) {

		phonebookDAO.updatePhonebook(phonebook);
	}

	@Override
	public Phonebook getPhonebookByPk(Long phonebookId) {

		return phonebookDAO.getPhonebookByPk(phonebookId);
	}

	@Override
	public Phonebook getPhonebookByPhoneNumber(String phoneNumber) {

		return phonebookDAO.getPhonebookByPhoneNumber(phoneNumber);
	}

	@Override
	public List<Phonebook> getAllPhonebook() {

		return phonebookDAO.getAllPhonebook();
	}

	@Override
	public List<Phonebook> getAllPhonebookPaginated(int pageSize, int pageNumber) {

		return phonebookDAO.getAllPhonebookPaginated(pageSize, pageNumber);
	}

	@Override
	public void deletePhonebook(Long phonebookId) {

		phonebookDAO.deletePhonebook(phonebookId);
	}

}
