package com.accenture.util.exception;

/**
 * User Defined Exception caused when database connectivity is lost
 * 
 * @author
 *
 */
public class ItemDeleteException extends AbstractException {

	public static final PaasError DELETE_FAILED = new PaasError(
			"paas.apibase.error6");
	private static final long serialVersionUID = 2835667310687080580L;

	/**
	 * @param error
	 */
	public ItemDeleteException(final PaasError error) {
		super(error);

	}

	/**
	 * @param error
	 * @param message
	 */
	public ItemDeleteException(final PaasError error, final String message) {
		super(error, message);

	}

	/**
	 * @param error
	 * @param message
	 * @param cause
	 */
	public ItemDeleteException(final PaasError error, final String message,
			final Throwable cause) {
		super(error, message, cause);

	}

	/**
	 * @param error
	 * @param cause
	 */
	public ItemDeleteException(final PaasError error, final Throwable cause) {
		super(error, cause);

	}

}
