package servlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description servlet3测试文件上传
 * @Author jianlin
 * @DateTime 2020/8/16 21:37
 **/
@WebServlet(urlPatterns = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //得到上传文件的目录
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(savePath);

        if(!file.exists() && !file.isDirectory()){
            System.out.println("目录不存在，需要创建");
            file.mkdirs();
        }

        //获取文件
        Part img = req.getPart("file");
        //文件全路径
        String filePath = file.getPath() + File.separator + img.getSubmittedFileName();
        //写入文件
        img.write(filePath);
        //在使用PrintWriter对象打印中文字符之前，先设置utf-8编码，否者会乱码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();
        writer.println("File upload:"+filePath);
    }
}
