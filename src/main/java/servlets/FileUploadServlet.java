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

@WebServlet(name = "servlets.FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 100, maxFileSize = 1024 * 1024 * 300, maxRequestSize = 1024 * 1024 * 500)

public class FileUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (request.getParameter("Submit") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("admin/admin.jsp");
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


        /**
         * Processing on the uploaded files
         * */
        Handler Handler = new Handler();
        for (UploadDetail file : fileList) {
            System.out.println("Start handler "+file);
            Handler.fileHandler(file.getFileName());
            System.out.println("Done handler ");
        }

        System.out.println("Dont handler ");

        request.setAttribute("uploadedFiles", fileList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/fileUploadResponse.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /***** Helper Method #1 - This Method Is Used To Read The File Names *****/
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