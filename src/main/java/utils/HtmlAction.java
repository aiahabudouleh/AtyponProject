package utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class HtmlAction {

    public static StringBuilder getHtmlArticle(String path) {

        BufferedReader reader = null;
        StringBuilder contentBuilder = null;

        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String str;

        try {
            contentBuilder = new StringBuilder();

            while ((str = reader.readLine()) != null) {
                contentBuilder.append(str + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return contentBuilder;
    }
}
