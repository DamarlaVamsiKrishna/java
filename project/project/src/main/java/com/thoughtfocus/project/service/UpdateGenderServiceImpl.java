package com.thoughtfocus.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.project.controller.RegisterController;
import com.thoughtfocus.project.dto.GenderContactDTO;
import com.thoughtfocus.project.entity.DetailsEntity;
import com.thoughtfocus.project.exception.InvalidDetailsException;
import com.thoughtfocus.project.repository.DetailsRepository;

@Service
public class UpdateGenderServiceImpl implements UpdateGenderService {

	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	DetailsRepository repository;

	@Override
	public DetailsEntity updateGenderByContact(GenderContactDTO dto) {
		try {
			DetailsEntity detailsEntity = repository.getByContact(dto.getContact());
			if (detailsEntity != null && dto.getGender() != "" && dto.getContact() > 99999) {
				detailsEntity.setGender(dto.getGender());
				repository.save(detailsEntity);
				return detailsEntity;
			} else {
				throw new InvalidDetailsException("enter valid details");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
