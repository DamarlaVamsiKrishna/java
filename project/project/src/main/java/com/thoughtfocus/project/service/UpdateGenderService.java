package com.thoughtfocus.project.service;

import com.thoughtfocus.project.dto.GenderContactDTO;
import com.thoughtfocus.project.entity.DetailsEntity;

public interface UpdateGenderService {
	public DetailsEntity updateGenderByContact(GenderContactDTO dto);
}
