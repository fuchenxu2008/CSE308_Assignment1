package com.accenture.util.exception;

/**
 * User Defined Exception caused when database connectivity is lost
 * 
 * @author
 *
 */
public class ItemCreateException extends AbstractException {

	public static final PaasError ITEM_TRACKING_DATA_ALREADY_AVAILABLE = new PaasError(
			"paas.apibase.error1");
	public static final PaasError MISSING_REQUIRED_FIELD = new PaasError(
			"paas.apibase.error4");
	public static final PaasError ITEM_ID_ALREADY_EXISTS = new PaasError(
			"paas.apibase.error5");

	public static final PaasError CREATE_FAILED = new PaasError(
			"paas.apibase.error4");

	public static String ALREADY_EXISTS = "Name Already Exsists";
	private static final long serialVersionUID = 2835667310687080580L;

	/**
	 * @param error
	 */
	public ItemCreateException(final PaasError error) {
		super(error);

	}

	/**
	 * @param error
	 * @param message
	 */
	public ItemCreateException(final PaasError error, final String message) {
		super(error, message);

	}

	/**
	 * @param error
	 * @param message
	 * @param cause
	 */
	public ItemCreateException(final PaasError error, final String message,
			final Throwable cause) {
		super(error, message, cause);

	}

	/**
	 * @param error
	 * @param cause
	 */
	public ItemCreateException(final PaasError error, final Throwable cause) {
		super(error, cause);

	}

}
