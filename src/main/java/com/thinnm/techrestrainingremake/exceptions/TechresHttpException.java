package com.thinnm.techrestrainingremake.exceptions;

import org.springframework.http.HttpStatus;

public class TechresHttpException extends BaseException{
	static final long serialVersionUID = -3387516993124229948L;
	private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
	private String errorMessage = HttpStatus.INTERNAL_SERVER_ERROR.toString();
	private Object data = null;
	
	public TechresHttpException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public TechresHttpException(HttpStatus httpStatus, String errorMessage) {
		super(errorMessage);
		this.httpStatus=httpStatus;
		this.errorMessage=errorMessage;
	}

	public TechresHttpException(String errorMessage, HttpStatus httpStatus, String errorMessage2, Object data) {
		super(errorMessage);
		this.httpStatus = httpStatus;
		errorMessage = errorMessage2;
		this.data = data;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
}
