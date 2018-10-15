package priv.mq.onePiece.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class IsLoginFilter extends OncePerRequestFilter {

	/* @author MaQuan
	 * @time 2017年9月25日 下午8:44:14
	 * @description : 拦截请求，若用户未登录，则不允许访问相应页面。
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//获取当前请求：
		String uri = request.getRequestURI();
		if(uri.contains("onePiece") && uri.contains("do")){
			boolean doFilter = true;
			//不拦截的请求列表：
			String[] notFilters = {"userValidation.do", "index.do", "login.do", "Figures.do", "signUp.do", "findPassword.do"};
			for(String notFilter: notFilters){
				if(uri.contains(notFilter)){
					doFilter = false;
				}
			}
			if(doFilter){
				//执行过滤
				//从Session中获取登录实体
				Object obj = request.getSession().getAttribute("user");
				if(obj == null){
					//若不存在实体，则跳到登录界面
					response.setCharacterEncoding("UTF-8");
					response.setHeader("Content-type", "text/html;charset=UTF-8");
					String loginPage = "/onePiece/login.do";
					StringBuilder builder = new StringBuilder();
					builder.append("<script charset=\"UTF-8\" type=\"text/javascript\">");
					builder.append("window.top.location.href='");
					builder.append(loginPage);
					builder.append("';");
					builder.append("</script>");
					response.getWriter().write(builder.toString());
					response.getWriter().close();
				}else{
					filterChain.doFilter(request, response);
				}
			}else{
				filterChain.doFilter(request, response);
			}
		}else{
			filterChain.doFilter(request, response);
		}
	}
}
