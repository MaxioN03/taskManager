package com.bsuir.dao.resourceFactory;


import com.bsuir.dao.entity.Task;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class XMLResource implements Resource {

    public List getResource(String type) {

        switch (type.toLowerCase()) {
            case "task":
                return getTasks();
        }
        return null;
    }

    private List<Task> getTasks() {
        List<Task> result = new LinkedList<Task>();
        try {
            File inputFile = new File("E:\\Uchoba\\6\\ВДИШП\\lab12\\src\\main\\resources\\tasks.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("task");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    result.add(new Task(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()),
                            eElement.getElementsByTagName("projectName").item(0).getTextContent(),
                            eElement.getElementsByTagName("taskName").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("lab").item(0).getTextContent()),
                            Integer.parseInt(eElement.getElementsByTagName("resource").item(0).getTextContent()),
                            Integer.parseInt(eElement.getElementsByTagName("factLab").item(0).getTextContent()),
                            Integer.parseInt(eElement.getElementsByTagName("leftLab").item(0).getTextContent())));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
