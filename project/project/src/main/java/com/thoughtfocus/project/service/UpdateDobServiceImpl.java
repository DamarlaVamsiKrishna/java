package com.thoughtfocus.project.service;

import javax.naming.InvalidNameException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.project.controller.RegisterController;
import com.thoughtfocus.project.dto.UpdateDOBDTO;
import com.thoughtfocus.project.dto.UpdateDobByNameDTO;
import com.thoughtfocus.project.entity.DetailsEntity;
import com.thoughtfocus.project.repository.DetailsRepository;

@Service
public class UpdateDobServiceImpl implements UpdateDobService {

	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	DetailsRepository repository;

	@Override
	public DetailsEntity updateDobOfUser(UpdateDOBDTO dto) {
		try {
			// logger.info(dto.toString());
			DetailsEntity detailsEntity = repository.getByEmail(dto.getEmail());
			if (detailsEntity != null) {
				detailsEntity.setDob(dto.getDob());
				logger.info(detailsEntity.toString());
				repository.save(detailsEntity);
				return detailsEntity;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public DetailsEntity updateDobOfUserByName(UpdateDobByNameDTO dto) {
		try {
			logger.info(dto.getFirstName());
			DetailsEntity detailsEntity = repository.getByFirstName(dto.getFirstName());
			if (detailsEntity != null && dto.getDob() != "" && dto.getFirstName() != "") {
				detailsEntity.setDob(dto.getDob());
				repository.save(detailsEntity);
				return detailsEntity;
			} else {
				throw new InvalidNameException("Enter valid name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
