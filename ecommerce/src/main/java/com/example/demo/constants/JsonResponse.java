package com.example.demo.constants;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class JsonResponse {
	
	public JsonResponse() {
		
	}
	
	public JsonResponse(HttpStatus statusCode, String result, String message) {
		super();
		this.statusCode = statusCode;
		this.result = result;
		Message = message;
	}

	private HttpStatus statusCode;
	
	private String result;
	
	private String Message;

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	

}