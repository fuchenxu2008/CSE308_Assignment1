package com.accenture.util.exception;

@SuppressWarnings("serial")
public abstract class AbstractException extends Exception implements
		ErrorAware, UniqueIdAware {

	private PaasError error;
	private String uniqueId;

	/**
	 * Defined as private to force the creation of Exceptions using Error as
	 * parameter
	 */
	@SuppressWarnings("unused")
	private AbstractException() {

	}

	/**
	 * AbstractRuntimeException constructor
	 * 
	 * @param error
	 *            instance of Error representing the condition that triggered
	 *            the creation of the exception
	 */
	public AbstractException(PaasError error) {
		this(error, null, null);
	}

	/**
	 * 
	 * AbstractRuntimeException constructor
	 * 
	 * @param error
	 *            instance of Error representing the condition that triggered
	 *            the creation of the exception
	 * @param message
	 *            developer comments providing additional contextual information
	 *            about the problem being reported
	 */
	public AbstractException(PaasError error, String message) {
		this(error, message, null);
	}

	/**
	 * 
	 * AbstractRuntimeException constructor
	 * 
	 * @param error
	 *            instance of Error representing the condition that triggered
	 *            the creation of the exception
	 * @param cause
	 *            original exception begin identified as the cause
	 */
	public AbstractException(PaasError error, Throwable cause) {
		this(error, null, cause);
	}

	/**
	 * 
	 * AbstractRuntimeException constructor
	 * 
	 * @param error
	 *            instance of Error representing the condition that triggered
	 *            the creation of the exception
	 * @param message
	 *            developer comments providing additional contextual information
	 *            about the problem being reported
	 * @param cause
	 *            original exception begin identified as the cause
	 */
	public AbstractException(PaasError error, String message, Throwable cause) {
		super(message, cause);
		if (error == null) {
			throw new IllegalArgumentException("Error can't null");
		}
		this.error = error;
		this.uniqueId = UniqueIdGenerator.generateId();
	}

	/**
	 * @return error code associated with the exception instance
	 */
	public PaasError getError() {
		return this.error;
	}

	/**
	 * @return unique id code associated with the exception instance
	 */
	public String getUniqueId() {
		return this.uniqueId;
	}

	/**
	 * @return returns a decorated string containing the data attributes
	 *         captured or generated as part of the exception
	 */
	@Override
	public String toString() {
		return "Exception: [error=" + this.error + ", uniqueId="
				+ this.uniqueId + ", message=" + getMessage() + ", cause="
				+ getCause() + "]";
	}

}
