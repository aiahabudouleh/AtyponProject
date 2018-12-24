package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.util.Collection;


public class FindFile {

    /**
     * @param path
     */
    public static String findXML(String path) {
        File file = new File(path);
        Collection<File> files = FileUtils.listFiles(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

        for (File instance : files) {
            if (instance.getName().endsWith(".xml")) return instance.getAbsolutePath();
        }

        return "none";
    }

    /**
     * @param path
     */
    public static String findPDF(String path) {
        File file = new File(path);
        Collection<File> files = FileUtils.listFiles(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

        for (File instance : files) {
            if (instance.getName().endsWith(".pdf")) return instance.getAbsolutePath();
        }

        return "none";
    }

}
