package servlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Descriptiond servlet3.0 demo
 * @Author jianlin
 * @DateTime 2020/8/16 19:43
 **/
//servlet注解
@WebServlet(
        name = "annotationServlet", //servlet的名称，没有指定，则默认使用类的全限定名
        //value = "",等价于urlPatterns，不能同时使用
        urlPatterns = "/annotation", //一组servlet的url匹配模式
        loadOnStartup = -1, //servlet的加载顺序，默认为-1
        asyncSupported = false, //是否支持异步操作方式，默认为false
        description = "这是注解版本的servlet",//描述信息
        displayName = "annotationServlet", //servlet的显示名，通常配合工具使用
        initParams = { @WebInitParam(name = "userName", value = "zhangsan"), @WebInitParam(name = "age", value = "18") } //初始化参数
)
public class AnnotationServletDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = this.getInitParameter("userName");
        String age = this.getInitParameter("age");
        PrintWriter writer = resp.getWriter();
        writer.println("hello servlet!!"+userName+","+age);
        writer.flush();
        writer.close();
    }
}
