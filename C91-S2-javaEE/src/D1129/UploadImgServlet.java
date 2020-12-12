package D1129;

import com.google.gson.Gson;

import javax.servlet.ServletContext;
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

@WebServlet("/uploadImg.do")
@MultipartConfig
public class UploadImgServlet extends HttpServlet {
    private final Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");
        resp.setHeader("content-type", "text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        Part part = req.getPart("imgFile");
        ServletContext sc = req.getServletContext();
        String filename = part.getSubmittedFileName();
//        String cd = part.getHeader("Content-Disposition");
//        System.out.println(cd);
//        String filename = cd.substring(cd.lastIndexOf("=") + 2, cd.length() - 1);
        String webPath = "/Axios/" + filename;


        String diskPath = sc.getRealPath(webPath);
        System.out.println(diskPath);
        part.write(diskPath);
//        //getContextPath()获取当前工程名
//        webPath =  webPath;
//        System.out.println(webPath);
//        resp.getWriter().append(webPath);

        Map<String,String> data = new HashMap<>();
        data.put("msg","上传成功");
        data.put("path","Axios/" + filename);



//       part.write("D:/" + filename);
//       part.write(System.getProperty("user.dir") +"/"+ filename);

        resp.getWriter().append(gson.toJson(data));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
