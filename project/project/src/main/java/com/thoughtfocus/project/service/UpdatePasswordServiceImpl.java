package com.thoughtfocus.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtfocus.project.controller.RegisterController;
import com.thoughtfocus.project.dto.UpdatePasswordDTO;
import com.thoughtfocus.project.entity.DetailsEntity;
import com.thoughtfocus.project.exception.InvalidLengthException;
import com.thoughtfocus.project.exception.PasswordChangeException;
import com.thoughtfocus.project.repository.DetailsRepository;

@Service
public class UpdatePasswordServiceImpl implements UpdatePasswordService {
	static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	DetailsRepository repository;

	@Override
	public DetailsEntity UpdatePasswordByEmail(UpdatePasswordDTO dto) {
		try {
			if (dto.getEmail() != null && dto.getEmail() != "") {
				String mail = dto.getEmail();
				logger.info(mail);
				if (dto.getPassword().length() > 5) {
					DetailsEntity detailsEntity = repository.getByEmail(mail);
					detailsEntity.setPassword(dto.getPassword());
					repository.save(detailsEntity);
					return detailsEntity;
				} else {
					throw new InvalidLengthException("password length should be greaterthan 5");
				}

			} else {
				throw new PasswordChangeException("Enter valid email to change the password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
