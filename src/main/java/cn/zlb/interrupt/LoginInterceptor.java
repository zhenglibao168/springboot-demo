package cn.zlb.interrupt;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author libao.zheng
 * @date 2020/7/20 1:47 下午
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      // System.out.println("拦截器拦截到request path: " + request.getRequestURI());
        return true;
    }
}
