package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class Copy {

    /**
     * @param source
     * @param destenation
     */
    public static void copyDirectory(String source, String destenation) {
        File srcDir = new File(source);
        File desDir = new File(destenation);

        try {
            FileUtils.copyDirectory(srcDir, desDir);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * @param source
     * @param destination
     */
    public static void copyFile(String source, String destination) {

        File srcFile = new File(source);
        File desFile = new File(destination + File.separator + srcFile.getName());

        try {
            FileUtils.copyFile(srcFile, desFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error : Can't copy files");
            System.out.println(e.getMessage());
        }

    }


}
