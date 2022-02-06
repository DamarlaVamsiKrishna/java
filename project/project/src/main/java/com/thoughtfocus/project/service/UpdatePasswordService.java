package com.thoughtfocus.project.service;

import com.thoughtfocus.project.dto.UpdatePasswordDTO;
import com.thoughtfocus.project.entity.DetailsEntity;

public interface UpdatePasswordService {
	public DetailsEntity UpdatePasswordByEmail(UpdatePasswordDTO dto);
}
