package com.dleague.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.dleague.common.wrapper.MultipartWrapper;

/**
 * Servlet Filter implementation class EncryptFilter
 */
@WebFilter(servletNames = { 
		"MemberLoginServlet", 
		"MemberEnrollEndServlet" 
		//"MemberUpdateServlet"
		,"MemberUpdatePasswordEndServlet"
})
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//암호화처리
		HttpServletRequest httpReq = (HttpServletRequest)request;
		//암호화래퍼객체 생성
		MultipartWrapper encWrapper = new MultipartWrapper(httpReq);
	
		System.out.println("[암호화처리됨@EncryptFilter]");
		// pass the request along the filter chain
		chain.doFilter(encWrapper, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
