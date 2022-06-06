package InjectionXML;


import Ddao.IDao;
import metier.Imetier;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ConfigurationXML {
    private String nomfile;
    public ConfigurationXML(String nomfile) {
        this.nomfile = nomfile;
    }
    public String getNomfile() {
        return nomfile;
    }
    public void setNomfile(String nomfile) {
        this.nomfile = nomfile;
    }
    public String gestClassDao() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new File(nomfile));
        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName("fremwoerk");
        String firstname = null;
        for (int temp = 0; temp < list.getLength(); temp++) {

            Node node = list.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;

                firstname = element.getElementsByTagName("dao").item(0).getTextContent();

            }
        }
        return firstname;
    }

    public String gestClassMetier() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new File(nomfile));

        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName("fremwoerk");
        String metier = null;
        for (int temp = 0; temp < list.getLength(); temp++) {

            Node node = list.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;
                metier = element.getElementsByTagName("metier").item(0).getTextContent();
            }
        }
        return metier;
    }
public Imetier getClasse() throws InstantiationException, IllegalAccessException, ParserConfigurationException, IOException, SAXException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
    Class cDao=Class.forName(gestClassDao());
    IDao dao=(IDao) cDao.newInstance();
    Class cmetier=Class.forName(gestClassMetier());
    Imetier metier= (Imetier) cmetier.newInstance();
    Method method=cmetier.getMethod("setDao",IDao.class);
    method.invoke(metier,dao);
    return  metier;

}
}
