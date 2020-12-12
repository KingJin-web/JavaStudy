package D1201.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/upload.s")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setHeader("content-type", "text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        Part part = req.getPart("headimg");
        String cd = part.getHeader("Content-Disposition");
        String filename = cd.substring(cd.lastIndexOf("=") + 2, cd.length() - 1);
        String webPath = "/headimgs/" + filename;
        ServletContext sc = req.getServletContext();

        String diskPath = sc.getRealPath(webPath);
        System.out.println(diskPath);
        part.write(diskPath);

        webPath = sc.getContextPath() + webPath;

        resp.getWriter().append(webPath);


    }
}
