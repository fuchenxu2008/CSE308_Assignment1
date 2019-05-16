package com.accenture.util.exception;

@SuppressWarnings("serial")
public abstract class AbstractRuntimeException extends RuntimeException
		implements ErrorAware, UniqueIdAware {

	private PaasError error;
	private String uniqueId;

	/**
	 * Defined as private to force the creation of Exceptions using Error as
	 * parameter
	 */
	@SuppressWarnings("unused")
	private AbstractRuntimeException() {

	}

	/**
	 * AbstractRuntimeException constructor
	 * 
	 * @param error
	 *            instance of Error representing the condition that triggered
	 *            the creation of the exception
	 */
	public AbstractRuntimeException(PaasError error) {
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
	public AbstractRuntimeException(PaasError error, String message) {
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
	public AbstractRuntimeException(PaasError error, Throwable cause) {
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
	public AbstractRuntimeException(PaasError error, String message,
			Throwable cause) {
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
