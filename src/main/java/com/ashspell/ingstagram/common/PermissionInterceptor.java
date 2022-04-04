package com.ashspell.ingstagram.common;

	import java.io.IOException;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import org.springframework.stereotype.Component;
	import org.springframework.web.servlet.HandlerInterceptor;
	import org.springframework.web.servlet.ModelAndView;

	@Component
	public class PermissionInterceptor implements HandlerInterceptor {

		// 요청이 들어 올때 
		@Override
		public boolean preHandle(
				HttpServletRequest request, 
				HttpServletResponse response, 
				Object handler) throws IOException {
			
			// 로그인 여부 확인
			HttpSession session = request.getSession();
			
			
			String uri = request.getRequestURI();
			
			Integer userId = (Integer)session.getAttribute("userId");
			
			// 로그인이 안된상태 
			if(userId == null) {
				
				if(uri.startsWith("/ingstagram")) {
					// 로그인 화면으로 이동해라 
					response.sendRedirect("/ingstagram/signin_view");
					return false;
				}
				
			} else { 
				
				if(uri.startsWith("/ingstagram")) {
					// 리스트 화면으로 이동
					response.sendRedirect("/ingstagram/list");
					return false;
				}
				
			}
			
			return true;
		}
		
		@Override
		public void postHandle(
				HttpServletRequest reqeust,
				HttpServletResponse response,
				Object handler,
				ModelAndView modelAndView) {
			
		}
		
		@Override
		public void afterCompletion(
				HttpServletRequest request,
				HttpServletResponse response,
				Object handler,
				Exception ex) {
			
		}
		
		
}
