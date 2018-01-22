package cn.easybuy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/*"},filterName="EncodeFilter" ,initParams = {@WebInitParam(name = "encode", value = "utf-8")}) 
public class EncodeFilter implements Filter {
	private String encode=null;
	public void destroy() {
		encode=null;
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// 转型
		final HttpServletRequest request = (HttpServletRequest) req;    
		HttpServletResponse response = (HttpServletResponse) res;
		
		// 一、处理公用业务
		request.setCharacterEncoding("UTF-8");					// POST提交有效
		response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(request, response);		// 传入代理对象
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		String encode=filterConfig.getInitParameter("encode");		
		if(this.encode==null){
			this.encode=encode;
		}
	}
	
}
