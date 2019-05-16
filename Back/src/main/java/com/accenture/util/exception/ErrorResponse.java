package com.accenture.util.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * The Class ResponseMessage.
 */
@JsonRootName(value = "response_message")
public class ErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1597272760896097436L;

	/**
	 * The message.
	 */
	private String message;

	public ErrorResponse() {

	}

	/**
	 * Instantiates a new response message.
	 * 
	 * @param msg
	 *            the message
	 */
	public ErrorResponse(String message) {
		this.message = message;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 * 
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return contained message
	 */
	public String toString() {
		return message;
	}

}
