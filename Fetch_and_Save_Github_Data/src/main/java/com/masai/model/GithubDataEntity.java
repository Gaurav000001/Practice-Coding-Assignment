package com.masai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "github_data")
public class GithubDataEntity {
	
	@Id
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String name;
	private String html_url;
	private String description;
	private String created_at;
	private Integer open_issues;
	private Integer watchers;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Owner owner;
}
