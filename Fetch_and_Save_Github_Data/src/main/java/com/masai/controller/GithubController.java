package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.GithubDataEntity;
import com.masai.service.GithubService;

@RestController
public class GithubController {
	
	@Autowired
	private GithubService githubService;
	
	@GetMapping("/api/github")
	public ResponseEntity<String> fetchAndSaveGithubDataHandler(@RequestParam String username){
		return new ResponseEntity<>(githubService.getUserDataByUsername(username), HttpStatus.OK);
	}
	
	@GetMapping("/api/github/{id}")
	public ResponseEntity<GithubDataEntity> getGitHubDataById(@PathVariable Long id) {
	    // Implementation here
	    return ResponseEntity.ok(githubService.fetchedGitHubData(id));
	}
}
