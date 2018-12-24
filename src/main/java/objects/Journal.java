package objects;

import java.io.File;

public class Journal {

    public String journalName;
    public String publisherName;
    public String publisherLocation;
    public String publisherId;
    public String userName;
    public String issnPpub;
    public String issnEpub;

    public String getJournalName() {
        return journalName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getPublisherLocation() {
        return publisherLocation;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public String getUserName() {
        return userName;
    }

    public String getIssnPpub() {
        return issnPpub;
    }

    public String getIssnEpub() {
        return issnEpub;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public void setPublisherLocation(String publisherLocation) {
        this.publisherLocation = publisherLocation;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIssnPpub(String issnPpub) {
        this.issnPpub = issnPpub;
    }

    public void setIssnEpub(String issnEpub) {
        this.issnEpub = issnEpub;
    }

    public void createJournalDirectory(String journalPAth) {

        File newJournal = new File(journalPAth + File.separator + journalName);

        if (!newJournal.exists()) newJournal.mkdirs();
        else {
            System.out.println("Already exist !!!! ");
        }


    }

    public Journal(String journalName, String publisherName, String publisherLocation, String publisherId, String userName, String issnPpub, String issnEpub) {
        this.journalName = journalName;
        this.publisherName = publisherName;
        this.publisherLocation = publisherLocation;
        this.publisherId = publisherId;
        this.userName = userName;
        this.issnPpub = issnPpub;
        this.issnEpub = issnEpub;
    }

    public Journal() {
    }
}
