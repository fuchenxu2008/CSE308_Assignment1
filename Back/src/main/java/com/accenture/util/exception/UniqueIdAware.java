package com.accenture.util.exception;

/**
 * Interface intended to be used by PaaS exception type abstract classes. It
 * provides methods to access contextual information related to the exception.
 * 
 * @author gautam.pal
 * 
 */
public interface UniqueIdAware {

	/**
	 * 
	 * @return String representing an auto-generated uniqueId
	 */
	String getUniqueId();

}
