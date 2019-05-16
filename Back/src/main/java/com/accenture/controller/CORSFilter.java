package com.accenture.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter {

	protected static final Logger logger = LoggerFactory
			.getLogger(CORSFilter.class);
	private static final String REQUEST_PREFIX = "Request: ";
	private static final String RESPONSE_PREFIX = "Response: ";
	private AtomicLong id = new AtomicLong();

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, final FilterChain filterChain)
			throws ServletException, IOException {

		if (logger.isDebugEnabled()) {
			// long requestId = id.incrementAndGet();
			// request = new RequestWrapper(requestId, request);
			// response = new ResponseWrapper(requestId, response);
		}

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods",
				"POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader(
				"Access-Control-Allow-Headers",
				"origin, content-type, accept,x-websocket-protocol,x-websocket-version,x-websocket-extensions,authorization,user-token");

		response.setHeader("Access-Control-Allow-Credentials", "true");
		filterChain.doFilter(request, response);
		// response.flushBuffer();

	}

}
