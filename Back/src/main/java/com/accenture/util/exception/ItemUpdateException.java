package com.accenture.util.exception;

/**
 * User Defined Exception caused when database connectivity is lost
 * 
 * @author
 *
 */
public class ItemUpdateException extends AbstractException {

	public static final PaasError UPDATE_FAILED_ERROR = new PaasError(
			"paas.apibase.error3");
	public static String UPDATE_FAILED = "Update Failed";
	private static final long serialVersionUID = 2835667310687080580L;

	/**
	 * @param error
	 */
	public ItemUpdateException(final PaasError error) {
		super(error);

	}

	/**
	 * @param error
	 * @param message
	 */
	public ItemUpdateException(final PaasError error, final String message) {
		super(error, message);

	}

	/**
	 * @param error
	 * @param message
	 * @param cause
	 */
	public ItemUpdateException(final PaasError error, final String message,
			final Throwable cause) {
		super(error, message, cause);

	}

	/**
	 * @param error
	 * @param cause
	 */
	public ItemUpdateException(final PaasError error, final Throwable cause) {
		super(error, cause);

	}

}
