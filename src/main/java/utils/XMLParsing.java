package utils;

import objects.Structure;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class XMLParsing {

    static org.jdom2.Element root = null;

    private static HashMap<String, String> nodeValue = new HashMap<String, String>();

    /**
     * @param xslPath
     * @param xmlPath
     * @param htmlPath
     */
    public static void toHTML(String xslPath, String xmlPath, String htmlPath) {

        TransformerFactory tFactory = TransformerFactory.newInstance();

        Transformer transformer = null;

        try {
            transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource(xslPath));

        } catch (Exception e) {
            System.out.println("Error : new transformer xsl path");
            System.out.println(e.getMessage());
        }


        try {
            transformer.transform(new javax.xml.transform.stream.StreamSource(xmlPath), new javax.xml.transform.stream.StreamResult(new FileOutputStream(htmlPath)));
        } catch (Exception e) {
            System.out.println("Error : new transformer xml to html");
        }

    }

    /**
     * @param path
     */
    public static Structure findStructure(String path) {

        parsing(path);
        String journalTitle = nodeValue.get("journal-title");
        String articleIssue = nodeValue.get("issue");
        String articleDOI = root.getChild("front").getChild("article-meta").getChildText("article-id");
        String articleTitle = nodeValue.get("article-title");

        System.out.println("Article DOI : "+articleDOI);
        System.out.println("Article title: "+articleTitle);

        Structure structure=new Structure(journalTitle,articleIssue);
        structure.setDoi(articleDOI);
        structure.setIssue(articleIssue);
        structure.setTitle(articleTitle);
        return structure;
    }

    /**
     * @param path
     */
    private static void parsing(String path) {
        SAXBuilder builder = new SAXBuilder();
        Document xmlReader = null;
        try {
            //*** Must be in JATS Folder***//
            xmlReader = builder.build(new File(path));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error : can't open xml file");
        }


        root = xmlReader.getRootElement();
        Stack<org.jdom2.Element> nodeStack = new Stack<org.jdom2.Element>();


        nodeStack.push(root);

        while (true) {

            if (nodeStack.empty()) break;

            org.jdom2.Element currentElement = nodeStack.pop();
            List<org.jdom2.Element> elementList = currentElement.getChildren();
            Element thisElement = null;
            int length = elementList.size();

            for (int indx = 0; indx < length; ++indx) {
                thisElement = elementList.get(indx);
                nodeStack.push(thisElement);
                nodeValue.put(thisElement.getName(), thisElement.getText());
            }

        }
    }

    /**
     * @param path
     */
    public static void generateInfoFile(String path) {

        Document infoDocument = new Document();

        Element root = new Element("info");
        Element entry = new Element("entry");
        Element permissions = new Element("permissions");
        Element titleGroup = new Element("title-group");

        Element publisher = new Element("publisher");
        publisher.setText(nodeValue.get("publisher-name"));

        Element source = new Element("source");
        source.setText(nodeValue.get("source"));

        Element epubdate = new Element("epubdate");
        Element volume = new Element("volume");
        Element issue = new Element("issue");
        Element fpage = new Element("fpage");
        Element lpage = new Element("lpage");

        Element copyrightStatement = new Element("copyright-statement");
        copyrightStatement.setText(nodeValue.get("copyright-statement"));

        Element articleTitle = new Element("article-title");
        articleTitle.setText(nodeValue.get("article-title"));

        Element year = new Element("year");
        year.setText(nodeValue.get("year"));

        Element month = new Element("month");
        month.setText(nodeValue.get("month"));

        Element day = new Element("day");
        day.setText(nodeValue.get("day"));


        infoDocument.setRootElement(root);

        root.addContent(entry);
        entry.addContent(permissions);
        permissions.addContent(copyrightStatement);
        entry.addContent(titleGroup);
        titleGroup.addContent(articleTitle);
        entry.addContent(publisher);
        entry.addContent(source);
        entry.addContent(epubdate);
        epubdate.addContent(year);
        epubdate.addContent(month);
        epubdate.addContent(day);

        entry.addContent(volume);
        volume.setText(nodeValue.get("volum"));

        entry.addContent(issue);
        issue.setText(nodeValue.get("issue"));

        entry.addContent(fpage);
        fpage.setText(nodeValue.get("fpage"));

        entry.addContent(lpage);
        lpage.addContent("lpage");

        XMLOutputter xmlOutputter = new XMLOutputter(Format.getCompactFormat().getPrettyFormat());

        try {
            xmlOutputter.output(infoDocument, new FileOutputStream(new File(path + File.separator + "info.xml")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Done writing xml");
    }

}
