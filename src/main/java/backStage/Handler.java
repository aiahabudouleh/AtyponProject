package backStage;

import DAO.ArticlesDAO;
import utils.*;
import objects.Structure;

import java.io.File;

public class Handler {

    /*****  Define The Absolute Paths for working areas*****/
    private static final String APPLICATION_PATH = "/home/ayaabudoleh/IdeaProjects/AtyponProject/";
    private static final String CACHED_PATH = APPLICATION_PATH +"uploadedFilesCache";
    private static final String UN_PROCESSED_PATH = APPLICATION_PATH+"unProcessedFiles";
    private static final String PROCESSED_PATH = APPLICATION_PATH+"processedFiles";
    private static final String JATS_PATH = "/home/ayaabudoleh/Backstage/JATS_HTML";
    private static final String toHTML_XSLPATH=JATS_PATH+File.separator+"toHTML.xsl";

    public static void builder(){
        createDirectory(CACHED_PATH);
        createDirectory(UN_PROCESSED_PATH);
        createDirectory(PROCESSED_PATH);
    }

    public void fileHandler (String filename){

        String fileInChachPath=CACHED_PATH+File.separator+filename;
        UnzipFile.unzip(fileInChachPath,UN_PROCESSED_PATH);

        /***** Remove issue and mainfes.xml from unProcessedFiles *****/
        RemoveFile.deleteFile(UN_PROCESSED_PATH, "manifest.xml");
        RemoveFile.deleteFile(UN_PROCESSED_PATH, "issue-files");

        /***** Get AA xml file path *****/
        String uploadedArticleXML = FindFile.findXML(UN_PROCESSED_PATH);
        String uploadedArticlePdf=FindFile.findPDF(UN_PROCESSED_PATH);

        /******** Get AA file name ********/
        File filetemp = new File(uploadedArticleXML);

        /******** Copy AA xml file to JATSFiles for processing ********/
        Copy.copyFile(uploadedArticleXML, JATS_PATH);

        /******** Find ARTICLE structure ********/
        String articleXMLPathProcessing=JATS_PATH+File.separator+filetemp.getName();
        System.out.println(" Article xml : "+articleXMLPathProcessing);

        Structure articleStructure= XMLParsing.findStructure(articleXMLPathProcessing);
        System.out.println("************************* Article Structure : "+articleStructure);

        /******** Create journal folder in processed directory ********/
        String journalPath=PROCESSED_PATH+File.separator+articleStructure.getJournal();
        createDirectory(journalPath);

        /******** Create issue folder in journal directory ********/
        String issuePath=journalPath+File.separator+articleStructure.getIssue();

        /******** Create AA folder in journal directory ********/
        String processedArticlePath=issuePath+File.separator+articleStructure.getDoi();

        /******** Copy AA xml file to AA directory for storing ********/
        Copy.copyFile(uploadedArticleXML, processedArticlePath);
        Copy.copyFile(uploadedArticlePdf, processedArticlePath);

        /******** Parsing XML to HTML ********/
        String htmlPath=processedArticlePath+File.separator+"article.html";
        articleStructure.setPath(htmlPath);
        String articleXMLInProcessing=JATS_PATH+File.separator+filetemp.getName();
        XMLParsing.toHTML(toHTML_XSLPATH,articleXMLPathProcessing ,htmlPath);


        /******** Parsing XML to info ********/
        XMLParsing.generateInfoFile(processedArticlePath);

        /******** Removing AA XML from JATS directory ********/
        RemoveFile.deleteFile(JATS_PATH,filetemp.getName());

        /******** Removing AA folder from unProcessed directory ********/
        RemoveFile.deleteFile(UN_PROCESSED_PATH,filetemp.getParentFile().getParentFile().getName());

        /******** Add AA to database ********/
        ArticlesDAO.insertArticle(articleStructure,processedArticlePath);


    }

    private static void createDirectory(String path){
        File Directory = new File(path);
        if (Directory.exists() == false) {
            Directory.mkdirs();
        }
    }

    public static String getCachedPath() {
        return CACHED_PATH;
    }
}
