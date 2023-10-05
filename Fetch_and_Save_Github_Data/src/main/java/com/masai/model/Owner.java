package com.masai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Owner {
	
	@Id
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String avatar_url;
	private String html_url;
	private String type;
	private Boolean site_admin;
}
