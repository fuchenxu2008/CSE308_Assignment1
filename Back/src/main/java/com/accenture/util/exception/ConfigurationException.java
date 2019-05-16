/**
 * 
 */
package com.accenture.util.exception;

/**
 * @author gautam.pal
 *
 */
public class ConfigurationException extends AbstractRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2423373463792662349L;

	public static final PaasError CONFIGURATION_ATTRIBUTE_WRONG_VALUE = new PaasError(
			"paas.apibase.error2");

	/**
	 * @param error
	 */
	public ConfigurationException(PaasError error) {
		super(error);
	}

	/**
	 * @param error
	 * @param message
	 */
	public ConfigurationException(PaasError error, String message) {
		super(error, message);
	}

	/**
	 * @param error
	 * @param cause
	 */
	public ConfigurationException(PaasError error, Throwable cause) {
		super(error, cause);
	}

	/**
	 * @param error
	 * @param message
	 * @param cause
	 */
	public ConfigurationException(PaasError error, String message,
			Throwable cause) {
		super(error, message, cause);
	}

}
