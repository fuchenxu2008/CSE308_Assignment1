/**
 * 
 */
package com.accenture.util.exception;

/**
 * @author gautam.pal
 *
 */
public class ApiException extends AbstractRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8179611017801778L;

	public static final PaasError INTERNAL_SERVER_ERROR = new PaasError(
			"INTERNAL_SERVER_ERROR");

	public static final PaasError BAD_REQUEST = new PaasError("BAD_REQUEST");

	public static final PaasError PRECONDITION_FAILED = new PaasError(
			"PRECONDITION_FAILED");

	public static final PaasError UNSUPPORTED_MEDIA_TYPE = new PaasError(
			"UNSUPPORTED_MEDIA_TYPE");

	public static final PaasError SERVICE_UNAVAILABLE = new PaasError(
			"SERVICE_UNAVAILABLE");

	public static final PaasError REQUEST_TIMEOUT = new PaasError(
			"REQUEST_TIMEOUT");

	public static final PaasError CONFIGURATION_EXCEPTION = new PaasError(
			"CONFIGURATION_EXCEPTION");

	public static final PaasError RETRIEVE_FAILED = new PaasError(
			"RETRIVE_FAILED");

	public static final PaasError UPDATE_FAILED = new PaasError("UPDATE_FAILED");

	public static final PaasError DELETE_FAILED = new PaasError("DELETE_FAILED");

	/**
	 * @param error
	 */
	public ApiException(PaasError error) {
		super(error);
	}

	/**
	 * @param error
	 * @param message
	 */
	public ApiException(PaasError error, String message) {
		super(error, message);
	}

	/**
	 * @param error
	 * @param cause
	 */
	public ApiException(PaasError error, Throwable cause) {
		super(error, cause);
	}

	/**
	 * @param error
	 * @param message
	 * @param cause
	 */
	public ApiException(PaasError error, String message, Throwable cause) {
		super(error, message, cause);
	}

}
