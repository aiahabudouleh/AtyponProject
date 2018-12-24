package objects;

public class ArticleMETA {

    private String DOI;
    private String publisherId;
    private String subject;
    private String articleTitle;
    private String autherName;
    private String surname;
    private String degree;

    class PublishDate {
        boolean epub;
        boolean ppub;
        int month;
        int year;
    }


    private int volume;
    private int issue;
    private String issueTitle;

    private int fpage;
    private int lpage;

    class Permession {
        String copyRightStatement;
        int copyRightYear;
        String copyRightHolder;
        String contentType;
    }

    class SelfURI {
        String contentType;
        String xlink;
    }

    //This is for me till now
    private String articlaPath;

}
