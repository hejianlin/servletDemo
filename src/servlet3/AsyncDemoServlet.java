package servlet3;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @Description servlet异步处理demo
 * @Author jianlin
 * @DateTime 2020/8/16 21:01
 **/
@WebServlet(urlPatterns = "/demo",asyncSupported = true)
public class AsyncDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("进入Servlet的时间："+new Date()+".");
        out.flush();

        //在子线程中执行业务调用，并由其负责输出响应，主线程退出
        //配置request属性，使其支持异步处理
        req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        AsyncContext asyncContext = req.startAsync();
        new Thread(new Executor(asyncContext)).start();

        out.println("结束Servlet的时间："+new Date()+".");
        out.flush();

    }
}

class Executor implements Runnable {

    private AsyncContext ctx = null;
    public Executor (AsyncContext ctx ){
        this.ctx = ctx;
    }

    @Override
    public void run() {

        try {
            //等待10秒，模拟业务方法的执行
            Thread.sleep(10000);
            PrintWriter out = ctx.getResponse().getWriter();
            out.println("业务处理完毕的时间："+ new Date()+".");
            out.flush();
            ctx.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
