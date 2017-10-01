package king.consierd.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 继承 ZuulFilter 重写其方法, 定义过滤规则
 *
 * @author 张红杰 13022800618
 * @version 1.0, 2017.10.1 10:21
 */
@Component
public class MyFilter extends ZuulFilter {

	/**
	 * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
	 *	 pre：路由之前
	 *	 routing：路由之时
	 *	 post： 路由之后
	 *	 error：发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤的顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 这里可以写逻辑判断, 是否要过滤, true表示永远过滤
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * run：过滤器的具体逻辑
	 * 可用很复杂, 包括查sql, nosql去判断该请求到底有没有权限访问
	 */
	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String token = request.getParameter("token");
		if (null == token) {
			try {
				context.setSendZuulResponse(false);
				context.setResponseStatusCode(401);
				context.getResponse().getWriter().write("token is null!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
