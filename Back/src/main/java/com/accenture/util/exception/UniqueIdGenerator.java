package com.accenture.util.exception;

import java.util.UUID;

/**
 * Unique ID generator based on java.util.UUID
 * 
 * @author gautam.pal
 * 
 */
public final class UniqueIdGenerator {

	private UniqueIdGenerator() {

	}

	/**
	 * Static factory to retrieve a type 4 (pseudo randomly generated) UUID. The
	 * UUID is generated using a cryptographically strong pseudo random number
	 * generator.
	 * 
	 * @see java.util.UUID
	 * @return String representing uniqueId
	 */
	public static String generateId() {
		return UUID.randomUUID().toString();
	}

}
