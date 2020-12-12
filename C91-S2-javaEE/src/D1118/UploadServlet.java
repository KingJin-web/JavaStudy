package D1118;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.lang.*;
/**
 * @MultipartConfig 文件上传注解
 * long maxFileSize() 单个文件最大大小
 * long maxRequestSize() 总大小限制
 * int fileSizeThreshold() 上传数量
 */
@WebServlet("/Upload.s")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10, fileSizeThreshold = 10)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //服务器接收中文乱码
        req.setCharacterEncoding("utf-8");
        //服务器发送中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        Part part = req.getPart("myFile"); //获取文件上传封装对象

        part.getSize();//获取文件大小
        System.out.println(part.getSize());
        System.out.println(part.getHeaderNames());

        String cd = part.getHeader("Content-Disposition");
        //截取不同类型的文件需要自行判断
        String filename = cd.substring(cd.lastIndexOf("=") + 2, cd.length() - 1);
        //part.getSubmittedFileName();//获取上传文件名
        //String path = "H:\\jetbrains\\java\\JavaEE-s2\\web\\AJAX\\文件上传\\";
        String path = "H:\\jetbrains\\java\\JavaEE-s2\\out\\" +
                "artifacts\\JavaEE_s2_war_exploded\\AJAX\\文件上传\\";
        path = req.getServletContext().getRealPath("/headimgs/");

        path = path + filename;
        part.write(path);
        Gson gson = new Gson();

        Map<String,String> data = new HashMap<>();
        data.put("msg","上传成功");
        data.put("path","/headimgs/" + filename);



//       part.write("D:/" + filename);
//       part.write(System.getProperty("user.dir") +"/"+ filename);

        resp.getWriter().append(gson.toJson(data));

    }
}
