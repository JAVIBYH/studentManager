package com.yuan.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录过滤拦截器
 * @author hjw
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String uri = request.getRequestURI();
		System.out.println("进入拦截器，uri= "+uri);
		Object user = request.getSession().getAttribute("user");
		if(user == null){
			//表示未登录或者登录状态失效
			System.out.println("未登录或登录失效，uri = " + uri);
			//请求头中X-Requested-With: XMLHttpRequest 表示是ajax请求  
			//如果 X-Requested-With 为 null，则为同步请求。 如果 X-Requested-With 为 XMLHttpRequest 则为 Ajax异步请求。
			if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
				//ajax请求
				Map<String, String> ret = new HashMap<String, String>();
				ret.put("type", "error");
				ret.put("msg", "登录状态已失效，请重新去登录!");
				response.getWriter().write(JSONObject.fromObject(ret).toString());
				return false;
			}
			response.sendRedirect(request.getContextPath() + "/system/login");
			return false;
		}
		return true;
	}

}
