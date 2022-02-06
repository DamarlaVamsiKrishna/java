package com.thoughtfocus.project.service;

import com.thoughtfocus.project.dto.UpdateDOBDTO;
import com.thoughtfocus.project.dto.UpdateDobByNameDTO;
import com.thoughtfocus.project.entity.DetailsEntity;

public interface UpdateDobService {
	public DetailsEntity updateDobOfUser(UpdateDOBDTO dto);

	public DetailsEntity updateDobOfUserByName(UpdateDobByNameDTO dto);
}
