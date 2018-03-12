package main.java.com.unico.auth.impl;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.filter.GenericFilterBean;

public class RestAuthFilter extends GenericFilterBean {
	
	public static final String AUTHENTICATION_HEADER = "Authorization";

	
	private RestAuthenticationImpl restAuth;
 
    @Override
    public void doFilter(
      ServletRequest request, 
      ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    	if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String authCredentials = httpServletRequest
					.getHeader(AUTHENTICATION_HEADER);
    	boolean authenticationStatus = false;
		try {
			authenticationStatus = restAuth.authenticate(authCredentials);
		} catch (Exception e) {
			System.err.println("Exception while decoding authentication credentials"+e.getMessage());
		}
    	if (authenticationStatus) {
    		chain.doFilter(request, response);
		} else {
			if (response instanceof HttpServletResponse) {
				HttpServletResponse httpServletResponse = (HttpServletResponse) response;
				httpServletResponse
						.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
	}
        
    }

    @Autowired
    @Qualifier("restAuth")
	public void setRestAuth(RestAuthenticationImpl restAuth) {
		this.restAuth = restAuth;
	}
}


