package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.GithubDataEntity;

@Repository
public interface GithubDataEntityRepository extends JpaRepository<GithubDataEntity, Long>{
	
	
}
