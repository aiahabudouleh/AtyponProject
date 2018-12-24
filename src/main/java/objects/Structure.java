package objects;

public class Structure {

    public String journal;
    public String issue;
    public String doi;
    public String path;
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournal() {
        return journal;
    }

    public String getIssue() {
        return issue;
    }

    public String getDoi() {
        return doi;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public Structure(String journal, String issue, String doi) {
        this.journal = journal;
        this.issue = issue;
        this.doi = doi;
    }

    public Structure(String journal, String issue, String title, String path) {
        this.journal = journal;
        this.issue = issue;
        this.title = title;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Structure(String journal, String issue) {
        this.journal = journal;
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Structure{" +
                "journal='" + journal + '\'' +
                ", issue='" + issue + '\'' +
                ", doi='" + doi + '\'' +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
