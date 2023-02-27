package com.mantvydas.exambackend.exception;

public class ClientValidationException extends RuntimeException{
	
	private static final long serialVersionUID = 3788211805372059083L;
	private String field;
    private String error;

    private String rejectedValue;
    
    public ClientValidationException() {
    	
    }

	public ClientValidationException(String field, String error, String rejectedValue) {
		super();
		this.field = field;
		this.error = error;
		this.rejectedValue = rejectedValue;
	}

	public String getField() {
		return field;
	}

	public String getError() {
		return error;
	}

	public String getRejectedValue() {
		return rejectedValue;
	}
}