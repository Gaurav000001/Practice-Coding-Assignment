package com.masai.service;

import com.masai.model.GithubDataEntity;

public interface GithubService {
	
	public String getUserDataByUsername(String username);
	
	public GithubDataEntity fetchedGitHubData(Long id);
}
