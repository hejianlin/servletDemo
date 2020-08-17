package servlet3;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @Description 过滤器demo
 * @Author jianlin
 * @DateTime 2020/8/16 20:38
 **/
@WebFilter(
        filterName = "filterDemo", //过滤器名称，没有指定的话，默认使用全限制类名
        urlPatterns = "/*",  //url匹配
        initParams = {@WebInitParam(name = "className",value = "filer")}, //初始化参数
        dispatcherTypes = DispatcherType.REQUEST //转发器类型，默认REQUEST
        )
public class AnnotationFilterDemo implements Filter {

    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String className = filterConfig.getInitParameter("className");
        System.out.println("go to filer!"+className);
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("out of filer!");
    }

}
