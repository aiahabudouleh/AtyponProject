<%@ page import="java.util.List" %>
<%@ page import="objects.UploadDetail" %><%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 11/8/18
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="/error.jsp" %>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
    th, td {
        padding: 15px;
    }
</style>

<html>
<head>
    <title>uploaded file details</title>
</head>
<body>
<br>
<br>
<div>
    <i>File Upload Status</i>
    <br>
    <br>
    <table>
        <thead>
        <tr align="center">
            <td><i>File name</i></td>
            <td><i>File size</i></td>
            <td><i>Upload status</i></td>
        </tr>
        </thead>

        <tbody>
        <% List<UploadDetail> uploadDetails = (List<UploadDetail>) request.getAttribute("uploadedFiles");
            for (int i = 0; i < uploadDetails.size(); ++i) {
        %>
        <tr>
            <td align="center"><span id="fileName"><%=uploadDetails.get(i).getFileName() %></span></td>
            <td align="center"><span id="fileSize"><%=uploadDetails.get(i).getFileSize() %> KB</span></td>
            <td align="center"><span id="fileuploadStatus"><%=uploadDetails.get(i).getUploadStatus() %></span></td>

        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<br>
<a href="admin/admin.jsp"> <i> Publisher-Page </i></a>

</body>
</html>
