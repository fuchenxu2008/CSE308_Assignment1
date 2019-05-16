package com.accenture.util.exception;

import java.io.Serializable;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

/**
 * Type representing an error code. Error is MessageSourceAware so the
 * description of the error code will be pulled from property files using Spring
 * MessageSourceAware support.
 * 
 * @author gautam.pal
 * 
 */
@Component
public class PaasError implements Serializable, MessageSourceAware,
		InitializingBean {

	private static final Logger LOG = LoggerFactory.getLogger(PaasError.class);

	private static final Locale DEFAULT_ERROR_DICTIONARY_LOCAL = Locale.ENGLISH;
	public static final String UNKNOWN_DESCRIPTION = "UNKNOWN_DESCRIPTION: Error dictionary may not be propertly configured or errror code may not be defined on error dictioary.";

	private String code;
	private String description;

	@Autowired
	private static MessageSource messageSource;

	/**
	 * Empty constructor defined as private to force the creation of the object
	 * using an error code
	 */
	@SuppressWarnings("unused")
	private PaasError() {

	}

	/**
	 * 
	 * @param code
	 *            String representing error code
	 */
	public PaasError(String code) {

		if (code == null || code.isEmpty()) {
			throw new IllegalArgumentException(
					"Error code can't be null or empty");
		}
		this.code = code;
		this.description = UNKNOWN_DESCRIPTION;
		if (null != messageSource) {
			try {
				this.description = messageSource.getMessage(code, null,
						DEFAULT_ERROR_DICTIONARY_LOCAL);
			} catch (NoSuchMessageException e) {
				LOG.error("Unable to find error description on dictionary for error code:"
						+ code);
			}
		}

	}

	/**
	 * 
	 * @return String representing error code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return String representing the description for the error code
	 *         represented by the object
	 */
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Error: [code=" + code + ", description=" + description + "]";
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		PaasError.messageSource = messageSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.code == null) ? 0 : this.code.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PaasError other = (PaasError) obj;
		if (this.code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!this.code.equals(other.code)) {
			return false;
		}
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

}
