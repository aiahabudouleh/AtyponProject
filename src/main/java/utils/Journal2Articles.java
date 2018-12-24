package utils;

import DAO.ArticlesDAO;
import objects.Structure;

import java.util.ArrayList;
import java.util.HashMap;

public class Journal2Articles {


    public static HashMap<String, ArrayList<String>> mapJ2A() {

        HashMap<String, ArrayList<String>> j2a = new HashMap<>();

        ArrayList<Structure> articles = ArticlesDAO.listArticles();

        int length = articles.size();

        for (int i = 0; i < length; ++i) {
            Structure article = articles.get(i);
            ArrayList<String> list;
            if (j2a.get(article.getJournal()) != null) list = j2a.get(article.getJournal());
            else list = new ArrayList<String>();

            list.add(article.getTitle());

            j2a.put(article.getJournal(), list);
        }
        return j2a;
    }

}
