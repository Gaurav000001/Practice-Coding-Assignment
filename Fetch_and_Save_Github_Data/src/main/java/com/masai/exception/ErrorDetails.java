package com.masai.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetails {
	
	private String uri;
	private String error;
	private Integer errorCode;
	private String message;
}
