package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masai.model.GithubDataEntity;
import com.masai.repository.GithubDataEntityRepository;

@Service
public class GithubServiceImpl implements GithubService{
	
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private GithubDataEntityRepository githubDataEntityRepository;
    
    @Override
    public String getUserDataByUsername(String username) {
    	String GITHUB_API_URL = "https://api.github.com/users/" + username + "/repos";
    	
    	GithubDataEntity[] githubDataEntityArray = restTemplate.getForObject(GITHUB_API_URL, GithubDataEntity[].class);
    	
    	for(GithubDataEntity githubDataEntity: githubDataEntityArray) {
    		if(githubDataEntityRepository.existsById(githubDataEntity.getId()) == false) githubDataEntityRepository.save(githubDataEntity);
    	}
        
        return "Data saved successfully!";
    }
    

	@Override
	public GithubDataEntity fetchedGitHubData(Long id) {
		if(githubDataEntityRepository.existsById(id) == false) throw new RuntimeException("Data Not Found");
		return githubDataEntityRepository.findById(id).get();
	}

}
