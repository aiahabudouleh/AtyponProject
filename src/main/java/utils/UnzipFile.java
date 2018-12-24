package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipFile {

    private static int BUFFER_SIZE = 1024;

    /**
     * @param zipFilePath
     * @param destDir
     */
    public static void unzip(String zipFilePath, String destDir) {

        File directory = new File(destDir);

        if (!directory.exists()) directory.mkdirs();
        FileInputStream fileInputStream = null;
        byte[] buffer = new byte[BUFFER_SIZE];
        try {
            fileInputStream = new FileInputStream(zipFilePath);

        } catch (Exception e) {
            System.out.println("Error : Creating file input stream");
            System.out.println(e.toString());
        }
        ZipInputStream zipInputStream = null;
        try {
            zipInputStream = new ZipInputStream(fileInputStream);
        } catch (Exception e) {
            System.out.println("Error : creating zip input stream");
            System.out.println(e.toString());
        }
        ZipEntry zipEntry = null;
        FileOutputStream fileOutputStream = null;
        try {
            zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {

                String fileName = zipEntry.getName();
                File newFile = new File(destDir + File.separator + fileName);

                new File(newFile.getParent()).mkdirs();
                fileOutputStream = new FileOutputStream(newFile);

                int len = 0;
                while ((len = zipInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, len);
                }

                fileOutputStream.close();
                zipInputStream.closeEntry();
                zipEntry = zipInputStream.getNextEntry();
            }


            zipInputStream.closeEntry();
            zipInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Error: reading zip entry " + zipEntry.getName());
            System.out.println(e.getMessage());
        }
    }
}
