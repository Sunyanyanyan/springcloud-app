package com.cn.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序
     * @return 返回值越小，优先级越高
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 是否执行run方法
     * true执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器逻辑
     * @return
     * @throws ZuulException
     * 返回值为null 不起作用
     */
    @Override
    public Object run() throws ZuulException {
        //初始化context上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isBlank(token)){
            //拦截,不转发请求
            context.setSendZuulResponse(false);
            //401 身份为认证
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置响应
            context.setResponseBody("request error");
        }
        return null;
    }
}
