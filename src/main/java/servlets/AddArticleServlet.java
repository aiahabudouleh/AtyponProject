package servlets;

import backStage.Handler;
import objects.UploadDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddArticleServlet", urlPatterns = {"/addArticle"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 50)

public class AddArticleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("ADD") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("webAdmin/addArticle.jsp");
            rd.include(request, response);
        }

        Handler handler = new Handler();
        handler.builder();

        String fileName = "";

        UploadDetail uploadDetail = null;
        List<UploadDetail> fileList = new ArrayList<UploadDetail>();

        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            uploadDetail = new UploadDetail();
            uploadDetail.setFileName(fileName);
            uploadDetail.setFileSize(part.getSize() / 1024);
            uploadDetail.setUploadStatus("successful");
            try {
                part.write(Handler.getCachedPath() + File.separator + fileName);
            } catch (Exception e) {
                uploadDetail.setUploadStatus("Failure : " + e.getMessage());
            }
            fileList.add(uploadDetail);
        }


        /*
         * Processing on the uploaded files
         * */
        for (UploadDetail file : fileList) {
            Handler Handler = new Handler();
            Handler.fileHandler(file.getFileName());
        }

        String message = "Uploaded successfully";
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/webAdmin/actionResult.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    /***** Helper Method #1 - This Method Is Used To Read The File Names
     @param part
     *****/
    private String extractFileName(Part part) {
        String fileName = "",
                contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return fileName;
    }

}
