package servlet4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;

/**
 * @Description TODO
 * @Author jianlin
 * @DateTime 2020/8/17 23:44
 **/
@WebServlet(urlPatterns = "/server")
public class ServerPushServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到PushBuilder对象
        PushBuilder pushBuilder = req.newPushBuilder();
        //指定推送的资源，并且进行推送
        pushBuilder.path("1.jpg").push();
    }
}
