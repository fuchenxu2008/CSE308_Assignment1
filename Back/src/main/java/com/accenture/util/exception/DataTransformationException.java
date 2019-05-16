/**
 * 
 */
package com.accenture.util.exception;

/**
 * @author gautam.pal
 *
 */
public class DataTransformationException extends AbstractException {

	public static final PaasError UNABLE_TO_UNMARSHALL = new PaasError(
			"TBD-001");
	public static final PaasError UNABLE_TO_MARSHALL = new PaasError("TBD-001");

	/**
	 * 
	 */
	private static final long serialVersionUID = 1111554958979480294L;

	/**
	 * @param error
	 */
	public DataTransformationException(PaasError error) {
		super(error);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param message
	 */
	public DataTransformationException(PaasError error, String message) {
		super(error, message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param cause
	 */
	public DataTransformationException(PaasError error, Throwable cause) {
		super(error, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param error
	 * @param message
	 * @param cause
	 */
	public DataTransformationException(PaasError error, String message,
			Throwable cause) {
		super(error, message, cause);
		// TODO Auto-generated constructor stub
	}

}
