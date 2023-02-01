package com.abc.demo.config.handler;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		ObjectMapper mapper = new ObjectMapper();
	    ObjectNode objNode1 = mapper.createObjectNode();
	    objNode1.put("error", "403");
	    
	    
	    response.setStatus(HttpServletResponse.SC_OK);
	    response.getWriter().write(objNode1.toString());
	    response.getWriter().flush();
	    response.getWriter().close();
		
	}

}
