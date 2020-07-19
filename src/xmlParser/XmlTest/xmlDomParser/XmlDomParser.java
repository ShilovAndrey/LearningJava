package xmlParser.XmlTest.xmlDomParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xerces.internal.jaxp.JAXPConstants.JAXP_SCHEMA_LANGUAGE;
import static com.sun.org.apache.xerces.internal.jaxp.JAXPConstants.W3C_XML_SCHEMA;

public class XmlDomParser {
    public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        factory.setNamespaceAware(true);
        factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Handler handler = new Handler();
        builder.setErrorHandler(handler);
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath path = xPathFactory.newXPath();
        File file = new File("C:/Users/1/Desktop/ИТ/Проекты/LearningJava/src/xmlParser/XmlTest/company_staff.xml");
        Document document = builder.parse(file);
        Element root = document.getDocumentElement();
        String companyName = root.getChildNodes().item(0).getTextContent();
        System.out.println("Название компании - " + companyName);
        int numDepts = ((Number) path.evaluate("count(/company/departments/department)", document, XPathConstants.NUMBER)).intValue();
        for (int i = 0; i < numDepts; i++) {
            Element deptElement = (Element) document.getElementsByTagName("department").item(i);
            String nameDepartment = deptElement.getAttribute("dept_name");
            System.out.println("Департамент " + nameDepartment + ":");
            List<Employee> theList = new ArrayList();
            NodeList empNodes = deptElement.getChildNodes();
            for (int j = 0; j < empNodes.getLength(); j++) {
                if (empNodes.item(j) instanceof Element) {
                    Element employeeElement = (Element) empNodes.item(j);
                    Employee employee = new Employee();
                    employee.setId(Integer.parseInt(employeeElement.getAttribute("id_number")));
                    NodeList empDataNodes = employeeElement.getChildNodes();
                    for (int k = 0; k < empDataNodes.getLength(); k++) {
                        if (empDataNodes.item(k) instanceof Element) {
                            Element dataElement = (Element) empDataNodes.item(k);
                            switch (dataElement.getTagName()) {
                                case "name":
                                    employee.setName(dataElement.getTextContent());
                                    break;
                                case "age":
                                    employee.setAge(Integer.parseInt(dataElement.getTextContent()));
                                    break;
                                case "gender":
                                    employee.setGender(dataElement.getTextContent().charAt(0));
                                    break;
                                case "salary":
                                    employee.getSalary().setValue(Integer.parseInt(dataElement.getTextContent()));
                                    employee.getSalary().setCurrency(dataElement.getAttribute("currency"));
                                    break;
                            }
                        }
                    }
                    theList.add(employee);
                }
            }
            theList.forEach(System.out::println);
        }
    }
}

class Handler implements ErrorHandler {
    @Override
    public void warning(SAXParseException exception) throws SAXException {

    }

    @Override
    public void error(SAXParseException exception) throws SAXException {

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {

    }
}