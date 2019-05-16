package com.accenture.util.exception;

/**
 * User Defined Exception caused when database connectivity is lost
 * 
 * @author gautam.pal
 *
 */
public class ItemRetrievalException extends AbstractException {

	public static final PaasError ITEM_RETRIEVAL_EXCEPTION = new PaasError(
			"paas.apibase.error7");
	private static final long serialVersionUID = 2835667310687080580L;

	/**
	 * @param error
	 */
	public ItemRetrievalException(final PaasError error) {
		super(error);

	}

	/**
	 * @param error
	 * @param message
	 */
	public ItemRetrievalException(final PaasError error, final String message) {
		super(error, message);

	}

	/**
	 * @param error
	 * @param message
	 * @param cause
	 */
	public ItemRetrievalException(final PaasError error, final String message,
			final Throwable cause) {
		super(error, message, cause);

	}

	/**
	 * @param error
	 * @param cause
	 */
	public ItemRetrievalException(final PaasError error, final Throwable cause) {
		super(error, cause);

	}

}
