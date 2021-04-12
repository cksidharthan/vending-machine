package com.machine.vending.helper;

import org.springframework.http.HttpStatus;

public class VendingAppResponse<E> {

	private HttpStatus statusCode;
	private String responseMessage;
	private E responsePayload;
	
	public VendingAppResponse() {
	}

	public VendingAppResponse(HttpStatus statusCode, String responseMessage, E responsePayload) {
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
		this.responsePayload = responsePayload;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public E getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(E responsePayload) {
		this.responsePayload = responsePayload;
	}

	@Override
	public String toString() {
		return "VendingAppResponse [responseMessage=" + responseMessage + "]";
	}
	
}
