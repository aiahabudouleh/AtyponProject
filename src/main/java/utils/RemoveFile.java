package utils;

import java.io.File;

public class RemoveFile {

    public static void deleteFile(String path, String deletedFile) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File fileInstance : files) {

            if (fileInstance.getName().equals(deletedFile)) {
                if (fileInstance.isDirectory()) {
                    deleteDirectory(fileInstance.getPath());
                } else fileInstance.delete();

                System.out.println("File : " + deletedFile + "  Done.");

            } else if (fileInstance.isDirectory()) {
                deleteFile(fileInstance.getPath(), deletedFile);
            }
        }
    }


    private static void deleteDirectory(String path) {
        File file = new File(path);
        if (file.isDirectory() == false) {
            file.delete();
            return;
        }

        if (file.list().length == 0) {
            file.delete();
            return;
        }

        File[] files = file.listFiles();
        for (File instance : files) {
            if (instance.isDirectory()) deleteDirectory(instance.getPath());
            instance.delete();
        }

        file.delete();

    }

}
