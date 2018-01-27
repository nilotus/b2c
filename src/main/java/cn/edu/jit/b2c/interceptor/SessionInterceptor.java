//package cn.edu.jit.b2c.interceptor;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by ChenQF on 2018/1/18.
// */
//public class SessionInterceptor implements HandlerInterceptor{
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        System.out.println("url=" + httpServletRequest.getRequestURI());
//        if(httpServletRequest.getRequestURI().contains("/**"))
//            return true;
//        Object obj = httpServletRequest.getSession().getAttribute("admin_now");
//        if(obj == null) {
//            httpServletResponse.sendRedirect("index.html");
//            return false;
//        }
//        return false;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//
//    }
//}
