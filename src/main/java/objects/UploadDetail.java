package objects;

import java.io.Serializable;

public class UploadDetail implements Serializable {

    private long fileSize;
    private String fileName;
    private String uploadStatus;

    public long getFileSize() {
        return fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public String getUploadStatus() {
        return uploadStatus;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    @Override
    public String toString() {
        return "objects.UploadDetail{" +
                "fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", uploadStatus='" + uploadStatus + '\'' +
                '}';
    }


}
