package com.mikro.test.service;

import java.util.List;

import com.mikro.test.model.Phonebook;

public interface PhonebookService {

	void addPhonebook(Phonebook phonebook);

	void addOrUpdatePhonebook(Phonebook phonebook);

	void updatePhonebook(Phonebook phonebook);

	Phonebook getPhonebookByPk(Long phonebookId);

	Phonebook getPhonebookByPhoneNumber(String phoneNumber);

	List<Phonebook> getAllPhonebook();

	List<Phonebook> getAllPhonebookPaginated(int pageSize, int pageNumber);

	void deletePhonebook(Long phonebookId);
	
}
