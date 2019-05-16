package com.accenture.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Format {

	private static ObjectMapper jsonMapper;

	/**
	 * Create a json mapper to convert from PlainOldJavaObjects to json strings.
	 * 
	 * @return
	 */
	public static ObjectMapper getApplicationJsonObjectMapper() {
		if (jsonMapper == null) {
			jsonMapper = new ObjectMapper();
			return jsonMapper;
		} else {
			return jsonMapper;
		}
	}

}
