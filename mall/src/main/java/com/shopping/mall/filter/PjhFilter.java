package com.shopping.mall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.shopping.mall.dto.PjhMemberDto;

public class PjhFilter implements Filter {
	
	private String[] arrPath = {
			"/myaccount.action",
			"/mycart.action",
			"/mycart/addproduct.action",
			"/myorder/orderlist.action"
									};
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String url = request.getServletPath();
		
		System.out.println("필터들어옴 url : " + url);
		
		//배역에 있는 주소인지 검색
		boolean goToLogin = false;
		for(String path : arrPath) {
			if(url.equals(path)) {
				goToLogin = true;
				break;
			}
		}
		
		//세션가져오기
		HttpSession httpSession = request.getSession();
		PjhMemberDto session = (PjhMemberDto) httpSession.getAttribute("session");
		
		//로그인 필요한데 세션이 null이면
		if(goToLogin && session == null) {
			
			System.out.println("널");
			
			response.sendRedirect("/mall/myaccount/login.action");			
		} else{
			//계속진행
			chain.doFilter(req, resp);
		}
	}
	
	@Override
	public void destroy() {}

}
