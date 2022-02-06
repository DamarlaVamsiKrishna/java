package com.thoughtfocus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thoughtfocus.project.entity.DetailsEntity;

public interface DetailsRepository extends JpaRepository<DetailsEntity, Integer> {
	public DetailsEntity getByEmail(String email);

	public DetailsEntity getByFirstName(String firstName);

	public DetailsEntity getByContact(long contact);

	public DetailsEntity getByEmailAndPassword(String email, String password);
}
